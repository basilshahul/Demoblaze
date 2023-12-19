package parallel;

import org.junit.Assert;

import com.at.factory.DriverFactory;
import com.pages.ProductPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductPageSteps {
	
	private ProductPage productPage = new ProductPage(DriverFactory.getDriver());
	private String actualalert;

	@When("the user navigate to a product category")
	public void the_user_navigate_to_a_product_category() {
	    productPage.clickPhonesCategory();
	}

	@When("the user click on a product to view its details")
	public void the_user_click_on_a_product_to_view_its_details() {
	    productPage.clickOnProduct();
	}

	@When("the user add the product to the cart")
	public void the_user_add_the_product_to_the_cart() {
	    productPage.clickAddToCart();
	}

	@Then("the user gets the alert message {string}")
	public void the_user_gets_the_alert_message(String expectedalert) {
		actualalert = productPage.getAlertMessage();
		Assert.assertTrue(actualalert.equals(expectedalert));
		if (actualalert.equals(expectedalert)) {
			System.out.println("Product added to cart");
			} else {
				System.out.println("Warning Alert: " + actualalert);
			}
	}

}
