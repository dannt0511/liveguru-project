package commons;

import org.openqa.selenium.WebDriver;

import user.pageObject.CompareProductPageObject;
import user.pageObject.HomePageObject;
import user.pageObject.LoginPageObject;
import user.pageObject.LogoutPageObject;
import user.pageObject.MyAccountDashboardPageObject;
import user.pageObject.MyAccountInfoPageObject;
import user.pageObject.ProductDetailPageObject;
import user.pageObject.ProductListPageObject;
import user.pageObject.RegisterPageObject;
import user.pageObject.ReviewProductPageObject;
import user.pageObject.ShareWishlistPageObject;
import user.pageObject.ShoppingCartPageObject;
import user.pageObject.WishlistPageObject;

public class PageGeneratorManager {

	public static HomePageObject openHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static RegisterPageObject openRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static MyAccountDashboardPageObject openAccountDashboardPage(WebDriver driver) {
		return new MyAccountDashboardPageObject(driver);
	}

	public static MyAccountInfoPageObject openAccountInfoPage(WebDriver driver) {
		return new MyAccountInfoPageObject(driver);
	}

	public static LogoutPageObject openLogoutPage(WebDriver driver) {
		return new LogoutPageObject(driver);
	}

	public static LoginPageObject openLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static ProductListPageObject openProductListPage(WebDriver driver) {
		return new ProductListPageObject(driver);
	}

	public static ProductDetailPageObject openProductDetailPage(WebDriver driver) {
		return new ProductDetailPageObject(driver);
	}

	public static ShoppingCartPageObject openShoppingCartPage(WebDriver driver) {
		return new ShoppingCartPageObject(driver);
	}

	public static CompareProductPageObject openCompareProductPage(WebDriver driver) {
		return new CompareProductPageObject(driver);
	}

	public static WishlistPageObject openWishlistPage(WebDriver driver) {
		return new WishlistPageObject(driver);
	}

	public static ShareWishlistPageObject openShareWishlistPage(WebDriver driver) {
		return new ShareWishlistPageObject(driver);
	}

	public static ReviewProductPageObject openReviewProductPage(WebDriver driver) {
		return new ReviewProductPageObject(driver);
	}

}
