package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;

	// 1. By Locators:
	private By loginpage = By.id("login2");
	private By logintext = By.id("logInModalLabel");
	private By username = By.id("loginusername");
	private By password = By.id("loginpassword");
	private By loginbutton = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
	private By message = By.id("nameofuser");
	
	// 2. Constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page in the form of methods:
	
	public void clickLoginPageButton() {
		driver.findElement(loginpage).click();
	}
	
	public String getLoginPageText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement loginPage = driver.findElement(logintext);
		wait.until(ExpectedConditions.textToBePresentInElement(loginPage, "Log in"));
		return driver.findElement(logintext).getText();
	}

	public void enterUserName(String user) {
		driver.findElement(username).sendKeys(user);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnLogin() {
		driver.findElement(loginbutton).click();
	}
	
	public String getWelcomeMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(message));
		return driver.findElement(message).getText();
	}

}

