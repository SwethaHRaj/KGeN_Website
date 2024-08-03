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
import reusableComponents.AllApi;
import reusableComponents.PropertiesOperations;
import testBase.BaseClass;
import testBase.ExtentTestFactory;
import testBase.LocalDriverFactory;

public class KgenGamerQuests extends BaseClass {

	// Header
	By questsHeaderText = By.xpath("//span[@class='MuiTypography-root MuiTypography-h4 css-1dg7emc']");
	// Sub Tabs
	By allTab = By.xpath("//button[normalize-space()='ALL']");
		// QuestTitle
		
	By liveTab = By.xpath("//button[normalize-space()='LIVE']");
	By upcomingTab = By.xpath("//button[normalize-space()='UPCOMING']");
		// No quest message
		By nullMessage = By.xpath("//div[@class='MuiBox-root css-8atqhb'][normalize-space()='No matching quests found! Please change the filters and try again.']");
	By endedTab = By.xpath("//button[normalize-space()='ENDED']");
	// Filters
	By myQuestDropdown = By.xpath("//div[contains(text(),'MY QUEST')]");
	By typeDropdown = By.xpath("//div[contains(text(),'TYPE')]");
	
//	By  = By.xpath("");
//	By  = By.xpath("");

	
	// partial failure
	public void verifyAllQuests() throws Exception {
		
		// If Quests List Is Null
		// write code
				
		// If Quests List Available
		ExtentTestFactory.getInstance().getExtentTest().info("------------------All Quests Verification Started------------------");
		LocalDriverFactory.getInstance().getLocalDriver().navigate().refresh();
		moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(questsHeaderText), "Quests 'All' Tab");
		String[] allQuests= AllApi.getAllQuests();
		for(int i=0;i<allQuests.length;i++) {							
			String questTitle = allQuests[i];
			//div/div[200]/div/div[3]/div[1]/div/p 
			//p[normalize-space()='"+questTitle+"']
			moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//div/div["+(i+1)+"]/div/div[3]/div[1]/div/p")), "Quest "+(i+1)+"");
			assertEqualsString_Custom(getText_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//div/div["+(i+1)+"]/div/div[3]/div[1]/div/p")),"Quest "+(i+1)+""), questTitle);
		}
		ExtentTestFactory.getInstance().getExtentTest().info("------------------All Quests Verification Successful------------------");	
	}
	
	
	// Pass
	public void verifyLiveQuests() throws Exception {
		
		// If Quests List Is Null
		// write code
		
		// If Quests List Available
		ExtentTestFactory.getInstance().getExtentTest().info("------------------Live Quests Verification Started------------------");
//		LocalDriverFactory.getInstance().getLocalDriver().navigate().refresh();
		moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(liveTab), "Quests 'Live' Tab");
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(liveTab), "Quests 'Live' Tab");
		String[] liveQuests= AllApi.getLiveQuests();
		for(int i=0;i<liveQuests.length;i++) {							
			String questTitle = liveQuests[i];
			//div/div[200]/div/div[3]/div[1]/div/p 
			//p[normalize-space()='"+questTitle+"']
			moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//div[@class='MuiStack-root css-37tgcq']//div["+(i+1)+"]//div[1]//div[3]//div[1]//div[1]//p[1]")), "Live Quest "+(i+1)+"");
			assertEqualsString_Custom(getText_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//div[@class='MuiStack-root css-37tgcq']//div["+(i+1)+"]//div[1]//div[3]//div[1]//div[1]//p[1]")),"Live Quest "+(i+1)+""), questTitle);
		}
		ExtentTestFactory.getInstance().getExtentTest().info("------------------Live Quests Verification Successful------------------");	
	}
	
	public void verifyUpcomingQuests() throws Exception {
		
		ExtentTestFactory.getInstance().getExtentTest().info("------------------Upcoming Quests Verification Started------------------");
		String[] upcomingQuests= AllApi.getUpcomingQuests();
		// If Quests List Is Null
		if(upcomingQuests.length==0){
			moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(upcomingTab), "Quests 'Upcoming' Tab");
			click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(upcomingTab), "Quests 'Live' Tab");
			moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(nullMessage), "Quests 'Upcoming' Tab");
			assertEqualsString_Custom(getText_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(nullMessage),"Upcoming Null Message"), "No matching quests found! Please change the filters and try again.");
		}		
		// If Quests List Available
		else {
		moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(upcomingTab), "Quests 'Upcoming' Tab");
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(upcomingTab), "Quests 'Upcoming' Tab");
		for(int i=0;i<upcomingQuests.length;i++) {							
			String questTitle = upcomingQuests[i];
			moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//div[@class='MuiStack-root css-37tgcq']//div["+(i+1)+"]//div[1]//div[3]//div[1]//div[1]//p[1]")), "Live Quest "+(i+1)+"");
			assertEqualsString_Custom(getText_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//div[@class='MuiStack-root css-37tgcq']//div["+(i+1)+"]//div[1]//div[3]//div[1]//div[1]//p[1]")),"Live Quest "+(i+1)+""), questTitle);
		}
		}
		ExtentTestFactory.getInstance().getExtentTest().info("------------------Upcoming Quests Verification Successful------------------");	
	}
	
	public void verifyEndedQuests() throws Exception {
		
		ExtentTestFactory.getInstance().getExtentTest().info("------------------Ended Quests Verification Started------------------");
		String[] endedQuests= AllApi.getEndedQuests();
		// If Quests List Is Null
		if(endedQuests.length==0){
			moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(endedTab), "Quests 'Upcoming' Tab");
			click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(endedTab), "Quests 'Live' Tab");
			moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(nullMessage), "Quests 'Upcoming' Tab");
			assertEqualsString_Custom(getText_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(nullMessage),"Ended Null Message"), "No matching quests found! Please change the filters and try again.");
		}		
		// If Quests List Available
		else {
		moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(endedTab), "Quests 'Upcoming' Tab");
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(endedTab), "Quests 'Upcoming' Tab");
		for(int i=0;i<endedQuests.length;i++) {							
			String questTitle = endedQuests[i];
			moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//p[normalize-space()='"+questTitle+"']")), "Live Quest "+(i+1)+"");
			assertEqualsString_Custom(getText_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//p[normalize-space()='"+questTitle+"']")),"Live Quest "+(i+1)+""), questTitle);
		}
		}
		ExtentTestFactory.getInstance().getExtentTest().info("------------------Ended Quests Verification Successful------------------");	
	}


}

