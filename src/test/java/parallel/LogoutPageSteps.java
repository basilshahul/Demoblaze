package parallel;

import org.junit.Assert;

import com.at.factory.DriverFactory;
import com.pages.LoginPage;
import com.pages.LogoutPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutPageSteps {
	
	private String getloginagain;
	private LogoutPage logoutPage = new LogoutPage(DriverFactory.getDriver());
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("the user logged in demoblaze site")
	public void the_user_logged_in_demoblaze_site() {
		loginPage.clickLoginPageButton();
		loginPage.getLoginPageText();
	    loginPage.enterUserName("automtester");
	    loginPage.enterPassword("Test@123");
	    loginPage.clickOnLogin();
	    loginPage.getWelcomeMessage();
	}

	@When("the user select the logout option")
	public void the_user_select_the_logout_option() {
	    logoutPage.clickOnLogout();
	}

	@Then("the user logged out and redirected to homepage")
	public void the_user_logged_out_and_redirected_to_homepage() {
	    getloginagain = logoutPage.verifyLogout();
	    Assert.assertTrue(getloginagain.equals("Log in"));
	    System.out.println("Logged out and redirected to homapage");
	}

}
