package stepDefinations;

import java.awt.AWTException;
import java.io.IOException;

import contextClass.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.Test4Objects;

public class Test4 {
	
	TestContext testContext;
	Test4Objects test4Objects;
	

	public Test4(TestContext context) {
		testContext = context;
		test4Objects = context.getPageObjectManager().getTest4();
	}
	
	
	@Given("^Drag button Drag Me to the Red Rectangle box$")
	public void drag_button_Drag_Me_to_the_Red_Rectangle_box() throws InterruptedException, AWTException  {
		test4Objects.performDragAndDrop();
	}

	@When("^verify if button was dragged inside the box$")
	public void verify_if_button_was_dragged_inside_the_box() throws IOException  {
		testContext.getWebDriverManager().takeScreenshot("Drag and Drop Verification");

	}

	

}
