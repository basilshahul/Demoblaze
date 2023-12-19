package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {

	private WebDriver driver;
	private String login;
	
	// 1. By Locators:
	private By logoutbutton = By.id("logout2");
	private By logintext = By.id("login2");
	
	// 2. Constructor of the page class:
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page in the form of methods:
	
	public void clickOnLogout() {
		driver.findElement(logoutbutton).click();
	}
	
	public String verifyLogout() {
		login = driver.findElement(logintext).getText();
		return login;
	}
}
