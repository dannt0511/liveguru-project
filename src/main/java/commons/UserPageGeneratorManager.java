package commons;

import org.openqa.selenium.WebDriver;

import user.pageObject.AdvanceSearchResultPageObject;
import user.pageObject.AdvancedSearchPageObject;
import user.pageObject.CheckoutPageObject;
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

public class UserPageGeneratorManager {

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

	public static CheckoutPageObject openCheckoutPage(WebDriver driver) {
		return new CheckoutPageObject(driver);
	}

	public static AdvancedSearchPageObject openAdvanceSearchPage(WebDriver driver) {
		return new AdvancedSearchPageObject(driver);
	}

	public static AdvanceSearchResultPageObject openAdvancedSearchResultPage(WebDriver driver) {
		return new AdvanceSearchResultPageObject(driver);
	}

}
