package user.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.UserPageGeneratorManager;
import user.pageUIs.AdvancedSearchPageUI;

public class AdvancedSearchPageObject extends BasePage {
	private WebDriver driver;

	public AdvancedSearchPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void inputPriceFromTextbox(String priceFrom) {
		waitForElementClickable(AdvancedSearchPageUI.PRICE_FROM);
		sendKeysToElement(AdvancedSearchPageUI.PRICE_FROM, priceFrom);

	}

	public void inputPriceToTextbox(String priceTo) {
		waitForElementClickable(AdvancedSearchPageUI.PRICE_TO);
		sendKeysToElement(AdvancedSearchPageUI.PRICE_TO, priceTo);

	}

	public AdvanceSearchResultPageObject clickSearchButton() {
		waitForElementClickable(AdvancedSearchPageUI.SEARCH_BUTTON);
		clickToElement(AdvancedSearchPageUI.SEARCH_BUTTON);
		return UserPageGeneratorManager.openAdvancedSearchResultPage(driver);
	}

}
