package user.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.UserPageGeneratorManager;
import user.pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void inputEmailTextbox(String email) {
		waitForElementClickable(LoginPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(LoginPageUI.EMAIL_TEXTBOX, email);

	}

	public void inputPasswordTextbox(String password) {
		waitForElementClickable(LoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(LoginPageUI.PASSWORD_TEXTBOX, password);

	}

	public MyAccountDashboardPageObject clickLoginButton() {
		waitForElementClickable(LoginPageUI.LOGIN_BUTTON);
		clickToElement(LoginPageUI.LOGIN_BUTTON);
		return UserPageGeneratorManager.openAccountDashboardPage(driver);
	}

}
