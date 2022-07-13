package stepDefinations;

import java.io.IOException;
import org.testng.Assert;
import contextClass.TestContext;
import cucumber.api.java.en.*;
import pageObjects.Test1Objects;

public class Test1 {
	
	TestContext testContext;
	Test1Objects test1Objects;
	

	public Test1(TestContext context) {
		testContext = context;
		test1Objects = context.getPageObjectManager().getTest1();
	}
	
	@Given("^Click on Open Modal button$")
	public void click_on_Open_Modal_button(){
		test1Objects.click_openModal();

	}

	@When("^Enter values for \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enter_values_for_and(String name, String city)  {
		test1Objects.enter_name(name);
		test1Objects.enter_city(city);
	
	}

	@When("^Click the Enter Data button$")
	public void click_the_Enter_Data_button() {
		test1Objects.click_enter();
	    
	}

	@Then("^Close the Modal$")
	public void close_the_Modal()  {
		test1Objects.click_closeModal(); 
	}

	@Then("^Verify values under Open Modal button that were entered in the textboxes$")
	public void verify_values_under_Open_Modal_button_that_were_entered_in_the_textboxes() throws IOException  {
		
		String verifyName = test1Objects.getnameValue();
		String verifyCity = test1Objects.getcityValue();
		
		System.out.println("Name Dsiplayed : "+verifyName);
		System.out.println("City Dsiplayed : "+verifyCity);
		
		Assert.assertEquals(verifyName, "Prasanna Kumar");
		Assert.assertEquals(verifyCity, "Hyderabad");
		
		testContext.getWebDriverManager().takeScreenshot("Verifying name and city");
	}

}
