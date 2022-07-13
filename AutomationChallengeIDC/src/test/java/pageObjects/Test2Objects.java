package pageObjects;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class Test2Objects {

	WebDriver driver;

	public Test2Objects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH,using="//button[@class='btn btn-primary dropdown-toggle']")
	private WebElement clickMe;

	@FindBy(how = How.XPATH,using="//ul[@class='dropdown-menu show']")
	private WebElement dropDown;

	@FindAll(@FindBy(how = How.XPATH,using="//ul[@class=\"dropdown-menu show\"]/li"))
	private List<WebElement> dropDownList;

	@FindBy(how = How.XPATH,using="//input[@id='myInput']")
	private WebElement search;


	public void clickMe() {
		clickMe.click();
	}
	public void enter_search(String searchValue) {
		search.sendKeys(searchValue);
	}
	public void clearSearch() {
		search.clear();
	}
	
	public List<WebElement> getdropDown() {
		return dropDownList;
	}
	
	public boolean isDisplayedOptions() {
		List<WebElement> elements = dropDownList;
		for(WebElement ele : elements ) {
			if(ele.isDisplayed()) {
				return true;
			}
		}
		return false;
	}
	
}
