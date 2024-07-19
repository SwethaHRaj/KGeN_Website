package testBase;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	WebDriver driver = null;

	public WebDriver createDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();	
			options.addArguments("--disable-notifications");
	        options.addArguments("--disable-popup-blocking");
	        options.addArguments("--disable-infobars");
	        options.addArguments("--disable-extensions");
	        options.addArguments("--disable-features=EnableEphemeralFlashPermission,EnablePasswordGeneration");
	        options.addArguments("--disable-background-timer-throttling");
	        options.addArguments("--disable-backgrounding-occluded-windows");
	        options.addArguments("--disable-renderer-backgrounding");
	        options.addArguments("--chrome.switches","--disable-extensions"); 
	        options.addArguments("--disable-save-password");
			options.addArguments("--no-crash-upload");
			options.addArguments("--deny-permission-prompts");
			options.addArguments("--no-first-run");
			options.addArguments("--disable-features=FirstRunUI");
			options.addArguments("--disable-features=OptimizationHints");
			options.addArguments("--disable-features=OptimizationHintsFetching");
			options.addArguments("--disable-features=Translate");
			options.addArguments("--disable-features=OptimizationTargetPrediction");
			options.addArguments("--disable-features=OptimizationGuideModelDownloading");
			options.addArguments("--disable-features=DownloadBubble");
			options.addArguments("--disable-features=DownloadBubbleV2");
			options.addArguments("--disable-features=InsecureDownloadWarnings");
			options.addArguments("--disable-features=InterestFeedContentSuggestions");
			options.addArguments("--disable-features=OptimizationHints");
			options.addArguments("--disable-features=OptimizationHintsFetching");
			options.addArguments("--disable-features=Translate");
			options.addArguments("--disable-features=OptimizationTargetPrediction");
			options.addArguments("--disable-features=OptimizationGuideModelDownloading");
			options.addArguments("--disable-features=InsecureDownloadWarnings");
			options.addArguments("--disable-features=InterestFeedContentSuggestions");
			options.addArguments("--enable-automation");
	        options.addArguments("--incongnito");
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--disable-notifications");
	        options.addArguments("--disable-popup-blocking");
	        options.addArguments("--disable-infobars");
	        options.addArguments("--disable-extensions");
			options.addArguments("--incongnito");
			driver = new EdgeDriver(options);
		} else if (browser.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
		return driver;
	}
}
