package test;

import java.time.Duration;

import org.testng.annotations.Test;

import reusableComponents.AllApi;
import reusableComponents.PropertiesOperations;
import testBase.BaseClass;
import testBase.LocalDriverFactory;


public class AllTests extends BaseClass {
	
//	@Test
		public void navBarNavigationKgenHome() throws InterruptedException {
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
		
//		store.verifyKStoreHomePageNavigation();
//		store.clickLoginButton();
//		store.verifyLoginWindowNavigation();
//		store.enterPhoneNumber(PropertiesOperations.getProperty("phoneNumber"));
//		store.clickVerifyButton();
//		store.verifyOTPWindowNavigation();
//		store.enterOtp(PropertiesOperations.getProperty("otp"));
//		store.clickSubmitButton();
		
		Thread.sleep(Duration.ofSeconds(30));
		kgenHome.clickAboutTab();
		kgenHome.verifyAboutPageNavigation();
		kgenHome.clickBuildTab();
		kgenHome.verifyBuildPageNavigation();
		kgenHome.clickConnectTab();
		kgenHome.verifyConnectPageNavigation();
		kgenHome.clickDroparenaTab();
		kgenHome.verifyDropArenaPageNavigation("stage");	
	}
	
	@Test
	public void verifyFeaturedQuestsSection() throws Exception {
//		allApi.getFeaturedGames();
		kgenGamerHome.verifyFeaturedQuestsSection();
		kgenGamerHome.verifyFeaturedGamesSection();
	}
	
	
	
	
}
