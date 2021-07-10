package stepDefinations;


import contextClass.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import managers.WebDriverManager;
import pageObjects.HomePage;

public class HomePageSteps {
	TestContext testContext;
	WebDriverManager webDriverManager;
	HomePage homePage;
	

	public HomePageSteps(TestContext context) {
		testContext = context;
	//	webDriverManager=testContext.getWebDriverManager();
		homePage= testContext.getPageObjectManager().getHomePage();
	}
	@Given("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {	
		homePage.navigate_to_homePage();
	}

	@When("^user searches for \"([^\"]*)\"$")
	public void user_searches_for(String arg1) throws Throwable {
		homePage.perform_Search("Dress");
	}

}
