package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import user.pageObject.HomePageObject;
import user.pageObject.ProductListPageObject;

public class BasePage {
	private WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageUrl(String pageUrl) {
		driver.get(pageUrl);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void backToPage() {
		driver.navigate().back();
	}

	public void forwardToPage() {
		driver.navigate().forward();
	}

	public void refreshPage() {
		driver.navigate().refresh();
		;
	}

	public Alert waitAlertPresence() {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert() {
		waitAlertPresence().accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitAlertPresence().dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return waitAlertPresence().getText();
	}

	public void sendKeysToAlert(String textContent) {
		waitAlertPresence().sendKeys(textContent);
	}

	public void switchToWinByID(String winId) {
		Set<String> allWindow = driver.getWindowHandles();
		for (String runWindow : allWindow) {
			if (!runWindow.equals(winId)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(String winTitle) {
		Set<String> allWindow = driver.getWindowHandles();
		for (String runWindow : allWindow) {
			driver.switchTo().window(runWindow);
			String runWinTitle = driver.getTitle();
			if (runWinTitle.equals(winTitle)) {
				break;
			}
		}
	}

	public void deleteAllWinExceptParent(String parentID) {
		Set<String> allWindow = driver.getWindowHandles();
		for (String runWindow : allWindow) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
			driver.switchTo().window(parentID);
		}
	}

	private WebElement getElement(String locator) {
		return driver.findElement(getByLocator(locator));
	}

	private WebElement getElement(String locator, String... dynamicValue) {
		return driver.findElement(getByXpathDynamicLocator(locator, dynamicValue));
	}

	public List<WebElement> getElements(String locator) {
		return driver.findElements(getByLocator(locator));
	}

	public List<WebElement> getElements(String locator, String... dynamicValue) {
		return driver.findElements(getByXpathDynamicLocator(locator, dynamicValue));
	}

	private By getByLocator(String locatorType) {
		By by = null;
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=")
				|| locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=")
				|| locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=")
				|| locatorType.startsWith("Xpath=")) {
			by = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator type is not supported");
		}

		return by;
	}

	private By getByXpathDynamicLocator(String locatorType, String... value) {
		if (locatorType.startsWith("xpath") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
			locatorType = String.format(locatorType, (Object[]) value);
		}
		return By.xpath(locatorType.substring(6));
	}

	public void clickToElement(String locator) {
		getElement(locator).click();
	}

	public void clickToElement(String locator, String... dynamicValue) {
		getElement(locator, dynamicValue).click();
	}

	public void sendKeysToElement(String locator, String textContent) {
		WebElement element = getElement(locator);
		element.clear();
		element.sendKeys(textContent);
		;
	}

	public void sendKeysToElement(String locator, String textContent, String... dynamicValue) {
		WebElement element = getElement(locator, dynamicValue);
		element.clear();
		element.sendKeys(textContent);
		;
	}

	public void selectInDefaultDropdown(String locator, String textContent) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(textContent);
	}

	public void selectInDefaultDropdown(String locator, String textContent, String... dynamicValue) {
		Select select = new Select(getElement(locator, dynamicValue));
		select.selectByVisibleText(textContent);
	}

	public WebElement getSelectedItemInDropdown(String locator) {
		Select select = new Select(getElement(locator));
		return select.getFirstSelectedOption();
	}

	public WebElement getSelectedItemInDropdown(String locator, String... dynamicValue) {
		Select select = new Select(getElement(locator, dynamicValue));
		return select.getFirstSelectedOption();
	}

	public boolean isDropdownMultiple(String locator) {
		Select select = new Select(getElement(locator));
		return select.isMultiple();
	}

	public void selectCustomDropdown(String parentLocator, String childLocator, String selectedItem) {
		getElement(parentLocator).click();
		sleepInSeconds(1);
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		List<WebElement> allItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator)));
		for (WebElement item : allItems) {
			if (item.getText().trim().equals(selectedItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSeconds(1);
				item.click();
				break;
			}

		}
	}

	public void sleepInSeconds(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getAttributeValue(String locator, String attributeName) {
		return getElement(locator).getAttribute(attributeName);

	}

	public String getAttributeValue(String dynamicLocator, String attributeName, String... dynamicValue) {
		return getElement(dynamicLocator, dynamicValue).getAttribute(attributeName);

	}

	public String getElementText(String locator) {
		return getElement(locator).getText();

	}

	public String getElementText(String locator, String... dynamicValue) {
		return getElement(locator, dynamicValue).getText();

	}

	public String getCssValue(String locator, String propertyName) {
		return getElement(locator).getCssValue(propertyName);

	}

	public String getHexaColorFromRgba(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();

	}

	public int getElementsSize(String locator) {
		return getElements(locator).size();

	}

	public int getElementsSize(String locator, String... dynamicValue) {
		return getElements(locator, dynamicValue).size();

	}

	public void checkTheCheckboxOrRadio(String locator) {
		WebElement element = getElement(locator);
		if (!element.isSelected()) {
			element.click();
		}

	}

	public void checkTheCheckboxOrRadio(String locator, String... dynamicValue) {
		WebElement element = getElement(locator, dynamicValue);
		if (!element.isSelected()) {
			element.click();
		}

	}

	public void unCheckTheCheckbox(String locator) {
		WebElement element = getElement(locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public void unCheckTheCheckbox(String locator, String... dynamicValue) {
		WebElement element = getElement(locator, dynamicValue);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(String locator) {
		return getElement(locator).isDisplayed();
	}

	public boolean isElementDisplayed(String locator, String... dynamicValue) {
		return getElement(locator, dynamicValue).isDisplayed();
	}

	public boolean isElementEnabled(String locator) {
		return getElement(locator).isEnabled();
	}

	public boolean isElementSelected(String locator) {
		return getElement(locator).isSelected();
	}

	public boolean isElementSelected(String locator, String... dynamicValue) {
		return getElement(locator, dynamicValue).isSelected();
	}

	public void switchToFrame(String locator) {
		driver.switchTo().frame(getElement(locator));
	}

	public void switchToDefaultContent(String locator) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(String locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(locator)).perform();
	}

	public void hoverMouseToElement(String locator, String... dynamicValue) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(locator, dynamicValue)).perform();
	}

	public Object executeForBrowser(String javaScript) {
		return ((JavascriptExecutor) driver).executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(String textExpected) {
		String textActual = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(String url) {
		((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(String locator) {
		WebElement element = getElement(locator);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element,
				"style", "border: 2px solid red; border-style: dashed;");
		sleepInSeconds(1);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element,
				"style", originalStyle);
	}

	public void highlightElement(String locator, String... dynamicValue) {
		WebElement element = getElement(locator, dynamicValue);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element,
				"style", "border: 2px solid red; border-style: dashed;");
		sleepInSeconds(1);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element,
				"style", originalStyle);
	}

	public void clickToElementByJS(String locator, String... dynamicValue) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(locator, dynamicValue));
	}

	public void clickToElementByJS(String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(locator));
	}

	public void scrollToElement(String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
	}

	public void sendkeyToElementByJS(String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')",
				getElement(locator));
	}

	public void removeAttributeInDOM(String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getElement(locator));
	}

	public boolean waitForPageLoadReady() {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);

	}

	public String getElementValidationMessage(String locator) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;",
				getElement(locator));
	}

	public boolean isImageLoaded(String locator) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getElement(locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));

	}

	public void waitForElementInvisible(String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
	}

	public void waitForElementClickable(String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
	}

	public void waitForAllElementsVisible(String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
	}

	public void waitForElementVisible(String locator, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait
				.until(ExpectedConditions.visibilityOfElementLocated(getByXpathDynamicLocator(locator, dynamicValue)));
	}

	public void waitForElementClickable(String locator, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpathDynamicLocator(locator, dynamicValue)));
	}

	public void waitForElementPresence(String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(locator)));
	}

	public void openPage(String dynamicLocator, String... dynamicValue) {
		waitForElementClickable(dynamicLocator, dynamicValue);
		clickToElement(dynamicLocator, dynamicValue);
	}

	public void clickLinkOnMyAccountMenu(String linkName) {
		waitForElementClickable(BasePageUI.HEADER_ACCOUNT_MENU);
		clickToElement(BasePageUI.HEADER_ACCOUNT_MENU);
		waitForElementVisible(BasePageUI.HEADER_ACCOUNT_PULLDOWN);
		waitForElementClickable(BasePageUI.HEADER_ACCOUNT_MENU_LINK_BY_NAME, linkName);
		clickToElement(BasePageUI.HEADER_ACCOUNT_MENU_LINK_BY_NAME, linkName);
	}

	public HomePageObject clickLogo() {
		waitForElementClickable(BasePageUI.LOGO);
		clickToElement(BasePageUI.LOGO);
		return PageGeneratorManager.openHomePage(driver);
	}

	public ProductListPageObject openProductListFromSubHeader(String menuName) {
		waitForElementClickable(BasePageUI.NAV_MENU, menuName);
		clickToElement(BasePageUI.NAV_MENU, menuName);
		return PageGeneratorManager.openProductListPage(driver);
	}

}
