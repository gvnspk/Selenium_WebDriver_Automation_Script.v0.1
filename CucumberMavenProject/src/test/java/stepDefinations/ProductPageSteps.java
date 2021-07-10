package stepDefinations;


import contextClass.TestContext;
import cucumber.api.java.en.When;
import pageObjects.ProductPage;

public class ProductPageSteps {
	TestContext testContext;
	ProductPage productPage;
	
	public ProductPageSteps(TestContext context) {
		testContext = context;
		productPage = testContext.getPageObjectManager().getProductPage();
	}
	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() throws Throwable {
		productPage.select_Product_List(0);
		productPage.selectColor("White");
		productPage.selectSize("Medium");	
	}
}
