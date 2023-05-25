package admin.pageObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import admin.pageUIs.InvoicesListPageUI;
import commons.BasePage;

public class InvoicesListPageObject extends BasePage {

	public InvoicesListPageObject(WebDriver driver) {
		super(driver);
	}

	public boolean isRecordSortedAsc(String columnName) {
		String index = String.valueOf(getElementsSize(InvoicesListPageUI.COLUMN_INDEX_BY_HEADER, columnName) + 1);
		List<String> dataTextList = new ArrayList<String>();
		List<String> sortedList = new ArrayList<String>();
		List<WebElement> elementList = getElements(InvoicesListPageUI.DATA_COLUMN_BY_INDEX, index);
		for (WebElement element : elementList) {
			dataTextList.add(element.getText());
		}

		for (String text : dataTextList) {
			System.out.println("ori text: " + text);
			sortedList.add(text);
		}
		Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);
		for (String text : sortedList) {
			System.out.println("sorted: " + text);
		}

		return dataTextList.equals(sortedList);
	}

	public boolean isRecordSortedDesc(String columnName) {
		String index = String.valueOf(getElementsSize(InvoicesListPageUI.COLUMN_INDEX_BY_HEADER, columnName) + 1);
		List<String> dataTextList = new ArrayList<String>();
		List<String> sortedList = new ArrayList<String>();
		List<WebElement> elementList = getElements(InvoicesListPageUI.DATA_COLUMN_BY_INDEX, index);
		for (WebElement element : elementList) {
			dataTextList.add(element.getText());
		}

		for (String text : dataTextList) {
			sortedList.add(text);
		}
		Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);
		Collections.reverse(sortedList);

		return dataTextList.equals(sortedList);
	}

	public boolean isRecordDateSortedAsc(String columnName) {
		String index = String.valueOf(getElementsSize(InvoicesListPageUI.COLUMN_INDEX_BY_HEADER, columnName) + 1);
		List<Date> dateList = new ArrayList<Date>();
		List<Date> sortedList = new ArrayList<Date>();
		List<WebElement> elementList = getElements(InvoicesListPageUI.DATA_COLUMN_BY_INDEX, index);
		for (WebElement element : elementList) {
			dateList.add(convertStringToDate(element.getText()));
		}

		for (Date date : dateList) {
			sortedList.add(date);
		}
		Collections.sort(sortedList);

		return dateList.equals(sortedList);
	}

	public boolean isRecordDateSortedDesc(String columnName) {
		String index = String.valueOf(getElementsSize(InvoicesListPageUI.COLUMN_INDEX_BY_HEADER, columnName) + 1);
		List<Date> dateList = new ArrayList<Date>();
		List<Date> sortedList = new ArrayList<Date>();
		List<WebElement> elementList = getElements(InvoicesListPageUI.DATA_COLUMN_BY_INDEX, index);
		for (WebElement element : elementList) {
			dateList.add(convertStringToDate(element.getText()));
		}

		for (Date date : dateList) {
			sortedList.add(date);
		}
		Collections.sort(sortedList);
		Collections.reverse(sortedList);

		return dateList.equals(sortedList);
	}

	public Date convertStringToDate(String dateInString) {
		dateInString = dateInString.replace(",", "");
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy hh:mm:ss aa");
		Date date = null;
		try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public boolean isRecordFloatSortedAsc(String columnName) {
		String index = String.valueOf(getElementsSize(InvoicesListPageUI.COLUMN_INDEX_BY_HEADER, columnName) + 1);
		List<Float> numberList = new ArrayList<Float>();
		List<Float> sortedList = new ArrayList<Float>();
		List<WebElement> elementList = getElements(InvoicesListPageUI.DATA_COLUMN_BY_INDEX, index);
		for (WebElement element : elementList) {
			String number = element.getText().replace("$", "").replace(",", "");
			numberList.add(Float.parseFloat(number));
		}

		for (Float number : numberList) {
			sortedList.add(number);
		}
		Collections.sort(sortedList);

		return numberList.equals(sortedList);
	}

	public boolean isRecordFloatSortedDesc(String columnName) {
		String index = String.valueOf(getElementsSize(InvoicesListPageUI.COLUMN_INDEX_BY_HEADER, columnName) + 1);
		List<Float> numberList = new ArrayList<Float>();
		List<Float> sortedList = new ArrayList<Float>();
		List<WebElement> elementList = getElements(InvoicesListPageUI.DATA_COLUMN_BY_INDEX, index);
		for (WebElement element : elementList) {
			String number = element.getText().replace("$", "").replace(",", "");
			numberList.add(Float.parseFloat(number));
		}

		for (Float number : numberList) {
			sortedList.add(number);
		}
		Collections.sort(sortedList);
		Collections.reverse(sortedList);

		return numberList.equals(sortedList);
	}

}
