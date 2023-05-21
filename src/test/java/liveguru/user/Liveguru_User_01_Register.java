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
import commons.UserPageGeneratorManager;
import reportConfig.ExtentTestManager;
import user.pageObject.HomePageObject;
import user.pageObject.LoginPageObject;
import user.pageObject.LogoutPageObject;
import user.pageObject.MyAccountDashboardPageObject;
import user.pageObject.MyAccountInfoPageObject;
import user.pageObject.RegisterPageObject;

public class Liveguru_User_01_Register extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private MyAccountDashboardPageObject accountDashboardPage;
	private MyAccountInfoPageObject accountInfoPage;
	private LogoutPageObject logoutPage;
	private LoginPageObject loginPage;
	private String browser, firstName, lastName, email, password, rePassword, successMessage, accountDashboardPageTitle,
			welcomeMessage;

	@Parameters({ "browser", "userAppUrl" })
	@BeforeClass
	public void beforeClass(String browser, String appUrl) {
		this.browser = browser;
		firstName = "Reagan";
		lastName = "Lynn";
		email = "reaganlynn" + randomNum() + "@mail.com";
		password = "3k3AhJgE";
		rePassword = "3k3AhJgE";
		successMessage = "Thank you for registering with Main Website Store.";
		accountDashboardPageTitle = "MY DASHBOARD";
		welcomeMessage = "Hello, " + firstName + " " + lastName + "!";
		driver = openBrowsers(browser, appUrl);
		homePage = UserPageGeneratorManager.openHomePage(driver);

	}

	@Test
	public void Register_01_Register_Success(Method method) {
		ExtentTestManager.startTest(method.getName() + "-" + this.browser.toUpperCase(),
				"Register_01_Register_Success");
		ExtentTestManager.getTest().log(Status.INFO,
				"Register_01_Register_Success - Step 01: Click My account menu and click Register link on pulldown");
		homePage.clickLinkOnMyAccountMenu("Register");
		registerPage = UserPageGeneratorManager.openRegisterPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Register_01_Register_Success - Step 02: Input textbox firstname with value '" + firstName + "'");
		registerPage.inputFirstnameTextbox(firstName);

		ExtentTestManager.getTest().log(Status.INFO,
				"Register_01_Register_Success - Step 03: Input textbox lastname with value '" + lastName + "'");
		registerPage.inputLastnameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO,
				"Register_01_Register_Success - Step 04: Input textbox email with value '" + email + "'");
		registerPage.inputEmailTextbox(email);

		ExtentTestManager.getTest().log(Status.INFO,
				"Register_01_Register_Success - Step 05: Input textbox password with value '" + password + "'");
		registerPage.inputPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO,
				"Register_01_Register_Success - Step 06: Input textbox confirm password with value '" + rePassword
						+ "'");
		registerPage.inputConfirmPasswordTextbox(rePassword);

		ExtentTestManager.getTest().log(Status.INFO, "Register_01_Register_Success - Step 07: Click Register button");
		accountDashboardPage = registerPage.clickRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO,
				"Register_01_Register_Success - Step 08: Verify if text is displayed after registering successfully");
		Assert.assertEquals(accountDashboardPage.getRegisterSuccessMessage(), successMessage);
	}

	@Test
	public void Register_02_Account_Info(Method method) {
		ExtentTestManager.startTest(method.getName() + "-" + this.browser.toUpperCase(), "Register_02_Account_Info");
		ExtentTestManager.getTest().log(Status.INFO, "Register_02_Account_Info - Step 01: Open Account info page");
		accountDashboardPage.openPage(BasePageUI.SIDE_MENU_DYNAMIC_LOCATOR_BY_NAME, "Account Information");
		accountInfoPage = UserPageGeneratorManager.openAccountInfoPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Register_02_Account_Info - Step 02: Verify if firstname textbox value is '" + firstName + "'");
		Assert.assertEquals(accountInfoPage.getFirstnameTextboxValue(), firstName);

		ExtentTestManager.getTest().log(Status.INFO,
				"Register_02_Account_Info - Step 03: Verify if lastname textbox value is '" + lastName + "'");
		Assert.assertEquals(accountInfoPage.getLastnameTextboxValue(), lastName);

		ExtentTestManager.getTest().log(Status.INFO,
				"Register_02_Account_Info - Step 04: Verify if email textbox value is '" + email + "'");
		Assert.assertEquals(accountInfoPage.getEmailTextboxValue(), email);

	}

	@Test
	public void Register_03_Login(Method method) {
		ExtentTestManager.startTest(method.getName() + "-" + this.browser.toUpperCase(), "Register_03_Login");
		ExtentTestManager.getTest().log(Status.INFO, "Register_03_Login - Step 01: Logout");
		accountInfoPage.clickLinkOnMyAccountMenu("Log Out");
		logoutPage = UserPageGeneratorManager.openLogoutPage(driver);
		homePage = logoutPage.clickLogo();

		ExtentTestManager.getTest().log(Status.INFO, "Register_03_Login - Step 02: Open Login page");
		homePage.clickLinkOnMyAccountMenu("Log In");
		loginPage = UserPageGeneratorManager.openLoginPage(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Register_03_Login - Step 03: Input email textbox with value '" + email + "'");
		loginPage.inputEmailTextbox(email);

		ExtentTestManager.getTest().log(Status.INFO,
				"Register_03_Login - Step 04: Input password textbox with value '" + password + "'");
		loginPage.inputPasswordTextbox(password);
		ExtentTestManager.getTest().log(Status.INFO, "Register_03_Login - Step 05: Click button Login");
		accountDashboardPage = loginPage.clickLoginButton();
		ExtentTestManager.getTest().log(Status.INFO,
				"Register_03_Login - Step 06: Verify if dashboard header text is displayed correctly");
		Assert.assertEquals(accountDashboardPage.getPageTitle(), accountDashboardPageTitle);
		Assert.assertEquals(accountDashboardPage.getWelcomeMessage(), welcomeMessage);
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
