package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import reusableComponents.API;
import reusableComponents.PropertiesOperations;
import testBase.BaseClass;
import testBase.ExtentTestFactory;
import testBase.LocalDriverFactory;

public class Quests extends BaseClass {

	// Banner section
	By bannerViewQuestButton = By.xpath("//div[@class='swiper-slide swiper-slide-visible swiper-slide-active']//a[@role='link'][normalize-space()='View Quest']");
	By carausel1 = By.xpath("//div[@class='MuiBox-root css-1np2gmf']");
	By carausel2 = By.xpath("//div[@class='MuiStack-root css-148y9b3']//div[2]");
	By carausel3 = By.xpath("//div[@class='MuiStack-root css-148y9b3']//div[3]");
	By carausel4 = By.xpath("//div[@class='MuiStack-root css-148y9b3']//div[4]");
	// Filters
	By upcomingCheckbox = By.xpath("//div[@class='MuiBox-root css-4jobju']//div[2]//li[1]//div[1]//div[2]//ul[1]//div[1]//div[1]//div[1]");
	By liveCheckbox = By.xpath("p[normalize-space()='Live']");
	By endedCheckbox = By.xpath("//div[@class='MuiBox-root css-4jobju']//div[2]//li[1]//div[1]//div[2]//ul[1]//div[3]//div[1]//div[1]");
	// Quest card
	By questCard = By.linkText("href='/gamer/quests/karate-combat-v']");

	//p[normalize-space()='Live']
	public void clickLiveFilter() throws Exception {
		
		
	}

}



//a[@href='/gamer/quests/explore-becoming-a-guru-by-dappradar']//div[@class='MuiStack-root MuiCardContent-root css-1l32c5v']//div[@class='MuiStack-root css-15vhhhd']//div[@class='MuiBox-root css-1tehhj4']//div[@class='MuiBox-root css-1udtli7']