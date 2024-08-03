package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import reusableComponents.AllApi;
import testBase.BaseClass;
import testBase.ExtentTestFactory;
import testBase.LocalDriverFactory;

public class KgenGamerHome extends BaseClass {
	
	By logo = By.xpath("//a[normalize-space()='']//img[@alt='kgen_logo']");
	By featuredQuestsSectionHeading = By.xpath("//span[normalize-space()='Featured Quests']");	
	By featuredGamesSectionHeading = By.xpath("//span[normalize-space()='Featured Games']");
	By trendingGamesSectionHeading = By.xpath("//span[normalize-space()='Trending Now']");
	
	public void verifyHomePageNavigation() {
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(logo), "Home Page");
	}
	
	public void verifyFeaturedQuestsSection() throws Exception {
		ExtentTestFactory.getInstance().getExtentTest().info("------------------Featured Quests Section Verification Started------------------");
		LocalDriverFactory.getInstance().getLocalDriver().navigate().refresh();
		moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(featuredQuestsSectionHeading), "Featured Quests Section");
		String[] featuredQuests= AllApi.getFeaturedQuests();
		for(int i=0;i<4;i++) {
			String featuredQuest = featuredQuests[i];
			moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//p[normalize-space()='"+featuredQuest+"']")), "Featured Quest");
			assertEqualsString_Custom(getText_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//p[normalize-space()='"+featuredQuest+"']")),"Featured Quest"), featuredQuest);
		}
		ExtentTestFactory.getInstance().getExtentTest().info("------------------Featured Quests Section Verification Successful------------------");
	}
	
	public void verifyFeaturedGamesSection() throws Exception {
		ExtentTestFactory.getInstance().getExtentTest().info("------------------Featured Games Section Verification Started------------------");
		moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(featuredGamesSectionHeading), "Featured Games Section");
		String[] featuredGames= AllApi.getFeaturedGames();
		for(int i=0;i<4;i++) {
			String featuredGame = featuredGames[i];
			moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//p[normalize-space()='"+featuredGame+"']")), "Featured Game");
			assertEqualsString_Custom(getText_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//p[normalize-space()='"+featuredGame+"']")),"Featured Game"), featuredGame);
		}
		ExtentTestFactory.getInstance().getExtentTest().info("------------------Featured Games Section Verification Successful------------------");
	}
	
	public void verifyTrendingGamesSection() throws Exception {
		ExtentTestFactory.getInstance().getExtentTest().info("------------------Trending Games Section Verification Started------------------");
		moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(trendingGamesSectionHeading), "Trending Games Section");
		String[] trendingGames= AllApi.getTrendingNowGames();
		for(int i=0;i<4;i++) {						
			String trendingGame = trendingGames[i];
			moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//span[normalize-space()='"+trendingGame+"']")), "Trending Game");
			assertEqualsString_Custom(getText_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//span[normalize-space()='"+trendingGame+"']")),"Trending Game"), trendingGame);
		}
		ExtentTestFactory.getInstance().getExtentTest().info("------------------Trending Games Section Verification Successful------------------");
	}
	
	
	
	
}
 