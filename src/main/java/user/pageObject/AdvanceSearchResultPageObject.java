package user.pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import user.pageUIs.AdvancedSearchResultPageUI;

public class AdvanceSearchResultPageObject extends BasePage {

	public AdvanceSearchResultPageObject(WebDriver driver) {
		super(driver);
	}

	public String getResultNumber() {
		waitForElementVisible(AdvancedSearchResultPageUI.RESULT_NUMBER);
		String[] result = getElementText(AdvancedSearchResultPageUI.RESULT_NUMBER).split(" ");
		return result[0].trim();
	}

	public boolean isResultPriceInRange(String priceFrom, String priceTo) {
		float iPriceFrom = Float.parseFloat(priceFrom);
		float iPriceTo = Float.parseFloat(priceTo);
		List<WebElement> resultList = getElements(AdvancedSearchResultPageUI.PRODUCT_PRICE_LIST);
		List<Float> resultPriceList = new ArrayList<Float>();
		for (WebElement result : resultList) {
			String resultText = result.getText().replace("$", "");
			resultPriceList.add(Float.parseFloat(resultText));
		}
		for (Float result : resultPriceList) {
			if (result >= iPriceFrom && result <= iPriceTo) {
				return true;
			}
		}
		return false;
	}

}
