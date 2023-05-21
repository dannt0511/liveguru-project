package commons;

import org.openqa.selenium.WebDriver;

import admin.pageObject.CustomerListPageObject;
import admin.pageObject.LoginPageObject;

public class AdminPageGeneratorManager {

	public static LoginPageObject openLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static CustomerListPageObject openCustomerListPage(WebDriver driver) {
		return new CustomerListPageObject(driver);
	}

}
