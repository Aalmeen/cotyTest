package Tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.cotyAdminPage;
import Pages.navigationPage;
import utils.DataReader;
import utils.SeleniumDriverFactory;
import utils.EmailReport;

@Listeners(EmailReport.class)
public class Sprint2USTest extends SeleniumDriverFactory{
	
	DataReader dr = new DataReader();

	@Test(description = "Implementation of one-click to access the hubs")
	public void verifyFixNavigation() {
		navigationPage nav = new navigationPage(driver);

		try {
			launchCotyUrl();
			nav.clickOnMenuIcon();
			nav.clickOnOurStoryLink();
			Assert.assertEquals(nav.getPageTitle(), "our story | coty.com", "Page not redirected to Our story page");
			nav.clickOnMenuIcon();
			nav.navigateBackToMaineMenuItem();
			nav.clickOnBrandsthatInspire();
			Assert.assertEquals(nav.getPageTitle(), "brands that inspire | coty.com", "Page not redirected to Brands that inspire page");
			nav.clickOnMenuIcon();
			nav.navigateBackToMaineMenuItem();
			nav.clickOnResponsibleGrowth();
			Assert.assertEquals(nav.getPageTitle(), "Responsible growth | coty.com", "Page not redirected to Responsible growth page");
			nav.clickOnMenuIcon();
			nav.navigateBackToMaineMenuItem();
			nav.clickOnJoinUs();
			Assert.assertEquals(nav.getPageTitle(), "Join us | coty.com", "Page not redirected to Join us page");
			
		} catch (Exception e) {
			Log.error("Exception Ocurred:", e);
		}
		}
	
	@Test(description = "Verify Authors can schedule when to publish and unpublish certain content")
	public void verifyAuthorCanScheduleContent() {
		navigationPage nav = new navigationPage(driver);
		cotyAdminPage cap = new cotyAdminPage(driver);

		try {
			launchCotyAdminUrl();
			cap.clickOnCookiedAgreeButton();
			cap.loginAsAdmin(user, password);
			cap.clickOnHomeIcon();
			cap.clickOnEditButton();
			cap.clickOnScheduleOptionTab();
			Assert.assertEquals(cap.verifyScheduleOptionText(), "Not Scheduled", "Text not matching with Not scheduled");
			cap.enterPublishDate("");
			cap.clickOnSubmitButton();
			Assert.assertEquals(cap.verifyErrorMessage(), "The value input for field Publish on is invalid", "Error message does not display for scheduling content");
			cap.enterPublishTime("");
			Assert.assertEquals(cap.verifyScheduleOptionText(), "Scheduled for publishing", "Text not matching with Scheduled for publishing");
			cap.clickOnSubmitButton();
			
		} catch (Exception e) {
			Log.error("Exception Ocurred:", e);
		}
		}
	
	@Test(description = "Verify Search bar to filter and find pages from “Content Structure” ")
	public void verifyFilterFunctionalityForContent() {
		navigationPage nav = new navigationPage(driver);
		cotyAdminPage cap = new cotyAdminPage(driver);

		try {
			launchCotyAdminUrl();
			cap.clickOnCookiedAgreeButton();
			cap.loginAsAdmin(user, password);
			cap.navigateToAdminContent(cotyUrl);
			cap.verifyAvailableSearchFields();
			cap.enterCreatedStartDate("08/17/2018");
			cap.enterCreatedEndDate("08/17/2018");
			cap.clickOnApplyButton();
			Assert.assertEquals(cap.verifySearchResultForCreatedDate("08/17/2018"), true, "Search result are not matching");
			cap.enterUpdatedStartDate("08/29/2018");
			cap.enterUpdatedEndDate("08/29/2018");
			cap.clickOnApplyButton();
			Assert.assertEquals(cap.verifySearchResultForUpdatedDate("08/17/2018"), true, "Search result are not matching");
			
		} catch (Exception e) {
			Log.error("Exception Ocurred:", e);
		}
		}
	
	@Test(description = "Verify The author should be able to arrange content on news page")
	public void verifyArrangingContentOnNewspage() {
		navigationPage nav = new navigationPage(driver);
		cotyAdminPage cap = new cotyAdminPage(driver);

		try {                                                                  
			launchCotyAdminUrl();
			cap.loginAsAdmin(user, password);
			cap.clickOnHomeIcon();
			nav.clickOnMenuIcon();
			nav.clickOnInTheNewsLink();
			cap.clickOnSubNewsLink();
			String str = nav.getPageTitle();
			cap.clickOnEditButton();
			Assert.assertEquals(cap.verifyNewsPriorityDropDown(), true, "News priority drop down is not displaying");
			cap.selectNewsPriority("1");
			cap.clickOnSubmitButton();
			cap.runApacheSolr(cotyUrl);
			cap.clickOnHomeIcon();
			nav.clickOnMenuIcon();
			nav.clickOnInTheNewsLink();
			Assert.assertEquals(nav.verifyNewsPriortrized(str), true, "News is not getting priotrized");			
			
		} catch (Exception e) {
			Log.error("Exception Ocurred:", e);
		}
		}
	


}
