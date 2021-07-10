package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import managers.FileReaderManager;

public class HomePage {
	WebDriver driver;
	FileReaderManager fileReaderManager;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void navigate_to_homePage() {
		
		driver.get(FileReaderManager.getInstance().getConfigReader().getURL());
	}
	
	public void perform_Search(String search) {
		driver.navigate().to("http://shop.demoqa.com/?s="+search+"&post_type=product");
	}

}
