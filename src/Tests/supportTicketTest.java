package Tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Pages.navigationPage;
import utils.DataReader;
import utils.EmailReport;
import utils.SeleniumDriverFactory;

@Listeners(EmailReport.class)
public class supportTicketTest extends SeleniumDriverFactory {

	DataReader dr = new DataReader();

	@Test(description = "Verify footer links on all pages")
	public void verifyFooterLinksOnAllPages() {
		navigationPage nav = new navigationPage(driver);

		try {
			launchCotyUrl();
			List<String> str = new ArrayList<String>();
			//str = dr.readUrl();
			str = nav.getUrls(str);
			nav.verifyFooterLinksOnAllPages(cotyUrl, str);

		} catch (Exception e) {
			Log.error("Exception occured:", e);
			driver.quit();
		}
	}
	
	@Test(description = "Verify Session of cotywebsite")
	public void getSessionID() {
		navigationPage nav = new navigationPage(driver);

		try {
			launchCotyUrl();
			List<String> str = new ArrayList<String>();
			//str = dr.readUrl();
			str = nav.getUrls(str);
			nav.getSessionId(cotyUrl, str);

		} catch (Exception e) {
			Log.error("Exception occured:", e);
			driver.quit();
		}
	}
}
