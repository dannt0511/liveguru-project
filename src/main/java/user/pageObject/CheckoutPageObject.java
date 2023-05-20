package user.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import user.pageUIs.CheckoutPageUI;

public class CheckoutPageObject extends BasePage {

	public CheckoutPageObject(WebDriver driver) {
		super(driver);
	}

	public void inputBillingTextboxByName(String textboxName, String content) {
		waitForElementClickable(CheckoutPageUI.BILLING_TEXTBOX, textboxName);
		sendKeysToElement(CheckoutPageUI.BILLING_TEXTBOX, content, textboxName);

	}

	public void selectBillingSelectbox(String selectboxName, String content) {
		waitForElementClickable(CheckoutPageUI.BILLING_SELECTBOX, selectboxName);
		selectInDefaultDropdown(CheckoutPageUI.BILLING_SELECTBOX, content, selectboxName);

	}

	public void selectShipToOtherAddress() {
		waitForElementClickable(CheckoutPageUI.BILLING_NOT_USE_FOR_SHIPPING_NO_CHECKBOX);
		checkTheCheckboxOrRadio(CheckoutPageUI.BILLING_NOT_USE_FOR_SHIPPING_NO_CHECKBOX);
	}

	public void clickBillingContinueButton() {
		waitForElementClickable(CheckoutPageUI.BILLING_CONTINUE_BUTTON);
		clickToElement(CheckoutPageUI.BILLING_CONTINUE_BUTTON);

	}

	public void inputShippingTextboxByName(String textboxName, String content) {
		waitForElementClickable(CheckoutPageUI.SHIPPING_TEXTBOX, textboxName);
		sendKeysToElement(CheckoutPageUI.SHIPPING_TEXTBOX, content, textboxName);

	}

	public void selectShippingSelectbox(String selectboxName, String content) {
		waitForElementClickable(CheckoutPageUI.SHIPPING_SELECTBOX, selectboxName);
		selectInDefaultDropdown(CheckoutPageUI.SHIPPING_SELECTBOX, content, selectboxName);
	}

	public void clickShippingContinueButton() {
		waitForElementClickable(CheckoutPageUI.SHIPPING_CONTINUE_BUTTON);
		clickToElement(CheckoutPageUI.SHIPPING_CONTINUE_BUTTON);

	}

	public void clickShippingMethodContinueButton() {
		waitForElementClickable(CheckoutPageUI.SHIPPING_METHOD_CONTINUE_BUTTON);
		clickToElement(CheckoutPageUI.SHIPPING_METHOD_CONTINUE_BUTTON);

	}

	public void selectPaymentMethod(String paymentMethod) {
		waitForElementClickable(CheckoutPageUI.PAYMENT_METHOD_RADIO, paymentMethod);
		checkTheCheckboxOrRadio(CheckoutPageUI.PAYMENT_METHOD_RADIO, paymentMethod);

	}

	public void clickPaymentMethodContinueButton() {
		waitForElementClickable(CheckoutPageUI.PAYMENT_METHOD_CONTINUE_BUTTON);
		clickToElement(CheckoutPageUI.PAYMENT_METHOD_CONTINUE_BUTTON);

	}

	public void clickPlaceOrderButton() {
		waitForElementClickable(CheckoutPageUI.PLACE_ORDER_BUTTON);
		clickToElement(CheckoutPageUI.PLACE_ORDER_BUTTON);

	}

	public String getPageTitle() {
		waitForElementInvisible(CheckoutPageUI.WAITING_REVIEW);
		waitForElementVisible(CheckoutPageUI.SUCCESS_PAGE_TITLE);
		return getElementText(CheckoutPageUI.SUCCESS_PAGE_TITLE);
	}

}
