package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"regression","master"})
	public void verify_account_registration(){
		
		try {
			logger.debug("application started");
		
		logger.info("starting test");
		
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount(); //events log to file
		logger.info("clicked on My Account link");
		hp.clickRegister();
		logger.info("clicked on Registration Link");
		
		logger.info("Entering customer details");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		//regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		//regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("clicked on continue");
		String confmsg=regpage.getConfirmationMsg();
		logger .info("validating expected message");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			logger.error("test failed...");
			Assert.fail();
			
		}
		logger.info("***finished TC_001_AccountRegistrationTest");
		
		
		
	}
	
	
	
	
}
