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
import reportConfig.ExtentTestManager;
import user.pageObject.HomePageObject;
import user.pageObject.ProductListPageObject;
import user.pageObject.ShoppingCartPageObject;

public class Liveguru_User_03_Order extends BaseTest {
	private WebDriver driver;
	private String browser, productName, couponCode, successMsg, discountPrice, editQty, errorMsg, itemErrorMsg,
			emptyMsg, emptyPageTitle;
	private HomePageObject homePage;
	private ProductListPageObject productListPage;
	private ShoppingCartPageObject shoppingCartPage;

	@Parameters({ "browser", "userAppUrl" })
	@BeforeClass
	public void beforeClass(String browser, String appUrl) {
		this.browser = browser;
		productName = "Sony Xperia";
		couponCode = "GURU50";
		successMsg = "Coupon code \"GURU50\" was applied.";
		discountPrice = "-$5.00";
		editQty = "501";
		errorMsg = "Some of the products cannot be ordered in requested quantity.";
		itemErrorMsg = "* The maximum quantity allowed for purchase is 500.";
		emptyMsg = "You have no items in your shopping cart.";
		emptyPageTitle = "SHOPPING CART IS EMPTY";

		driver = openBrowsers(browser, appUrl);
		homePage = PageGeneratorManager.openHomePage(driver);

	}

	@Test
	public void Order_01_Apply_Coupon(Method method) {
		ExtentTestManager.startTest(method.getName() + "-" + this.browser.toUpperCase(), "Order_01_Apply_Coupon");
		ExtentTestManager.getTest().log(Status.INFO,
				"Order_01_Apply_Coupon - Step 01: Add product name '" + productName + "' to cart");
		productListPage = homePage.openProductListFromSubHeader("Mobile");
		shoppingCartPage = productListPage.addProductToCart(productName);

		ExtentTestManager.getTest().log(Status.INFO,
				"Order_01_Apply_Coupon - Step 02: Apply coupon code value '" + couponCode + "'");
		shoppingCartPage.inputCouponCodeTextbox(couponCode);
		shoppingCartPage.clickCouponApplyLink();

		ExtentTestManager.getTest().log(Status.INFO,
				"Order_01_Apply_Coupon - Step 03: Verify if coupon code is applied");
		Assert.assertEquals(shoppingCartPage.getSuccessMsg(), successMsg);
		Assert.assertEquals(shoppingCartPage.getAppliedDiscountCode(), "(" + couponCode + ")");
		Assert.assertEquals(shoppingCartPage.getDiscountPrice(), discountPrice);
	}

	@Test
	public void Order_02_Edit_Qty(Method method) {
		ExtentTestManager.startTest(method.getName() + "-" + this.browser.toUpperCase(), "Order_02_Edit_Qty");
		ExtentTestManager.getTest().log(Status.INFO,
				"Order_02_Edit_Qty - Step 01: Edit qty textbox with value '" + editQty + "'");
		shoppingCartPage.inputQtyTextbox(editQty);

		ExtentTestManager.getTest().log(Status.INFO, "Order_02_Edit_Qty - Step 02: Click button Update");
		shoppingCartPage.clickUpdateButton();

		ExtentTestManager.getTest().log(Status.INFO, "Order_02_Edit_Qty - Step 03: Verify if error message is correct");
		Assert.assertEquals(shoppingCartPage.getErrorMessage(), errorMsg);
		Assert.assertEquals(shoppingCartPage.getItemErrorMessage(productName), itemErrorMsg);

		ExtentTestManager.getTest().log(Status.INFO, "Order_02_Edit_Qty - Step 04: Click Empty cart link");
		shoppingCartPage.clickEmptyLink();

		ExtentTestManager.getTest().log(Status.INFO,
				"Order_02_Edit_Qty - Step 05: Verify if the shopping cart is empty");
		Assert.assertEquals(shoppingCartPage.getPageTitle(), emptyPageTitle);
		Assert.assertEquals(shoppingCartPage.getEmptyMessage(), emptyMsg);
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
