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

//	WebDriver driver = null;
//
//	public WebDriver createDriver(String browser) {
//		if (browser.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			ChromeOptions options = new ChromeOptions();	
////	        options.addArguments("--incongnito");
//			options.addArguments("--ash-no-nudges");
//			
//			
//			driver = new ChromeDriver(options);
//		} else if (browser.equalsIgnoreCase("edge")) {
//			WebDriverManager.edgedriver().setup();
//			EdgeOptions options = new EdgeOptions();
//			options.addArguments("--disable-notifications");
//	        options.addArguments("--disable-popup-blocking");
//	        options.addArguments("--disable-infobars");
//	        options.addArguments("--disable-extensions");
//			options.addArguments("--incongnito");
//			driver = new EdgeDriver(options);
//		} else if (browser.equalsIgnoreCase("safari")) {
//			WebDriverManager.safaridriver().setup();
//            driver = new SafariDriver();
//        }
//		return driver;
//	}

	public WebDriver createDriver(String browser) {
    WebDriver driver;
    if (browser.equalsIgnoreCase("chrome")) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        // Set download preferences
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", "/path/to/download");
        prefs.put("download.directory_upgrade", true);
        prefs.put("download.prompt_for_download", false);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("safebrowsing.enabled", false);
        prefs.put("safebrowsing.disable_download_protection", true);
        options.setExperimentalOption("prefs", prefs);

        // Set arguments
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-features=EnableEphemeralFlashPermission,EnablePasswordGeneration");
        options.addArguments("--disable-background-timer-throttling");
        options.addArguments("--disable-backgrounding-occluded-windows");
        options.addArguments("--disable-renderer-backgrounding");
        options.addArguments("--chrome.switches", "--disable-extensions");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--no-crash-upload");
        options.addArguments("--deny-permission-prompts");
        options.addArguments("--no-first-run");
        options.addArguments("--disable-features=FirstRunUI,OptimizationHints,OptimizationHintsFetching,Translate,OptimizationTargetPrediction,OptimizationGuideModelDownloading,DownloadBubble,DownloadBubbleV2,InsecureDownloadWarnings,InterestFeedContentSuggestions");
        options.addArguments("--enable-automation");
        options.addArguments("--incognito");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-single-click-autofill");
        options.addArguments("--allow-file-access-from-files");
        options.addArguments("--disable-prompt-on-repost");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-translate");

        // Set additional capabilities
        options.setCapability("goog:loggingPrefs", Map.of("performance", "ALL", "browser", "ALL"));

        driver = new ChromeDriver(options);
    } else if (browser.equalsIgnoreCase("edge")) {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();

        // Set arguments
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--incognito");

        driver = new EdgeDriver(options);
    } else if (browser.equalsIgnoreCase("safari")) {
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
    } else {
        throw new IllegalArgumentException("Browser not supported: " + browser);
    }
    return driver;
}




}
