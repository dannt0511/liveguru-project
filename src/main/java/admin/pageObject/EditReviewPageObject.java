package admin.pageObject;

import org.openqa.selenium.WebDriver;

import admin.pageUIs.EditReviewPageUI;
import commons.AdminPageGeneratorManager;
import commons.BasePage;

public class EditReviewPageObject extends BasePage {
	private WebDriver driver;

	public EditReviewPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void selectReviewStatus(String updateStatus) {
		waitForElementClickable(EditReviewPageUI.STATUS_SELECTBOX);
		selectInDefaultDropdown(EditReviewPageUI.STATUS_SELECTBOX, updateStatus);

	}

	public ReviewListPageObject clickSaveReviewButton() {
		waitForElementClickable(EditReviewPageUI.SAVE_REVIEW_BUTTON);
		clickToElement(EditReviewPageUI.SAVE_REVIEW_BUTTON);
		return AdminPageGeneratorManager.openReviewListPage(driver);
	}

}
