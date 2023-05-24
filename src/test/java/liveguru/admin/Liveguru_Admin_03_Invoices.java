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
import admin.pageObject.InvoicesListPageObject;
import admin.pageObject.LoginPageObject;
import commons.AdminPageGeneratorManager;
import commons.BaseTest;
import commons.GlobalConstants;
import reportConfig.ExtentTestManager;

public class Liveguru_Admin_03_Invoices extends BaseTest {
	private WebDriver driver;
	private String browser;
	private LoginPageObject loginPage;
	private CustomerListPageObject customerListPage;
	private InvoicesListPageObject invoicesListPage;

	@Parameters({ "browser", "adminAppUrl" })
	@BeforeClass
	public void beforeClass(String browser, String appUrl) {
		this.browser = browser;

		driver = openBrowsers(browser, appUrl);
		loginPage = AdminPageGeneratorManager.openLoginPage(driver);
		loginPage.inputUsernameTextbox(GlobalConstants.ADMIN_USERNAME);
		loginPage.inputPasswordTextbox(GlobalConstants.ADMIN_PASSWORD);
		customerListPage = loginPage.clickLoginButton();
		customerListPage.clickCloseButtonOnPopup();
		invoicesListPage = (InvoicesListPageObject) customerListPage.openPageFromNavBar("Sales", "Invoices");
	}

	@Test
	public void Invoices_01_Sort(Method method) {
		ExtentTestManager.startTest(method.getName() + "-" + this.browser.toUpperCase(), "Invoices_01_Sort");
		ExtentTestManager.getTest().log(Status.INFO,
				"Invoices_01_Sort - Step 01: Verify if the records are sorted asc by invoices no");
		invoicesListPage.clickHeaderTableToSortAsc("Invoice #");
		invoicesListPage.waitAdminPageLoadReady();
		Assert.assertTrue(invoicesListPage.isRecordSortedAsc("Invoice #"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Invoices_01_Sort - Step 02: Verify if the records are sorted desc by invoices no");
		invoicesListPage.sortTableinDesc();
		invoicesListPage.waitAdminPageLoadReady();
		Assert.assertTrue(invoicesListPage.isRecordSortedDesc("Invoice #"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Invoices_01_Sort - Step 03: Verify if the records are sorted asc by invoices date");
		invoicesListPage.clickHeaderTableToSortAsc("Invoice Date");
		invoicesListPage.waitAdminPageLoadReady();
		Assert.assertTrue(invoicesListPage.isRecordDateSortedAsc("Invoice Date"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Invoices_01_Sort - Step 04: Verify if the records are sorted desc by invoices date");
		invoicesListPage.sortTableinDesc();
		invoicesListPage.waitAdminPageLoadReady();
		Assert.assertTrue(invoicesListPage.isRecordDateSortedDesc("Invoice Date"));
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
