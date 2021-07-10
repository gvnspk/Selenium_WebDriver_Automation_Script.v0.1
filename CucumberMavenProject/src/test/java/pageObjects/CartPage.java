package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH,using="//a[@class='checkout-button button alt wc-forward']")
	private WebElement proceedCheckout;
	
	public void click_ProceedCheckout() {
		proceedCheckout.click();
	}
}
