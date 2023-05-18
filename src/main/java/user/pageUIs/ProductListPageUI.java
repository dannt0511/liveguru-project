package user.pageUIs;

public class ProductListPageUI {
	public static final String PRICE_BY_PRODUCT_NAME = "xpath=//a[text() = '%s']//parent::h2//following-sibling::div//span[@class='price']";
	public static final String ADD_TO_CART_BUTTON_BY_PRODUCT_NAME = "xpath=//a[text() = '%s']//parent::h2//following-sibling::div//button";
	public static final String PRODUCT_NAME_DYNAMIC_LOCATOR = "xpath=//a[text() = '%s']";
	public static final String ADD_TO_COMPARE_LINK_BY_PRODUCT_NAME = "xpath=//a[text() = '%s']//parent::h2//following-sibling::div/ul//a[@class='link-compare']";
	public static final String ADD_TO_WISHLIST_LINK_BY_PRODUCT_NAME = "xpath=//a[text() = '%s']//parent::h2//following-sibling::div/ul//a[@class='link-wishlist']";
	public static final String SUCCESS_MSG = "css=li.success-msg";
	public static final String COMPARE_BUTTON = "xpath=//button[@title='Compare']";
}
