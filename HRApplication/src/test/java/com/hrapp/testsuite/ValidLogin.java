package com.hrapp.testsuite;

import com.hrapp.pages.HomePage;
import com.hrapp.pages.LoginPage;
import com.hrapp.utilities.BaseClass;
import org.testng.annotations.*;

public class ValidLogin extends BaseClass {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public ValidLogin() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
	}
	
	@Test
	public void loginToApp() throws InterruptedException {
		loginpage.ValidateLoginPage();
		loginpage.EnterLoginCredentials();
		homepage.validateHomePage();
		
	}
	
	@AfterMethod
	public void finalstep() {
		driver.quit();
	}
	

}
