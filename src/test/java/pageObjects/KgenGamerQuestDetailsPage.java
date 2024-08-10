package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import reusableComponents.AllApi;
import testBase.BaseClass;
import testBase.ExtentTestFactory;
import testBase.LocalDriverFactory;

public class KgenGamerQuestDetailsPage  extends BaseClass {
	
	By questState = By.xpath("//span[normalize-space()='LIVE']");
	By questHeaderText = By.xpath("//span[@class='styles_title__r5Moj']");
	By startQuestButton = By.xpath("//button[@text=\"Start Quest\"]");
	By inProgressButton = By.xpath("//button[@text=\"In Progress\"]");
	By shareIcon = By.xpath("//div[@class='styles_buttonContainer__0q7y_']//div//div[1]//*[name()='svg']");
	By stagesBlockText = By.xpath("//span[normalize-space()='STAGES']");
	By stagesBlockUserProgressAndTotalStagesCount = By.xpath("//span[normalize-space()='0 / 2']");
	
	
	//div[@class='accordion_accordion__TnN3q']//div[    2    ]//div[3]//button[1] ---submit cta
//	By stageSubmitButton = By.xpath("span[normalize-space()='login method']/../../../../../div[2]/div[3]/button");
//	By  = By.xpath("");
//	By  = By.xpath("");
//	By  = By.xpath("");
//	By  = By.xpath("");
//	By  = By.xpath("");
//	By  = By.xpath("");
	
	public void submitProof() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(LocalDriverFactory.getInstance().getLocalDriver() ,Duration.ofSeconds(2000));
	
		ExtentTestFactory.getInstance().getExtentTest().info("------------------Quest Proof Submission Started------------------");
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(startQuestButton), "Quest Start Button");
		sendKeys_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//input/../../div[3]/input")), "Phone Number Field","9876543210");
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//span[contains(text(),'Login')]")), "Login Button");
		sendKeys_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//input/../../../div[2]/div/input")), "OTP Field","111111");
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//span[@class='m_80f1301b mantine-Button-inner']")), "OTP Verify Button");
		wait.until(ExpectedConditions.visibilityOf(LocalDriverFactory.getInstance().getLocalDriver().findElement(inProgressButton)));
//		wait.until(ExpectedConditions.visibilityOf(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//button[@class='button_buttonBody__CW6b6 button_variant-primary__XZGfJ kcash-bonus-Modal_contentAmountInnerClaimDiv__HUArD']"))));
		if(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//button[@class='button_buttonBody__CW6b6 button_variant-primary__XZGfJ kcash-bonus-Modal_contentAmountInnerClaimDiv__HUArD']")).isDisplayed()==true) {
			click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//img[@alt='close-icon']")),"Loyalty Bonus Popup Close Icon");
			//span[@class='kcash-bonus-Modal_contentAmountInnerClaimDivText__Xdv5F']   ------> Claim cta
			wait.until(ExpectedConditions.visibilityOf(LocalDriverFactory.getInstance().getLocalDriver().findElement(inProgressButton)));
			moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//div[@class='accordion_accordion__TnN3q']//div[2]//div[3]//button[1]")), "Stage-1 Submit Button");
			click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//div[@class='accordion_accordion__TnN3q']//div[2]//div[3]//button[1]")), "Stage-1 Submit Button");
			moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//span[@class='linksModal_title__lAx5_']")), "Proof Submission Modal");
			String proofType = getText_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//div[@class='infoBox_infoBox__Jgnq7 linksModal_infoBox__9SkKw']/span[2]")),"Proof Type");
			
			if(proofType.equals("Twitter link")) {
				sendKeys_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.id("inputField_input__lD7jT")), "Quest Proof", "https://x.com/home");
				click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//button[@class='submitButton_submitButton__lvTo3']")), "Proof Submission Modal Submit Button");
			}
		}
		else {
		moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("span[normalize-space()='login method']/../../../../../div[2]/div[3]/button")), "Stage-1 Submit Button");
		click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("span[normalize-space()='login method']/../../../../../div[2]/div[3]/button")), "Stage-1 Submit Button");
		moveToElement_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//span[@class='linksModal_title__lAx5_']")), "Proof Submission Modal");
		String proofType = getText_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//div[@class='infoBox_infoBox__Jgnq7 linksModal_infoBox__9SkKw']")),"Proof Type");
		
		if(proofType.equals("Twitter link")) {
			sendKeys_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.id("inputField_input__lD7jT")), "Quest Proof", "https://x.com/home");
			click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//button[@class='submitButton_submitButton__lvTo3']")), "Proof Submission Modal Submit Button");
		}
		}
		ExtentTestFactory.getInstance().getExtentTest().info("------------------Quest Proof Submission Success------------------");
		
		
		
		
		/**		Thread.sleep(20);
		if(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//button[@class='button_buttonBody__CW6b6 button_variant-primary__XZGfJ kcash-bonus-Modal_contentAmountInnerClaimDiv__HUArD']")).isDisplayed()==false) {	
		else if(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//button[@class='button_buttonBody__CW6b6 button_variant-primary__XZGfJ kcash-bonus-Modal_contentAmountInnerClaimDiv__HUArD']")).isDisplayed()==true) {
			click_Custom(LocalDriverFactory.getInstance().getLocalDriver().findElement(By.xpath("//img[@alt='close-icon']")),"Loyalty Bonus Popup Close Icon");
			//span[@class='kcash-bonus-Modal_contentAmountInnerClaimDivText__Xdv5F']   ------> Claim cta
		}
		else
			Thread.sleep(20); 
		**/
		
}
}
