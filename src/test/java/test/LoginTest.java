package test;

import org.testng.annotations.Test;

import pageObjects.KgenHome;
import reusableComponents.AllApi;
import reusableComponents.PropertiesOperations;
import testBase.BaseClass;
import testBase.LocalDriverFactory;

@Test
public class LoginTest extends BaseClass {
	
	public void loginTest() throws Exception {
//		home.verifyHomePageNavigation();
//		navBar.clickLoginButton();
//		login.verifyLoginPageNavigation();
//		login.enterPhoneNumber(PropertiesOperations.getProperty("phoneNumber"));
//		login.clickVerifyButton();
//		
//		login.enterOtp(PropertiesOperations.getProperty("otp"));
//		login.clickSubmitButton();
//		navBar.verifyLogin();
//		navBar.clickQuestsTab();
//		navBar.verifyQuestsPageNavigation();
//		quests.clickLiveFilter();
//		allApi.getFeaturedQuests();
//		home.verifyFeaturedQuestsSection();
		
	}
		
	//set property for kgen home page
	
//	@Test(invocationCount = 3, threadPoolSize = 3)
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
		kgenHome.verifyNavBarTabURLs("stage");
	}
	

//	@Test(invocationCount = 3, threadPoolSize = 3)
//	@Test
	public void verifyGamerQuestsPage() throws Exception {
//		kgenGamerQuests.verifyAllQuests();
//		kgenGamerQuestsListingPage.verifyLiveQuests();
//		kgenGamerQuestsListingPage.verifyUpcomingQuests();
//		kgenGamerQuestsListingPage.verifyEndedQuests();
//		kgenGamerQuestsListingPage.clickQuestCard();
//		kgenGamerQuestDetailsPage.submitProof();
	}

	
	
	
}
