package user.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import user.pageUIs.ShareWishlistPageUI;

public class ShareWishlistPageObject extends BasePage {
	private WebDriver driver;
	public ShareWishlistPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void inputShareEmailTextbox(String shareEmail) {
		waitForPageLoadReady();
		waitForElementClickable(ShareWishlistPageUI.EMAIL_TEXTAREA);
		sendKeysToElement(ShareWishlistPageUI.EMAIL_TEXTAREA, shareEmail);
	}

	public WishlistPageObject clickShareWishlistButton() {
		waitForElementClickable(ShareWishlistPageUI.SHARE_WISHLIST_BUTTON);
		clickToElement(ShareWishlistPageUI.SHARE_WISHLIST_BUTTON);
		return PageGeneratorManager.openWishlistPage(driver);
	}
}
