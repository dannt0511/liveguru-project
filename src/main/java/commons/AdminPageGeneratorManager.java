package commons;

import org.openqa.selenium.WebDriver;

import admin.pageObject.CustomerListPageObject;
import admin.pageObject.EditReviewPageObject;
import admin.pageObject.LoginPageObject;
import admin.pageObject.OrderListPageObject;
import admin.pageObject.ReviewListPageObject;

public class AdminPageGeneratorManager {

	public static LoginPageObject openLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static CustomerListPageObject openCustomerListPage(WebDriver driver) {
		return new CustomerListPageObject(driver);
	}

	public static ReviewListPageObject openReviewListPage(WebDriver driver) {
		return new ReviewListPageObject(driver);
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

	public static EditReviewPageObject openEditReviewPage(WebDriver driver) {
		return new EditReviewPageObject(driver);
	}

}
