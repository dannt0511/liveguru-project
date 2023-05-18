package user.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import user.pageUIs.ReviewProductPageUI;

public class ReviewProductPageObject extends BasePage {

	public ReviewProductPageObject(WebDriver driver) {
		super(driver);
	}

	public void selectRatingReview(String rating) {
		waitForElementClickable(ReviewProductPageUI.RATING_BY_VALUE, rating);
		checkTheCheckboxOrRadio(ReviewProductPageUI.RATING_BY_VALUE, rating);

	}

	public void setTextboxBlank(String string) {
		waitForElementClickable(ReviewProductPageUI.NICKNAME_TEXTBOX);

	}

	public void clickSubmitButton() {
		waitForElementClickable(ReviewProductPageUI.SUBMIT_BUTTON);
		clickToElement(ReviewProductPageUI.SUBMIT_BUTTON);

	}

	public String getYourThoughtTextareaErrorMsg() {
		waitForElementVisible(ReviewProductPageUI.YOUR_THOUGHT_TEXTAREA_ERROR_MSG);
		return getElementText(ReviewProductPageUI.YOUR_THOUGHT_TEXTAREA_ERROR_MSG);
	}
	
	public String getTextboxErrorMsg(String textboxName) {
		waitForElementVisible(ReviewProductPageUI.ERROR_MSG_BY_TEXTBOX_NAME, textboxName);
		return getElementText(ReviewProductPageUI.ERROR_MSG_BY_TEXTBOX_NAME, textboxName);
	}

	public void inputToYourThoughtTextbox(String reviewDetail) {
		waitForElementClickable(ReviewProductPageUI.YOUR_THOUGHT_TEXTBOX);
		sendKeysToElement(ReviewProductPageUI.YOUR_THOUGHT_TEXTBOX, reviewDetail);

	}

	public void inputToSummaryTextbox(String reviewTitle) {
		waitForElementClickable(ReviewProductPageUI.TITLE_TEXTBOX);
		sendKeysToElement(ReviewProductPageUI.TITLE_TEXTBOX, reviewTitle);

	}

	public void inputToNicknameTextbox(String reviewNickname) {
		waitForElementClickable(ReviewProductPageUI.NICKNAME_TEXTBOX);
		sendKeysToElement(ReviewProductPageUI.NICKNAME_TEXTBOX, reviewNickname);

	}

	public String getSuccessMsg() {
		waitForElementVisible(ReviewProductPageUI.SUCCESS_MSG);
		return getElementText(ReviewProductPageUI.SUCCESS_MSG);
	}

}
