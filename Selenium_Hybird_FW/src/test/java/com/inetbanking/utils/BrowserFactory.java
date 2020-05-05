package com.inetbanking.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	public BrowserFactory() {
		// TODO Auto-generated constructor stub
	}
	
	WebDriver driver;
	public WebDriver getBrowser(String bName) {
		if (bName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/dhaliwal_mac/Documents/Eclipse_Workspace/Selenium_Hybird_FW/resources/chromedriver");
			driver = new ChromeDriver();
		}
		else if (bName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/dhaliwal_mac/Documents/Eclipse_Workspace/Selenium_Hybird_FW/resources/geckodriver");
			driver = new FirefoxDriver();
		}
		return driver;
	}

}
