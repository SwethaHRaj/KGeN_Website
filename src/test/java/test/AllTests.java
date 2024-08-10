package test;

import java.time.Duration;

import org.testng.annotations.Test;

import reusableComponents.AllApi;
import reusableComponents.PropertiesOperations;
import testBase.BaseClass;
import testBase.LocalDriverFactory;


public class AllTests extends BaseClass {
	
	//set property for kgen home page
	
	@Test
		public void navBarNavigationKgenHome() throws InterruptedException {
		
//		store.verifyKStoreHomePageNavigation();
//		store.clickLoginButton();
//		store.verifyLoginWindowNavigation();
//		store.enterPhoneNumber(PropertiesOperations.getProperty("phoneNumber"));
//		store.clickVerifyButton();
//		store.verifyOTPWindowNavigation();
//		store.enterOtp(PropertiesOperations.getProperty("otp"));
//		store.clickSubmitButton();
		
//		Thread.sleep(Duration.ofSeconds(30));
		kgenHome.verifyNavBarTabURLs(null);	
	}
	
		
	//set property for gamer home page	
		
//	@Test
	public void verifyGamerHomePage() throws Exception {
//		allApi.getTrendingNowGames();
		kgenGamerHome.verifyFeaturedQuestsSection();
		kgenGamerHome.verifyFeaturedGamesSection();
		kgenGamerHome.verifyTrendingGamesSection();
	}
	
	//set property for gamer quests page
	
//	@Test(invocationCount = 3, threadPoolSize = 3)
//	@Test
	public void verifyGamerQuestsPage() throws Exception {
//		kgenGamerQuests.verifyAllQuests();
//		kgenGamerQuestsListingPage.verifyLiveQuests();
//		kgenGamerQuestsListingPage.verifyUpcomingQuests();
//		kgenGamerQuestsListingPage.verifyEndedQuests();
		kgenGamerQuestsListingPage.clickQuestCard();
		kgenGamerQuestDetailsPage.submitProof();
	}
	
	
	
}
