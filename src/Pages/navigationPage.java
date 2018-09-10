package Pages;

import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.SeleniumDriverFactory;

public class navigationPage {

	public WebDriver driver;
	public Logger Log = Logger.getLogger(SeleniumDriverFactory.class.getName());

	@FindBy(css = "#block-menu-menu-footer-menu > ul:nth-child(1) > li")
	WebElement footerLinks;

	@FindBy(xpath = "//*[@id='block-menu-menu-footer-menu']/ul/li[1]/a")
	WebElement contactUs;
	
	@FindBy(xpath = "//*[@id='block-menu-menu-footer-menu']/ul/li[2]/a")
	WebElement supplieProcurement;

	@FindBy(xpath = "//*[@id='block-menu-menu-footer-menu']/ul/li[3]/a")
	WebElement termsPrivacy;
	
	@FindBy(css = "#burger-menu")
	WebElement menuIcon;
	
	@FindBy(xpath = "//a[@href='/our-story']")
	WebElement ourStoryLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Brands that inspire')]")
	WebElement brandThatInspirelink;
	
	@FindBy(xpath = "//a[contains(text(), 'Responsible growth')]")
	WebElement responsibleGrowthLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Join us')]")
	WebElement JoinUsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'In the news')]")
	WebElement inTheNews;
	
	@FindBy(css = ".arrow")
	WebElement backtoMainMenu;
	
	@FindBy(xpath = "//*[@id='block-menu-menu-footer-menu']/ul/li[4]/a")
	WebElement transparency;

	@FindBy(css = "div.views-row:nth-child(1) > a:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1)")
	WebElement firstDisplayedNews;

	@FindBy(css = "a.social-icon:nth-child(1)")
	WebElement twitterFooter;
	
	@FindBy(css = "a.social-icon:nth-child(2)")
	WebElement instagramFooter;
	
	@FindBy(css = "a.social-icon:nth-child(3)")
	WebElement linkedInFooter;
	
	@FindBy(css = ".field--name-field-twitter-in-page")
	WebElement twitterC4;
	
	@FindBy(css = ".field--name-field-instagram-in-page")
	WebElement instagramC4;
	
	@FindBy(css = ".field--name-field-linked-in-page")
	WebElement linkedC4;
	
	@FindBy(css = ".field--name-field-facebook-page")
	WebElement facebookC4;
	
	@FindBy(xpath = "//div[@class='icon-arrow-circle'][1]")
	WebElement ourStoryCTA;
	
	@FindBy(xpath = "//div[@class='icon-arrow-circle'][2]")
	WebElement founderCTA;
	
	@FindBy(xpath = ".field--name-field-hero-paragraphs > div:nth-child(1) > div:nth-child(1)")
	WebElement ourHomeCTA;
	
	public navigationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyFooterLinksOnAllPages(String cotyUrl, List<String> str) {
		for (int i = 0; i < str.size(); i++) {
			driver.get(cotyUrl + str.get(i));
			Log.info("Navigated to " + cotyUrl + str.get(i));
			
			if (contactUs.isDisplayed() && contactUs.isEnabled()) {
				String url = contactUs.getAttribute("href");
				verifyLinkActive(url);
			} else {
				Log.info("Contact Us link into footer is not enabled");
			}
			
			if (supplieProcurement.isDisplayed() && supplieProcurement.isEnabled()) {
				String url = supplieProcurement.getAttribute("href");
				verifyLinkActive(url);
			} else {
				Log.info("supplie procurement link into footer is not enabled");
			}
			
			if (termsPrivacy.isDisplayed() && termsPrivacy.isEnabled()) {
				String url = termsPrivacy.getAttribute("href");
				verifyLinkActive(url);
			} else {
				Log.info("terms and provacy link into footer is not enabled");
			}
			
			if (transparency.isDisplayed() && transparency.isEnabled()) {
				String url = transparency.getAttribute("href");
				verifyLinkActive(url);
			} else {
				Log.info("transparency link into footer is not enabled");
			}
		}
	}

	private void verifyLinkActive(String footerUrl) {
		try {
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.97.32.19", 8080));
			URL url = new URL(footerUrl);
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection(proxy);
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() == 200) {
				Log.info(footerUrl + " - " + httpURLConnect.getResponseMessage());
			}
			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				Log.info(footerUrl + " - " + httpURLConnect.getResponseMessage() + " - "
						+ HttpURLConnection.HTTP_NOT_FOUND);
			}
		} catch (Exception e) {
			Log.error("Exception occured:", e);
		}

	}

	public void getSessionId(String cotyUrl, List<String> str) {
		
		for (int i = 0; i < str.size(); i++) {
			driver.get(cotyUrl + str.get(i));
			SessionId session = ((RemoteWebDriver)driver).getSessionId();
			Log.info("Session of url: " +  cotyUrl+ str.get(i) + " is " + session.toString());
		}
		
	}

	public List<String> getUrls(List<String> str) {
		str.add("brands");
		str.add("brands/consumer-beauty");
		str.add("brands/luxury");
		str.add("brands/professional-beauty");
		str.add("contact-us");
		str.add("cookie-policy");
		str.add("cookies-policy-it");
		str.add("home");
		str.add("in-the-news");
		str.add("in-the-news/brand/backstage-at-london-fashion-week-with-wella-professional");
		str.add("in-the-news/brand/behind-the-scenes-at-new-york-fashion-week-with-ghd");
		str.add("in-the-news/brand/opi-iceland-collection-inspiration");
		str.add("in-the-news/press-release/chloe-announces-face-of-new-fragrance");
		str.add("our-story");
		str.add("our-story/coty-founders");
		str.add("our-story/coty-founders/bourjois-ponsin");
		str.add("our-story/coty-founders/cristina-carlino");
		str.add("press-release/Wella-Professionals-ITVA");
		//str.add("privacy-policy");
		str.add("search");
		str.add("terms-use");
		str.add("ugcrelease");
		str.add("in-the-news/press-release/clairol-launches-new-niceneasy");
		str.add("in-the-news/press-release/coty-acquires-burberry-luxury-fragrances");
		str.add("in-the-news/press-release/coty-announces-transformation-of-iconic-covergirl-brand");
		str.add("in-the-news/press-release/coty-appoints-daniel-ramos-as-chief-scientific-officer");
		str.add("in-the-news/voices/coty-fragrance-expert-deconstructs-a-scent");
		str.add("our-story/coty-leader");
		str.add("our-story/coty-leaders/camillo-pane");
		str.add("join-our-team");
		str.add("join-our-team/how-we-work");
		str.add("our-story/the-purpose-of-coty");
		str.add("our-story/division-professional-beauty");
		str.add("our-story/division-luxury");
		str.add("our-story/division-consumer-beauty");
		str.add("our-story/coty-values/our-values");
		return str;
	}

	public void clickOnMenuIcon() {
		menuIcon.click();	
		Log.info("clicked on menu icon");
	}

	public void clickOnOurStoryLink() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(ourStoryLink));
		ourStoryLink.click();
		Log.info("clicked on Our Story menu link");
	}

	public String getPageTitle() {
		String str = driver.getTitle();
		return driver.getTitle();
	}

	public void navigateBackToMaineMenuItem() {
		backtoMainMenu.click();
		Log.info("clicked on back icon of menu items");
	}

	public void clickOnBrandsthatInspire() {
		brandThatInspirelink.click();
		Log.info("clicked on brands that inspire menu link");
	}

	public void clickOnResponsibleGrowth() {
		responsibleGrowthLink.click();
		Log.info("clicked on responsible growth menu link");
	}

	public void clickOnJoinUs() {
		JoinUsLink.click();	
		Log.info("clicked on Join us link");
	}

	public void verifyCTAOnOurStoryBanner() {
		ourStoryCTA.isDisplayed();
		Log.info("Clicked on CTA icon on our story banner");
	}

	public void clickOnCTAofOurStoryBanner() {
		ourStoryCTA.click();
		Log.info("clicked on CTA icon on our story banner");
	}

	public void verifyCTAOnOurFounderBanner() {
		founderCTA.isDisplayed();
		Log.info("clicked on CTA icon on our founder banner");
	}

	public void clickOnCTAOnOurFounderBanner() {
		founderCTA.click();
		Log.info("clicked on CTA icon on our founder banner");
	}

	public void verifyCTAOnStrategyBanner() {
		ourStoryCTA.isDisplayed();
		Log.info("Verified CTA icon on strategy banner");
	}

	public void clickOnCTAofStrategyBanner() {
		ourStoryCTA.click();
		Log.info("clicked on CTA icon of strategy banner");
	}

	public void clickOnInTheNewsLink() {
		inTheNews.click();
		Log.info("clicked on In the News Link");
	}


	public boolean verifyNewsPriortrized(String str) {
		return firstDisplayedNews.getText().contains(str);
	}
	
	public void verifySocialMediaLinksOnAllPagesFooter(String cotyUrl, List<String> str) {
		for (int i = 0; i < str.size(); i++) {
			driver.get(cotyUrl + str.get(i));
			Log.info("Navigated to " + cotyUrl + str.get(i));
			
			if (twitterFooter.isDisplayed() && twitterFooter.isEnabled()) {
				String url = twitterFooter.getAttribute("href");
				verifyLinkActive(url);
			} else {
				Log.info("twitter link into footer is not enabled");
			}
			
			if (instagramFooter.isDisplayed() && instagramFooter.isEnabled()) {
				String url = instagramFooter.getAttribute("href");
				verifyLinkActive(url);
			} else {
				Log.info("footer link into footer is not enabled");
			}
			
			if (linkedInFooter.isDisplayed() && linkedInFooter.isEnabled()) {
				String url = linkedInFooter.getAttribute("href");
				verifyLinkActive(url);
			} else {
				Log.info("terms and provacy link into footer is not enabled");
			}
		}
	}
	
	public void NavigateToPageHavingC4Component(String cotyUrl) {
		driver.get(cotyUrl+"in-the-news/voices/renowed-makeup-artist-gives-us-the-latest-trends-in-singapore");
		
	}

	public void verifySocialMediaLinksOnC4() {
		twitterC4.isDisplayed();
		facebookC4.isDisplayed();
		linkedC4.isDisplayed();
		instagramC4.isDisplayed();	
		Log.info("Verified social media links on footer");
	}

	public void verifyCTAOnHomePage() {
		ourHomeCTA.isDisplayed();
		Log.info("CTA icon displayed at home page");
	}

	public void clickOnCTAAtHomePage() {
		ourHomeCTA.click();
		Log.info("clicked on CTA icon ");
		
	}

}
