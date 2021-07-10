package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testDataTypes.CustomerDetails;

public class CheckOutPage {
	public CheckOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH,using="//input[@id='billing_first_name']")
	private WebElement firstName; 
	
	@FindBy(how = How.XPATH,using="//input[@name='billing_last_name']")
	private WebElement lastName;
	
	@FindAll(@FindBy(how = How.XPATH,using="//span[@id='select2-billing_country-container']"))
	private List<WebElement> countryList;
	
	@FindBy(how = How.XPATH,using="//input[@id='billing_address_1']")
	private WebElement address;
	
	@FindBy(how = How.XPATH,using="//input[@id='billing_city']")
	private WebElement townOrCity;
	
	@FindBy(how = How.XPATH,using="//input[@id='billing_postcode']")
	private WebElement pinCode;
	
	@FindBy(how = How.XPATH,using="//input[@id='billing_phone']")
	private WebElement phoneNumber;
	
	@FindBy(how = How.XPATH,using="//input[@id='billing_email']")
	private WebElement email;
	
	@FindBy(how = How.XPATH,using="//input[@id='terms']")
	private WebElement termsConditions;
	
	@FindBy(how=How.XPATH,using="//button[@id='place_order']")
	private WebElement placeOrder;
	
	@FindBy(how=How.XPATH,using="//p[@class='woocommerce-thankyou-order-received']")
	private WebElement confirm;
	
	public void enter_FirstName(String fName) {
		firstName.sendKeys(fName);
	}
	
	public void enter_LastName(String lName) {
		lastName.sendKeys(lName);
	}
	
	public void enter_countryList(String country) {
		for(WebElement countryName : countryList) {
			if(countryName.getText().equalsIgnoreCase(country)) {
				countryName.click();
				try { Thread.sleep(2000);}
				 catch (InterruptedException e) {}
				countryName.click();
				break;
			}
		}
	}
	
	public void enter_address(String userAddress) {
		address.sendKeys(userAddress);
	}
	
	public void enter_townOrCity(String userTownOrCity) {
		townOrCity.sendKeys(userTownOrCity);
	}
	
	public void enter_pinCode(String userPinCode) {
		pinCode.sendKeys(userPinCode);
	}
	
	public void enter_phoneNumber(String userPhoneNumber) {
		phoneNumber.sendKeys(userPhoneNumber);
	}
	
	public void enter_email(String userEmail) {
		email.sendKeys(userEmail);
	}
	
	public void click_termsConditions() {
		if(termsConditions.isSelected()==false) {
			termsConditions.click();
		}
	}
	
	public void click_placeOrder() {
		placeOrder.click();
	}
	
	public void get_confirm() {
		String userConfirm = confirm.getText();
		System.out.println(userConfirm);
	}
	
	public void fill_CheckOutPage(CustomerDetails customer) {
		enter_FirstName(customer.firstName);
		enter_LastName(customer.lastName);
		enter_countryList(customer.countryList);
		enter_address(customer.address.building);
		enter_townOrCity(customer.address.townOrCity);
		enter_pinCode(customer.address.pinCode);
		enter_phoneNumber(customer.contactDetails.phoneNumber);
		enter_email(customer.contactDetails.email);
	}
	
}
