package Demo;

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

public class NewTest {
	
	public static ExtentReports report;
	public static ExtentTest logger;
	public WebDriver driver;
	
	@Test(priority=0)				
	public void testEasy() {	
		
		driver.get("http://demo.guru99.com/test/guru99home/");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Demo Guru99 Page")); 	
		System.out.println("The System has Successfully checked the Bank Page");
		logger=report.createTest("WebSite Guru99 Page", "Check for Title of the page");
		logger.pass("Test Passed Successfully");
	}	  
	
	@Test(priority=1)
	public void TestPrint() {
		System.out.println("The System has Successfully Finsihed First Jenkins Integration Project");
		logger.log(Status.FAIL, "Checking Fail Method");
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
