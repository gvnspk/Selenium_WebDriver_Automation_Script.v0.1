package stepDefinations;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import contextClass.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.Test2Objects;

public class Test2 {

	TestContext testContext;
	Test2Objects test2Objects;


	public Test2(TestContext context) {
		testContext = context;
		test2Objects = context.getPageObjectManager().getTest2();
	}


	@Given("^Click on Click Me button$")
	public void click_on_Click_Me_button()  {
		test2Objects.clickMe();

	}

	@When("^Search for the keyword \"([^\"]*)\"$")
	public void search_for_the_keyword(String searchWord)   {
		test2Objects.enter_search(searchWord);
	}


	@Then("^Verify two options are visible as \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verify_two_options_are_visible_as_and(String resultWord1, String resultWord2) throws IOException {

		List<WebElement> elements = test2Objects.getdropDown();
		for(WebElement ele : elements) {

			System.out.println(ele.getText());
			
			testContext.getWebDriverManager().takeScreenshot("Displaying Angular and Angular 2 in dropdown");

			if(ele.getText().equalsIgnoreCase(resultWord1)) {
				Assert.assertTrue(true);
				System.out.println("Angular Word exists");
			}
			if(ele.getText().equalsIgnoreCase(resultWord2)) {
				Assert.assertTrue(true);
				System.out.println("Angular 2 Word exists");
			}

		}	
	}

	@Then("^Clear the search box and type \"([^\"]*)\"$")
	public void clear_the_search_box_and_type(String searchWord2)  {
		test2Objects.clearSearch();
		test2Objects.enter_search(searchWord2);
	}

	@Then("^Verify no option is visible$")
	public void verify_no_option_is_visible() throws IOException  {
		
		//Since Elements are not displayed but present in DOM returns blank objects, we implement count method and check the count values of elements which are not blank.
		int count=0;
		List<WebElement> elements = test2Objects.getdropDown();
		for(WebElement ele : elements) {
			String value = ele.getText();
			if(value !="") {
				count++;
			}
		}
		System.out.println("Number of options visible after searching React JS "+count);
		Assert.assertEquals(count, 0);
		
		//Taking Screenshot to see if options are displayed or not
		testContext.getWebDriverManager().takeScreenshot("Displaying Null options ");
		
		//Checking using isDisplayed method fetching boolean value and doing assertion
		
		boolean displayed = test2Objects.isDisplayedOptions();
		Assert.assertEquals(displayed, false);
	}


}
