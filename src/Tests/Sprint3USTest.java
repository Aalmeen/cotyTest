package Tests;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.cotyAdminPage;
import Pages.navigationPage;
import utils.SeleniumDriverFactory;
import utils.EmailReport;

@Listeners(EmailReport.class)
public class Sprint3USTest extends SeleniumDriverFactory{
	
//	@Test(description = "Verify size of CTA")
//	public void verifySizeOfCTA() {
//		navigationPage nav = new navigationPage(driver);
//
//		try {
//			launchCotyUrl();
//			nav.clickOnMenuIcon();
//			nav.clickOnOurStoryLink();
//			nav.verifyCTAOnOurStoryBanner();
//			nav.clickOnCTAofOurStoryBanner();
//			Assert.assertEquals(nav.getPageTitle(), "Our Purpose | coty.com", "Page not redirected to our purpose page");
//			nav.clickOnMenuIcon();
//			nav.clickOnOurStoryLink();
//			nav.verifyCTAOnOurFounderBanner();
//			nav.clickOnCTAOnOurFounderBanner();
//			Assert.assertEquals(nav.getPageTitle(), "Our Founders | coty.com", "Page not redirected to our founder page");
//			nav.clickOnMenuIcon();
//			nav.navigateBackToMaineMenuItem();
//			nav.navigateBackToMaineMenuItem();
//			nav.clickOnResponsibleGrowth();
//			nav.verifyCTAOnStrategyBanner();
//			nav.clickOnCTAofStrategyBanner();
//			Assert.assertEquals(nav.getPageTitle(), "strategy | coty.com", "Page not redirected to strategy page");
//			
//			
//		} catch (Exception e) {
//			Log.error("Exception Ocurred:", e);
//		}
//		}
	
	@Test(description = "Verify all the social media links in the footer section")
	public void verifySocialMediaLinkOnFooter() {
		navigationPage nav = new navigationPage(driver);
		cotyAdminPage cap = new cotyAdminPage(driver);

		try {
			launchCotyUrl();
			cap.clickOnCookiedAgreeButton();
			List<String> str = new ArrayList<String>();
			str = nav.getUrls(str);
			nav.verifySocialMediaLinksOnAllPagesFooter(cotyUrl, str);
			
		} catch (Exception e) {
			Log.error("Exception Ocurred:", e);
		}
		}
	
	@Test(description = "Verify all the social media links in C4 component")
	public void verifySocialMediaLinkInC4() {
		navigationPage nav = new navigationPage(driver);
		cotyAdminPage cap = new cotyAdminPage(driver);

		try {
			launchCotyUrl();
			cap.clickOnCookiedAgreeButton();
			nav.NavigateToPageHavingC4Component(cotyUrl);
			nav.verifySocialMediaLinksOnC4();
			
		} catch (Exception e) {
			Log.error("Exception Ocurred:", e);
		}
		}


}
