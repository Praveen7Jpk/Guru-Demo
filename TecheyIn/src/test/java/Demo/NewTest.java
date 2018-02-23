package Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	
	public WebDriver driver;
	
	@Test(priority=0)				
	public void testEasy() {	
		driver.get("http://demo.guru99.com/test/guru99home/");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Demo Guru99 Page")); 	
		System.out.println("The System has Successfully checked the Bank Page");
	}	
	
	@Test(priority=1)
	public void TestPrint() {
		System.out.println("The System has Successfully checked the Bank Page");
	}
	@BeforeTest
	public void beforeTest() {	
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\praveen kumar J\\Documents\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();  
	}		
	@AfterTest
	public void afterTest() {
		driver.quit();			
	}		
}
