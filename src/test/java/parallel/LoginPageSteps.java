package parallel;

import org.junit.Assert;

import com.pages.LoginPage;
import com.at.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginPageSteps {

	private static String logintext, message;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("user is on home page")
	public void user_is_on_home_page() {
		DriverFactory.getDriver().get("https://www.demoblaze.com/");
	}
	
	@When("user clicks on login page button")
	public void user_clicks_on_login_page_button() {
		loginPage.clickLoginPageButton();
		logintext = loginPage.getLoginPageText();
		System.out.println("Login page header is: " + logintext);
	}
	
	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterUserName(username);
	}
	
	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}
	
	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	}
	
	@Then("user gets the welcome message of the page")
	public void user_gets_the_welcome_message_of_the_page() {
		message = loginPage.getWelcomeMessage();
		System.out.println("Welcome message is: " + message);
	}
	
	@Then("welcome message should be {string}")
	public void welcome_message_should_be(String expectedMessage) {
		message = loginPage.getWelcomeMessage();
		Assert.assertTrue(message.contains(expectedMessage));
	}
}

