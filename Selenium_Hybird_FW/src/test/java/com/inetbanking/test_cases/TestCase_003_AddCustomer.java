package com.inetbanking.test_cases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.page_objects.LoginPage;
import com.inetbanking.page_objects.NewCustomer;

public class TestCase_003_AddCustomer extends TestHelper {
	
	@Test
	public void addNewCutomer() {
		logger.info("entered login credentials");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(username, password);
		NewCustomer newCustomer = PageFactory.initElements(driver, NewCustomer.class);
		logger.info("click new customer link");
		newCustomer.clickNewCustomer();
		logger.info("enter customer details");
		newCustomer.setCustomerName("Honey Singh");
		newCustomer.setGender("male");
		newCustomer.setDOB("10", "12", "1990");
		newCustomer.setAddress("Worley");
		newCustomer.setCity("mumbai");
		newCustomer.setState("maharastra");
		newCustomer.setPincode("100100");
		newCustomer.setTelephone("9437812124");
		newCustomer.setEmail(randomName()+"@gmail.com");
		newCustomer.setPassword("12345678");
		newCustomer.saveNewCustomer();
		
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		logger.info("verify test result");
		Assert.assertTrue(result);
	}

	public String randomName() {
		return RandomStringUtils.randomAlphabetic(10);
	}
}
