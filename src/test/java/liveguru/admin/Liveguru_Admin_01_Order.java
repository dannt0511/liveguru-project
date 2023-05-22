package liveguru.admin;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
	private String browser, record_status_01, record_status_02, action,actionErrorMsg,filename;
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
		ExtentTestManager.startTest(method.getName() + "-" + this.browser.toUpperCase(),
				"Order_01_Print_Invoices");
		ExtentTestManager.getTest().log(Status.INFO,
				"Order_01_Print_Invoices - Step 01: Open order list page");
		orderListPage = (OrderListPageObject) customerListPage.openPageFromNavBar("Sales","Orders");
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Order_01_Print_Invoices - Step 02: Search record with status '"+record_status_01+"'");
		orderListPage.selectRecordStatus(record_status_01);
		orderListPage.clickSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Order_01_Print_Invoices - Step 03: Print invoices with first record in the table");
		orderListPage.selectFirstRecordCheckboxInTable();
		orderListPage.selectActionSelectbox(action);
		orderListPage.clickSubmitButton();
	
		ExtentTestManager.getTest().log(Status.INFO,
				"Order_01_Print_Invoices - Step 04: Verify message error");
		Assert.assertEquals(orderListPage.getErrorMsg(), actionErrorMsg);
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Order_01_Print_Invoices - Step 05: Search record with status '"+record_status_02+"'");
		orderListPage.selectRecordStatus(record_status_02);
		orderListPage.clickSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Order_01_Print_Invoices - Step 06: Print invoices with first record in the table");
		orderListPage.selectFirstRecordCheckboxInTable();
		orderListPage.selectActionSelectbox(action);
		orderListPage.clickSubmitButton();
		Assert.assertTrue(orderListPage.isFileDownloaded(filename));;
	}
}
