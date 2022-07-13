package stepDefinations;

import contextClass.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	TestContext testContext;
	
	public Hooks(TestContext context) {
		testContext = context;
	}
	
	@Before 
	public void setUp() {
		testContext.getWebDriverManager().getDriver();
	}
	
	@After
	public void tearDown() {
		testContext.getWebDriverManager().closeDriver();
	}
}
