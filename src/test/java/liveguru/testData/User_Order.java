package liveguru.testData;

public class User_Order {
	public static final String PRODUCT_NAME = "Sony Xperia";

	public static class Coupon {
		public static final String COUPON_CODE = "GURU50";
		public static final String SUCCESS_MSG = "Coupon code \"GURU50\" was applied.";
		public static final String DISCOUNT_PRICE = "-$5.00";

	}

	public static class Edit_Qty {
		public static final String EDIT_QTY = "501";
		public static final String ERROR_MSG = "Some of the products cannot be ordered in requested quantity.";
		public static final String ITEM_ERROR_MSG = "* The maximum quantity allowed for purchase is 500.";
		public static final String EMPTY_MSG = "You have no items in your shopping cart.";
		public static final String EMPTY_PAGE_TITLE = "SHOPPING CART IS EMPTY";

	}

	public static class Purchase_Product {
		public static final String SHIPPING_FIRSTNAME = "Ariana";
		public static final String SHIPPING_LASTNAME = "Welch";
		public static final String SHIPPING_COUNTRY = "United States";
		public static final String SHIPPING_STATE = "New York";
		public static final String SHIPPING_ZIP = "543432";
		public static final String SHIPPING_ADDRESS = "162 Ford Street";
		public static final String SHIPPING_PHONE = "490-967-106";
		public static final String SHIPPING_EXPECT_SHIP_COST = "$5.00";
		public static final String EXPECT_TOTAL_PRICE = "$100.00";

		public static final String BILLING_COUNTRY = "United States";
		public static final String BILLING_STATE = "New York";
		public static final String BILLING_ZIP = "34616";
		public static final String BILLING_ADDRESS = "155 Atkins Avenue APT 63";
		public static final String BILLING_PHONE = "687-570-4586";
		public static final String PAYMENT_METHOD = "Check / Money order";
		public static final String ORDER_CREATE_MSG = "YOUR ORDER HAS BEEN RECEIVED.";
	}
}
