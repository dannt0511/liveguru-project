package commons;

import org.openqa.selenium.WebDriver;

import admin.pageObject.CustomerListPageObject;
import admin.pageObject.LoginPageObject;
import admin.pageObject.OrderListPageObject;

public class AdminPageGeneratorManager {

	public static LoginPageObject openLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static CustomerListPageObject openCustomerListPage(WebDriver driver) {
		return new CustomerListPageObject(driver);
	}

	public static BasePage openReviewListPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

	public static BasePage openRatingListPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

	public static OrderListPageObject openOrderListPage(WebDriver driver) {
		return new OrderListPageObject(driver);
	}

	public static BasePage openInvoicesListPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

}
