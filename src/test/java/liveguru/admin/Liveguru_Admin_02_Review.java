package liveguru.admin;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import admin.pageObject.CustomerListPageObject;
import admin.pageObject.EditReviewPageObject;
import admin.pageObject.LoginPageObject;
import admin.pageObject.ReviewListPageObject;
import commons.AdminPageGeneratorManager;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.UserPageGeneratorManager;
import reportConfig.ExtentTestManager;
import user.pageObject.HomePageObject;
import user.pageObject.ProductDetailPageObject;
import user.pageObject.ProductListPageObject;
import user.pageObject.ReviewProductPageObject;

public class Liveguru_Admin_02_Review extends BaseTest {
	private WebDriver driver;
	private String browser, productCategory, productName, rating, reviewSummary, reviewDetail, reviewNickname,
			updateStatus;
	private LoginPageObject loginPage;
	private CustomerListPageObject customerListPage;
	private ReviewListPageObject reviewListPage;
	private HomePageObject userHomePage;
	private ProductListPageObject userProductListPage;
	private ProductDetailPageObject userProductDetailPage;
	private ReviewProductPageObject userReviewPage;
	private EditReviewPageObject editReviewPage;

	@Parameters({ "browser", "userAppUrl" })
	@BeforeClass
	public void beforeClass(String browser, String appUrl) {
		this.browser = browser;
		productCategory = "Mobile";
		productName = "IPhone";
		rating = "4";
		reviewSummary = "ReaganSummary" + randomNum();
		reviewDetail = "Detail";
		reviewNickname = "reaganlynn";
		updateStatus = "Approved";

		driver = openBrowsers(browser, appUrl);
		userHomePage = UserPageGeneratorManager.openHomePage(driver);
	}

	@Test
	public void Review_01_Approve(Method method) {
		ExtentTestManager.startTest(method.getName() + "-" + this.browser.toUpperCase(), "Review_01_Approve");
		ExtentTestManager.getTest().log(Status.INFO,
				"Review_01_Approve - Step 01: Go to product name '" + productName + "'");
		userProductListPage = userHomePage.openProductListFromSubHeader(productCategory);
		userProductDetailPage = userProductListPage.clickProductName(productName);

		ExtentTestManager.getTest().log(Status.INFO,
				"Review_01_Approve - Step 02: Go to review page of product name '" + productName + "'");
		userReviewPage = userProductDetailPage.clickAddReviewLink();

		ExtentTestManager.getTest().log(Status.INFO,
				"Review_01_Approve - Step 03: Review product name '" + productName + "'");
		userReviewPage.selectRatingReview(rating);
		userReviewPage.inputToYourThoughtTextbox(reviewDetail);
		userReviewPage.inputToSummaryTextbox(reviewSummary);
		userReviewPage.inputToNicknameTextbox(reviewNickname);
		userReviewPage.clickSubmitButton();

		ExtentTestManager.getTest().log(Status.INFO, "Review_01_Approve - Step 04: Go to admin site");
		userReviewPage.openPageUrl(GlobalConstants.ADMIN_PAGE_URL);
		loginPage = AdminPageGeneratorManager.openLoginPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Review_01_Approve - Step 05: Login to admin site");
		loginPage.inputUsernameTextbox(GlobalConstants.ADMIN_USERNAME);
		loginPage.inputPasswordTextbox(GlobalConstants.ADMIN_PASSWORD);
		customerListPage = loginPage.clickLoginButton();
		customerListPage.clickCloseButtonOnPopup();

		ExtentTestManager.getTest().log(Status.INFO, "Review_01_Approve - Step 06: Go to Pending review page");
		reviewListPage = (ReviewListPageObject) customerListPage.openPageFromNavBar("Catalog", "Reviews and Ratings",
				"Customer Reviews", "Pending Reviews");
		

		ExtentTestManager.getTest().log(Status.INFO, "Review_01_Approve - Step 07: Sort table by ID in DESC order");
		reviewListPage.clickHeaderTableToSortAsc("ID");
		reviewListPage.sortTableinDesc();

		ExtentTestManager.getTest().log(Status.INFO, "Review_01_Approve - Step 08: Go to edit screen");
		editReviewPage = reviewListPage.clickRecordEditLink(1);

		ExtentTestManager.getTest().log(Status.INFO,
				"Review_01_Approve - Step 09: Update status to value '" + updateStatus + "'");
		editReviewPage.selectReviewStatus(updateStatus);
		reviewListPage = editReviewPage.clickSaveReviewButton();

		ExtentTestManager.getTest().log(Status.INFO, "Review_01_Approve - Step 10: Back to user site");
		reviewListPage.openPageUrl(GlobalConstants.USER_PAGE_URL);
		userHomePage = UserPageGeneratorManager.openHomePage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Review_01_Approve - Step 11: Go to detail page of product '" + productName + "'");
		userProductListPage = userHomePage.openProductListFromSubHeader(productCategory);
		userProductDetailPage = userProductListPage.clickProductName(productName);

		ExtentTestManager.getTest().log(Status.INFO, "Review_01_Approve - Step 12: Click review tab");
		userProductDetailPage.clickReviewTab();

		ExtentTestManager.getTest().log(Status.INFO, "Review_01_Approve - Step 13: Verify if the review is displayed");
		Assert.assertTrue(userProductDetailPage.isReviewSummaryDisplayed(reviewSummary));

	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
