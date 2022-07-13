package stepDefinations;

import java.io.IOException;

import contextClass.TestContext;
import cucumber.api.java.en.Given;
import pageObjects.BackgroundObjects;


public class Background {
	TestContext testContext;
	BackgroundObjects backgroundObjects;
	

	public Background(TestContext context) {
		testContext = context;
		backgroundObjects = context.getPageObjectManager().getBackground();
		
	}

	@Given("^Navigation to the home page using the \"([^\"]*)\"$")
	public void navigation_to_the_home_page_using_the(String url) {
		backgroundObjects.navigate_to_homePage();
	}
	
	@Given("^User is on the home page$")
	public void user_is_on_the_home_page() throws IOException{
		backgroundObjects.verify_homePage();
		testContext.getWebDriverManager().takeScreenshot("Home Page");
	}
	
	

}
