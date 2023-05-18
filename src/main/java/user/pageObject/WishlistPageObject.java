package user.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import user.pageUIs.WishlistPageUI;

public class WishlistPageObject extends BasePage {
	private WebDriver driver;

	public WishlistPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getSuccessMsg() {
		waitForPageLoadReady();
		waitForElementVisible(WishlistPageUI.SUCCESS_MSG);
		return getElementText(WishlistPageUI.SUCCESS_MSG);
	}

	public ShareWishlistPageObject clickShareWishlistButton() {
		waitForElementClickable(WishlistPageUI.SHARE_WISHLIST_BUTTON);
		clickToElement(WishlistPageUI.SHARE_WISHLIST_BUTTON);
		return PageGeneratorManager.openShareWishlistPage(driver);

	}

	public boolean isProductDisplayed(String wishlistProduct) {
		waitForPageLoadReady();
		return isElementDisplayed(WishlistPageUI.PRODUCT_NAME_DYNAMIC_LOCATOR, wishlistProduct);
	}

}
