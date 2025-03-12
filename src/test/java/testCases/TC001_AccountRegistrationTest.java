package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass

{
   @Test(groups={"Regression","Master"})
	public void verify_account_registration() 
   {
	   logger.info("*****starting TC001__AccountRegistrationTest*****");
	   logger.debug("This is a debug log messgae");
	   
	   try
	   {
	   HomePage hp = new HomePage(driver);
	   hp.clickMyAccount();
	   logger.info("Clicked on MyAccount Link...");
	   
	   hp.clickRegister();
	   logger.info("Clicked on Register Link...");
	    
	   
	   AccountRegistrationPage regpage= new AccountRegistrationPage(driver);
	   
	   logger.info("Providing customer details");
	   regpage.setFirstName(randomeString().toUpperCase());
	   regpage.setLastName(randomeString().toUpperCase());
	   regpage.setEmail(randomeString()+"@gmail.com");   
	   regpage.setTelephone(randomeNumber());
	   
	   
	   String password = randomeAlphaNumeric();
	   
	   regpage.setPassword(password);
	   regpage.setConfirmPassword(password);
	   
	   regpage.setPrivacypolicy();
	   regpage.clickContinue();
	   
	   logger.info("Validating expected message..");
	   String confmsg = regpage.getConfirmationMsg();

	   Assert.assertEquals(confmsg, "Your Account Has Been Created!");	
      }
   
       catch(Exception e) 
	   {
    	   logger.error("Exception occurred: " + e.getMessage());
	       Assert.fail();
	   }
	
	logger.info("*****finished  TC001__AccountRegistrationTest*****");
   } 
}


