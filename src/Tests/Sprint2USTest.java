package Tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
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

}
