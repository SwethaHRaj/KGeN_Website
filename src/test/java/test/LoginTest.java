package test;

import org.testng.annotations.Test;

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
		
//		store.verifyKStoreHomePageNavigation();
//		store.clickLoginButton();
//		store.verifyLoginWindowNavigation();
//		store.enterPhoneNumber(PropertiesOperations.getProperty("phoneNumber"));
//		store.clickVerifyButton();
//		store.verifyOTPWindowNavigation();
//		store.enterOtp(PropertiesOperations.getProperty("otp"));
//		store.clickSubmitButton();
		
		kgenHome.clickAboutTab();
		kgenHome.verifyAboutPageNavigation();
		kgenHome.clickBuildTab();
		kgenHome.verifyBuildPageNavigation();
		kgenHome.clickConnectTab();
		kgenHome.verifyConnectPageNavigation();
		kgenHome.clickDroparenaTab();
		kgenHome.verifyDropArenaPageNavigation();
		
	}
	
	
	
	
	
}
