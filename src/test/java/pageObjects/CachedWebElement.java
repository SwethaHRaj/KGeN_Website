package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import testBase.ExtentTestFactory;

public class CachedWebElement {
    private WebDriver driver;
    private By locator;
    private WebElement element;

    public CachedWebElement(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
        this.element = null;
    }

    private void locateElement() {
        this.element = driver.findElement(locator);
    }

    private WebElement getElement() {
        if (this.element == null) {
            locateElement();
        }
        return this.element;
    }

    private void retryOnStale(Runnable action) {
        try {
            action.run();
        } catch (StaleElementReferenceException e) {
            locateElement();
            action.run();
        }
    }

    public void click() {
        retryOnStale(() -> getElement().click());
    }

    public void sendKeys(CharSequence... keysToSend) {
        retryOnStale(() -> getElement().sendKeys(keysToSend));
    }

    public String getText() {
        final String[] text = new String[1];
        retryOnStale(() -> text[0] = getElement().getText());
        return text[0];
    }
    
    public void verify_PageNavigation(String pageName) {
		try {
			if (getElement().isDisplayed())
				ExtentTestFactory.getInstance().getExtentTest().log(Status.PASS,
						pageName + "--> Navigated successfully");
		} catch (Exception e) {
			ExtentTestFactory.getInstance().getExtentTest().log(Status.FAIL, pageName + "--> Navigation Failed");
		}
	}

    // Add more methods as needed, following the same pattern
}


//Usage Example
//CachedWebElement cachedElement = new CachedWebElement(LocalDriverFactory.getInstance().getLocalDriver(), build_tab);
//cachedElement.click();
//cachedElement.verify_PageNavigation("Build Page");

