package user.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import user.pageUIs.MyAccountInfoPageUI;

public class MyAccountInfoPageObject extends BasePage {

	
	public MyAccountInfoPageObject(WebDriver driver) {
		super(driver);
	}

	public String getFirstnameTextboxValue() {
		waitForElementVisible(MyAccountInfoPageUI.FIRSTNAME_TEXTBOX);
		return getAttributeValue(MyAccountInfoPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastnameTextboxValue() {
		waitForElementVisible(MyAccountInfoPageUI.LASTNAME_TEXTBOX);
		return getAttributeValue(MyAccountInfoPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(MyAccountInfoPageUI.EMAIL_TEXTBOX);
		return getAttributeValue(MyAccountInfoPageUI.EMAIL_TEXTBOX, "value");
	}

}
