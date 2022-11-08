package com.hrapp.testsuite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrapp.pages.AttendencePage;
import com.hrapp.pages.HomePage;
import com.hrapp.pages.LoginPage;
import com.hrapp.pages.ProfilePage;
import com.hrapp.utilities.BaseClass;
import com.hrapp.utilities.ReportGenerator;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AttendanceReport extends BaseClass {
	LoginPage loginpage;
	HomePage homepage;
	ProfilePage profilelist;
	AttendencePage attendancereport;
	ExtentTest logger;	
	ExtentReports report = ReportGenerator.initializeExtentReports() ;		
	ExtentTest login_process;
	
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
		login_process = report.startTest("Attendance report generator");
		logger = report.startTest("Verify can able to get the attendence report");
		logger.log(LogStatus.INFO,  "Started test case");
		loginpage.ValidateLoginPage();
		loginpage.EnterLoginCredentials();
		homepage.validateHomePage();
		attendancereport.generateAttendenceReport();
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
