package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login_PF {

	WebDriver driver;
	
	//Constructor for driver,As every page requires  base driver
	public Login_PF (WebDriver driver) {
		//"this" keyword is the instance of class(Login_PF)
		this.driver=driver;
		
		//This initElement will create all web elements 
		PageFactory.initElements(driver, this);
	}
	
	//Locators 
	@FindBy(how=How.NAME,using ="uid")  // You Can use this too as @FindBy(name=uid)
    WebElement  usernameGB;
	
	@FindBy(how=How.NAME,using ="password")
	WebElement passwordGB;
	
	@FindBy(name="btnLogin")
	WebElement loginBtnGB;
	
	//Methods
	public void Text_user_name(String urs) {
		usernameGB.sendKeys(urs);
	}
	
	public void Text_password_name(String pwd) {
		passwordGB.sendKeys(pwd);
	}
	
	public void Login_Button() {
		loginBtnGB.click();
	}
	
}
