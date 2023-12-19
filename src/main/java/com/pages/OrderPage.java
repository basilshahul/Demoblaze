package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {

	private WebDriver driver;
	private WebElement viewcart, response;
	
	// 1. By Locators:
	private By cartpage = By.id("cartur");
	private By addeditem = By.xpath("//*[@id='tbodyid']/tr/td[2]");
	private By placeorder = By.xpath("//*[@id='page-wrapper']/div/div[2]/button");
	private By loadorderpage = By.id("orderModalLabel");
	private By name = By.id("name");
	private By creditcard = By.id("card");
	private By purchase = By.xpath("//*[@id='orderModal']/div/div/div[3]/button[2]");
	private By confirmation = By.xpath("//h2[contains(text(), 'Thank you for your purchase!')]");
	
	
	// 2. Constructor of the page class:
	public OrderPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page in the form of methods:
	
	public void clickOnCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		viewcart = wait.until(ExpectedConditions.presenceOfElementLocated(cartpage));
		viewcart.click();
	}
	
	public void verifyCartPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.urlToBe("https://www.demoblaze.com/cart.html"));
		System.out.println("Cart page loaded");
	}
	
	public String getAddedItem() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(addeditem));
		return driver.findElement(addeditem).getText();
	}
	
	public void clickOnPlaceOrder() {
		driver.findElement(placeorder).click();
	}
	
	public void enterShippingDetails() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(loadorderpage));
		driver.findElement(name).sendKeys("John");
		driver.findElement(creditcard).sendKeys("786328656");
		driver.findElement(purchase).click();
	}

	public String getAlertMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		response = wait.until(ExpectedConditions.presenceOfElementLocated(confirmation));
		return response.getText();
	}
}
