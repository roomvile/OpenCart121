package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
		
	}

	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btncontinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
   
	
	public void setFirstName(String fname) 
	{
		txtFirstName.sendKeys(fname);
	}
		
	public void setLastName(String lname) 
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email) 
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tel) 
	{
		txtTelephone.sendKeys(tel);
		
	}
	
	public void setPassword(String pwd) 
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd) 
	{
		txtConfirmPassword.sendKeys(pwd);
	}
	
	public void setPrivacypolicy() 
	{
		chkPolicy.click();
	}
	
	public void clickContinue()
	{
	   //sol1
		btncontinue.click();
		
		//sol2
		//btncontinue.submit();
		
		//sol3
		//Actions action = new Actions(driver);
		//action.moveToElement(btncontinue).click().perform();
		
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btncontinue);
		
		//sol5
		//btncontinue.sendKeys(Keys.RETURN);
		
		//sol6
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(btncontinue)).click();
		
	}
	
	public String getConfirmationMsg() 
	{
	try {
		//WebElement msgConfirmation = null;
		return (msgConfirmation.getText());
	}	catch(Exception e) {
		  return(e.getMessage());
	}
	}	
	
}
