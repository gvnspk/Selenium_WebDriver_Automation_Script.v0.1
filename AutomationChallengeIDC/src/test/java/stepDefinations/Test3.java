package stepDefinations;


import java.io.IOException;

import org.testng.Assert;
import contextClass.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.Test3Objects;

public class Test3 {
	
	TestContext testContext;
	Test3Objects test3Objects;
	

	public Test3(TestContext context) {
		testContext = context;
		test3Objects = context.getPageObjectManager().getTest3();
	}
	
	@Given("^In search box enter value \"([^\"]*)\"$")
	public void in_search_box_enter_value(String wordSearch)  {
		test3Objects.performSearch(wordSearch);
	}
	
	@When("^Verify table displays two rows with country as \"([^\"]*)\"$")
	public void verify_table_displays_two_rows_with_country_as(String country) throws IOException  {
	  int noOfRows = test3Objects.displayTableWithSearch(country);
	  Assert.assertEquals(noOfRows,2);
	  testContext.getWebDriverManager().takeScreenshot("Table view after searching USA");
	}

	@When("^Clear search box$")
	public void clear_search_box() {
	  test3Objects.clearSearchTable();

	}

	@Then("^Verify table displays four rows$")
	public void verify_table_displays_four_rows() throws IOException  {
		int noOfRows = test3Objects.displayTableClearSearch();
		Assert.assertEquals(noOfRows,4);
		testContext.getWebDriverManager().takeScreenshot("Table view after clear search");
	   
	}

}
