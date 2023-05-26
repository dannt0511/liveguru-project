package admin.pageUIs;

public class OrderListPageUI {
	public static final String STATUS_SELECTBOX = "css=select#sales_order_grid_filter_status";
	public static final String ERROR_MSG = "css=li.error-msg";
	public static final String VIEW_PER_PAGE_SELECTBOX = "xpath=//select[@name='limit']";
	public static final String RECORD_NUMBER = "xpath=//table[@id='sales_order_grid_table']//tbody//tr";
	public static final String RESET_FILTER_BUTTON = "xpath=//button[@title='Reset Filter']";
	public static final String SELECT_VISIBLE_LINK = "xpath=//a[text()='Select Visible']";
	public static final String UNSELECT_VISIBLE_LINK = "xpath=//a[text()='Unselect Visible']";
	public static final String SELECT_RECORD_COUNT_TEXT = "xpath=//strong[@id='sales_order_grid_massaction-count']//parent::td";
}
