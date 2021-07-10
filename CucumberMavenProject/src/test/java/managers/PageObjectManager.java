package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.ProductPage;

public class PageObjectManager {
	private WebDriver driver;
	private HomePage homePage;
	private ProductPage productPage;
	private CartPage cartPage;
	private CheckOutPage checkOutPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	public HomePage getHomePage() {
		return(homePage==null) ? homePage = new HomePage(driver) : homePage;
	}
	
	public ProductPage getProductPage() {
		return(productPage==null) ? productPage = new ProductPage(driver) : productPage;
	}
	
	public CartPage getCartPage() {
		return(cartPage==null) ? cartPage = new CartPage(driver) : cartPage;
	}
	
	public CheckOutPage getCheckOutPage() {
		return(checkOutPage==null) ? checkOutPage = new CheckOutPage(driver) : checkOutPage;
	}
	
}
