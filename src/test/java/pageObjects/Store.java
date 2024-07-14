package pageObjects;

import org.openqa.selenium.By;

import testBase.LocalDriverFactory;
import testBase.BaseClass;

public class Store extends BaseClass{
	
	By logo_icon= By.xpath("//a[@title='Logo']//img[@alt='Logo']");
	By login_btn= By.xpath("//button[@class='login']");	
	By phoneNumber_txt= By.tagName("input");
	By verify_btn= By.tagName("button");
	By otp_txt=By.xpath("//input[@id='otp_0_233w072grh8lyf6qh9a']");
	By submit_btn=By.xpath("//button[normalize-space()='SUBMIT']");
	
	
	
	public void verifyKStoreHomePageNavigation() {
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(logo_icon), "KStore Home Page");
	}
	
	public void clickLoginButton() {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(login_btn), "Login button");
	}
	
	public void verifyLoginWindowNavigation() {
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(phoneNumber_txt), "Login Window");
	}
	
	public void enterPhoneNumber(String phoneNumber) throws InterruptedException {
//		LocalDriverFactory.getInstance().getLocalDriver().wait(5000);
//		LocalDriverFactory.getInstance().getLocalDriver().navigate().refresh();
		sendKeys_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(phoneNumber_txt), "Phone Number Field" , phoneNumber);
	}

	public void clickVerifyButton() {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(verify_btn), "Verify button");
	}
	
	public void verifyOTPWindowNavigation() {
		verify_PageNavigation(LocalDriverFactory.getInstance().getLocalDriver().findElement(otp_txt), "KStore Home Page");
	}
	
	public void enterOtp(String otp) {
		sendKeys_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(otp_txt), "OTP Digit Field" , otp);
	}
	
	public void clickSubmitButton() {
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(submit_btn), "Submit Button");
	}

}
