package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import reusableComponents.PropertiesOperations;
import testBase.BaseClass;
import testBase.LocalDriverFactory;

public class KgenHome extends BaseClass {
	
	String expectedUrl;
	
	
	// NavBar tabs
	By logo = By.xpath("//img[@alt='logo']");
	By about_tab = By.xpath("//a[@class='cursor-pointer header_labelAnimation__H221Z'][normalize-space()='About']");
	By build_tab = By.xpath("//a[@class='cursor-pointer header_labelAnimation__H221Z'][normalize-space()='Build']");
	By connect_tab = By.xpath("//a[@class='cursor-pointer header_labelAnimation__H221Z'][normalize-space()='Connect']");
	By droparena_tab = By.xpath("//a[normalize-space()='DropArena']");
	By play_tab = By.xpath("//a[@class='cursor-pointer header_labelAnimation__H221Z'][normalize-space()='Play']");
	By store_tab = By.xpath("//a[@class='cursor-pointer header_labelAnimation__H221Z'][normalize-space()='Store']");
	// Verify pages
	//--Common highlight ele--
//	By verify_tabHighlight_we1 = By.xpath("//a[@class='cursor-pointer whitespace-nowrap']//*[name()='svg']//*[name()='path' and contains(@fill-rule,'evenodd')]");
	By verify_tabHighlight_we2 = By.xpath("//*[name()='text' and contains(@class,'text-cente')]/../../.");
	//--About--
	By verify_aboutPageElement = By.xpath("//span[@class='codedText pagename']");
	//--Build--
	By verify_buildPageElement = By.xpath("//div[normalize-space()='Launch']");
	//--Connect--
	By verify_connectPageElement = By.xpath("//div[normalize-space()='Human Stories']");
	//--DropArena--
	By verify_dropArenaPageElement = By.xpath("//h1[@class='campaignBanner_banner-title-ellipsis__Xn11f m_8a5d1357 mantine-Title-root']");
	
	//ABOUT Section Methods
	
	public void clickAboutTab() {	

        WebDriverWait wait = new WebDriverWait(LocalDriverFactory.getInstance().getLocalDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(LocalDriverFactory.getInstance().getLocalDriver().findElement(about_tab)));
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(about_tab), "About Tab");
		    
//		CachedWebElement cachedElement = new CachedWebElement(LocalDriverFactory.getInstance().getLocalDriver(), about_tab);
//		cachedElement.click();
//		cachedElement.verify_PageNavigation("About Page");
	}
	public void verifyAboutPageNavigation() {
//		verify_TabHighlight(LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_tabHighlight_we1),LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_tabHighlight_we2), "About");
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_aboutPageElement), "About Page");
	}
	
	//BUILD Section Methods
	
	public void clickBuildTab() {
		WebDriverWait wait = new WebDriverWait(LocalDriverFactory.getInstance().getLocalDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(LocalDriverFactory.getInstance().getLocalDriver().findElement(build_tab)));
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(build_tab), "Build Tab");
		
		
//		CachedWebElement cachedElement = new CachedWebElement(LocalDriverFactory.getInstance().getLocalDriver(), build_tab);
//		cachedElement.click();
//		cachedElement.verify_PageNavigation("Build Page");
	}
	public void verifyBuildPageNavigation() {
//		verify_TabHighlight(LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_tabHighlight_we1),LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_tabHighlight_we2), "Build");
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_buildPageElement), "Build Page");
	}
	
	//CONNECT Section Methods
	
	public void clickConnectTab() {
		WebDriverWait wait = new WebDriverWait(LocalDriverFactory.getInstance().getLocalDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(LocalDriverFactory.getInstance().getLocalDriver().findElement(connect_tab)));
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(connect_tab), "Connect Tab");
		
//		CachedWebElement cachedElement = new CachedWebElement(LocalDriverFactory.getInstance().getLocalDriver(), connect_tab);
//		cachedElement.click();
//		cachedElement.verify_PageNavigation("Connect Page");
	}
	public void verifyConnectPageNavigation() {
//		verify_TabHighlight(LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_tabHighlight_we1),LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_tabHighlight_we2), "Build");
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_connectPageElement), "Connect Page");
	}
	
	//DROPARENA Section Methods
	
	public void clickDroparenaTab() {
		WebDriverWait wait = new WebDriverWait(LocalDriverFactory.getInstance().getLocalDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(LocalDriverFactory.getInstance().getLocalDriver().findElement(droparena_tab)));
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(droparena_tab), "Droparena Tab");
		
//		CachedWebElement cachedElement = new CachedWebElement(LocalDriverFactory.getInstance().getLocalDriver(), droparena_tab);
//		cachedElement.click();
//		cachedElement.verify_PageNavigation("DropArena Page");
	}
	public void verifyDropArenaPageNavigation(String enviroment) {
//		verify_TabHighlight(LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_tabHighlight_we1),LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_tabHighlight_we2), "Build");
		if(enviroment.equalsIgnoreCase("stage"))
			expectedUrl = PropertiesOperations.getProperty("stagekgenHome")+"/gamer/droparena";
		else
			expectedUrl = PropertiesOperations.getProperty("prodKgenHome")+"/gamer/droparena";
		String actualUrl = LocalDriverFactory.getInstance().getLocalDriver().getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Page Navigation Failed");
//		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_dropArenaPageElement), "DropArena Page");
	}
//	
//	//PLAY Section Methods
//	
//	public void clickPlayTab() {
//		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(play_tab), "Play Tab");
//	}
//	
//	//STORE Section Methods
//	
//	public void clickStoreTab() {
//		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(store_tab), "Store Tab");
//	}

}