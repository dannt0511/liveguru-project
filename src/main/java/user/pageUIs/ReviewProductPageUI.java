package user.pageUIs;

public class ReviewProductPageUI {
	public static final String RATING_BY_VALUE = "xpath=//th[text() = 'Quality 1']//parent::tr//input[@value = '%s']";
	public static final String NICKNAME_TEXTBOX = "XPATH=//input[@name='nickname']";
	public static final String YOUR_THOUGHT_TEXTBOX = "XPATH=//textarea[@name='detail']";
	public static final String TITLE_TEXTBOX = "XPATH=//input[@name='title']";
	public static final String SUBMIT_BUTTON = "xpath=//button[@title= 'Submit Review']";
	public static final String YOUR_THOUGHT_TEXTAREA_ERROR_MSG = "xpath=//textarea[@name='detail']//following-sibling::div";
	public static final String ERROR_MSG_BY_TEXTBOX_NAME = "xpath=//input[@name='%s']//following-sibling::div";
	public static final String SUCCESS_MSG = "css=li.success-msg";
}
