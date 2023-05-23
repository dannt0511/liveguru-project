package admin.pageObject;

import java.io.File;

import org.openqa.selenium.WebDriver;

import admin.pageUIs.OrderListPageUI;
import commons.BasePage;
import commons.GlobalConstants;

public class OrderListPageObject extends BasePage {

	public OrderListPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void selectRecordStatus(String record_status_01) {
		waitForElementClickable(OrderListPageUI.STATUS_SELECTBOX);
		selectInDefaultDropdown(OrderListPageUI.STATUS_SELECTBOX, record_status_01);

	}

	public String getErrorMsg() {
		waitForElementVisible(OrderListPageUI.ERROR_MSG);
		return getElementText(OrderListPageUI.ERROR_MSG);
	}

	public boolean isFileDownloaded(String filename) {
		waitForDownloadFileFullnameCompleted(filename);
		int countFile = countFilesInDirectory();
		return countFile == 1;
	}

	public void waitForDownloadFileFullnameCompleted(String fileName) {
		int i = 0;
		while (i < 60) {
			boolean exist = isFileExists(fileName);
			if (exist == true) {
				i = 60;
				break;
			}
			sleepInSecond(1);
			i = i + 1;
		}
	}

	public void waitForDownloadFileContainsNameCompleted(String fileName) {
		int i = 0;
		while (i < 60) {
			boolean exist = isFileContain(fileName);
			if (exist == true) {
				i = 60;
				break;
			}
			sleepInSecond(1);
			i = i + 1;
		}
	}

	public boolean isFileContain(String fileName) {
		try {
			boolean flag = false;
			File dir = new File(GlobalConstants.DOWNLOAD_FILE_PATH);
			File[] files = dir.listFiles();
			if (files == null || files.length == 0) {
				flag = false;
			}
			for (int i = 0; i < files.length; i++) {
				if (files[i].getName().endsWith(fileName)) {
					flag = true;
				}
			}
			return flag;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}

	public boolean isFileExists(String file) {
		try {
			File files = new File(GlobalConstants.DOWNLOAD_FILE_PATH + file);
			boolean exists = files.exists();
			return exists;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}

	public int countFilesInDirectory() {
		File file = new File(GlobalConstants.DOWNLOAD_FILE_PATH);
		int i = 0;
		for (File listOfFiles : file.listFiles()) {
			if (listOfFiles.isFile()) {
				i++;
			}
		}
		return i;
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
