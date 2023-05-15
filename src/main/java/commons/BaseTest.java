package commons;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	protected final Log log;

	public enum BrowserList {
		CHROME, FIREFOX, OPERA, EDGE, COCCOC, IE, BRAVE, H_CHROME, H_FIREFOX;
	}

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	public WebDriver getDriver() {
		return driver;
	}

	protected WebDriver openBrowsers(String browserName, String appUrl) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		switch (browser) {
		case FIREFOX:
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
					GlobalConstants.PROJECT_PATH + "\\browserLogs\\FirefoxLog.log");
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case CHROME:
			System.setProperty("webdriver.chrome.args", "--disable-logging");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			ChromeOptions chromeOption = new ChromeOptions();
			chromeOption.addArguments("--lang=vi");
			chromeOption.addArguments("--disable-geolocation");
			chromeOption.setExperimentalOption("useAutomationExtension", false);
			chromeOption.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			chromeOption.setExperimentalOption("prefs", prefs);
			driver = WebDriverManager.chromedriver().capabilities(chromeOption).create();
			break;
		case OPERA:
			driver = WebDriverManager.operadriver().create();
			break;
		case EDGE:
			driver = WebDriverManager.edgedriver().create();
			break;
		case H_CHROME:
			ChromeOptions hChromeOption = new ChromeOptions();
			hChromeOption.addArguments("headless");
			hChromeOption.addArguments("window-size=1920x1080");
			return WebDriverManager.chromedriver().capabilities(hChromeOption).create();
		case H_FIREFOX:
			FirefoxOptions hFirefoxOption = new FirefoxOptions();
			hFirefoxOption.addArguments("-headless");
			hFirefoxOption.addArguments("window-size=1920x1080");
			return WebDriverManager.firefoxdriver().capabilities(hFirefoxOption).create();
		default:
			throw new RuntimeException("Browser name invalid");
		}
		driver.manage().window().maximize();
		driver.get(appUrl);
		return driver;
	}

	public int randomNum() {
		Random rand = new Random();
		return rand.nextInt(999);
	}

	public void sleepInSeconds(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void closeBrowserDriver() {
		driver.manage().deleteAllCookies();
		String cmd = null;
		try {
			String osName = GlobalConstants.OS_NAME.toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
