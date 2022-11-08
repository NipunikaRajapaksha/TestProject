package com.hrapp.testsuite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrapp.pages.HomePage;
import com.hrapp.pages.LoginPage;
import com.hrapp.pages.ProfilePage;
import com.hrapp.utilities.BaseClass;
import com.hrapp.utilities.ReportGenerator;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EmployeeProfile extends BaseClass {
	LoginPage loginpage;
	HomePage homepage;
	ProfilePage profilelist;
	ExtentTest logger;	
	ExtentReports report = ReportGenerator.initializeExtentReports() ;		
	ExtentTest login_process;
	
	public EmployeeProfile() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		profilelist = new ProfilePage();
		
	}
	
	@Test
	public void loginToApp() throws InterruptedException {
		login_process = report.startTest("Employee profile");
		logger = report.startTest("Verify can able to check the employee profiles");
		logger.log(LogStatus.INFO,  "Started test case");
		loginpage.ValidateLoginPage();
		loginpage.EnterLoginCredentials();
		homepage.validateHomePage();
		profilelist.validateEmployeeProfilePage();
		profilelist.validateEmployeeProfileList();
		logger.log(LogStatus.INFO,  "End of the test case");  
	    login_process .appendChild(logger);
		report.endTest(logger);
		report.endTest(login_process);
		report.flush();
		
	}
	
	@AfterMethod
	public void finalstep() {
		driver.quit();
	}
}
