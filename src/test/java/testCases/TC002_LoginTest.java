package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass 

{
   
	@Test(groups={"Sanity","Master"})
	public void verify_login() 
	{
		logger.info("*******starting TC002_loginTest*****");
		
		try
		{
		//homepage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//login
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//myaccountpage
		MyAccountPage myacc= new MyAccountPage(driver);
		boolean targetpage=myacc.isMyAccountPageExists();
		
		//Assert.assertEquals(targetpage, true,"Login Failed");
		Assert.assertTrue(targetpage);
		
		}
		catch(Exception e) 
		{
			Assert.fail();
		}
		
		logger.info("*******finished TC002_loginTest*****");	
		
	}
}
