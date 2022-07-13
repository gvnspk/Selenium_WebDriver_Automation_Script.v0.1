package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Test3Objects {

	WebDriver driver;

	public Test3Objects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH,using="//input[@id='searchMe']")
	private WebElement searchMe;

	@FindBy(how = How.XPATH, using="//table[@class='table table-bordered table-striped']")
	private WebElement tableName;

	@FindBy(how = How.XPATH, using="//tbody[@id='someTable']")
	private WebElement tableBody;

	@FindBy(how = How.XPATH, using="//td")
	private WebElement tableColoumns;

	public void performSearch(String searchWord) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", tableBody);
		searchMe.sendKeys(searchWord);
	}

	public int displayTableWithSearch(String countryName) {
		int count = 0;
		List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
		for(int r=0; r<rows.size();r++) {
			if(rows.get(r).isDisplayed()) {
				count++;
			}
			List<WebElement> coloumns = rows.get(r).findElements(By.tagName("td"));
			for(int c=0; c<coloumns.size();c++) {
				if(coloumns.get(c).getText().equalsIgnoreCase(countryName)) {
					String country = coloumns.get(c).getText();
					Assert.assertEquals(countryName, country);
				}
			}	
		}
		System.out.println("No of rows after searching the country name USA = " +count);
		return count;
	}

	public void clearSearchTable() {
		
		searchMe.sendKeys(Keys.CONTROL,"a");
		searchMe.sendKeys(Keys.BACK_SPACE);
		//searchMe.clear();
	}

	public int displayTableClearSearch() {
		int count = 0;
		List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
		for(int r=0; r<rows.size();r++) {
			if(rows.get(r).isDisplayed()) {
				count++;
			}
		}
		System.out.println("No of rows after clear search  = " +count);
		return count;
	}
}
