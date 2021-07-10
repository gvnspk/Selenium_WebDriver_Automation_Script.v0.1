package seleniumTests;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class E2E_Test {
private static WebDriver driver;
	public static void main(String[] args) throws IOException, Exception {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		ChromeOptions options  = new ChromeOptions();
		options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		options.addArguments("--headless");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://shop.demoqa.com/");
		driver.navigate().to("http://shop.demoqa.com/?s=dress&post_type=product");
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='noo-product-inner']"));
		//System.out.println(products.size());
		products.get(0).click();
		Select color = new Select(driver.findElement(By.xpath("//select[@id='pa_color']")));
		color.selectByVisibleText("White");
		Select size = new Select(driver.findElement(By.xpath("//select[@id='pa_size']")));
		size.selectByVisibleText("Medium");
		WebElement addToCart = driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']"));
		addToCart.click();
		WebElement viewCart = driver.findElement(By.xpath("//a[@class='button wc-forward']"));
		viewCart.click();
		WebElement proceedCheckout = driver.findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']"));
		proceedCheckout.click();
		WebElement firstName = driver.findElement(By.xpath("//input[@id='billing_first_name']"));
		firstName.sendKeys("Steve");
		WebElement lastname = driver.findElement(By.xpath("//input[@name='billing_last_name']"));
		lastname.sendKeys("Rogers");
		List<WebElement> countryList = driver.findElements(By.xpath("//span[@id='select2-billing_country-container']"));
		for(WebElement country : countryList) {
			if(country.getText().equalsIgnoreCase("India"));{
				country.click();
				Thread.sleep(3000);
				country.click();
				break;
			}
		}
		
		WebElement address = driver.findElement(By.xpath("//input[@id='billing_address_1']"));
		address.sendKeys("Street 121, House 1");
		WebElement townOrCity = driver.findElement(By.xpath("//input[@id='billing_city']"));
		townOrCity.sendKeys("NewYork");
		WebElement pinCode = driver.findElement(By.xpath("//input[@id='billing_postcode']"));
		pinCode.sendKeys("555555");
		WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='billing_phone']"));
		phoneNumber.sendKeys("9989796959");
		WebElement email = driver.findElement(By.xpath("//input[@id='billing_email']"));
		email.sendKeys("CaptianAmerica@avengers.com");
		WebElement termsConditions = driver.findElement(By.xpath("//input[@id='terms']"));
		if(termsConditions.isSelected()== false) {
			termsConditions.click();
		}
		
		WebElement placeOrder = driver.findElement(By.xpath("//button[@id='place_order']"));
		placeOrder.click();
		
		WebElement confirm = driver.findElement(By.xpath("//p[@class='woocommerce-thankyou-order-received']"));
		String message = confirm.getText();
		System.out.println(message);
		File img = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(img,new File("C:\\Users\\prasa\\Pictures\\ToolSQA.png"));
		driver.quit();
	}
		
}
