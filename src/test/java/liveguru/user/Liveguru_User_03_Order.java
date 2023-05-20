package liveguru.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import liveguru.testData.User_Order;
import liveguru.testData.User_Order.Coupon;
import liveguru.testData.User_Order.Edit_Qty;
import liveguru.testData.User_Order.Purchase_Product;
import reportConfig.ExtentTestManager;
import user.pageObject.CheckoutPageObject;
import user.pageObject.HomePageObject;
import user.pageObject.MyAccountDashboardPageObject;
import user.pageObject.ProductListPageObject;
import user.pageObject.RegisterPageObject;
import user.pageObject.ShoppingCartPageObject;

public class Liveguru_User_03_Order extends BaseTest {
	private WebDriver driver;
	private String browser, firstName, lastName, email, password, rePassword;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private MyAccountDashboardPageObject accountDashboardPage;
	private ProductListPageObject productListPage;
	private ShoppingCartPageObject shoppingCartPage;
	private CheckoutPageObject checkoutPage;

	@Parameters({ "browser", "userAppUrl" })
	@BeforeClass
	public void beforeClass(String browser, String appUrl) {
		this.browser = browser;
		firstName = "Reagan";
		lastName = "Lynn";
		email = "reaganlynn" + randomNum() + "@mail.com";
		password = "3k3AhJgE";
		rePassword = "3k3AhJgE";

		driver = openBrowsers(browser, appUrl);
		homePage = PageGeneratorManager.openHomePage(driver);
		homePage.clickLinkOnMyAccountMenu("Register");
		registerPage = PageGeneratorManager.openRegisterPage(driver);
		registerPage.inputFirstnameTextbox(firstName);
		registerPage.inputLastnameTextbox(lastName);
		registerPage.inputEmailTextbox(email);
		registerPage.inputPasswordTextbox(password);
		registerPage.inputConfirmPasswordTextbox(rePassword);
		accountDashboardPage = registerPage.clickRegisterButton();

	}

	@Test
	public void Order_01_Apply_Coupon(Method method) {
		ExtentTestManager.startTest(method.getName() + "-" + this.browser.toUpperCase(), "Order_01_Apply_Coupon");
		ExtentTestManager.getTest().log(Status.INFO,
				"Order_01_Apply_Coupon - Step 01: Add product name '" + User_Order.PRODUCT_NAME + "' to cart");
		productListPage = accountDashboardPage.openProductListFromSubHeader("Mobile");
		shoppingCartPage = productListPage.addProductToCart(User_Order.PRODUCT_NAME);

		ExtentTestManager.getTest().log(Status.INFO,
				"Order_01_Apply_Coupon - Step 02: Apply coupon code value '" + Coupon.COUPON_CODE + "'");
		shoppingCartPage.inputCouponCodeTextbox(Coupon.COUPON_CODE);
		shoppingCartPage.clickCouponApplyLink();

		ExtentTestManager.getTest().log(Status.INFO,
				"Order_01_Apply_Coupon - Step 03: Verify if coupon code is applied");
		Assert.assertEquals(shoppingCartPage.getSuccessMsg(), Coupon.SUCCESS_MSG);
		Assert.assertEquals(shoppingCartPage.getAppliedDiscountCode(), "(" + Coupon.COUPON_CODE + ")");
		Assert.assertEquals(shoppingCartPage.getDiscountPrice(), Coupon.DISCOUNT_PRICE);
	}

	@Test
	public void Order_02_Edit_Qty(Method method) {
		ExtentTestManager.startTest(method.getName() + "-" + this.browser.toUpperCase(), "Order_02_Edit_Qty");
		ExtentTestManager.getTest().log(Status.INFO,
				"Order_02_Edit_Qty - Step 01: Edit qty textbox with value '" + Edit_Qty.EDIT_QTY + "'");
		shoppingCartPage.inputQtyTextbox(Edit_Qty.EDIT_QTY);

		ExtentTestManager.getTest().log(Status.INFO, "Order_02_Edit_Qty - Step 02: Click button Update");
		shoppingCartPage.clickUpdateButton();

		ExtentTestManager.getTest().log(Status.INFO, "Order_02_Edit_Qty - Step 03: Verify if error message is correct");
		Assert.assertEquals(shoppingCartPage.getErrorMessage(), Edit_Qty.ERROR_MSG);
		Assert.assertEquals(shoppingCartPage.getItemErrorMessage(User_Order.PRODUCT_NAME), Edit_Qty.ITEM_ERROR_MSG);

		ExtentTestManager.getTest().log(Status.INFO, "Order_02_Edit_Qty - Step 04: Click Empty cart link");
		shoppingCartPage.clickEmptyLink();

		ExtentTestManager.getTest().log(Status.INFO,
				"Order_02_Edit_Qty - Step 05: Verify if the shopping cart is empty");
		Assert.assertEquals(shoppingCartPage.getPageTitle(), Edit_Qty.EMPTY_PAGE_TITLE);
		Assert.assertEquals(shoppingCartPage.getEmptyMessage(), Edit_Qty.EMPTY_MSG);
	}

	@Test
	public void Order_03_Create_Order(Method method) {
		ExtentTestManager.startTest(method.getName() + "-" + this.browser.toUpperCase(), "Order_03_Create_Order");
		ExtentTestManager.getTest().log(Status.INFO, "Order_03_Create_Order - Step 01: Add product to Cart");
		productListPage = shoppingCartPage.openProductListFromSubHeader("Mobile");
		shoppingCartPage = productListPage.addProductToCart(User_Order.PRODUCT_NAME);

		ExtentTestManager.getTest().log(Status.INFO,
				"Order_03_Create_Order - Step 02: Select State/ Province and Zip code");
		shoppingCartPage.selectCountrySelextbox(Purchase_Product.SHIPPING_COUNTRY);
		shoppingCartPage.selectStateSelextbox(Purchase_Product.SHIPPING_STATE);
		shoppingCartPage.inputZipTextbox(Purchase_Product.SHIPPING_ZIP);

		ExtentTestManager.getTest().log(Status.INFO, "Order_03_Create_Order - Step 03: Click Estimate link");
		shoppingCartPage.clickEstimateLink();
//		shoppingCartPage.clickCouponCancelLink();

		ExtentTestManager.getTest().log(Status.INFO, "Order_03_Create_Order - Step 04: Verify shipping cost generated");
		Assert.assertEquals(shoppingCartPage.getShippingCost(), Purchase_Product.SHIPPING_EXPECT_SHIP_COST);

		ExtentTestManager.getTest().log(Status.INFO,
				"Order_03_Create_Order - Step 05: Select shipping cost and update total");
		shoppingCartPage.selectShippingCost();
		shoppingCartPage.clickUpdateTotalButton();

		ExtentTestManager.getTest().log(Status.INFO,
				"Order_03_Create_Order - Step 06: Verify if shipping cost is added to total price");
		Assert.assertEquals(shoppingCartPage.getTotalPrice(), Purchase_Product.EXPECT_TOTAL_PRICE);

		ExtentTestManager.getTest().log(Status.INFO,
				"Order_03_Create_Order - Step 07: Click button Proceed to Checkout");
		checkoutPage = shoppingCartPage.clickProceedToCheckoutButton();

		ExtentTestManager.getTest().log(Status.INFO, "Order_03_Create_Order - Step 08: Input billing information");
		checkoutPage.inputBillingTextboxByName("street1", Purchase_Product.BILLING_ADDRESS);
		checkoutPage.inputBillingTextboxByName("city", Purchase_Product.BILLING_STATE);
		checkoutPage.selectBillingSelectbox("country_id", Purchase_Product.BILLING_COUNTRY);
		checkoutPage.selectBillingSelectbox("region_id", Purchase_Product.BILLING_STATE);
		checkoutPage.inputBillingTextboxByName("postcode", Purchase_Product.BILLING_ZIP);
		checkoutPage.inputBillingTextboxByName("telephone", Purchase_Product.BILLING_PHONE);
		checkoutPage.selectShipToOtherAddress();
		checkoutPage.clickBillingContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "Order_03_Create_Order - Step 09: Input shipping information");
		checkoutPage.inputShippingTextboxByName("firstname", Purchase_Product.SHIPPING_FIRSTNAME);
		checkoutPage.inputShippingTextboxByName("lastname", Purchase_Product.SHIPPING_LASTNAME);
		checkoutPage.inputShippingTextboxByName("street1", Purchase_Product.SHIPPING_ADDRESS);
		checkoutPage.inputShippingTextboxByName("city", Purchase_Product.SHIPPING_STATE);
		checkoutPage.selectShippingSelectbox("country_id", Purchase_Product.SHIPPING_COUNTRY);
		checkoutPage.selectShippingSelectbox("region_id", Purchase_Product.SHIPPING_STATE);
		checkoutPage.inputShippingTextboxByName("postcode", Purchase_Product.SHIPPING_ZIP);
		checkoutPage.inputShippingTextboxByName("telephone", Purchase_Product.SHIPPING_PHONE);
		checkoutPage.clickShippingContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "Order_03_Create_Order - Step 10: Select shipping method");
		checkoutPage.clickShippingMethodContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "Order_03_Create_Order - Step 11: Select payment method");
		checkoutPage.selectPaymentMethod(Purchase_Product.PAYMENT_METHOD);
		checkoutPage.clickPaymentMethodContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "Order_03_Create_Order - Step 12: Place order");
		checkoutPage.clickPlaceOrderButton();

		ExtentTestManager.getTest().log(Status.INFO, "Order_03_Create_Order - Step 13: Verify if the order is created");
		Assert.assertEquals(checkoutPage.getPageTitle(), Purchase_Product.ORDER_CREATE_MSG);
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
