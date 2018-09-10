package Pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.SeleniumDriverFactory;


public class cotyAdminPage {
	
	public WebDriver driver;
	public Logger Log = Logger.getLogger(SeleniumDriverFactory.class.getName());

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
	
	@FindBy(id = "edit-uid")
	WebElement authorTextBox;
	
	@FindBy(id = "edit-keys")
	WebElement contentTextBox;
	
	@FindBy(id = "edit-type")
	WebElement typeDropDown;
	
	@FindBy(id = "edit-status")
	WebElement publishedDropDown;
	
	@FindBy(id = "edit-date-filter-min-datepicker-popup-0")
	WebElement createStartDate;
	
	@FindBy(id = "edit-date-filter-max-datepicker-popup-0")
	WebElement createEndDate;
	
	@FindBy(id = "edit-date-filter-1-min-datepicker-popup-0")
	WebElement updateStartdate;
	
	@FindBy(id = "edit-date-filter-1-max-datepicker-popup-0")
	WebElement updateEndDate;
	
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
	
	@FindBy(id = "edit-field-latitude-coty-und-0-value")
	WebElement latitudeBox;	
	
	@FindBy(id = "edit-field-longitude-coty-und-0-value")
	WebElement longitudeBox;
	
	@FindBy(xpath = "//a[contains(text(), 'Coty Sunnyvale USA')]")
	WebElement addressInList;
	
	@FindBy(xpath = "//a[contains(text(), 'delete')]")
	WebElement deleteAddress;
	
	@FindBy(id = "edit-feeds-feedsfilefetcher-upload")
	WebElement uploadFile;
	
	@FindBy(xpath = "//*[contains(@id, 'edit-nodes')]")
	WebElement addressCheckBox;
	
	@FindBy(id = "edit-operation")
	WebElement selectDropDown;
	
	@FindBy(id = "edit-submit--2")
	WebElement updateButton;
	
	@FindBy(css = "div.views-row:nth-child(3)")
	WebElement subNewsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Edit')]")
	WebElement editCMS;	
	
	@FindBy(id = "edit-field-news-priority-und")
	WebElement newsPriorityDropDown;
	
	@FindBy(id = "edit-cron")
	WebElement indexQueueButton;
	
	@FindBy(id = "edit-submit-admin-views-node")
	WebElement applyButton;
	
	@FindBy(css = ".odd > td:nth-child(7)")
	WebElement createdRowValue;
	
	@FindBy(css = ".odd > td:nth-child(6)")
	WebElement updatedRowValue;
	
	@FindBy(xpath = "//strong[contains(text(), 'Scheduling options')]")
	WebElement sheduleContentOption;
	
	@FindBy(xpath = "//Span[@class='summary']/following-sibling::strong[contains(text(), 'Scheduling options')]")
	WebElement sheduleContentText;
	
	@FindBy(id = "edit-publish-on-datepicker-popup-0")
	WebElement publishDate;
	
	@FindBy(css = "edit-publish-on-timeEntry-popup-1")
	WebElement publishTime;
	
	@FindBy(css = "edit-unpublish-on-datepicker-popup-0")
	WebElement unpublishDate;
	
	@FindBy(css = "edit-unpublish-on-timeEntry-popup-1")
	WebElement unpublishTime;
	

	public cotyAdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void loginAsAdmin(String user, String password) {
		username.sendKeys(user);
		Log.info("user name entered");
		passWord.sendKeys(password);
		Log.info("Password enetered");
		clickOnSubmitButton();
		Log.info("Clicked on submit button");	
	}


	public void clickOnHomeIcon() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(homeIcon));
		homeIcon.click();
		Log.info("Clicked on home icon");
		
	}


	public boolean verifySeoMetaButton() {
		if (seoMetaButton.isDisplayed())
			return seoMetaButton.getText().equals("SEO Meta");
		return false;
		
	}


	public void clickOnSeoMetaButton() {
		seoMetaButton.click();
		Log.info("Clicked on SEO meta button");
		
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
		Log.info("Clicked on SEO close button ");
		
	}


	public boolean verifyTitleTextBox() {
		return pageTitleLabel.getText().equals("Page Title");
	}


	public void enterTitle(String testTitle) {
		titleTextBox.sendKeys(testTitle);
		Log.info("Sent text to Title");
	}


	public boolean verifyDescriptionTextBox() {
		if(descriptionTextBox.isDisplayed())
			return descriptionLabel.getText().equals("Description");
		return false;		
	}


	public void enterDescription(String testDescription) {
		descriptionTextBox.sendKeys(testDescription);
		Log.info("Sent text to description box");
	}


	public boolean verifyKeywordTextBox() {
		if(keyWordTextBox.isDisplayed())
			return keywordLabel.getText().equals("Keywords");
		return false;		
	}


	public void enterKeyword(String testKeyword) {
		keyWordTextBox.sendKeys(testKeyword);
		Log.info("Sent text tokeyword box");
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
		Log.info("Clicked on Seo Save button");
	}

	public void clickOnSeoDeleteButton() {
		seoDeleteButton.click();
		Log.info("Clicked on Seo delete button");
		
	}

	public boolean verifySuccessfulSaveMessage() {
		return cmsStatusBar.getText().equals("Meta has been saved");
	}
	
	public boolean verifySuccessfulDeleteMessage() {
		return cmsStatusBar.getText().equals("Meta has been deleted");
	}


	public void NavigateToCotyLocation(String cotyUrl) {
		 driver.get(cotyUrl+"/node/add/coty-location");
		 Log.info("redirected to"  + cotyUrl +"/node/add/coty-location");
	}

	public void verifyFieldsAvailableAtCotyLocationPage() {
		nameAtContact.isDisplayed();
		Log.info("Name field displayed at contact ");
		typeAtContact.isDisplayed();
		Log.info("Type field displayed at contact");
		streetAtContact.isDisplayed();
		Log.info("street field displayed at contact");
		cityAtContact.isDisplayed();
		Log.info("city field displayed at contact");
		stateAtContact.isDisplayed();
		Log.info("state field displayed at state");
		postalAtContact.isDisplayed();
		Log.info("postal fiedl displayed at contact");
		countryAtContact.isDisplayed();
		Log.info("country field displayed at contact");
		phoneAtContact.isDisplayed();
		Log.info("phone field displayed at contact");
		streetNameAtContact.isDisplayed();
		Log.info("street name field displayed at contact");
		streetNumberAtContact.isDisplayed();
		Log.info("Street Number displayed at contact");
		latitudeAtContact.isDisplayed();
		Log.info("Latitude field displayed at contact ");
		longitudeAtContact.isDisplayed();
		Log.info("Longitude field displayed at contact");
	}


	public void scrollDownAndclickOnSubmitButton() throws InterruptedException {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);",loginbutton);
		Thread.sleep(1000);			
		clickOnSubmitButton();
		Log.info("clicked on submit button");
	}
	
	public void clickOnSubmitButton() {
		loginbutton.click();
		Log.info("clicked on login button");
		
	}


	public void verifyMandatoryContactsFieldsErrorMessage() {
		nameErrorMessage.isDisplayed();
		streetErrorMessage.isDisplayed();
		latitudeErrorMessage.isDisplayed();
		longitudeErrorMessage.isDisplayed();
		Log.info("Error message displayed for name, street, lattitude and longitude");
		
	}


	public void clickOnCookiedAgreeButton() throws InterruptedException {
		Thread.sleep(1000);
		cookiesOkButton.click();
		Log.info("clicked on Ok button for cookies ");
	}

	public void clickOnGetLatitudeLongitudeButton() {
		getlatitudeButton.click();
		Log.info("Clicked on get latitude button");
	}
	
	public void enterStreetDetail(String street) {
		streetAtContact.sendKeys(street);
		Log.info("entered street number");
	}

	public void enterCity(String city) {
		cityAtContact.sendKeys(city);
		Log.info("entered city");
	}


	public void enterPostalCode(String code) {
		postalAtContact.sendKeys(code);
		Log.info("entered postal number at contact");
	}


	public void enterStreetNumber(String num) {
		streetNumberAtContact.sendKeys(num);
		Log.info("entered street number at contact");
	}


	public void enterStreetName(String name) {
		streetNameAtContact.sendKeys(name);
		Log.info("entered street name at contact");
		
	}


	public String verifyAutoPopulatedLatitude() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String str = (String) js.executeScript("return jQuery('#edit-field-latitude-coty-und-0-value').val()","");
		return str;
	}


	public String verifyAutoPopulatedLongitude() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String str = (String) js.executeScript("return jQuery('#edit-field-longitude-coty-und-0-value').val()","");
		return str;
	}


	public void enterLocationName(String name) {
		nameAtContact.sendKeys(name);
		Log.info("entered name at contact");
	}
	
	public String getCmsStatusMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(cmsStatusBar));
		return cmsStatusBar.getText();
	}


	public void navigateToAdminContent(String cotyUrl) {
		driver.get(cotyUrl+"/admin/content");
		Log.info("navigated to" + cotyUrl+"/admin/content");
	}


	public void verifyAddedAddressInList(String string) {
		addressInList.isDisplayed();
		Log.info("entered address at contact");
	}


	public void deleteAddressFromList() {
		deleteAddress.click();
		clickOnSubmitButton();
		Log.info("deted address");
	}


	public void NavigateToImportCotyLocation(String cotyUrl) {
		driver.get(cotyUrl+"/import/coty_locatiom");
		Log.info("navigated to" + cotyUrl+"/import/coty_locatiom");
	}


	public void selectFileToImport() {
		uploadFile.sendKeys(System.getProperty("user.dir") + "\\resources\\Test_coty_location.csv");
		Log.info("File selected for inport");
	}


	public void selectCheckBox(int count) {
		List<WebElement> li= driver.findElements(By.xpath("//*[contains(@id, 'edit-nodes')]"));
		for (int i =0; i< count; i++)
			li.get(i).click();
		
	}


	public void selectDropDownToDelete() {
		Select dropdown = new Select(selectDropDown);
		dropdown.selectByVisibleText("Delete selected content");
		Log.info("Selected content for delete");
	}


	public void clickOnUpdateButton() {
		updateButton.click();
		Log.info("clicked on updated button");
	}


	public void clickOnSubNewsLink() {
		subNewsLink.click();
		Log.info("Clicked on Sub News Link");
	}


	public void clickOnEditButton() {
		editCMS.click();
		Log.info("Clicked on Edit button");
	}


	public void selectNewsPriority(String i) {
		Select dropdown = new Select(selectDropDown);
		dropdown.selectByVisibleText(i);		
	}


	public Object verifyNewsPriorityDropDown() throws InterruptedException {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);",newsPriorityDropDown);
		Thread.sleep(1000);		
		return newsPriorityDropDown.isDisplayed();
	}


	public void runApacheSolr(String cotyUrl) {
		driver.get(cotyUrl+"admin/config/search/apachesolr/settings/solr/index");
		clickOnIndexQueueContent();
		clickOnSubmitButton();
		Log.info("clicked on submit button to run apache solr");
	}


	private void clickOnIndexQueueContent() {
		indexQueueButton.click();	
		Log.info("cliked on Index queue content");
	}


	public void verifyAvailableSearchFields() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(titleTextBox));
		titleTextBox.isDisplayed();
		authorTextBox.isDisplayed();
		contentTextBox.isDisplayed();
		typeDropDown.isDisplayed();
		publishedDropDown.isDisplayed();
		createStartDate.isDisplayed();
		createEndDate.isDisplayed();
		updateStartdate.isDisplayed();
		updateEndDate.isDisplayed();
		Log.info("Verified all search fields");
	}


	public void enterCreatedStartDate(String str) {
		createStartDate.sendKeys(str);
		Log.info("entered created start date");
	}


	public void clickOnApplyButton() {
		applyButton.click();
		Log.info("clicked on Apply button");
				
	}


	public boolean verifySearchResultForCreatedDate(String str) throws InterruptedException {
		Thread.sleep(2000);
		String str2 = createdRowValue.getText();
		return str2.contains(str);
	}

	public boolean verifySearchResultForUpdatedDate(String str) throws InterruptedException {
		Thread.sleep(2000);
		String str2 = updatedRowValue.getText();
		return str2.contains(str);
	}


	public void enterCreatedEndDate(String str) {
		createEndDate.sendKeys(str);
		Log.info("entered created end date");
	}


	public void enterUpdatedStartDate(String str) {
		updateStartdate.sendKeys(str);
		Log.info("entered updated start date");
	}


	public void enterUpdatedEndDate(String str) {
		updateEndDate.sendKeys(str);
		Log.info("enetered updated end date");
	}


	public void clickOnScheduleOptionTab() throws InterruptedException {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);",sheduleContentOption);
		Thread.sleep(1000);			
		sheduleContentOption.click();
		
	}


	public String verifyScheduleOptionText() {
		String str = sheduleContentText.getText();
		return str;
	}


	public void enterPublishDate(String string) {
		// TODO Auto-generated method stub
		
	}


	public String verifyErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}


	public void enterPublishTime(String string) {
		// TODO Auto-generated method stub
		
	}


}
