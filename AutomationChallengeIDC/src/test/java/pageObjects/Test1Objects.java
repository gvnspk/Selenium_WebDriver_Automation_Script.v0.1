package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Test1Objects {
	WebDriver driver;

	public Test1Objects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH,using="//button[@class='btn btn-info btn-lg']")
	private WebElement openModal;

	@FindBy(how = How.XPATH,using="//input[@id='name']")
	private WebElement name;

	@FindBy(how = How.XPATH,using="//input[@id='city']")
	private WebElement city;

	@FindBy(how = How.XPATH,using="//button[@id='enter']")
	private WebElement enterButton;

	@FindBy(how = How.XPATH,using="//button[@class='btn btn-default']")
	private WebElement closeModal;

	@FindBy(how = How.XPATH,using="//span[@id='nameVal']")
	private WebElement nameValue;

	@FindBy(how = How.XPATH,using="//span[@id='cityVal']")
	private WebElement cityValue;

	public void click_openModal() {
		openModal.click();
	}

	public void enter_name(String userName) {
		name.sendKeys(userName);
	}

	public void enter_city(String userCity) {
		city.sendKeys(userCity);
	}
	
	public void click_enter() {
		enterButton.click();
	}

	public void click_closeModal() {
		
		closeModal.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.elementToBeClickable(closeModal));
		
	}
	
	public String getnameValue() {
		String nameVal = nameValue.getText();
		return nameVal;
	}
	
	public String getcityValue() {
		String cityVal = cityValue.getText();
		return cityVal;
	}
	
}
