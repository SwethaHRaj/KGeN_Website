package test;

import org.testng.annotations.Test;

import reusableComponents.AllApi;
import reusableComponents.PropertiesOperations;
import testBase.BaseClass;

@Test
public class LoginTest extends BaseClass {
	
	public void loginTest() throws Exception {
		home.verifyHomePageNavigation();
		navBar.clickLoginButton();
		login.verifyLoginPageNavigation();
		login.enterPhoneNumber(PropertiesOperations.getProperty("phoneNumber"));
		login.clickVerifyButton();
		login.enterOtp(PropertiesOperations.getProperty("otp"));
		login.clickSubmitButton();
		navBar.verifyLogin();
		navBar.clickQuestsTab();
		navBar.verifyQuestsPageNavigation();
		quests.clickLiveFilter();
		allApi.getLiveQuests();
		home.verifyFeaturedQuestsSection();
	}
}
