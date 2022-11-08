package com.hrapp.datareader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigPropertyReader {
	Properties pro;
	
	public ConfigPropertyReader() {
		try {
			
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Configuration/config.property");
			pro = new Properties();
			pro.load(ip);
			
		}
		catch(Exception e){
			System.out.println("Exception - " +e.getMessage());
		}
	}
	
	public String getBaseUrl() {
		return pro.getProperty("baseURL");
	}
	
	public String getUserName() {
		return pro.getProperty("username");
	}
	
	public String getPassword() {
		return pro.getProperty("password");
	}
	
	public String getReportPath() {
		return pro.getProperty("reportPath");
	}
}
