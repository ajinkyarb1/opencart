package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups= {"sanity","master"})
	public void verify_login() {
		
		try {
		logger.info("***Starting TC_002_LoginTest***");
		logger.debug("capturing debug logs....");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on myaccount link");
		hp.clickLogin();
		logger.info("clicked on login link under myaccount...");
		
		//Login Page
		LoginPage lp = new LoginPage(driver);
		logger.info("clicked on login button");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();//login button
		
		//My Account Page
		MyAccountPage macc= new MyAccountPage(driver);
		
		boolean targetPage= macc.isMyAccountPageExists();
		if(targetPage==true) {
			Assert.assertTrue(true);
		}else {
			logger.error("Login test failed");
		}
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("***Finished TC002 LOGIN TEST***");
		
		
		
	}
	

}
