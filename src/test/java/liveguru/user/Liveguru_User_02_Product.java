package liveguru.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import reportConfig.ExtentTestManager;
import user.pageObject.HomePageObject;
import user.pageObject.ProductDetailPageObject;
import user.pageObject.ProductListPageObject;

public class Liveguru_User_02_Product extends BaseTest {
	private WebDriver driver;
	private String browser, productName, productListPagePrice, detailPagePrice;
	private HomePageObject homePage;
	private ProductListPageObject productListPage;
	private ProductDetailPageObject productDetailPage;

	@Parameters({ "browser", "userAppUrl" })
	@BeforeClass
	public void beforeClass(String browser, String appUrl) {
		this.browser = browser;
		productName = "Sony Xperia";

		driver = openBrowsers(browser, appUrl);
		homePage = PageGeneratorManager.openHomePage(driver);

	}

	@Test
	public void Product_01_Product_Price(Method method) {
		ExtentTestManager.startTest(method.getName() + "-" + this.browser.toUpperCase(), "Product_01_Product_Price");
		ExtentTestManager.getTest().log(Status.INFO, "Product_01_Product_Price - Step 01: Open mobile product list");
		productListPage = homePage.openProductListFromSubHeader("Mobile");

		ExtentTestManager.getTest().log(Status.INFO, "Product_01_Product_Price - Step 02: Get price of product name '"
				+ productName + "' on Product list screen");
		productListPagePrice = productListPage.getProductPriceByName(productName);

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_01_Product_Price - Step 03: Open product detail page of product name '" + productName + "'");
		productDetailPage = productListPage.clickProductName(productName);

		ExtentTestManager.getTest().log(Status.INFO, "Product_01_Product_Price - Step 04: Open price of product name '"
				+ productName + "' on Product detail screen");
		detailPagePrice = productDetailPage.getProductPrice();

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_01_Product_Price - Step 05: Verify if the price on product list screen is equal to the price on product detail screen");
		Assert.assertEquals(productListPagePrice, detailPagePrice);
	}
}
