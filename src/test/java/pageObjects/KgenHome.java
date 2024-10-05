package pageObjects;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import freemarker.core.CustomAttribute;
import freemarker.core.Environment;
import reusableComponents.PropertiesOperations;
import testBase.BaseClass;
import testBase.LocalDriverFactory;
public class KgenHome extends BaseClass {
	
	String expectedUrl;
	
	
	//Secure login by google
	By google_cta = By.id("idp1");
	By google_emailAddressInputField = By.id("identifierId");
	By google_emailAddressNextButton = By.xpath("//button/span[text()='Next']");
	By google_passwordInputFieldText = By.xpath("//div[text()='Enter your password']/..");
	By google_passwordInputField = By.xpath("//div[@class='Xb9hP']/input[@class='whsOnd zHQkBf']");
	By google_passwordNextButton = By.xpath("//button/span[text()='Next']");
	
	
	// NavBar tabs
	By logo = By.xpath("//img[@alt='logo']");
	By about_tab = By.linkText("About");
	By build_tab = By.linkText("Build");
	By connect_tab = By.linkText("Connect");
	By droparena_tab = By.linkText("DropArena");
	By play_tab = By.linkText("Play");
	By store_tab = By.linkText("Store");
	// Verify pages
	//--Common highlight ele--
//	By verify_tabHighlight_we1 = By.xpath("//a[@class='cursor-pointer whitespace-nowrap']//*[name()='svg']//*[name()='path' and contains(@fill-rule,'evenodd')]");
	By verify_tabHighlight_we2 = By.xpath("//*[name()='text' and contains(@class,'text-cente')]/../../.");
	//--About--
	By verify_aboutPageElement = By.cssSelector(".codedText.home");
	//--Build--
	By verify_buildPageElement = By.xpath("//div[text()=\"Launch\"]");
	//--Connect--
	By verify_connectPageElement = By.cssSelector("div[class='ConnectBanner_cont___2hn3']");
	//--DropArena--
	By verify_dropArenaPageElement = By.cssSelector(".m_811560b9.mantine-Button-label");
	//--Play--
	By verify_PlayPageElement = By.cssSelector("div[class='MuiBox-root css-7zzdjs']");
		
	
	
	//----------------------------------------------ABOUT Section Methods----------------------------------------------
	
	
	public void secureGoogleLogin() throws InterruptedException {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(google_cta), "Google Cta");
		sendKeys_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(google_emailAddressInputField), "Email Address Field", "swetha.hr@kgen.io");
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(google_emailAddressNextButton), "Email Next Cta");
		WebDriverWait wait = new WebDriverWait(LocalDriverFactory.getInstance().getLocalDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(LocalDriverFactory.getInstance().getLocalDriver().findElement(google_passwordInputFieldText)));
//		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(google_passwordInputField), "Password Next Cta");
//		JavascriptExecutor js = (JavascriptExecutor) LocalDriverFactory.getInstance().getLocalDriver();
//		js.executeScript("arguments[0].value='Swethahr@indigg';", LocalDriverFactory.getInstance().getLocalDriver().findElement(google_passwordInputField));
		sendKeys_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(google_passwordInputField), "Password Field", "Swethahr@indigg");
		Thread.sleep(5000);
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(google_passwordNextButton), "Password Next Cta");
	}
	
	
	public void clickAboutTab() {	
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(about_tab), "About Tab");
		
	}
	public void verifyAboutPageNavigation(String environment) {
		WebDriverWait wait = new WebDriverWait(LocalDriverFactory.getInstance().getLocalDriver(), Duration.ofSeconds(20));
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_aboutPageElement), "About Page");
	}
	
	//----------------------------------------------BUILD Section Methods----------------------------------------------
	
	public void clickBuildTab() {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(build_tab), "Build Tab");
	}
	public void verifyBuildPageNavigation(String environment) {
		WebDriverWait wait = new WebDriverWait(LocalDriverFactory.getInstance().getLocalDriver(), Duration.ofSeconds(20));
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_buildPageElement), "Build Page");
	}
	
	//----------------------------------------------CONNECT Section Methods----------------------------------------------
	
	public void clickConnectTab() {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(connect_tab), "Connect Tab");
	}
	public void verifyConnectPageNavigation(String environment) {
		WebDriverWait wait = new WebDriverWait(LocalDriverFactory.getInstance().getLocalDriver(), Duration.ofSeconds(20));
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_connectPageElement), "Connect Page");
	}
	
	//----------------------------------------------DROPARENA Section Methods----------------------------------------------
	
	public void clickDroparenaTab() {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(droparena_tab), "Droparena Tab");
	}
	public void verifyDropArenaPageNavigation(String environment) {
		WebDriverWait wait = new WebDriverWait(LocalDriverFactory.getInstance().getLocalDriver(), Duration.ofSeconds(20));
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_dropArenaPageElement), "DropArena Page");
	}
	
	
	
	//----------------------------------------------PLAY Section Methods----------------------------------------------
	
	public void clickPlayTab() {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(play_tab), "Play Tab");
	}
	public void verifyPlayPageURL(String environment) {
		WebDriverWait wait = new WebDriverWait(LocalDriverFactory.getInstance().getLocalDriver(), Duration.ofSeconds(20));
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_PlayPageElement), "Play Page");
	}
	
	
	//----------------------------------------------General Methods----------------------------------------------
	
	public void verifyNavBarTabURLs(String enviroment) {
		String originalWindow = LocalDriverFactory.getInstance().getLocalDriver().getWindowHandle();
		clickAboutTab();
		verifyAboutPageNavigation(enviroment);
		clickBuildTab();
		verifyBuildPageNavigation(enviroment);
		clickConnectTab();
		verifyConnectPageNavigation(enviroment);
		clickDroparenaTab();
		verifyDropArenaPageNavigation(enviroment);
		clickPlayTab();
		// Wait for the new window or tab
		Set<String> allWindows = LocalDriverFactory.getInstance().getLocalDriver().getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
            	LocalDriverFactory.getInstance().getLocalDriver().switchTo().window(windowHandle);
                break;
            }
        }
        // Perform actions in the new window
		verifyPlayPageURL(enviroment);
		// Close the new window and switch back to the original window
		LocalDriverFactory.getInstance().getLocalDriver().close();
		LocalDriverFactory.getInstance().getLocalDriver().switchTo().window(originalWindow);
	}
}