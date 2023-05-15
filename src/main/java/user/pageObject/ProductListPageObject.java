package user.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import user.pageUIs.ProductListPageUI;

public class ProductListPageObject extends BasePage {
	private WebDriver driver;

	public ProductListPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getProductPriceByName(String productName) {
		waitForElementVisible(ProductListPageUI.PRICE_BY_PRODUCT_NAME, productName);
		return getElementText(ProductListPageUI.PRICE_BY_PRODUCT_NAME, productName);
	}

	public ProductDetailPageObject clickProductName(String productName) {
		waitForElementClickable(ProductListPageUI.PRODUCT_NAME_DYNAMIC_LOCATOR, productName);
		clickToElement(ProductListPageUI.PRODUCT_NAME_DYNAMIC_LOCATOR, productName);
		return PageGeneratorManager.openProductDetailPage(driver);
	}

}
