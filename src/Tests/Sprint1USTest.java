package Tests;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Pages.cotyAdminPage;
import Pages.cotyHomePage;
import utils.DataReader;
import utils.SeleniumDriverFactory;
import utils.EmailReport;;

@Listeners(EmailReport.class)
public class Sprint1USTest extends SeleniumDriverFactory {

	DataReader dr = new DataReader();

//	@Test(description = "Verify SEO module is not displayed for non admin user")
//	public void verifySeoModuleForNonAdmin() {
//		cotyAdminPage cap = new cotyAdminPage(driver);
//
//		try {
//			launchCotyUrl();
//			Assert.assertEquals(false, cap.verifySeoMetaButton(), "SEO Meta button not displayed for non admin user");
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		}
//	
//	@Test(description = "Verify SEO module is installed and configured in the website")
//	public void verifySeoModuleConfiguration() {
//		cotyAdminPage cap = new cotyAdminPage(driver);
//
//		try {
//			launchCotyAdminUrl();
//			cap.loginAsAdmin(user, password);
//			cap.clickOnHomeIcon();
//			Assert.assertEquals(true, cap.verifySeoMetaButton(), "SEO Meta button displayed");
//			cap.clickOnSeoMetaButton();
//			Assert.assertEquals(true,cap.verifySeoSliderPopUp(), "SEO Meta pop up openend");
//			Assert.assertEquals(true, cap.verifySeoCloseButton(), "SEO  Meta close button displayed");
//			cap.clickOnSeoCloseButton();
//			Assert.assertEquals(false,cap.verifySeoSliderPopUp(), "SEO Meta pop up closed");	
//			cap.clickOnSeoMetaButton();
//			Assert.assertEquals(true, cap.verifyTitleTextBox(), "Page Title box displayed");
//			cap.enterTitle("Coty Page Title Test");
//			Assert.assertEquals(true, cap.verifyDescriptionTextBox(), "Description box displayed");
//			cap.enterDescription("Coty Description Test");
//			Assert.assertEquals(true, cap.verifyKeywordTextBox(), "Keyword box displayed");
//			cap.enterKeyword("Fashion");
//			cap.clickOnSeoSaveButton();
//			Assert.assertEquals(true, cap.verifySuccessfulSaveMessage(), "Success message displayed");
//			Assert.assertEquals(true, cap.verifyAddedTitle("Coty Page Title Test"), "Title added to page successfully");
//			Assert.assertEquals(true, cap.verifyMetaTagsInViewSource("Fashion"), "Meta tags added to page source successfully");
//						
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//	
//	@Test(description = "Verify SEO module is installed and configured in the website")
//	public void verifySeoModuleValidation() {
//		cotyAdminPage cap = new cotyAdminPage(driver);
//
//		try {
//			launchCotyAdminUrl();
//			cap.loginAsAdmin(user, password);
//			cap.clickOnHomeIcon();
//			cap.clickOnSeoMetaButton();
//			cap.enterTitle("Coty page Test");
//			cap.enterDescription("Coty Description Test");
//			cap.enterKeyword("Test, Test2, Test3");
//			cap.clickOnSeoSaveButton();
//			Assert.assertEquals(true, cap.verifySuccessfulSaveMessage(), "Success message displayed");
//			Assert.assertEquals(true, cap.verifyMetaTagsInViewSource("Test, Test2, Test3"), "Meta tags changed and added to page source successfully");
//			cap.clickOnSeoMetaButton();
//			cap.enterKeyword("Testing");
//			cap.clickOnSeoSaveButton();
//			Assert.assertEquals(true, cap.verifySuccessfulSaveMessage(), "Success message displayed");
//			Assert.assertEquals(true, cap.verifyMetaTagsInViewSource("Testing"), "Changed Meta tags added to page source successfully");
//			cap.clickOnSeoMetaButton();
//			cap.clickOnSeoDeleteButton();
//			Assert.assertEquals(true, cap.verifySuccessfulDeleteMessage(), "Success message displayed");
//			Assert.assertEquals(false, cap.verifyMetaTagsInViewSource("Testing"), "Meta tags deleted to page source successfully");
//						
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
	
	@Test(description = "Verify coty contact us configured in the website")
	public void verifyContactUsValidation() {
		cotyAdminPage cap = new cotyAdminPage(driver);

		try {
			launchCotyAdminUrl();
			cap.loginAsAdmin(user, password);
			cap.NavigateToCotyLocation(cotyUrl);
			cap.clickOnCookiedAgreeButton();
			cap.verifyFieldsAvailableAtCotyLocationPage();
			cap.clickOnContactSaveButton();
			cap.verifyMandatoryContactsFieldsErrorMessage();
			cap.enterLocationName("Coty Sunnyvale USA");
			cap.clickOnGetLatitudeLongitudeButton();
			Assert.assertEquals(getAlertMessage(), "Please enter the Street", "Alert message for street verified");
			acceptAlert();
			cap.enterStreetDetail("Hermosa Ave");
			cap.clickOnGetLatitudeLongitudeButton();
			Assert.assertEquals(getAlertMessage(), "Please enter City", "Alert message for city is verified");
			acceptAlert();
			cap.enterCity("Sunnyvale");
			cap.clickOnGetLatitudeLongitudeButton();
			Assert.assertEquals(getAlertMessage(), "Please enter Postal Code", "Alert message for postal code is verified");
			acceptAlert();
			cap.enterPostalCode("94085");
			cap.clickOnGetLatitudeLongitudeButton();
			Assert.assertEquals(getAlertMessage(), "Please enter Street Number", "Alert message for street number is verified");
			acceptAlert();
			cap.enterStreetNumber("330");
			cap.clickOnGetLatitudeLongitudeButton();
			Assert.assertEquals(getAlertMessage(), "Please enter Street Name", "Alert message for street name is verified");
			acceptAlert();
			cap.enterStreetName("Potrero Ave");
			cap.clickOnGetLatitudeLongitudeButton();
			Assert.assertEquals("", cap.verifyAutoPopulatedLatitude(), "auto populated latitude is verified");
			Assert.assertEquals("", cap.verifyAutoPopulatedLongitude(), "auto populated latitude is verified");
			cap.clickOnContactSaveButton();
			Assert.assertEquals("", cap.getSuccessfulSaveMessage(), "auto populated latitude is verified");
						
		} catch (Exception e) {
			System.out.println(e);
		}
	}


//	@Test(description = "Verify google translate icon displayed on all screen")
//	public void verifyGoogleTranslatePlugin() {
//		cotyHomePage chp = new cotyHomePage(driver);
//
//		try {
//			launchCotyUrl();
//			List<String> str = dr.readUrl();
//			chp.verifyGTPlugin(cotyUrl, str);
//			Log.info("Google translate icon displayed on all pages");
//
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//	
//	 @Test(description = "Verify selecting language from google translate icon
//	 will change the site content in that language")
//	 public void verifyGoogleTranslatingLanguage() {
//	 cotyHomePage chp = new cotyHomePage(driver);
//	
//	 try {
//	 List<String> str = dr.readUrl();
//	 chp.selectLanguage("DE", str);
//	 Assert.assertEquals(chp.verifyLanguage("DE"), true);
//	 Log.info("Google translate icon displayed on all pages");
//	
//	 } catch (Exception e) {
//	 System.out.println(e);
//	 }
//	 }

}
