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

	public ShoppingCartPageObject addProductToCart(String productName) {
		waitForElementClickable(ProductListPageUI.ADD_TO_CART_BUTTON_BY_PRODUCT_NAME, productName);
		clickToElement(ProductListPageUI.ADD_TO_CART_BUTTON_BY_PRODUCT_NAME, productName);
		return PageGeneratorManager.openShoppingCartPage(driver);
	}

	public void addProductToCompareList(String productName) {
		waitForElementClickable(ProductListPageUI.ADD_TO_COMPARE_LINK_BY_PRODUCT_NAME, productName);
		clickToElement(ProductListPageUI.ADD_TO_COMPARE_LINK_BY_PRODUCT_NAME, productName);

	}

	public String getSuccessMsg() {
		waitForPageLoadReady();
		waitForElementVisible(ProductListPageUI.SUCCESS_MSG);
		return getElementText(ProductListPageUI.SUCCESS_MSG);
	}

	public CompareProductPageObject clickCompareButton(String currentWinId) {
		waitForElementClickable(ProductListPageUI.COMPARE_BUTTON);
		clickToElement(ProductListPageUI.COMPARE_BUTTON);
		switchToWinByID(currentWinId);
		return PageGeneratorManager.openCompareProductPage(driver);
	}

}
