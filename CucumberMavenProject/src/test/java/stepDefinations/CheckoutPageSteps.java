package stepDefinations;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import contextClass.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import managers.WebDriverManager;
import pageObjects.CheckOutPage;
import testDataTypes.CustomerDetails;


public class CheckoutPageSteps {
	TestContext testContext;
	CheckOutPage checkOutPage;
	WebDriver driver;
	WebDriverManager webDriverManager;
	
	public CheckoutPageSteps(TestContext context) {
		testContext = context;
		webDriverManager = testContext.getWebDriverManager();
		checkOutPage = testContext.getPageObjectManager().getCheckOutPage();
		
	}
	
	@When("^enter \\\"(.*)\\\" details on checkout page$")
	public void enter_details_on_checkout_page(String customerName) throws Throwable {
		CustomerDetails customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
		checkOutPage.fill_CheckOutPage(customer);
		checkOutPage.click_termsConditions();
	}

	@When("^place the order$")
	public void place_the_order() throws Throwable {
		checkOutPage.click_placeOrder();
	}

	@Then("^Order should be sucessfully placed$")
	public void order_should_be_sucessfully_placed() throws Throwable {
		checkOutPage.get_confirm();
		
		File img = ((TakesScreenshot) webDriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(img,new File("C:\\Users\\prasa\\Pictures\\ToolSQA.png"));
	}
	

}
