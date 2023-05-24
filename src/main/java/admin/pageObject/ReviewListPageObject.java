package admin.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import admin.pageUIs.ReviewListPageUI;
import commons.AdminPageGeneratorManager;
import commons.BasePage;

public class ReviewListPageObject extends BasePage{
	private WebDriver driver;
	public ReviewListPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public EditReviewPageObject clickRecordEditLink(int index) {
		waitForAllElementsVisible(ReviewListPageUI.EDIT_LINK);
		List<WebElement> linkList = getElements(ReviewListPageUI.EDIT_LINK);
		linkList.get(index - 0).click();
		return AdminPageGeneratorManager.openEditReviewPage(driver);
	}

}
