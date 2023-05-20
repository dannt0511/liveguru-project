package liveguru.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BasePageUI;
import commons.BaseTest;
import commons.PageGeneratorManager;
import reportConfig.ExtentTestManager;
import user.pageObject.AdvanceSearchResultPageObject;
import user.pageObject.AdvancedSearchPageObject;
import user.pageObject.CompareProductPageObject;
import user.pageObject.HomePageObject;
import user.pageObject.MyAccountDashboardPageObject;
import user.pageObject.ProductDetailPageObject;
import user.pageObject.ProductListPageObject;
import user.pageObject.RegisterPageObject;
import user.pageObject.ReviewProductPageObject;
import user.pageObject.ShareWishlistPageObject;
import user.pageObject.WishlistPageObject;

public class Liveguru_User_02_Product extends BaseTest {
	private WebDriver driver;
	private String browser, firstProductName, secondProductName, wishlistProduct, productListPagePrice, detailPagePrice,
			firstSuccessMsg, secondSuccessMsg, currentWinId, winTitle, firstName, lastName, email, password, rePassword,
			wishlistSuccessMsg, shareEmail, shareSuccessMsg, reviewProduct, reviewErrorMsg, reviewSuccessMsg, rating,
			reviewTitle, reviewDetail, reviewNickname, firstPriceFrom, firstPriceTo, secondPriceFrom, secondPriceTo;
	private HomePageObject homePage;
	private ProductListPageObject productListPage;
	private ProductDetailPageObject productDetailPage;
	private CompareProductPageObject compareProductPage;
	private RegisterPageObject registerPage;
	private MyAccountDashboardPageObject accountDashboardPage;
	private WishlistPageObject wishlistPage;
	private ShareWishlistPageObject shareWishlistPage;
	private ReviewProductPageObject reviewPage;
	private AdvancedSearchPageObject advanceSearchPage;
	private AdvanceSearchResultPageObject searchResultPage;

	@Parameters({ "browser", "userAppUrl" })
	@BeforeClass
	public void beforeClass(String browser, String appUrl) {
		this.browser = browser;
		firstName = "Reagan";
		lastName = "Lynn";
		email = "reaganlynn" + randomNum() + "@mail.com";
		password = "3k3AhJgE";
		rePassword = "3k3AhJgE";
		firstProductName = "Sony Xperia";
		secondProductName = "IPhone";
		firstSuccessMsg = "The product Sony Xperia has been added to comparison list.";
		secondSuccessMsg = "The product IPhone has been added to comparison list.";
		winTitle = "Products Comparison List - Magento Commerce";
		wishlistProduct = "LG LCD";
		wishlistSuccessMsg = wishlistProduct + " has been added to your wishlist. Click here to continue shopping.";
		shareEmail = "shareEmail@mail.com";
		shareSuccessMsg = "Your Wishlist has been shared.";
		reviewProduct = "Samsung LCD";
		reviewErrorMsg = "THIS IS A REQUIRED FIELD.";
		reviewSuccessMsg = "Your review has been accepted for moderation.";
		rating = "4";
		reviewTitle = "Title";
		reviewDetail = "Detail";
		reviewNickname = "reaganlynn";
		firstPriceFrom = "0";
		firstPriceTo = "150";
		secondPriceFrom = "151";
		secondPriceTo = "1000";

		driver = openBrowsers(browser, appUrl);
		homePage = PageGeneratorManager.openHomePage(driver);
		currentWinId = homePage.getWindowHandle();
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
	public void Product_01_Product_Price(Method method) {
		ExtentTestManager.startTest(method.getName() + "-" + this.browser.toUpperCase(), "Product_01_Product_Price");
		ExtentTestManager.getTest().log(Status.INFO, "Product_01_Product_Price - Step 01: Open mobile product list");
		productListPage = accountDashboardPage.openProductListFromSubHeader("Mobile");

		ExtentTestManager.getTest().log(Status.INFO, "Product_01_Product_Price - Step 02: Get price of product name '"
				+ firstProductName + "' on Product list screen");
		productListPagePrice = productListPage.getProductPriceByName(firstProductName);

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_01_Product_Price - Step 03: Open product detail page of product name '" + firstProductName
						+ "'");
		productDetailPage = productListPage.clickProductName(firstProductName);

		ExtentTestManager.getTest().log(Status.INFO, "Product_01_Product_Price - Step 04: Open price of product name '"
				+ firstProductName + "' on Product detail screen");
		detailPagePrice = productDetailPage.getProductPrice();

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_01_Product_Price - Step 05: Verify if the price on product list screen is equal to the price on product detail screen");
		Assert.assertEquals(productListPagePrice, detailPagePrice);
	}

	@Test
	public void Product_02_Compare_Products(Method method) {
		ExtentTestManager.startTest(method.getName() + "-" + this.browser.toUpperCase(), "Product_02_Compare_Products");
		ExtentTestManager.getTest().log(Status.INFO,
				"Product_02_Compare_Products - Step 01: Back to mobile product list");
		productListPage = productDetailPage.openProductListFromSubHeader("Mobile");

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_02_Compare_Products - Step 02: Add product name '" + firstProductName + "' to compare list");
		productListPage.addProductToCompareList(firstProductName);

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_02_Compare_Products - Step 03: Verify if the product is added to list successfully");
		Assert.assertEquals(productListPage.getSuccessMsg(), firstSuccessMsg);

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_02_Compare_Products - Step 04: Add product name '" + secondProductName + "' to compare list");
		productListPage.addProductToCompareList(secondProductName);

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_02_Compare_Products - Step 05: Verify if the product is added to list successfully");
		Assert.assertEquals(productListPage.getSuccessMsg(), secondSuccessMsg);

		ExtentTestManager.getTest().log(Status.INFO, "Product_02_Compare_Products - Step 06: Click Compare button");
		compareProductPage = productListPage.clickCompareButton(currentWinId);

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_02_Compare_Products - Step 07: Verify if the products are displayed on the comparison window");
		Assert.assertEquals(compareProductPage.getPageTitle(), winTitle);
		Assert.assertTrue(compareProductPage.isProductDisplayed(firstProductName));
		Assert.assertTrue(compareProductPage.isProductDisplayed(secondProductName));

		ExtentTestManager.getTest().log(Status.INFO, "Product_02_Compare_Products - Step 08: Close popup window");
		productListPage = compareProductPage.closeWindow(currentWinId);
	}

	@Test
	public void Product_03_Wishlist(Method method) {
		ExtentTestManager.startTest(method.getName() + "-" + this.browser.toUpperCase(), "Product_03_Wishlist");
		ExtentTestManager.getTest().log(Status.INFO, "Product_03_Wishlist - Step 01: Go to TV product list");
		productListPage.openProductListFromSubHeader("TV");

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_03_Wishlist - Step 02: Add product name '" + wishlistProduct + "' to wishlist page");
		wishlistPage = productListPage.addProductToWishlist(wishlistProduct);

		ExtentTestManager.getTest().log(Status.INFO, "Product_03_Wishlist - Step 03: Verify if message is correct");
		Assert.assertEquals(wishlistPage.getSuccessMsg(), wishlistSuccessMsg);

		ExtentTestManager.getTest().log(Status.INFO, "Product_03_Wishlist - Step 04: Click Share wishlist button");
		shareWishlistPage = wishlistPage.clickShareWishlistButton();

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_03_Wishlist - Step 05: Share wishlist with email value '" + shareEmail + "'");
		shareWishlistPage.inputShareEmailTextbox(shareEmail);
		wishlistPage = shareWishlistPage.clickShareWishlistButton();

		ExtentTestManager.getTest().log(Status.INFO, "Product_03_Wishlist - Step 06: Verify if message is correct");
		Assert.assertEquals(wishlistPage.getSuccessMsg(), shareSuccessMsg);

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_03_Wishlist - Step 07: Verify if product name '" + wishlistProduct + "' is displayed");
		Assert.assertTrue(wishlistPage.isProductDisplayed(wishlistProduct));
	}

	@Test
	public void Product_04_Review_Product(Method method) {
		ExtentTestManager.startTest(method.getName() + "-" + this.browser.toUpperCase(), "Product_04_Review_Product");
		ExtentTestManager.getTest().log(Status.INFO, "Product_04_Review_Product - Step 01: Go to TV product list");
		productListPage = wishlistPage.openProductListFromSubHeader("TV");

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_04_Review_Product - Step 02: Go to detail page of product name '" + reviewProduct + "'");
		productDetailPage = productListPage.clickProductName(reviewProduct);

		ExtentTestManager.getTest().log(Status.INFO, "Product_04_Review_Product - Step 03: Click Add your review link");
		reviewPage = productDetailPage.clickAddReviewLink();

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_04_Review_Product - Step 04: Select rating star value '" + rating + "'");
		reviewPage.selectRatingReview(rating);

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_04_Review_Product - Step 05: Add review with all textbox blank");
		reviewPage.inputToNicknameTextbox("");
		reviewPage.clickSubmitButton();

		ExtentTestManager.getTest().log(Status.INFO, "Product_04_Review_Product - Step 06: Verify error messages");
		Assert.assertEquals(reviewPage.getYourThoughtTextareaErrorMsg(), reviewErrorMsg);
		Assert.assertEquals(reviewPage.getTextboxErrorMsg("title"), reviewErrorMsg);
		Assert.assertEquals(reviewPage.getTextboxErrorMsg("nickname"), reviewErrorMsg);

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_04_Review_Product - Step 07: Input valid value to textbox");
		reviewPage.inputToYourThoughtTextbox(reviewDetail);
		reviewPage.inputToSummaryTextbox(reviewTitle);
		reviewPage.inputToNicknameTextbox(reviewNickname);
		reviewPage.clickSubmitButton();

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_04_Review_Product - Step 08: Verify add review success message");
		Assert.assertEquals(reviewPage.getSuccessMsg(), reviewSuccessMsg);
	}

	@Test
	public void Product_05_Advance_Search(Method method) {
		ExtentTestManager.startTest(method.getName() + "-" + this.browser.toUpperCase(), "Product_05_Advance_Search");
		ExtentTestManager.getTest().log(Status.INFO, "Product_05_Advance_Search - Step 01: Go to Advance seach page");
		reviewPage.openPage(BasePageUI.FOOTER_DYNAMIC_LOCATOR_BY_NAME, "Advanced Search");
		advanceSearchPage = PageGeneratorManager.openAdvanceSearchPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_05_Advance_Search - Step 02: Input search condition Price");
		advanceSearchPage.inputPriceFromTextbox(firstPriceFrom);
		advanceSearchPage.inputPriceToTextbox(firstPriceTo);

		ExtentTestManager.getTest().log(Status.INFO, "Product_05_Advance_Search - Step 03: Click button Search");
		searchResultPage = advanceSearchPage.clickSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Product_05_Advance_Search - Step 04: Verify result");
		Assert.assertEquals(searchResultPage.getResultNumber(), "2");
		Assert.assertTrue(searchResultPage.isResultPriceInRange(firstPriceFrom, firstPriceTo));

		ExtentTestManager.getTest().log(Status.INFO, "Product_05_Advance_Search - Step 05: Go to Advance seach page");
		searchResultPage.openPage(BasePageUI.FOOTER_DYNAMIC_LOCATOR_BY_NAME, "Advanced Search");
		advanceSearchPage = PageGeneratorManager.openAdvanceSearchPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_05_Advance_Search - Step 06: Input search condition Price");
		advanceSearchPage.inputPriceFromTextbox(secondPriceFrom);
		advanceSearchPage.inputPriceToTextbox(secondPriceTo);

		ExtentTestManager.getTest().log(Status.INFO, "Product_05_Advance_Search - Step 07: Click button Search");
		searchResultPage = advanceSearchPage.clickSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Product_05_Advance_Search - Step 08: Verify result");
		Assert.assertEquals(searchResultPage.getResultNumber(), "3");
		Assert.assertTrue(searchResultPage.isResultPriceInRange(secondPriceFrom, secondPriceTo));
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
