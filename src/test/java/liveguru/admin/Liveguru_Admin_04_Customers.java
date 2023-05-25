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
import admin.pageObject.LoginPageObject;
import commons.AdminPageGeneratorManager;
import commons.BaseTest;
import commons.GlobalConstants;
import reportConfig.ExtentTestManager;

public class Liveguru_Admin_04_Customers extends BaseTest {
	private WebDriver driver;
	private String browser, searchName, searchId, searchMail, searchTelephone, searchZip, searchCountry, searchState;
	private LoginPageObject loginPage;
	private CustomerListPageObject customerListPage;

	@Parameters({ "browser", "adminAppUrl" })
	@BeforeClass
	public void beforeClass(String browser, String appUrl) {
		this.browser = browser;
		searchName = "Reagan Lynn";
		searchId = "83544";
		searchTelephone = "687-570-4586";
		searchMail = "reaganlynn876@mail.com";
		searchZip = "34616";
		searchCountry = "United States";
		searchState = "New York";

		driver = openBrowsers(browser, appUrl);
		loginPage = AdminPageGeneratorManager.openLoginPage(driver);
		loginPage.inputUsernameTextbox(GlobalConstants.ADMIN_USERNAME);
		loginPage.inputPasswordTextbox(GlobalConstants.ADMIN_PASSWORD);
		customerListPage = loginPage.clickLoginButton();
		customerListPage.clickCloseButtonOnPopup();
	}

	@Test
	public void Customer_01_Search(Method method) {
		ExtentTestManager.startTest(method.getName() + "-" + this.browser.toUpperCase(), "Customer_01_Search");
		ExtentTestManager.getTest().log(Status.INFO, "Customer_01_Search - Step 01: Search with ID");
		customerListPage.inputIDTextbox("From", searchId);
		customerListPage.inputIDTextbox("To", searchId);
		customerListPage.clickAdminSearchButton();
		customerListPage.waitAdminPageLoadReady();
		Assert.assertTrue(customerListPage.isSearchResultCorrect("ID", searchId));

		ExtentTestManager.getTest().log(Status.INFO, "Customer_01_Search - Step 02: Search with Name");
		customerListPage.clickResetFilterButton();
		customerListPage.waitAdminPageLoadReady();
		customerListPage.inputFilterTextbox("Name", searchName);
		customerListPage.clickAdminSearchButton();
		customerListPage.waitAdminPageLoadReady();
		Assert.assertTrue(customerListPage.isSearchResultCorrect("Name", searchName));

		ExtentTestManager.getTest().log(Status.INFO, "Customer_01_Search - Step 03: Search with Email");
		customerListPage.clickResetFilterButton();
		customerListPage.waitAdminPageLoadReady();
		customerListPage.inputFilterTextbox("Email", searchMail);
		customerListPage.clickAdminSearchButton();
		customerListPage.waitAdminPageLoadReady();
		Assert.assertTrue(customerListPage.isSearchResultCorrect("Email", searchMail));

		ExtentTestManager.getTest().log(Status.INFO, "Customer_01_Search - Step 04: Search with Telephone");
		customerListPage.clickResetFilterButton();
		customerListPage.waitAdminPageLoadReady();
		customerListPage.inputFilterTextbox("Telephone", searchTelephone);
		customerListPage.clickAdminSearchButton();
		customerListPage.waitAdminPageLoadReady();
		Assert.assertTrue(customerListPage.isSearchResultCorrect("Telephone", searchTelephone));

		ExtentTestManager.getTest().log(Status.INFO, "Customer_01_Search - Step 05: Search with ZIP");
		customerListPage.clickResetFilterButton();
		customerListPage.waitAdminPageLoadReady();
		customerListPage.inputFilterTextbox("ZIP", searchZip);
		customerListPage.clickAdminSearchButton();
		customerListPage.waitAdminPageLoadReady();
		Assert.assertTrue(customerListPage.isSearchResultCorrect("ZIP", searchZip));

		ExtentTestManager.getTest().log(Status.INFO, "Customer_01_Search - Step 06: Search with Country");
		customerListPage.clickResetFilterButton();
		customerListPage.waitAdminPageLoadReady();
		customerListPage.selectFilterSelectbox("Country", searchCountry);
		customerListPage.clickAdminSearchButton();
		customerListPage.waitAdminPageLoadReady();
		Assert.assertTrue(customerListPage.isSearchResultCorrect("Country", searchCountry));

		ExtentTestManager.getTest().log(Status.INFO, "Customer_01_Search - Step 07: Search with State");
		customerListPage.clickResetFilterButton();
		customerListPage.waitAdminPageLoadReady();
		customerListPage.inputFilterTextbox("State/Province", searchState);
		customerListPage.clickAdminSearchButton();
		customerListPage.waitAdminPageLoadReady();
		Assert.assertTrue(customerListPage.isSearchResultCorrect("State/Province", searchState));
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
