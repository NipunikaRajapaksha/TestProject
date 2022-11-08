package com.hrapp.testsuite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrapp.pages.AttendencePage;
import com.hrapp.pages.HomePage;
import com.hrapp.pages.LoginPage;
import com.hrapp.pages.ProfilePage;
import com.hrapp.utilities.BaseClass;

public class AttendanceReport extends BaseClass {
	LoginPage loginpage;
	HomePage homepage;
	ProfilePage profilelist;
	AttendencePage attendancereport;
	
	public AttendanceReport() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		profilelist = new ProfilePage();
		attendancereport = new AttendencePage();
		
	}
	
	@Test
	public void loginToApp() throws InterruptedException {
		loginpage.ValidateLoginPage();
		loginpage.EnterLoginCredentials();
		homepage.validateHomePage();
		attendancereport.generateAttendenceReport();
		
	}
	
	@AfterMethod
	public void finalstep() {
		driver.quit();
	}
}
