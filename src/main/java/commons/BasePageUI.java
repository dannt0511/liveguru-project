package commons;

public class BasePageUI {

	public static final String USER_HEADER_ACCOUNT_MENU = "css=div.account-cart-wrapper>a";
	public static final String USER_HEADER_ACCOUNT_PULLDOWN = "xpath=//div[@id='header-account']";
	public static final String USER_HEADER_ACCOUNT_MENU_LINK_BY_NAME = "xpath=//div[@id='header-account']//a[text() = '%s']";

	public static final String USER_LOGO = "css=a.logo";
	public static final String USER_NAV_MENU = "xpath=//a[text() = '%s']";

	public static final String USER_SIDE_MENU_DYNAMIC_LOCATOR_BY_NAME = "xpath=//a[text() = 'Account Information']";
	public static final String USER_FOOTER_DYNAMIC_LOCATOR_BY_NAME = "xpath=//div[@class='footer']//a[text() = '%s']";

	public static final String ADMIN_NAV_BAR_MENU_BY_NAME = "xpath=//span[text() = '%s']//ancestor::li";
	public static final String ADMIN_NAV_BAR_SUB_MENU_LEVEL_1 = "xpath=//span[text() = '%s']";
	public static final String ADMIN_NAV_BAR_SUB_MENU_LEVEL_2 = "xpath=//li[@class='parent level2']";
	public static final String ADMIN_NAV_BAR_DESTINATION_MENU = "xpath=//span[text()='%s']//parent::a";
	public static final String ADMIN_SEARCH_BUTTON = "xpath=//button[@title='Search']";
	public static final String ADMIN_TABLE_CHECKBOX = "xpath=//input[@type='checkbox']";
	public static final String ADMIN_ACTION_SELECTBOX = "CSS=select#sales_order_grid_massaction-select";
	public static final String ADMIN_SUBMIT_BUTTON = "xpath=//button[@title='Submit']";
	public static final String ADMIN_LOADING_ICON = "css=p#loading_mask_loader";
	public static final String ADMIN_TABLE_HEADER_BY_NAME = "xpath=//span[text() = '%s']//parent::a";
	public static final String TABLE_SORT_ASC = "css=a.sort-arrow-asc";
}
