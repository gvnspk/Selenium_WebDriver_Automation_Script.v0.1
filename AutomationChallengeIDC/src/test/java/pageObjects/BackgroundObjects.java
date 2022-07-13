package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
//import contextClass.TestContext;
import dataProvider.ConfigFileReader;


public class BackgroundObjects {
	WebDriver driver;
	private static ConfigFileReader configFileReader = new ConfigFileReader();
	//TestContext testContext = new TestContext()  ;
	
	public BackgroundObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigate_to_homePage() {	
		
		driver.navigate().to(configFileReader.getURL());
	}
	
	public void verify_homePage() throws IOException {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Home", "Verifying that user is on home page");;
	//	testContext.getWebDriverManager().takeScreenshot("Home Page");
	}
	
}
