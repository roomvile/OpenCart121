package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger; //log4j

public class BaseClass 
{
	  public WebDriver driver;
	  public Logger logger; //log4j
	  public Properties p;
	  
	  @BeforeClass(groups= {"Sanity","Regression","Master"}) 
	  @Parameters({"os","browser"})
	   public void setup(String os,String br) throws IOException 
	     {
		  
		  //loading cofig.properties file
		  FileReader file = new FileReader("./src//test//resources//config.properties");
		  p=new Properties();
		  p.load(file);
		  
		  
		   logger = LogManager.getLogger(this.getClass()); //log4j
		   
		   
		   if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		   {
			   DesiredCapabilities capabilities = new DesiredCapabilities();
			   
			  //os
			   
			   if(os.equalsIgnoreCase("windows")) 
			   {
				   capabilities.setPlatform(Platform.WIN11);
			   }
			   else if(os.equalsIgnoreCase("mac"))
			   {
				   capabilities.setPlatform(Platform.MAC);
			   }
			   else 
			   {
				 System.out.println("No matching os");
				 return;
			   }
			   
			   //browser
			   switch(br.toLowerCase()) 
			   {
			   case "chrome":capabilities.setBrowserName("chrome");break;
			   case "edge":capabilities.setBrowserName("MicrosoftEdge");break;
			   default: System.out.println("No matching browser");return; 
			   }
			   
			   driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);   
			   
		       }
		    
		   
		   if(p.getProperty("execution_env").equalsIgnoreCase("local"))
			   
		   {
			   
		   switch(br.toLowerCase())
		   {
		   case "chrome" : driver = new ChromeDriver(); break;
		   case "edge" : driver = new EdgeDriver(); break;
		   case "firefox" : driver = new FirefoxDriver(); break;
		   default: System.out.println("invalid browser name..."); return;
		   } 
		   }
		   
		    driver.manage().deleteAllCookies();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		    //driver.get("http://localhost/opencart/upload/index.php");
		    driver.get(p.getProperty("appURL2")); //reading the values from file   
		    driver.manage().window().maximize();
	     }
	  
	   @AfterClass(groups= {"Sanity","Regression","Master"}) 
	   public void tearDown() 
	   {
		   driver.quit();   
	   }
	   
	   public String randomeString() 
       {
    	   String generatedString=RandomStringUtils.randomAlphabetic(5);
    	   return generatedString;
       } 
       
       public String randomeNumber() 
       {
    	   String generatedNumber=RandomStringUtils.randomNumeric(10);
    	   return generatedNumber;
       }
 
       public String randomeAlphaNumeric() 
       {
    	   String generatedstring=RandomStringUtils.randomAlphabetic(3);
    	   String generatedNumber=RandomStringUtils.randomNumeric(3);
    	   return (generatedstring+"@"+generatedNumber);
       }
 
	  
}
