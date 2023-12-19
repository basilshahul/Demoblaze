package parallel;

import org.junit.Assert;

import com.at.factory.DriverFactory;
import com.pages.RegistrationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationPageSteps {
	
		private RegistrationPage registrationPage = new RegistrationPage(DriverFactory.getDriver());
		private String actualalert;

		@Given("the user is on demoblaze website")
		public void the_user_is_on_demoblaze_website() {
			DriverFactory.getDriver().get("https://www.demoblaze.com/index.html");
		}

		@When("the user click on the sign up link")
		public void the_user_click_on_the_sign_up_link() {
			registrationPage.clickSignUpLink();
		}

		@When("the user fill out the registration form with valid data")
		public void the_user_fill_out_the_registration_form_with_valid_data() {
			registrationPage.enterUserName();
			registrationPage.enterPassword();
		}
		
		@When("the user click on the sign up button")
		public void the_user_click_on_the_sign_up_button() {
			registrationPage.clickOnSignUp();	
		}

		@Then("the user gets alert message {string}")
		public void the_user_gets_alert_message(String expectedalert) {
			actualalert = registrationPage.getAlertText();
			if (actualalert.equals(expectedalert)) {
			System.out.println("User registration successful");
			} else {
				System.out.println("Warning Alert: " + actualalert);
			}
			Assert.assertTrue(actualalert.equals(expectedalert));
		}
}
