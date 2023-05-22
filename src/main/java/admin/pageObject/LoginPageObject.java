package admin.pageObject;

import org.openqa.selenium.WebDriver;

import admin.pageUIs.LoginPageUI;
import commons.AdminPageGeneratorManager;
import commons.BasePage;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void inputUsernameTextbox(String username) {
		waitForElementClickable(LoginPageUI.USERNAME_TEXTBOX);
		sendKeysToElement(LoginPageUI.USERNAME_TEXTBOX, username);

	}

	public void inputPasswordTextbox(String password) {
		waitForElementClickable(LoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(LoginPageUI.PASSWORD_TEXTBOX, password);

	}

	public CustomerListPageObject clickLoginButton() {
		waitForElementClickable(LoginPageUI.LOGIN_BUTTON);
		clickToElement(LoginPageUI.LOGIN_BUTTON);
		return AdminPageGeneratorManager.openCustomerListPage(driver);
	}

}
