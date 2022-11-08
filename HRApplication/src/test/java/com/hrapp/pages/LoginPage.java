package com.hrapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hrapp.utilities.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="pwd")
	WebElement password;
	
	@FindBy(xpath="//a[@id=\"loginButton\"]")
	WebElement loginbtn;
	
	@FindBy(xpath="//td[@id=\"headerContainer\"]")
	WebElement validateloginpageheader;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void ValidateLoginPage() {
		String actual = validateloginpageheader.getText();
		String expected = "Please identify yourself";
		Assert.assertEquals(actual, expected);
		
	}
	
	public void EnterLoginCredentials(){
		try {
			username.sendKeys(BaseClass.prop.getProperty("username"));
			password.sendKeys(BaseClass.prop.getProperty("password"));
			loginbtn.click();
			Thread.sleep(2000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
