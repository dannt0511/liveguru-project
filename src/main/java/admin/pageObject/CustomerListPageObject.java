package admin.pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import admin.pageUIs.CustomerListPageUI;
import commons.BasePage;

public class CustomerListPageObject extends BasePage {

	public CustomerListPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickCloseButtonOnPopup() {
		waitForElementClickable(CustomerListPageUI.POPUP_CLOSE_BUTTON);
		clickToElement(CustomerListPageUI.POPUP_CLOSE_BUTTON);
		waitForElementInvisible(CustomerListPageUI.POPUP);

	}

	public void inputIDTextbox(String searchCriteria, String content) {
		String index = String.valueOf(getElementsSize(CustomerListPageUI.COLUMN_INDEX_BY_HEADER, "ID") + 1);
		waitForElementClickable(CustomerListPageUI.ID_TEXTBOX_DYNAMIC_LOCATOR, index, searchCriteria);
		sendKeysToElement(CustomerListPageUI.ID_TEXTBOX_DYNAMIC_LOCATOR, content, index, searchCriteria);

	}

	public boolean isSearchResultCorrect(String columnName, String searchCondition) {
		String index = String.valueOf(getElementsSize(CustomerListPageUI.COLUMN_INDEX_BY_HEADER, columnName) + 1);
		List<String> textList = new ArrayList<String>();
		List<WebElement> elementList = getElements(CustomerListPageUI.DATA_COLUMN_BY_INDEX, index);
		for (WebElement element : elementList) {
			textList.add(element.getText().trim());
		}
		for (String text : textList) {
			if (text.equals(searchCondition)) {
				return true;
			}
		}
		return false;
	}

	public void inputFilterTextbox(String columnName, String content) {
		String index = String.valueOf(getElementsSize(CustomerListPageUI.COLUMN_INDEX_BY_HEADER, columnName) + 1);
		waitForElementClickable(CustomerListPageUI.FILTER_TEXTBOX_BY_INDEX, index);
		sendKeysToElement(CustomerListPageUI.FILTER_TEXTBOX_BY_INDEX, content, index);
	}

	public void clickResetFilterButton() {
		waitForElementClickable(CustomerListPageUI.RESET_FILTER_BUTTON);
		clickToElement(CustomerListPageUI.RESET_FILTER_BUTTON);

	}

	public void selectFilterSelectbox(String columnName, String content) {
		String index = String.valueOf(getElementsSize(CustomerListPageUI.COLUMN_INDEX_BY_HEADER, columnName) + 1);
		waitForElementClickable(CustomerListPageUI.FILTER_SELECTBOX_BY_INDEX, index);
		selectInDefaultDropdown(CustomerListPageUI.FILTER_SELECTBOX_BY_INDEX, content, index);

	}

}
