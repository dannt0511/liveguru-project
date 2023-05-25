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
import admin.pageObject.OrderListPageObject;
import commons.AdminPageGeneratorManager;
import commons.BaseTest;
import commons.GlobalConstants;
import reportConfig.ExtentTestManager;

public class Liveguru_Admin_01_Order extends BaseTest {

	private WebDriver driver;
	private String browser, record_status_01, record_status_02, action, actionErrorMsg, filename;
	private LoginPageObject loginPage;
	private CustomerListPageObject customerListPage;
	private OrderListPageObject orderListPage;

	@Parameters({ "browser", "adminAppUrl" })
	@BeforeClass
	public void beforeClass(String browser, String appUrl) {
		this.browser = browser;
		record_status_01 = "Canceled";
		record_status_02 = "Complete";
		action = "Print Invoices";
		actionErrorMsg = "There are no printable documents related to selected orders.";
		filename = "invoice";

		driver = openBrowsers(browser, appUrl);
		loginPage = AdminPageGeneratorManager.openLoginPage(driver);
		loginPage.inputUsernameTextbox(GlobalConstants.ADMIN_USERNAME);
		loginPage.inputPasswordTextbox(GlobalConstants.ADMIN_PASSWORD);
		customerListPage = loginPage.clickLoginButton();
		customerListPage.clickCloseButtonOnPopup();
	}

	@Test
	public void Order_01_Print_Invoices(Method method) {
		ExtentTestManager.startTest(method.getName() + "-" + this.browser.toUpperCase(), "Order_01_Print_Invoices");
		ExtentTestManager.getTest().log(Status.INFO, "Order_01_Print_Invoices - Step 01: Open order list page");
		orderListPage = (OrderListPageObject) customerListPage.openPageFromNavBar("Sales", "Orders");

		ExtentTestManager.getTest().log(Status.INFO,
				"Order_01_Print_Invoices - Step 02: Search record with status '" + record_status_01 + "'");
		orderListPage.selectRecordStatus(record_status_01);
		orderListPage.clickAdminSearchButton();

		ExtentTestManager.getTest().log(Status.INFO,
				"Order_01_Print_Invoices - Step 03: Print invoices with first record in the table");
		orderListPage.checkToRecordCheckbox(1);
		orderListPage.selectActionSelectbox(action);
		orderListPage.clickSubmitButton();

		ExtentTestManager.getTest().log(Status.INFO, "Order_01_Print_Invoices - Step 04: Verify message error");
		Assert.assertEquals(orderListPage.getErrorMsg(), actionErrorMsg);

		ExtentTestManager.getTest().log(Status.INFO,
				"Order_01_Print_Invoices - Step 05: Search record with status '" + record_status_02 + "'");
		orderListPage.selectRecordStatus(record_status_02);
		orderListPage.clickAdminSearchButton();

		ExtentTestManager.getTest().log(Status.INFO,
				"Order_01_Print_Invoices - Step 06: Print invoices with first record in the table");
		orderListPage.checkToRecordCheckbox(1);
		orderListPage.selectActionSelectbox(action);
		orderListPage.clickSubmitButton();
		Assert.assertTrue(orderListPage.isFileDownloaded(filename));

	}

	@Test
	public void Order_02_View_Per_Page(Method method) {
		ExtentTestManager.startTest(method.getName() + "-" + this.browser.toUpperCase(), "Order_01_Print_Invoices");
		ExtentTestManager.getTest().log(Status.INFO, "Order_01_Print_Invoices - Step 01: Go to order list page");
		orderListPage.clickResetFilterButton();
		orderListPage.waitAdminPageLoadReady();

		ExtentTestManager.getTest().log(Status.INFO,
				"Order_01_Print_Invoices - Step 02: Verify if there are 20 records per page");
		Assert.assertTrue(orderListPage.isRecordPerPageCorrect(20));

		ExtentTestManager.getTest().log(Status.INFO,
				"Order_01_Print_Invoices - Step 03: Select view 30 record per page");
		orderListPage.selectViewPerPageSelectbox("30");
		orderListPage.waitAdminPageLoadReady();
		Assert.assertTrue(orderListPage.isRecordPerPageCorrect(30));
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Order_01_Print_Invoices - Step 04: Select view 50 record per page");
		orderListPage.selectViewPerPageSelectbox("50");
		orderListPage.waitAdminPageLoadReady();
		Assert.assertTrue(orderListPage.isRecordPerPageCorrect(50));
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Order_01_Print_Invoices - Step 05: Select view 100 record per page");
		orderListPage.selectViewPerPageSelectbox("100");
		orderListPage.waitAdminPageLoadReady();
		Assert.assertTrue(orderListPage.isRecordPerPageCorrect(100));
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Order_01_Print_Invoices - Step 06: Select view 200 record per page");
		orderListPage.selectViewPerPageSelectbox("200");
		orderListPage.waitAdminPageLoadReady();
		Assert.assertTrue(orderListPage.isRecordPerPageCorrect(200));

	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
