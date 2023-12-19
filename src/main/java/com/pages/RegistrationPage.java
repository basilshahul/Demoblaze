package com.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

	private WebDriver driver;
	private WebElement signUp;
	
	// 1. By Locators:
	private By signup = By.id("signin2");
	private By signuptext = By.id("signInModalLabel");
	private By username = By.id("sign-username");
	private By password = By.id("sign-password");
	private By signupbutton = By.xpath("//div[@id='signInModal']/div/div/div[3]/button[2]");

	
	// 2. Constructor of the page class:
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page in the form of methods:
	public void clickSignUpLink() {
		driver.findElement(signup).click();
	}
	
	public void enterUserName() {
		signUp = driver.findElement(signuptext);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.textToBePresentInElement(signUp, "Sign up"));
		driver.findElement(username).sendKeys("Basil Ahamed");
	}

	public void enterPassword() {
		driver.findElement(password).sendKeys("Test@1234");
	}

	public void clickOnSignUp() {
		driver.findElement(signupbutton).click();
	}
	
	public String getAlertText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
}
