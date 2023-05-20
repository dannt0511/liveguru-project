package user.pageUIs;

public class ShoppingCartPageUI {
	public static final String COUPON_TEXTBOX = "css=input#coupon_code";
	public static final String APPLY_COUPON_LINK = "xpath=//button[@title='Apply']";
	public static final String CANCEL_COUPON_LINK = "xpath=//button[@title='Cancel']";
	public static final String SUCCESS_MSG = "css=li.success-msg";
	public static final String APPLIED_DISCOUNT_CODE = "xpath=//td[contains(text(),'Discount')]";
	public static final String DISCOUNT_PRICE = "xpath=//td[contains(text(),'Discount')]//following-sibling::td/span";
	public static final String COUNTRY_SELECTBOX = "css=select#country";
	public static final String STATE_TEXTBOX = "css=select#region_id";
	public static final String ZIP_TEXTBOX = "css=input#postcode";
	public static final String ESTIMATE_LINK = "xpath=//button[@title='Estimate']";
	public static final String ESTIMATE_SHIPPING_COST = "xpath=//label[@for='s_method_flatrate_flatrate']/span";
	public static final String ESTIMATE_SHIPPING_RADIO = "xpath=//input[@name='estimate_method']";
	public static final String UPDATE_TOTAL_BUTTON = "xpath=//button[@value='Update Total']";
	public static final String TOTAL_PRICE = "xpath=//strong[text() = 'Grand Total']//parent::td//following-sibling::td//span";
	public static final String PROCEED_TO_CHECKOUT_BUTTON = "css=ul.bottom button";

	public static final String QTY_TEXTBOX = "xpath=//input[@title = 'Qty']";
	public static final String UPDATE_QTY_BUTTON = "xpath=//button[@title='Update']";
	public static final String ERROR_MSG = "css=li.error-msg";
	public static final String ITEM_ERROR_MSG_BY_PRODUCT_NAME = "xpath=//a[text() = '%s']//parent::h2//following-sibling::p";
	public static final String EMPTY_CART_LINK = "xpath=//button[@title='Empty Cart']";
	public static final String PAGE_TITLE = "CSS=div.page-title h1";
	public static final String EMPTY_CART_MSG = "xpath=//div[@class='cart-empty']/p[1]";
}
