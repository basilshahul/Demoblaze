package parallel;

import org.junit.Assert;

import com.at.factory.DriverFactory;
import com.pages.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
	
	private static String hometext;
	private HomePage homepage = new HomePage(DriverFactory.getDriver());

	@When("the user goes to the demoblaze website")
	public void the_user_goes_to_the_demoblaze_website() {
		DriverFactory.getDriver().get("https://www.demoblaze.com");
	}

	@Then("the user sees the homepage loaded successfully")
	public void the_user_sees_the_homepage_loaded_successfully() {
		hometext = homepage.getHomePageText();
		Assert.assertTrue(hometext.contains("Home"));
		System.out.println("Home page text is: " + hometext);
	}

	@Then("the user sees the presence of logo, menu and featured products")
	public void the_user_sees_the_presence_of_logo_menu_and_featured_products() {
		System.out.println(homepage.logoPresent());
		Assert.assertTrue(homepage.logoPresent());
		
		homepage.menuItemsPresent();
		Assert.assertTrue(homepage.featuredProductPresent());
		System.out.println(homepage.featuredProductPresent());
	}

}
