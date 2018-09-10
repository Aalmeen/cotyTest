package Pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumDriverFactory;

public class cotyHomePage {

	public WebDriver driver;
	public Logger Log = Logger.getLogger(SeleniumDriverFactory.class.getName());

	@FindBy(id = "burger-menu")
	WebElement menuIcon;
	
	@FindBy(id = "google_translate_element2")
	WebElement gtIcon;

	public cotyHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifymenuicon() {

		menuIcon.isDisplayed();
		Log.info("Menu icon displayed at home page");
	}

	public void verifyGTPlugin(String applicationURL, List<String> str) {

		for (int i = 0; i < str.size(); i++) {
			driver.get(applicationURL + "/" + str.get(i));
			clickMenuIcon();
			verifyGTIcon();
			Log.info("Verified Google Translate plugin Icon" + applicationURL + "/" + str.get(i));
		}

	}

	private void verifyGTIcon() {
		gtIcon.isDisplayed();
		Log.info("Verified google translate  icon");
	}

	private void clickMenuIcon() {
		menuIcon.isDisplayed();
		menuIcon.click();
		Log.info("Clicked on Menu icon");
	}

	public void selectLanguage(String lang, List<String> str) {
		// TODO Auto-generated method stub
		
	}

	public boolean verifyLanguage(String lang) {
		
		if (lang.equals("DE"))
			return menuIcon.getText().equals("Unsere Geschichte");
		return false;
				
	}
}
