package com.hrapp.testsuite;

import com.hrapp.pages.HomePage;
import com.hrapp.pages.LoginPage;
import com.hrapp.utilities.BaseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.hrapp.utilities.ReportGenerator;

import org.testng.annotations.*;

public class ValidLogin extends BaseClass {
	
	ExtentTest logger;	
	ExtentReports report = ReportGenerator.initializeExtentReports() ;		
	ExtentTest login_process;
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
		login_process = report.startTest("Valid Login");
		logger = report.startTest("Verify authorized users can login successfully ");
		logger.log(LogStatus.INFO,  "Started test case");
		loginpage.ValidateLoginPage();
		loginpage.EnterLoginCredentials();
		homepage.validateHomePage();
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
