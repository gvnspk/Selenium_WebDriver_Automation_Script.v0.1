package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindAll(@FindBy(how = How.XPATH,using="//div[@class='noo-product-inner']"))
	private List<WebElement> product_list;
	
	@FindBy(how = How.XPATH,using="//select[@id='pa_color']")
	private WebElement color;
	
	@FindBy(how = How.XPATH,using="//select[@id='pa_size']")
	private WebElement size;
	
	@FindBy(how = How.XPATH,using="//button[@class='single_add_to_cart_button button alt']")
	private WebElement addCart;
	
	@FindBy(how = How.XPATH,using="//a[@class='button wc-forward']")
	private WebElement viewCart;
	
	public void select_Product_List(int productNumber) {
		product_list.get(productNumber).click();
	}
	
	public void selectColor(String colorName) {
		Select selColor = new Select(color);
		selColor.selectByVisibleText(colorName);
	}
	
	public void selectSize(String sizeValue) {
		Select seSize = new Select(size);
		seSize.selectByVisibleText(sizeValue);
	}
	
	public void clickOn_AddCart() {
		 addCart.click();
	}
	
	public void clickOn_ViewCart() {
		viewCart.click();
	}
	
}
