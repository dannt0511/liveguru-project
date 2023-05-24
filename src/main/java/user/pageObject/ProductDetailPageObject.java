package user.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.UserPageGeneratorManager;
import user.pageUIs.ProductDetailPageUI;

public class ProductDetailPageObject extends BasePage {
	private WebDriver driver;

	public ProductDetailPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getProductPrice() {
		waitForElementVisible(ProductDetailPageUI.PRICE);
		return getElementText(ProductDetailPageUI.PRICE);
	}

	public ReviewProductPageObject clickAddReviewLink() {
		waitForElementClickable(ProductDetailPageUI.ADD_REVIEW_LINK);
		clickToElement(ProductDetailPageUI.ADD_REVIEW_LINK);
		return UserPageGeneratorManager.openReviewProductPage(driver);
	}

	public void clickReviewTab() {
		waitForElementClickable(ProductDetailPageUI.REVIEW_TAB);
		clickToElement(ProductDetailPageUI.REVIEW_TAB);

	}

	public boolean isReviewSummaryDisplayed(String reviewTitle) {
		return isElementDisplayed(ProductDetailPageUI.REVIEW_RECORD_BY_SUMMARY, reviewTitle);
	}

}
