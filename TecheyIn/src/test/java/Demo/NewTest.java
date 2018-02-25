package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import extreports.ExtentManager;

public class NewTest  {
	
	public ExtentReports report;
	public ExtentTest logger;
	public WebDriver driver;
	
	@Test(priority=1)				
	public void Website_Page() {	
		
		//Check Web-site Title
		driver.get("http://demo.guru99.com/v4/");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Guru99 Bank Home Page")); 	
		System.out.println("The System has Successfully checked the Bank Page");
		
		//TestReport Creation_01
		logger=report.createTest("Guru99 Bank Website", "Check for Title of the page");
	    //Logs Test Results 
		logger.pass("Guru 99 WebTitle Test Passed Successfully");
	}	  
	
	@Test(priority=2)
	public void Login() throws InterruptedException {
	
		//User Login Credentials 
		 driver.findElement(By.name("uid")).sendKeys("mngr120253");
		 driver.findElement(By.name("password")).sendKeys("numAmAt");
		 driver.findElement(By.name("btnLogin")).click();
		 String Page_title="Guru99 Bank Manager HomePage";
		 Assert.assertEquals(driver.getTitle(), Page_title);
		 System.out.println("The System has Successfully LoggedIn");
		 
		//TestReport Creation_02
		logger=report.createTest("Website Logging Check","Website loggin with user credentials");	
		logger.log(Status.INFO, "Check for User Logging Function");
		//logger.fail("Failed Method Verification");
		
	}
	
	@BeforeTest
	public void beforeTest() {	
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\praveen kumar J\\Documents\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();  
		report=ExtentManager.GetExtent();	
	}	
	
	@AfterTest
	public void afterTest() {
		report.flush();
		driver.quit();
	}		
}
