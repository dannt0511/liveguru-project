package user.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.UserPageGeneratorManager;
import user.pageUIs.ShoppingCartPageUI;

public class ShoppingCartPageObject extends BasePage {
	private WebDriver driver;

	public ShoppingCartPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void inputCouponCodeTextbox(String couponCode) {
		waitForElementClickable(ShoppingCartPageUI.COUPON_TEXTBOX);
		sendKeysToElement(ShoppingCartPageUI.COUPON_TEXTBOX, couponCode);

	}

	public void clickCouponApplyLink() {
		waitForElementClickable(ShoppingCartPageUI.APPLY_COUPON_LINK);
		clickToElement(ShoppingCartPageUI.APPLY_COUPON_LINK);

	}

	public String getSuccessMsg() {
		waitForElementVisible(ShoppingCartPageUI.SUCCESS_MSG);
		return getElementText(ShoppingCartPageUI.SUCCESS_MSG);
	}

	public String getDiscountPrice() {
		waitForElementVisible(ShoppingCartPageUI.DISCOUNT_PRICE);
		return getElementText(ShoppingCartPageUI.DISCOUNT_PRICE);
	}

	public String getAppliedDiscountCode() {
		waitForElementVisible(ShoppingCartPageUI.APPLIED_DISCOUNT_CODE);
		String[] discountCode = getElementText(ShoppingCartPageUI.APPLIED_DISCOUNT_CODE).split(" ");
		return discountCode[1].trim();
	}

	public void inputQtyTextbox(String editQty) {
		waitForElementClickable(ShoppingCartPageUI.QTY_TEXTBOX);
		sendKeysToElement(ShoppingCartPageUI.QTY_TEXTBOX, editQty);
		clickToElement(ShoppingCartPageUI.QTY_TEXTBOX);

	}

	public void clickUpdateButton() {
		waitForElementClickable(ShoppingCartPageUI.UPDATE_QTY_BUTTON);
		clickToElement(ShoppingCartPageUI.UPDATE_QTY_BUTTON);

	}

	public String getErrorMessage() {
		waitForElementVisible(ShoppingCartPageUI.ERROR_MSG);
		return getElementText(ShoppingCartPageUI.ERROR_MSG);
	}

	public String getItemErrorMessage(String productName) {
		waitForElementVisible(ShoppingCartPageUI.ITEM_ERROR_MSG_BY_PRODUCT_NAME, productName);
		return getElementText(ShoppingCartPageUI.ITEM_ERROR_MSG_BY_PRODUCT_NAME, productName);
	}

	public void clickEmptyLink() {
		waitForElementClickable(ShoppingCartPageUI.EMPTY_CART_LINK);
		clickToElement(ShoppingCartPageUI.EMPTY_CART_LINK);

	}

	public String getEmptyMessage() {
		waitForElementVisible(ShoppingCartPageUI.EMPTY_CART_MSG);
		return getElementText(ShoppingCartPageUI.EMPTY_CART_MSG);
	}

	public String getPageTitle() {
		waitForElementVisible(ShoppingCartPageUI.PAGE_TITLE);
		return getElementText(ShoppingCartPageUI.PAGE_TITLE).trim();
	}

	public void selectCountrySelextbox(String shippingCountry) {
		waitForElementClickable(ShoppingCartPageUI.COUNTRY_SELECTBOX);
		selectInDefaultDropdown(ShoppingCartPageUI.COUNTRY_SELECTBOX, shippingCountry);

	}

	public void selectStateSelextbox(String shippingState) {
		waitForElementClickable(ShoppingCartPageUI.STATE_TEXTBOX);
		selectInDefaultDropdown(ShoppingCartPageUI.STATE_TEXTBOX, shippingState);

	}

	public void inputZipTextbox(String shippingZip) {
		waitForElementClickable(ShoppingCartPageUI.ZIP_TEXTBOX);
		sendKeysToElement(ShoppingCartPageUI.ZIP_TEXTBOX, shippingZip);

	}

	public void clickEstimateLink() {
		waitForElementClickable(ShoppingCartPageUI.ESTIMATE_LINK);
		clickToElement(ShoppingCartPageUI.ESTIMATE_LINK);

	}

	public String getShippingCost() {
		waitForElementVisible(ShoppingCartPageUI.ESTIMATE_SHIPPING_COST);
		return getElementText(ShoppingCartPageUI.ESTIMATE_SHIPPING_COST);
	}

	public void selectShippingCost() {
		waitForElementClickable(ShoppingCartPageUI.ESTIMATE_SHIPPING_RADIO);
		checkTheCheckboxOrRadio(ShoppingCartPageUI.ESTIMATE_SHIPPING_RADIO);

	}

	public void clickUpdateTotalButton() {
		waitForElementClickable(ShoppingCartPageUI.UPDATE_TOTAL_BUTTON);
		clickToElement(ShoppingCartPageUI.UPDATE_TOTAL_BUTTON);

	}

	public String getTotalPrice() {
		waitForElementVisible(ShoppingCartPageUI.TOTAL_PRICE);
		return getElementText(ShoppingCartPageUI.TOTAL_PRICE);
	}

	public CheckoutPageObject clickProceedToCheckoutButton() {
		waitForElementClickable(ShoppingCartPageUI.PROCEED_TO_CHECKOUT_BUTTON);
		clickToElement(ShoppingCartPageUI.PROCEED_TO_CHECKOUT_BUTTON);
		return UserPageGeneratorManager.openCheckoutPage(driver);
	}

	public void clickCouponCancelLink() {
		waitForElementClickable(ShoppingCartPageUI.CANCEL_COUPON_LINK);
		clickToElement(ShoppingCartPageUI.CANCEL_COUPON_LINK);

	}
}
