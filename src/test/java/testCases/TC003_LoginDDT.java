package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass
{
   @Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="datadriven")
   public void verify_LoginDDT(String email,String pwd,String exp) 
   {
	   logger.info("*****starting TC003_loginDDT*****");
		
	   try 
	   {
		//homepage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//login
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();   
		
		//MyAccountpage
		MyAccountPage myacc= new MyAccountPage(driver);
		boolean targetpage=myacc.isMyAccountPageExists();
		
		/*Data is valid- login success--test pass--logout
		 *               login fail--test fail
		 *               
		 *Data is invalid- login success--test fail--logout
		 *                 login failed--test pass                
		 * 
		 */
		
		if(exp.equalsIgnoreCase("valid")) 
		{
			if(targetpage==true)
			{
				myacc.clickLogout();
			    Assert.assertTrue(true);		
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetpage==true)
			{
				myacc.clickLogout();
			    Assert.assertTrue(false);		
			}
			else
			{
				Assert.assertTrue(true);
			}
		   }
	   }
		catch(Exception e) 
	    {
			logger.error("Exception occurred: " + e.getMessage());
			Assert.fail();
		}  
	   
		logger.info("*******finished TC003_loginDDT*****");
   
		}
   }


