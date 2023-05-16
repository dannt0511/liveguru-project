package user.pageUIs;

public class ShoppingCartPageUI {
	public static final String COUPON_TEXTBOX = "css=input#coupon_code";
	public static final String APPLY_COUPON_LINK = "xpath=//button[@title='Apply']";
	public static final String SUCCESS_MSG = "css=li.success-msg";
	public static final String APPLIED_DISCOUNT_CODE = "xpath=//td[contains(text(),'Discount')]";
	public static final String DISCOUNT_PRICE = "xpath=//td[contains(text(),'Discount')]//following-sibling::td/span";
	public static final String QTY_TEXTBOX = "xpath=//input[@title = 'Qty']";
	public static final String UPDATE_QTY_BUTTON = "xpath=//button[@title='Update']";
	public static final String ERROR_MSG = "css=li.error-msg";
	public static final String ITEM_ERROR_MSG_BY_PRODUCT_NAME = "xpath=//a[text() = '%s']//parent::h2//following-sibling::p";
	public static final String EMPTY_CART_LINK = "xpath=//button[@title='Empty Cart']";
	public static final String PAGE_TITLE = "CSS=div.page-title h1";
	public static final String EMPTY_CART_MSG = "xpath=//div[@class='cart-empty']/p[1]";
}
