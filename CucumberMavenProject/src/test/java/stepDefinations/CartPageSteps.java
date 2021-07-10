package stepDefinations;

import contextClass.TestContext;
import cucumber.api.java.en.When;
import pageObjects.CartPage;
import pageObjects.ProductPage;

public class CartPageSteps {
	TestContext testContext;
	ProductPage productPage;
	CartPage cartPage;
	
	public CartPageSteps(TestContext context) {
		testContext = context;
		productPage = testContext.getPageObjectManager().getProductPage();
		cartPage = testContext.getPageObjectManager().getCartPage();	
	}
	
	@When("^moves to checkout from proceed to cart option$")
	public void moves_to_checkout_from_proceed_to_cart_option() throws Throwable {
		productPage.clickOn_AddCart();
		productPage.clickOn_ViewCart();
		cartPage.click_ProceedCheckout();
	}

}
