package admin.pageUIs;

public class CustomerListPageUI {
	public static final String POPUP = "css=div#message-popup-window";
	public static final String POPUP_CLOSE_BUTTON = "xpath=//a[@title='close']";
	public static final String COLUMN_INDEX_BY_HEADER = "xpath=//span[text()='%s']//ancestor::th//preceding-sibling::th";
	public static final String DATA_COLUMN_BY_INDEX = "xpath=//table[@id='customerGrid_table']//tbody/tr/td[%s]";
	public static final String ID_TEXTBOX_DYNAMIC_LOCATOR = "xpath=//th[%s]//span[contains(text(),'%s')]//following-sibling::input";
	public static final String FILTER_TEXTBOX_BY_INDEX = "xpath=//tr[@class='filter']//th[%s]//input";
	public static final String FILTER_SELECTBOX_BY_INDEX = "xpath=//tr[@class='filter']//th[%s]//select";
	public static final String RESET_FILTER_BUTTON = "xpath=//button[@title='Reset Filter']";

}
