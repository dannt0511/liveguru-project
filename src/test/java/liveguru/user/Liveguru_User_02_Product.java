package liveguru.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import reportConfig.ExtentTestManager;
import user.pageObject.CompareProductPageObject;
import user.pageObject.HomePageObject;
import user.pageObject.ProductDetailPageObject;
import user.pageObject.ProductListPageObject;

public class Liveguru_User_02_Product extends BaseTest {
	private WebDriver driver;
	private String browser, firstProductName, secondProductName, productListPagePrice, detailPagePrice, firstSuccessMsg,
			secondSuccessMsg, currentWinId, winTitle;
	private HomePageObject homePage;
	private ProductListPageObject productListPage;
	private ProductDetailPageObject productDetailPage;
	private CompareProductPageObject compareProductPage;

	@Parameters({ "browser", "userAppUrl" })
	@BeforeClass
	public void beforeClass(String browser, String appUrl) {
		this.browser = browser;
		firstProductName = "Sony Xperia";
		secondProductName = "IPhone";
		firstSuccessMsg = "The product Sony Xperia has been added to comparison list.";
		secondSuccessMsg = "The product IPhone has been added to comparison list.";
		winTitle = "Products Comparison List - Magento Commerce";

		driver = openBrowsers(browser, appUrl);
		homePage = PageGeneratorManager.openHomePage(driver);
		currentWinId = homePage.getWindowHandle();

	}

	@Test
	public void Product_01_Product_Price(Method method) {
		ExtentTestManager.startTest(method.getName() + "-" + this.browser.toUpperCase(), "Product_01_Product_Price");
		ExtentTestManager.getTest().log(Status.INFO, "Product_01_Product_Price - Step 01: Open mobile product list");
		productListPage = homePage.openProductListFromSubHeader("Mobile");

		ExtentTestManager.getTest().log(Status.INFO, "Product_01_Product_Price - Step 02: Get price of product name '"
				+ firstProductName + "' on Product list screen");
		productListPagePrice = productListPage.getProductPriceByName(firstProductName);

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_01_Product_Price - Step 03: Open product detail page of product name '" + firstProductName
						+ "'");
		productDetailPage = productListPage.clickProductName(firstProductName);

		ExtentTestManager.getTest().log(Status.INFO, "Product_01_Product_Price - Step 04: Open price of product name '"
				+ firstProductName + "' on Product detail screen");
		detailPagePrice = productDetailPage.getProductPrice();

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_01_Product_Price - Step 05: Verify if the price on product list screen is equal to the price on product detail screen");
		Assert.assertEquals(productListPagePrice, detailPagePrice);
	}

	@Test
	public void Product_02_Compare_Products(Method method) {
		ExtentTestManager.startTest(method.getName() + "-" + this.browser.toUpperCase(), "Product_02_Compare_Products");
		ExtentTestManager.getTest().log(Status.INFO,
				"Product_02_Compare_Products - Step 01: Back to mobile product list");
		productListPage = productDetailPage.openProductListFromSubHeader("Mobile");

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_02_Compare_Products - Step 02: Add product name '" + firstProductName + "' to compare list");
		productListPage.addProductToCompareList(firstProductName);

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_02_Compare_Products - Step 03: Verify if the product is added to list successfully");
		Assert.assertEquals(productListPage.getSuccessMsg(), firstSuccessMsg);

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_02_Compare_Products - Step 04: Add product name '" + secondProductName + "' to compare list");
		productListPage.addProductToCompareList(secondProductName);

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_02_Compare_Products - Step 05: Verify if the product is added to list successfully");
		Assert.assertEquals(productListPage.getSuccessMsg(), secondSuccessMsg);

		ExtentTestManager.getTest().log(Status.INFO, "Product_02_Compare_Products - Step 06: Click Compare button");
		compareProductPage = productListPage.clickCompareButton(currentWinId);

		ExtentTestManager.getTest().log(Status.INFO,
				"Product_02_Compare_Products - Step 07: Verify if the products are displayed on the comparison window");
		Assert.assertEquals(compareProductPage.getPageTitle(), winTitle);
		Assert.assertTrue(compareProductPage.isProductDisplayed(firstProductName));
		Assert.assertTrue(compareProductPage.isProductDisplayed(secondProductName));

		ExtentTestManager.getTest().log(Status.INFO, "Product_02_Compare_Products - Step 08: Close popup window");
		productListPage = compareProductPage.closeWindow(currentWinId);
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
