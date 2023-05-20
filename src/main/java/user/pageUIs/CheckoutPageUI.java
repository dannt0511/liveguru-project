package user.pageUIs;

public class CheckoutPageUI {
	public static final String BILLING_TEXTBOX = "xpath=//input[@id='billing:%s']";
	public static final String BILLING_SELECTBOX = "xpath=//select[@id='billing:%s']";
	public static final String BILLING_NOT_USE_FOR_SHIPPING_NO_CHECKBOX = "xpath=//input[@id='billing:use_for_shipping_no']";
	public static final String BILLING_CONTINUE_BUTTON = "css=div#billing-buttons-container button";

	public static final String SHIPPING_TEXTBOX = "xpath=//input[@id='shipping:%s']";
	public static final String SHIPPING_SELECTBOX = "xpath=//select[@id='shipping:%s']";
	public static final String SHIPPING_CONTINUE_BUTTON = "css=div#shipping-buttons-container button";
	public static final String SHIPPING_METHOD_CONTINUE_BUTTON = "css=div#shipping-method-buttons-container button";
	public static final String PAYMENT_METHOD_RADIO = "xpath=//input[@title='%s']";
	public static final String PAYMENT_METHOD_CONTINUE_BUTTON = "css=div#payment-buttons-container button";
	public static final String PLACE_ORDER_BUTTON = "xpath=//button[@title='Place Order']";
	public static final String SUCCESS_PAGE_TITLE = "css=body.checkout-onepage-success div.page-title h1";
	public static final String WAITING_REVIEW = "css=span.please-wait";
}
