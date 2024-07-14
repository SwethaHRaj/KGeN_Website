package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BaseClass;
import testBase.LocalDriverFactory;

public class KgenHome extends BaseClass {
	
	
	// NavBar tabs
	By logo = By.xpath("//img[@alt='logo']");
	By about_tab = By.xpath("//a[@class='cursor-pointer whitespace-nowrap']");
	By build_tab = By.xpath("//a[@class=' cursor-pointer'][normalize-space()='Build']");
	By connect_tab = By.xpath("//a[@class=' cursor-pointer'][normalize-space()='Connect']");
	By droparena_tab = By.xpath("//a[normalize-space()='DropArena']");
	By play_tab = By.xpath("//a[@class=' cursor-pointer'][normalize-space()='Play']");
	By store_tab = By.xpath("//a[contains(@class,'cursor-pointer')][normalize-space()='Store']");
	// Verify pages
	//--Common highlight ele--
	By verify_tabHighlight_we1 = By.xpath("//a[@class='cursor-pointer whitespace-nowrap']//*[name()='svg']//*[name()='path' and contains(@fill-rule,'evenodd')]");
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
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(about_tab), "About Tab");
	}
	public void verifyAboutPageNavigation() {
		verify_TabHighlight(LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_tabHighlight_we1),LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_tabHighlight_we2), "About");
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_aboutPageElement), "About Page");
	}
	
	//BUILD Section Methods
	
	public void clickBuildTab() {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(build_tab), "Build Tab");
	}
	public void verifyBuildPageNavigation() {
		verify_TabHighlight(LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_tabHighlight_we1),LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_tabHighlight_we2), "Build");
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_buildPageElement), "Build Page");
	}
	
	//CONNECT Section Methods
	
	public void clickConnectTab() {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(connect_tab), "Connect Tab");
	}
	public void verifyConnectPageNavigation() {
		verify_TabHighlight(LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_tabHighlight_we1),LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_tabHighlight_we2), "Build");
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_connectPageElement), "Build Page");
	}
	
	//DROPARENA Section Methods
	
	public void clickDroparenaTab() {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(droparena_tab), "Droparena Tab");
	}
	public void verifyDropArenaPageNavigation() {
		verify_TabHighlight(LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_tabHighlight_we1),LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_tabHighlight_we2), "Build");
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_dropArenaPageElement), "Build Page");
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