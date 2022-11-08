package com.hrapp.datareader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigPropertyReader {
	Properties pro;
	
	public ConfigPropertyReader() {
		try {
			File src = new File("./Configuration/config.property");
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
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
}
