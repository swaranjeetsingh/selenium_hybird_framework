package com.inetbanking.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private @FindBy(xpath = "//input[@name='uid']")@CacheLookup WebElement usernameElement;
	private @FindBy(xpath = "//input[@name='password']")@CacheLookup WebElement passwordElement;
	private @FindBy(xpath = "//input[@name='btnLogin']")@CacheLookup WebElement loginButtonElement;
	
	private @FindBy(linkText = "Log out")@CacheLookup WebElement logoutLinkElement; 
	
	public void login(String uName, String uPass) {
		usernameElement.sendKeys(uName);
		passwordElement.sendKeys(uPass);
		loginButtonElement.click();
	}
	
	public void logout() {
		logoutLinkElement.click();
	}
	
}
