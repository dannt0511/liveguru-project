package user.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import user.pageUIs.ShoppingCartPageUI;

public class ShoppingCartPageObject extends BasePage {

	public ShoppingCartPageObject(WebDriver driver) {
		super(driver);
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
		waitForPageLoadReady();
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
		waitForPageLoadReady();
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
		waitForPageLoadReady();
		waitForElementVisible(ShoppingCartPageUI.PAGE_TITLE);
		return getElementText(ShoppingCartPageUI.PAGE_TITLE).trim();
	}
}
