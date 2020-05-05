package com.inetbanking.test_cases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;

import com.inetbanking.utils.BrowserFactory;
import com.inetbanking.utils.ReadConfig;

public class TestHelper {
	public static Logger logger;
	public static WebDriver driver;
	
	ReadConfig readConfig = new ReadConfig();
	BrowserFactory browserFactoryObj =  new BrowserFactory();
	
	String username = readConfig.getUserName();
	String password = readConfig.getPassword();
	String url = readConfig.getUrl();

  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @Parameters("browserName")
  @BeforeClass
  public void beforeClass(String browser) {
//	 setting logger object of log4j
	 logger = Logger.getLogger("inetbanking");
	 PropertyConfigurator.configure("log4j.properties");
	 
	 logger.info("Test run using " + browser + " browser");
	 TestHelper.driver = browserFactoryObj.getBrowser(browser);
	 driver.manage().deleteAllCookies();
	 driver.manage().window().maximize();
	 driver.get(url);
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
