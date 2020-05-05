package com.inetbanking.test_cases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.PageFactory;
import com.inetbanking.page_objects.LoginPage;

public class TestCase_001_LoginTest extends TestHelper{

	public TestCase_001_LoginTest() {
	
	}
	
	@Test
	public void loginTest() {
		logger.info("this is login test");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(username, password);
		String resultTitleString = driver.getTitle();
		if (resultTitleString.equals("Guru99 Bank Manager HomePage")) {
			AssertJUnit.assertTrue(true);
			logger.info("Login test passed");
		}
		else {
			AssertJUnit.assertTrue(false);
			logger.error("Login test failed");
		}
		
	}

}
