package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.cotyHomePage;
import utils.DataReader;
import utils.SeleniumDriverFactory;


public class navigationTest extends SeleniumDriverFactory {

	cotyHomePage chp = new cotyHomePage(driver);
	DataReader dr = new DataReader();
	
	@Test
	public void checkNavigationOnDifferentPages() {
		try {
			dr.readUrl();
			chp.verifymenuicon();
			Log.info("Menu icon displayed");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
}
