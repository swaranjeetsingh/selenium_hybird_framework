package com.inetbanking.test_cases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.page_objects.LoginPage;
import com.inetbanking.utils.ExcelUtility;

public class TestCase_002_LoginTest_DD extends TestHelper {
	
	@Test(dataProvider = "login_data")
	public void login_DD_Test(String username, String password) throws InterruptedException {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(username, password);
		
		if (isAlertPresent() == true) {
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.warn("login failed");
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
			logger.info("login passed");
			Thread.sleep(3000);
			loginPage.logout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	@DataProvider(name = "login_data")
	 String [][] getTestData() throws IOException {
		String filePath = "/Users/dhaliwal_mac/Documents/Eclipse_Workspace/Selenium_Hybird_FW/resources/Workbook1.xlsx";
		String sheetName = "Sheet1";
		return ExcelUtility.excel(filePath, sheetName);
	}
}
