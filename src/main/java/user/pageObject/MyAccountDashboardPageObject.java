package user.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import user.pageUIs.MyAccountDashboardPageUI;

public class MyAccountDashboardPageObject extends BasePage {

	public MyAccountDashboardPageObject(WebDriver driver) {
		super(driver);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(MyAccountDashboardPageUI.REGISTER_SUCCESS_MSG);
		return getElementText(MyAccountDashboardPageUI.REGISTER_SUCCESS_MSG);
	}

	public String getPageTitle() {
		waitForElementVisible(MyAccountDashboardPageUI.PAGE_TITLE);
		return getElementText(MyAccountDashboardPageUI.PAGE_TITLE);
	}

	public String getWelcomeMessage() {
		waitForElementVisible(MyAccountDashboardPageUI.WELCOME_MSG);
		return getElementText(MyAccountDashboardPageUI.WELCOME_MSG);
	}

}
