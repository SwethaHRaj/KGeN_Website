package pageObjects;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import freemarker.core.Environment;
import reusableComponents.PropertiesOperations;
import testBase.BaseClass;
import testBase.ExtentTestFactory;
import testBase.LocalDriverFactory;

public class KgenKDropHomePage extends BaseClass {

	//Featured Section
	By featuredSection_title = By.xpath("//h1[contains(@class,'m_8a5d1357 mantine-Title-root')]");
	

//	By  = By.xpath("");
	
	
	//----------------------------------------------      ---------------------------------------------- 
	
	public void validateFollowTasks() throws InterruptedException {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//button[@class='mantine-focus-auto mantine-active theme_actionIcon__7Jpg1 storyIntoModal_closeIcon__2_WfM m_8d3f4000 mantine-ActionIcon-root m_87cf2631 mantine-UnstyledButton-root']")),"Story Overlay Close");		
		 WebDriverWait wait = new WebDriverWait(LocalDriverFactory.getInstance().getLocalDriver(), Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.visibilityOf(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//div[@class='campaignDetails_card-container-2__on9eI']//div[1]//div[1]//div[2]//div[2]//div[1]//div[1]//div[2]//div[2]/p"))));
		 for(int i=1;i<3;i++) {
			 WebElement we = LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//div[@class='campaignDetails_card-container-2__on9eI']//div["+i+"]//div[1]//div[2]//div[2]//div[1]//div[1]//div[2]//div[2]/p"));
			 String campaignState = getText_Custom(we,"Campaign State");
			 System.out.println(i+" ---> "+campaignState);
			 if(campaignState.equals("GET STARTED")) {
			 moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//div[@class='campaignDetails_card-container-2__on9eI']//div["+i+"]//div[1]//div[2]//div[2]//div[1]//div[1]//div[2]//div[2]/p")), "Campaign Card"); 
			 Thread.sleep(3000);
			 click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//div[@class='campaignDetails_card-container-2__on9eI']//div["+i+"]//div[1]//div[2]//div[2]//div[1]//div[1]//div[2]//div[2]/p")),"Campaign Card");
			 }
		 }
	 }
	
	
	//----------------------------------------------  LOGIN - PHONE NUMBER  ----------------------------------------------
	
	public void loginToKDrop() throws InterruptedException {
//		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//button[@class='mantine-focus-auto mantine-active theme_actionIcon__7Jpg1 storyIntoModal_closeIcon__2_WfM m_8d3f4000 mantine-ActionIcon-root m_87cf2631 mantine-UnstyledButton-root']")),"Story Overlay Close");		
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//span[contains(text(),'LOGIN')]")),"Nav Bar Login Button");
		sendKeys_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//input/../../div[3]/input")),"Phone Number Input Field","9876543210");
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//span[contains(text(),'Login')]")),"Login cta of Phone Number Window");
		sendKeys_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//input/../../../div[2]/div/input")),"OTP Field","111111");
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//span[contains(text(),'Verify')]")),"Verify cta");
		TimeUnit.SECONDS.sleep(10);
	}
	
	

	public void validateFeaturedCampignsSection(String environment) throws InterruptedException {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//button[@class='mantine-focus-auto mantine-active theme_actionIcon__7Jpg1 storyIntoModal_closeIcon__2_WfM m_8d3f4000 mantine-ActionIcon-root m_87cf2631 mantine-UnstyledButton-root']")),"Story Overlay Close");		
		
		System.out.println("\n--------------------FEATURED CAMPAIGNS TESTING STARTED--------------------\n");
		String[] actualFeaturedCampaignTitles = new String[4];
		Arrays.fill(actualFeaturedCampaignTitles, null);
		int distinctCount = 0;
		
		// Record the start time
        long startTime = System.currentTimeMillis();
        long maxDuration = 30 * 1000; // 1 minute in milliseconds
		
		while (distinctCount < actualFeaturedCampaignTitles.length) {
			
			if (System.currentTimeMillis() - startTime > maxDuration) {
//                System.out.println("Time limit exceeded, exiting the loop.");
                break;
            }
			
            WebElement banner = LocalDriverFactory.getInstance().getLocalDriver().findElement(featuredSection_title);
            String bannerText = banner.getText().trim();
            

            // Check if the banner text is not already in the array
            boolean exists = false;
            for (String text : actualFeaturedCampaignTitles) {
                if (bannerText.equals(text)) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                actualFeaturedCampaignTitles[distinctCount] = bannerText;
                distinctCount++;
            }
            System.out.println(bannerText); //current banner
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		
		String[] expectedFeaturedCampaignTitles = allApi.getFeaturedCampaigns(environment);
		
		// Filter out nulls and compare
        String[] filteredActualValues = Arrays.stream(actualFeaturedCampaignTitles)
                                              .filter(value -> value != null)
                                              .toArray(String[]::new);
                                              
        String[] filteredExpectedValues = Arrays.stream(expectedFeaturedCampaignTitles)
                                                .filter(value -> value != null)
                                                .toArray(String[]::new);
        
        System.out.println("\nFE Featured Campaigns List Count = " + filteredActualValues.length);
        for(int j=0;j<filteredActualValues.length;j++) {
			System.out.println((j+1)+" : "+ actualFeaturedCampaignTitles[j]);
	    	ExtentTestFactory.getInstance().getExtentTest().info((j+1)+" : "+ actualFeaturedCampaignTitles[j]);
	    }
        
    	Arrays.sort(filteredActualValues);
		Arrays.sort(filteredExpectedValues);
		boolean areArraysEqual = Arrays.equals(filteredActualValues, filteredExpectedValues);
		Assert.assertTrue(areArraysEqual, "The actual FEATURED campaign values do not match the expected values!");
        System.out.println("\n===================================FEATURED CAMPAIGNS ARE MATCHING===================================\n");
		
	}
	
	
	//----------------------------------------------  Validate LIVE Campaigns In Campaigns Listing Page  ----------------------------------------------
	
	public void validateLiveCampaigns(String environment) throws InterruptedException {
//		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//button[@class='mantine-focus-auto mantine-active theme_actionIcon__7Jpg1 storyIntoModal_closeIcon__2_WfM m_8d3f4000 mantine-ActionIcon-root m_87cf2631 mantine-UnstyledButton-root']")),"Story Overlay Close");		
//		TimeUnit.SECONDS.sleep(5);
		System.out.println("\n--------------------LIVE CAMPAIGNS TESTING STARTED--------------------\n");
		List<WebElement> actualLiveCampaignsElements = LocalDriverFactory.getInstance().getLocalDriver().findElements(By.xpath("//div[2]//p[text()='GET STARTED']/../../..//p[2]"));
		String[] actualLiveCampaigns = new String[actualLiveCampaignsElements.size()];
		System.out.println("\nFE Live Campaigns List Count = " + actualLiveCampaigns.length);
		
		for (int i = 0; i < actualLiveCampaignsElements.size(); i++) {
		    actualLiveCampaigns[i] = actualLiveCampaignsElements.get(i).getText();
		    
		    String caseInsensitiveXPath = "//div[2]//p[text()='GET STARTED']/../../..//p[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='" + actualLiveCampaigns[i].toLowerCase() + "']";
		    
		    moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath(caseInsensitiveXPath)), "Moved to Campaign : "+ actualLiveCampaigns[i] +"");
		    System.out.println((i+1) +" : " + actualLiveCampaigns[i]); 
		}
		
		String[] expectedLiveCampaigns = allApi.getCampaignsByStatus("LIVE", environment);
		System.out.println("\nTotal count of ACTUAL LIVE Campaigns  = " + actualLiveCampaigns.length);
		System.out.println("Total count of EXPECTED LIVE Campaigns = " + expectedLiveCampaigns.length);
		Assert.assertEquals(actualLiveCampaigns.length,expectedLiveCampaigns.length ,"Total count of Actual and Expected LIVE campaigns are not matching");
		Arrays.sort(actualLiveCampaigns);
		Arrays.sort(expectedLiveCampaigns);
		
		boolean areArraysEqual = actualLiveCampaigns.length == expectedLiveCampaigns.length;


		// order of API and FE matching
//		if (areArraysEqual) {
//		    for (int i = 0; i < actualEndedCampaigns.length; i++) {
//		        if (!actualEndedCampaigns[i].equalsIgnoreCase(expectedEndedCampaigns[i])) {
//		            areArraysEqual = false;
//		            break;
//		        }
//		    }
//		}
		
		// If order of API and FE NOT matching
		if (areArraysEqual) {
			boolean isItemMatched = false;

			for (int i = 0; i < actualLiveCampaigns.length; i++) {
			    isItemMatched = false; // Reset for each item in actualEndedCampaigns
			    
			    for (int j = 0; j < expectedLiveCampaigns.length; j++) {
			        if (actualLiveCampaigns[i].equalsIgnoreCase(expectedLiveCampaigns[j])) {
			            isItemMatched = true;  // Match found, break inner loop
			            break;
			        }
			    }
			    
			    if (!isItemMatched) {
			        System.out.println("Item " + actualLiveCampaigns[i] + " does not have a match in expectedEndedCampaigns.");
			        break;  // Exit loop if a mismatch is found, you can remove this if you want to continue checking all items
			    }
			} 
		}

		System.out.println("Are actual and expected live campaigns equal (ignoring case)? " + areArraysEqual);
		Assert.assertTrue(areArraysEqual, "The actual LIVE campaigns do not match the expected values!");
		System.out.println("\n===================================LIVE CAMPAIGNS ARE MATCHING===================================\n");
	}

	
	//----------------------------------------------  Validate ENDED Campaigns In Campaigns Listing Page  ----------------------------------------------
	
	public void validateEndedCampaigns(String environment) throws InterruptedException {
//		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//button[@class='mantine-focus-auto mantine-active theme_actionIcon__7Jpg1 storyIntoModal_closeIcon__2_WfM m_8d3f4000 mantine-ActionIcon-root m_87cf2631 mantine-UnstyledButton-root']")),"Story Overlay Close");		
		System.out.println("\n--------------------ENDED CAMPAIGNS TESTING STARTED--------------------\n");
		List<WebElement> actualEndedCampaignsElements = LocalDriverFactory.getInstance().getLocalDriver().findElements(By.xpath("//div[2]//p[text()='ENDED']/../../..//div/p[2]"));
		String[] actualEndedCampaigns = new String[actualEndedCampaignsElements.size()];

		System.out.println("\nFE Ended Campaigns List Count = " + actualEndedCampaigns.length);
		
		for (int i = 0; i < actualEndedCampaignsElements.size(); i++) {
			actualEndedCampaigns[i] = actualEndedCampaignsElements.get(i).getText();
		    
		    String caseInsensitiveXPath = "//div[2]//p[text()='ENDED']/../../..//div/p[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='" + actualEndedCampaigns[i].toLowerCase() + "']";
		    
		    moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath(caseInsensitiveXPath)), "Moved to Campaign : "+ actualEndedCampaigns[i] +"");
		    System.out.println((i+1) +" : " + actualEndedCampaigns[i]); 
		}
		
		String[] expectedEndedCampaigns = allApi.getCampaignsByStatus("ENDED", environment);
		System.out.println("\nTotal count of ACTUAL ENDED Campaigns  = " + actualEndedCampaigns.length);
		System.out.println("Total count of EXPECTED ENDED Campaigns = " + expectedEndedCampaigns.length);
		Assert.assertEquals(actualEndedCampaigns.length,expectedEndedCampaigns.length ,"Total count of Actual and Expected ENDED campaigns are not matching");
		Arrays.sort(actualEndedCampaigns);
		Arrays.sort(expectedEndedCampaigns);
		
		boolean areArraysEqual = actualEndedCampaigns.length == expectedEndedCampaigns.length;

		
		// order of API and FE matching
//		if (areArraysEqual) {
//		    for (int i = 0; i < actualEndedCampaigns.length; i++) {
//		        if (!actualEndedCampaigns[i].equalsIgnoreCase(expectedEndedCampaigns[i])) {
//		            areArraysEqual = false;
//		            break;
//		        }
//		    }
//		}
		
		// If order of API and FE NOT matching
		if (areArraysEqual) {
			boolean isItemMatched = false;

			for (int i = 0; i < actualEndedCampaigns.length; i++) {
			    isItemMatched = false; // Reset for each item in actualEndedCampaigns
			    
			    for (int j = 0; j < expectedEndedCampaigns.length; j++) {
			        if (actualEndedCampaigns[i].equalsIgnoreCase(expectedEndedCampaigns[j])) {
			            isItemMatched = true;  // Match found, break inner loop
			            break;
			        }
			    }
			    
			    if (!isItemMatched) {
			        System.out.println("Item " + actualEndedCampaigns[i] + " does not have a match in expectedEndedCampaigns.");
			        break;  // Exit loop if a mismatch is found, you can remove this if you want to continue checking all items
			    }
			} 
		}
		

		System.out.println("Are actual and expected ended campaigns equal (ignoring case)? " + areArraysEqual);
		Assert.assertTrue(areArraysEqual, "The actual ENDED campaigns do not match the expected values!");
		System.out.println("\n===================================ENDED CAMPAIGNS ARE MATCHING===================================\n");
	}
	
	
	//----------------------------------------------  Validate Upcoming Campaigns In Campaigns Listing Page  ----------------------------------------------
	
	
	public void validateUpcomingCampaigns(String environment) throws InterruptedException {
//		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//button[@class='mantine-focus-auto mantine-active theme_actionIcon__7Jpg1 storyIntoModal_closeIcon__2_WfM m_8d3f4000 mantine-ActionIcon-root m_87cf2631 mantine-UnstyledButton-root']")),"Story Overlay Close");		
//		TimeUnit.SECONDS.sleep(5);
		System.out.println("\n--------------------UPCOMING CAMPAIGNS TESTING STARTED--------------------\n");
		List<WebElement> actualUpcomingCampaignsElements = LocalDriverFactory.getInstance().getLocalDriver().findElements(By.xpath("//div[2]/p[text()='COMING SOON']/../../../div/div/p[2]"));
		String[] actualUpcomingCampaigns = new String[actualUpcomingCampaignsElements.size()];
		
		System.out.println("\nFE Upcoming Campaigns List Count = " + actualUpcomingCampaigns.length);
		
		for (int i = 0; i < actualUpcomingCampaignsElements.size(); i++) {
			actualUpcomingCampaigns[i] = actualUpcomingCampaignsElements.get(i).getText();
		    
		    String caseInsensitiveXPath = "//div[2]//p[text()='COMING SOON']/../../../div/div/p[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='" + actualUpcomingCampaigns[i].toLowerCase() + "']";
		    
		    moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath(caseInsensitiveXPath)), "Moved to Campaign : "+ actualUpcomingCampaigns[i] +"");
		    System.out.println((i+1) +" : " + actualUpcomingCampaigns[i]); 
		}
		
		String[] expectedUpcomingCampaigns = allApi.getCampaignsByStatus("PUBLISHED", environment);
		System.out.println("\nTotal count of ACTUAL UPCOMING Campaigns  = " + actualUpcomingCampaigns.length);
		System.out.println("Total count of EXPECTED UPCOMING Campaigns = " + expectedUpcomingCampaigns.length);
		Assert.assertEquals(actualUpcomingCampaigns.length,expectedUpcomingCampaigns.length ,"Total count of Actual and Expected UPCOMING campaigns are not matching");
		Arrays.sort(actualUpcomingCampaigns);
		Arrays.sort(expectedUpcomingCampaigns);
		
		boolean areArraysEqual = actualUpcomingCampaigns.length == expectedUpcomingCampaigns.length;


		// order of API and FE matching
//		if (areArraysEqual) {
//		    for (int i = 0; i < actualEndedCampaigns.length; i++) {
//		        if (!actualEndedCampaigns[i].equalsIgnoreCase(expectedEndedCampaigns[i])) {
//		            areArraysEqual = false;
//		            break;
//		        }
//		    }
//		}
		
		// If order of API and FE NOT matching
		if (areArraysEqual) {
			boolean isItemMatched = false;

			for (int i = 0; i < actualUpcomingCampaigns.length; i++) {
			    isItemMatched = false; // Reset for each item in actualEndedCampaigns
			    
			    for (int j = 0; j < expectedUpcomingCampaigns.length; j++) {
			        if (actualUpcomingCampaigns[i].equalsIgnoreCase(expectedUpcomingCampaigns[j])) {
			            isItemMatched = true;  // Match found, break inner loop
			            break;
			        }
			    }
			    
			    if (!isItemMatched) {
			        System.out.println("Item " + actualUpcomingCampaigns[i] + " does not have a match in expectedEndedCampaigns.");
			        break;  // Exit loop if a mismatch is found, you can remove this if you want to continue checking all items
			    }
			} 
		}

		System.out.println("Are actual and expected Upcoming campaigns equal (ignoring case)? " + areArraysEqual);
		Assert.assertTrue(areArraysEqual, "The actual Upcoming campaigns do not match the expected values!");
		System.out.println("\n===================================UPCOMING CAMPAIGNS ARE MATCHING===================================\n");
	}

	
	
	
}