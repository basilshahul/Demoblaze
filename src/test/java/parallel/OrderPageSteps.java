package parallel;

import org.junit.Assert;

import com.at.factory.DriverFactory;
import com.pages.OrderPage;
import com.pages.ProductPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderPageSteps {
	
	private ProductPage productPage = new ProductPage(DriverFactory.getDriver());
	private OrderPage orderPage = new OrderPage(DriverFactory.getDriver());
	private String addeditem, actualalert;
	
	@When("the user add product to cart")
	public void the_user_add_product_to_cart() {
	    productPage.clickPhonesCategory();
	    productPage.clickOnProduct();
	    productPage.clickAddToCart();
	}

	@When("the user click on the cart")
	public void the_user_click_on_the_cart() {
	    orderPage.clickOnCart();
	}

	@Then("the user go to the cart page")
	public void the_user_go_to_the_cart_page() {
		orderPage.verifyCartPage();
	}

	@Then("the user review the items in the cart")
	public void the_user_review_the_items_in_the_cart() {
	    addeditem = orderPage.getAddedItem();
	    System.out.println("Added product: " + addeditem);
	}

	@When("the user click on the place order button")
	public void the_user_click_on_the_place_order_button() {
	    orderPage.clickOnPlaceOrder();
	}

	@When("the user fill the shipping details and click purchase button")
	public void the_user_fill_the_shipping_details_and_click_purchase_button() {
	    orderPage.enterShippingDetails();
	}

	@Then("the user gets the alert {string}")
	public void the_user_gets_the_alert(String expectedalert) {
		actualalert = orderPage.getAlertMessage();
		Assert.assertTrue(actualalert.equals(expectedalert));
		if (actualalert.equals(expectedalert)) {
			System.out.println("Product order placed successful");
			} else {
				System.out.println("Warning Alert: " + actualalert);
			}
	}

}
