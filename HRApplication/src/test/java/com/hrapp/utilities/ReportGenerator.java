package com.hrapp.utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.hrapp.datareader.ConfigPropertyReader;

public class ReportGenerator {
	public static ExtentReports report ;
	public static ConfigPropertyReader _config= new ConfigPropertyReader();



	public static ExtentReports initializeExtentReports()
	{	
	if(report == null){
		report=new ExtentReports(_config.getReportPath());
	}	
		return report ;
	}
}
