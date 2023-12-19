package com.pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;

	// 1. By Locators:
	private By hometext = By.xpath("//div[@id='navbarExample']/ul/li[1]/a");
	private By websitelogo = By.xpath("//a[@id='nava']/img");
	private By menuitems = By.xpath("//div[@id='navbarExample']/ul/li");
	private By featuredproduct = By.xpath("//div[@id='tbodyid']/div[1]/div/div/h4/a");
	private List<String> menuList = Arrays.asList("Home", "Contact", "About us", "Cart", "Log in", "Log out", "", "Sign up");
	
	// 2. Constructor of the page class:
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page the form of methods:
	public String getHomePageText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement homePage = driver.findElement(hometext);
		wait.until(ExpectedConditions.textToBePresentInElement(homePage, "Home"));
		return driver.findElement(hometext).getText();
	}
	
	// verify logo present
	public boolean logoPresent() {
		WebElement logo = driver.findElement(websitelogo);
		return logo.isDisplayed();
	}
	
	// verify all items present in navigation menu
	public void menuItemsPresent() {
		List<WebElement> menuItems = driver.findElements(menuitems);
		for(int i=0; i < menuList.size(); i++) {
			for(WebElement element : menuItems) {
				if (menuList.get(i).equals(element.getText())) {
					System.out.println("All navigation menu items present");
				} else {
					System.out.println("Menu items not present");
				}
			}
		}
	}

	// verify featured product present
	public boolean featuredProductPresent() {
		WebElement product = driver.findElement(featuredproduct);
		return product.isDisplayed();
	}
}
