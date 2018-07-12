package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SeleniumDriverFactory {

	protected WebDriver driver;
	public Logger Log = Logger.getLogger(SeleniumDriverFactory.class.getName());
	
	public WebDriver getWebDriver() {
		return driver;
	}

	enum BrowserType {
		FIREFOX, CHROME, IE
	};

	PropertyReader prop = new PropertyReader();
	String Browser = prop.readConfigFile("Browser");
	protected String cotyUrl = prop.readConfigFile("StagingUrl");
	protected String cotyAdminUrl = prop.readConfigFile("StagingCotyAdminUrl");
	protected String user = prop.readConfigFile("AdminUser");
	protected String password = prop.readConfigFile("AdminPassword");

	@BeforeClass
	public void setUp() {
		if (BrowserType.FIREFOX.toString().equals(Browser)) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			Log.info("Firefox driver instantiated");
		}
		if (BrowserType.CHROME.toString().equals(Browser)) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			Log.info("Chrome driver instantiated");
		}
		if (BrowserType.IE.toString().equals(Browser)) {
			driver = new InternetExplorerDriver();
			Log.info("IE driver instantiated");
		}

		driver.manage().window().maximize();

	}
	

	public void launchCotyAdminUrl() {
		driver.get(cotyAdminUrl);
		Log.info("Coty Admin Web application launched");
	}

	public void launchCotyUrl() {
		driver.get(cotyUrl);
		Log.info("Coty Web application launched");
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
