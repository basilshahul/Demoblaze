package com.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

	private WebDriver driver;
	private WebElement phone, sonyz5;
	private String fetchalert;
	
	// 1. By Locators:
	private By loadimages = By.xpath("//div[@id='tbodyid']/div[3]/div/a/img");
	private By phones = By.xpath("//*[@id='itemc' and contains(text(), 'Phones')]");
	private By sonyxperia = By.xpath("//*[@id='tbodyid']/div[6]/div/a/img");
	private By sonyimage = By.xpath("//*[@id='imgp']/div/img");
	private By addtocart = By.xpath("//*[@id='tbodyid']/div[2]/div/a");
	
	
	// 2. Constructor of the page class:
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page in the form of methods:
	
	public void clickPhonesCategory() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOfElementLocated(loadimages));
		phone = wait.until(ExpectedConditions.presenceOfElementLocated(phones));
		phone.click();
	}
	
	public void clickOnProduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		sonyz5 = wait.until(ExpectedConditions.presenceOfElementLocated(sonyxperia));
		sonyz5.click();
	}
	
	public void clickAddToCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOfElementLocated(sonyimage));
		driver.findElement(addtocart).click();
	}
	
	public String getAlertMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		fetchalert = alert.getText();
		alert.accept();
		return fetchalert;
	}
}
