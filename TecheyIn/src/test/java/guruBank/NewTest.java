package guruBank;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.utils.FileUtil;

import excelFiles.ExcelData;
import extentReports.ExtentManager;
import pageObject.Login_PF;

public class NewTest  {
	
	 ExtentReports report;
	 ExtentTest logger;
	 WebDriver driver;
	 String U1;
	 
	 Login_PF loginpage;
	
	@Test(priority=1)				
	public void Website_Page() {	
		
		//Check Web-site Title
		driver.get("http://demo.guru99.com/v4/");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Guru99 Bank Home Page")); 	
		System.out.println("The System has Successfully checked the Bank Page");
		
		//Taking Screenshots
		File Src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			 // now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(Src, new File("C:\\Users\\praveen kumar J\\Documents\\ScreenShots\\ScreenShot01.png"));
			}
			 
			catch (IOException e)
			 {
			  System.out.println(e.getMessage());
			 
			 }
		
		
		//TestReport Creation_01
		logger=report.createTest("Guru99 Bank Website", "Check for Title of the page");
	    //Logs Test Results 
		logger.pass("Guru 99 WebTitle Test Passed Successfully");
	}	  
	
	@Test(priority=2)
	public void Login() throws IOException{
	    // String U1=ExcelData.Username();
		 //System.out.println("The Website is up Username : "+U1);
		//User Login Credentials 
	/*	 driver.findElement(By.name("uid")).sendKeys(ExcelData.User);
		 driver.findElement(By.name("password")).sendKeys(ExcelData.Password);
		 driver.findElement(By.name("btnLogin")).click();*/
		
		//POM with PageFactory Desgin pattern
		
		loginpage.Text_user_name(ExcelData.User);
		loginpage.Text_password_name(ExcelData.Password);
		loginpage.Login_Button();
		
		
		//Site Title verfication
		 String Page_title="Guru99 Bank Manager HomePage";
		 Assert.assertEquals(driver.getTitle(), Page_title);
		 System.out.println("The System has Successfully LoggedIn");
		 
		//TestReport Creation_02
		logger=report.createTest("Website Logging Check","Website loggin with user credentials");	
		logger.log(Status.INFO, "Check for User Logging Function");
		//logger.fail("Failed Method Verification");
		
		File Src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			 // now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(Src, new File("C:\\Users\\praveen kumar J\\Documents\\ScreenShots\\ScreenShot03.png"));
			}
			 
			catch (IOException e)
			 {
			  System.out.println(e.getMessage());
			 
			 }
	}
	
	@BeforeTest
	public void beforeTest() {	
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\praveen kumar J\\Documents\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();  
		report=ExtentManager.GetExtent();	
		try {
			U1=ExcelData.Username();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Create a object for that class in POM pagefactory
		loginpage=new Login_PF(driver);
		
	}	
	
	@AfterTest
	public void afterTest() {
		report.flush();
		driver.quit();
	}		
}
