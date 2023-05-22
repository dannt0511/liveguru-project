package admin.pageObject;

import org.openqa.selenium.WebDriver;

import admin.pageUIs.CustomerListPageUI;
import commons.BasePage;

public class CustomerListPageObject extends BasePage{

	public CustomerListPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickCloseButtonOnPopup() {
		waitForElementClickable(CustomerListPageUI.POPUP_CLOSE_BUTTON);
		clickToElement(CustomerListPageUI.POPUP_CLOSE_BUTTON);
		waitForElementInvisible(CustomerListPageUI.POPUP);
		
	}



}
