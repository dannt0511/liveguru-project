package user.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import user.pageUIs.CompareProductPageUI;

public class CompareProductPageObject extends BasePage {
	private WebDriver driver;

	public CompareProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getPageTitle() {
		waitForPageLoadReady();
		return driver.getTitle();
	}

	public boolean isProductDisplayed(String productName) {
		waitForElementVisible(CompareProductPageUI.PRODUCT_NAME_DYNAMIC_LOCATOR, productName);
		return isElementDisplayed(CompareProductPageUI.PRODUCT_NAME_DYNAMIC_LOCATOR, productName);
	}

	public ProductListPageObject closeWindow(String winId) {
		deleteAllWinExceptParent(winId);
		return PageGeneratorManager.openProductListPage(driver);
	}

}
