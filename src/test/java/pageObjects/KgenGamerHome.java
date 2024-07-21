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
	By featuredQuestsSectionHeading = By.xpath("//span[normalize-space()='Featured Quests']");	
	
	public void verifyHomePageNavigation() {
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(logo), "Home Page");
	}
	
	public void verifyFeaturedQuestsSection() throws Exception {
		moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(featuredQuestsSectionHeading), "Featured Section");
		String[] featuredQuests= allApi.getFeaturedQuests();
		for(int i=0;i<4;i++) {
			String featuredQuest = featuredQuests[i];
			moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//p[normalize-space()='"+featuredQuest+"']")), "Featured Section");
			assertEqualsString_Custom(getText_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//p[normalize-space()='"+featuredQuest+"']")),"Featured Quest"), featuredQuest);
		}
	}
	
}
 