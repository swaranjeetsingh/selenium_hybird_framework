package com.inetbanking.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties properties;
	public ReadConfig() {
		try {
			FileInputStream fileInputStream = new FileInputStream(new File("/Users/dhaliwal_mac/Documents/Eclipse_Workspace/Selenium_Hybird_FW/congifuration/config.properties"));
			properties = new Properties();
			properties.load(fileInputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Exception is: " + e.getMessage());
		}
	}
	public String getUrl() {
		return (String) properties.getProperty("applicationURL");
	}
	public String getUserName() {
		return (String) properties.getProperty("username");
	}
	public String getPassword() {
		return (String) properties.getProperty("password");
	}
}
