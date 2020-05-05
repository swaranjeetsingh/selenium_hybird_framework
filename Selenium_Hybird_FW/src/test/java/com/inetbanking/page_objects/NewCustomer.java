package com.inetbanking.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class NewCustomer {
	WebDriver driver;
	public NewCustomer(WebDriver driver) {
		this.driver = driver;
	}
	
	private @FindBy(linkText = "New Customer")@CacheLookup WebElement newCustomerElement;
	private @FindBy(name = "name")@CacheLookup WebElement custNameElement;
	private @FindBy(xpath = "//tr[5]//td[2]//input[1]")@CacheLookup WebElement radioMaleElement;
	private @FindBy(xpath = "//tr[5]//td[2]//input[2]")@CacheLookup WebElement radioFemalElement;
	private @FindBy(css = "#dob")@CacheLookup WebElement dobElement;
	private @FindBy(xpath = "//textarea[@name='addr']")@CacheLookup WebElement addressElement;
	private @FindBy(xpath = "//input[@name='city']")@CacheLookup WebElement cityElement;
	private @FindBy(xpath = "//input[@name='state']")@CacheLookup WebElement stateElement;
	private @FindBy(xpath = "//input[@name='pinno']")@CacheLookup WebElement pincodeElement;
	private @FindBy(xpath = "//input[@name='telephoneno']")@CacheLookup WebElement telephoneNoElement;
	private @FindBy(xpath = "//input[@name='emailid']")@CacheLookup WebElement emailIdElement;
	private @FindBy(xpath = "//input[@name='password']")@CacheLookup WebElement passwordElement;
	private @FindBy(xpath = "//input[@name='sub']")@CacheLookup WebElement submitButtonElement;
	
	public void clickNewCustomer() {
		newCustomerElement.click();
	}
	public void setCustomerName(String nameString) {
		custNameElement.sendKeys(nameString);
	}
	public void setGender(String genderString) {
		if (genderString.equalsIgnoreCase("male")) {
			radioMaleElement.click();
		}
		else {
			radioFemalElement.click();
		}
	}
	public void setDOB(String dd, String mm, String yyyy ) {
		dobElement.sendKeys(dd);
		dobElement.sendKeys(mm);
		dobElement.sendKeys(yyyy);
	}
	public void setAddress(String addressString) {
		addressElement.sendKeys(addressString);
	}
	public void setCity(String cityString) {
		cityElement.sendKeys(cityString);
	}
	public void setState(String stateString) {
		stateElement.sendKeys(stateString);
	}
	public void setPincode(String pincodeString) {
		pincodeElement.sendKeys(pincodeString);
	}
	public void setTelephone(String telephoneString) {
		telephoneNoElement.sendKeys(telephoneString);
	}
	public void setEmail(String emailString) {
		emailIdElement.sendKeys(emailString);
	}
	public void setPassword(String passwordString) {
		passwordElement.sendKeys(passwordString);
	}
	public void saveNewCustomer() {
		submitButtonElement.click();
	}

}
