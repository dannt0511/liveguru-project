package user.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import user.pageUIs.ProductDetailPageUI;

public class ProductDetailPageObject extends BasePage {

	public ProductDetailPageObject(WebDriver driver) {
		super(driver);
	}

	public String getProductPrice() {
		waitForElementVisible(ProductDetailPageUI.PRICE);
		return getElementText(ProductDetailPageUI.PRICE);
	}

}
