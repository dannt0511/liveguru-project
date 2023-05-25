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

		ExtentTestManager.getTest().log(Status.INFO,
				"Invoices_01_Sort - Step 05: Verify if the records are sorted asc by order no");
		invoicesListPage.clickHeaderTableToSortAsc("Order #");
		invoicesListPage.waitAdminPageLoadReady();
		Assert.assertTrue(invoicesListPage.isRecordSortedAsc("Order #"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Invoices_01_Sort - Step 06: Verify if the records are sorted desc by order no");
		invoicesListPage.sortTableinDesc();
		invoicesListPage.waitAdminPageLoadReady();
		Assert.assertTrue(invoicesListPage.isRecordSortedDesc("Order #"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Invoices_01_Sort - Step 07: Verify if the records are sorted asc by order date");
		invoicesListPage.clickHeaderTableToSortAsc("Order Date");
		invoicesListPage.waitAdminPageLoadReady();
		Assert.assertTrue(invoicesListPage.isRecordDateSortedAsc("Order Date"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Invoices_01_Sort - Step 08: Verify if the records are sorted desc by order date");
		invoicesListPage.sortTableinDesc();
		invoicesListPage.waitAdminPageLoadReady();
		Assert.assertTrue(invoicesListPage.isRecordDateSortedDesc("Order Date"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Invoices_01_Sort - Step 09: Verify if the records are sorted asc by Bill to Name");
		invoicesListPage.clickHeaderTableToSortAsc("Bill to Name");
		invoicesListPage.waitAdminPageLoadReady();
		Assert.assertTrue(invoicesListPage.isRecordSortedAsc("Bill to Name"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Invoices_01_Sort - Step 10: Verify if the records are sorted desc by Bill to Name");
		invoicesListPage.sortTableinDesc();
		invoicesListPage.waitAdminPageLoadReady();
		Assert.assertTrue(invoicesListPage.isRecordSortedDesc("Bill to Name"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Invoices_01_Sort - Step 11: Verify if the records are sorted asc by Amount");
		invoicesListPage.clickHeaderTableToSortAsc("Amount");
		invoicesListPage.waitAdminPageLoadReady();
		Assert.assertTrue(invoicesListPage.isRecordFloatSortedAsc("Amount"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Invoices_01_Sort - Step 10: Verify if the records are sorted desc by Amount");
		invoicesListPage.sortTableinDesc();
		invoicesListPage.waitAdminPageLoadReady();
		Assert.assertTrue(invoicesListPage.isRecordFloatSortedDesc("Amount"));

	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
