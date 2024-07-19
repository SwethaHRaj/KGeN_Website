package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import testBase.BaseClass;
import testBase.LocalDriverFactory;

public class KgenGamerHome extends BaseClass {
	
	By logo = By.xpath("//a[normalize-space()='']//img[@alt='kgen_logo']");
	By featuredQuestsSection = By.xpath("//span[normalize-space()='Featured Quests']");	
	

	public void verifyHomePageNavigation() {
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(logo), "Home Page");
	}
	
	public void verifyFeaturedQuestsSection() throws Exception {
		moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(featuredQuestsSection), "Featured Section");
		WebDriverWait wait = new WebDriverWait(LocalDriverFactory.getInstance().getLocalDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/gamer/quests/karate-combat-v']//div[@class='MuiStack-root MuiCardContent-root css-1l32c5v']")));

		String[] featuredQuests= allApi.getFeaturedQuests();
		for(int i=0;i<5;i++) {
			String featuredQuest = featuredQuests[i];
			moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//span[normalize-space()='"+featuredQuest+"']")), "Featured Section");
			assertEqualsString_Custom(getText_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//span[normalize-space()='"+featuredQuest+"']")),"Featured Quest"), featuredQuest);
		}
	}
	
}