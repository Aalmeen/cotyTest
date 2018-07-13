package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class cotyAdminPage {
	
	public WebDriver driver;
	JavascriptExecutor js = ((JavascriptExecutor) driver);

	@FindBy(id = "edit-name")
	WebElement username;
	
	@FindBy(id = "edit-pass")
	WebElement passWord;
	
	@FindBy(id = "edit-submit")
	WebElement loginbutton;
	
	@FindBy(css = ".admin-menu-icon > a:nth-child(1) > span:nth-child(1)")
	WebElement homeIcon;
	
	@FindBy(className = "form-close")
	WebElement seoMetaButton;
	
	@FindBy(id = "edit-title")
	WebElement titleTextBox;
	
	@FindBy(css = ".form-item-title > label:nth-child(1)")
	WebElement pageTitleLabel;
	
	@FindBy(id = "edit-description")
	WebElement descriptionTextBox;
	
	@FindBy(css = "div.form-item:nth-child(2) > label:nth-child(1)")
	WebElement descriptionLabel;
	
	@FindBy(id = "edit-keywords")
	WebElement keyWordTextBox;
	
	@FindBy(css = "div.form-item:nth-child(3) > label:nth-child(1)")
	WebElement keywordLabel;
	
	@FindBy(id = "edit-save")
	WebElement seoSaveButton;
	
	@FindBy(id = "edit-delete")
	WebElement seoDeleteButton;
	
	@FindBy(css = ".messages")
	WebElement cmsStatusBar;
	
	@FindBy(id = "edit-title")
	WebElement nameAtContact;
	
	@FindBy(id = "edit-field-location-type-und-0-value")
	WebElement typeAtContact;
	
	@FindBy(id = "edit-field-address-und-0-street")
	WebElement streetAtContact;
	
	@FindBy(id = "edit-field-address-und-0-city")
	WebElement cityAtContact;
	
	@FindBy(id = "edit-field-address-und-0-province")
	WebElement stateAtContact;
	
	@FindBy(id = "edit-field-address-und-0-postal-code")
	WebElement postalAtContact;
	
	@FindBy(id = "edit-field-address-und-0-country")
	WebElement countryAtContact;
	
	@FindBy(id = "edit-field-phone-und-0-value")
	WebElement phoneAtContact;
	
	@FindBy(id = "edit-field-street-name-und-0-value")
	WebElement streetNameAtContact;
	
	@FindBy(id = "edit-field-street-number-und-0-value")
	WebElement streetNumberAtContact;
	
	@FindBy(id = "edit-field-latitude-coty-und-0-value")
	WebElement latitudeAtContact;
	
	@FindBy(id = "edit-field-longitude-coty-und-0-value")
	WebElement longitudeAtContact;
	
	@FindBy(xpath = "//li[contains(text(), 'Name field is required')]")
	WebElement nameErrorMessage;
	
	@FindBy(xpath = "//li[contains(text(), 'Street name field is required')]")
	WebElement streetErrorMessage;
	
	@FindBy(xpath = "//li[contains(text(), 'Please enter the latitude')]")
	WebElement latitudeErrorMessage;
	
	@FindBy(xpath = "//li[contains(text(), 'Please enter the longitude')]")
	WebElement longitudeErrorMessage;
	
	@FindBy(className = "agree-button")
	WebElement cookiesOkButton;

	@FindBy(id = "edit-latitude-longitude")
	WebElement getlatitudeButton;

	public cotyAdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void loginAsAdmin(String user, String password) {
		username.sendKeys(user);
		passWord.sendKeys(password);
		loginbutton.click();
		
	}


	public void clickOnHomeIcon() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(homeIcon));
		homeIcon.click();
		
	}


	public boolean verifySeoMetaButton() {
		if (seoMetaButton.isDisplayed())
			return seoMetaButton.getText().equals("SEO Meta");
		return false;
		
	}


	public void clickOnSeoMetaButton() {
		seoMetaButton.click();
		
	}


	public boolean verifySeoSliderPopUp() {
		return titleTextBox.isDisplayed();
	}


	public boolean verifySeoCloseButton() {
		seoMetaButton.isDisplayed();	
		return seoMetaButton.getText().equals("Close");
	}


	public void clickOnSeoCloseButton() {
		seoMetaButton.click();
		
	}


	public boolean verifyTitleTextBox() {
		return pageTitleLabel.getText().equals("Page Title");
	}


	public void enterTitle(String testTitle) {
		titleTextBox.sendKeys(testTitle);
		
	}


	public boolean verifyDescriptionTextBox() {
		if(descriptionTextBox.isDisplayed())
			return descriptionLabel.getText().equals("Description");
		return false;		
	}


	public void enterDescription(String testDescription) {
		descriptionTextBox.sendKeys(testDescription);
		
	}


	public boolean verifyKeywordTextBox() {
		if(keyWordTextBox.isDisplayed())
			return keywordLabel.getText().equals("Keywords");
		return false;		
	}


	public void enterKeyword(String testKeyword) {
		keyWordTextBox.sendKeys(testKeyword);
		
	}


	public boolean verifyAddedTitle(String testTtile) {
		String currentTitle = driver.getTitle();
		return currentTitle.equals(testTtile);
	}
		
	


	public boolean verifyMetaTagsInViewSource(String testTags) {
		return driver.getPageSource().contains(testTags);
		
	}


	public void clickOnSeoSaveButton() {
		seoSaveButton.click();
		
	}

	public void clickOnSeoDeleteButton() {
		seoDeleteButton.click();
		
	}

	public boolean verifySuccessfulSaveMessage() {
		return cmsStatusBar.getText().equals("Meta has been saved");
	}
	
	public boolean verifySuccessfulDeleteMessage() {
		return cmsStatusBar.getText().equals("Meta has been deleted");
	}


	public void NavigateToCotyLocation(String cotyUrl) {
		 driver.get(cotyUrl+"/node/add/coty-location");
		
	}

	public void verifyFieldsAvailableAtCotyLocationPage() {
		nameAtContact.isDisplayed();
		typeAtContact.isDisplayed();
		streetAtContact.isDisplayed();
		cityAtContact.isDisplayed();
		stateAtContact.isDisplayed();
		postalAtContact.isDisplayed();
		countryAtContact.isDisplayed();
		phoneAtContact.isDisplayed();
		streetNameAtContact.isDisplayed();
		streetNumberAtContact.isDisplayed();
		latitudeAtContact.isDisplayed();
		longitudeAtContact.isDisplayed();
	}


	public void clickOnContactSaveButton() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView(true);",loginbutton);
		Thread.sleep(1000);			
		loginbutton.click();
		
	}


	public void verifyMandatoryContactsFieldsErrorMessage() {
		nameErrorMessage.isDisplayed();
		streetErrorMessage.isDisplayed();
		latitudeErrorMessage.isDisplayed();
		longitudeErrorMessage.isDisplayed();
		
	}


	public void clickOnCookiedAgreeButton() throws InterruptedException {
		Thread.sleep(1000);
		cookiesOkButton.click();
	}

	public void clickOnGetLatitudeLongitudeButton() {
		getlatitudeButton.click();
	}
	
	public void enterStreetDetail(String street) {
		streetAtContact.sendKeys(street);
	}

	public void enterCity(String city) {
		cityAtContact.sendKeys(city);
	}


	public void enterPostalCode(String code) {
		postalAtContact.sendKeys(code);
	}


	public void enterStreetNumber(String num) {
		streetNumberAtContact.sendKeys(num);
	}


	public void enterStreetName(String name) {
		streetNameAtContact.sendKeys(name);
		
	}


	public String verifyAutoPopulatedLatitude() {
		return null;
	}


	public String verifyAutoPopulatedLongitude() {
	
		return null;
	}


	public void enterLocationName(String name) {
		nameAtContact.sendKeys(name);
		
	}
	
	public String getSuccessfulSaveMessage() {
		return cmsStatusBar.getText();
	}

	
	

}