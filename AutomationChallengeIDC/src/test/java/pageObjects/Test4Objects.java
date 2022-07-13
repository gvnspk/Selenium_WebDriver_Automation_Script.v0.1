package pageObjects;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Test4Objects {
	
	WebDriver driver;

	public Test4Objects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH,using="//div[@id='div1']")
	private WebElement dragHere;
	
	@FindBy(how = How.XPATH,using="//button[@id='drag1']")
	private WebElement dragButton;
	
	public void performDragAndDrop() throws InterruptedException, AWTException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", dragHere);
		
//		Actions act = new Actions(driver);
//		
//		act.dragAndDrop(dragHere,dragButton).build().perform();
//		
//		act.clickAndHold(dragButton)
//		.pause(Duration.ofSeconds(2))
//		.moveToElement(dragHere)
//		.pause(Duration.ofSeconds(2))
//		.release(dragButton)
//		.build()
//		.perform();
	
		
//		Point sourceCoordinates = dragButton.getLocation(); 
//		Point targetCoordinates = dragHere.getLocation();
//		Robot robot = new Robot();
//		robot.mouseMove(sourceCoordinates.getX(),sourceCoordinates.getY());
//		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//		robot.mouseMove(targetCoordinates.getX(), targetCoordinates.getY());
//		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                + "var dropEvent = createEvent('drop');\n"
                + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                + "var dragEndEvent = createEvent('dragend');\n"
                + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                + "simulateHTML5DragAndDrop(source,destination);", dragButton, dragHere);
	}
}
