package user.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import user.pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void inputFirstnameTextbox(String firstName) {
		waitForElementClickable(RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeysToElement(RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);

	}

	public void inputLastnameTextbox(String lastName) {
		waitForElementClickable(RegisterPageUI.LASTNAME_TEXTBOX);
		sendKeysToElement(RegisterPageUI.LASTNAME_TEXTBOX, lastName);

	}

	public void inputEmailTextbox(String email) {
		waitForElementClickable(RegisterPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(RegisterPageUI.EMAIL_TEXTBOX, email);

	}

	public void inputPasswordTextbox(String password) {
		waitForElementClickable(RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(RegisterPageUI.PASSWORD_TEXTBOX, password);

	}

	public void inputConfirmPasswordTextbox(String rePassword) {
		waitForElementClickable(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeysToElement(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, rePassword);

	}

	public MyAccountDashboardPageObject clickRegisterButton() {
		waitForElementClickable(RegisterPageUI.REGISTER_BUTTON);
		clickToElement(RegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.openAccountDashboardPage(driver);
	}

}
