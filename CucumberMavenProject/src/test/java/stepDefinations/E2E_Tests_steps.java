package stepDefinations;

//import java.io.File;
//import java.util.concurrent.TimeUnit;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import dataProvider.ConfigFileReader;
//import managers.FileReaderManager;
//import managers.PageObjectManager;
//import managers.WebDriverManager;
//import pageObjects.CartPage;
//import pageObjects.CheckOutPage;
//import pageObjects.HomePage;
//import pageObjects.ProductPage;

public class E2E_Tests_steps {
//	WebDriver driver;
//	HomePage homePage;
//	ProductPage productPage;
//	CartPage cartPage;
//	CheckOutPage checkOutPage;
//	PageObjectManager pageObjectManager;
//	WebDriverManager webDriverManager;
	//ConfigFileReader configFileReader;

//	
//	@Given("^user is on home page$")
//	public void user_is_on_home_page() throws Throwable {
//		//configFileReader = new ConfigFileReader();
//		//System.setProperty("webdriver.chrome.driver", FileReaderManager.getInstance().getConfigReader().getDriverPath());
//		//ChromeOptions options  = new ChromeOptions();
//		//options.setBinary(FileReaderManager.getInstance().getConfigReader().getBinaryPath());
//		//options.addArguments("--headless");
//		//DesiredCapabilities capabilities = new DesiredCapabilities();
//		//capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//		//options.merge(capabilities);
//		//driver = new ChromeDriver(options);
//		//driver.manage().window().maximize();
//		//driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitWaitTime(), TimeUnit.SECONDS);
//		webDriverManager = new WebDriverManager(); 
//		driver = webDriverManager.getDriver();
//		pageObjectManager = new PageObjectManager(driver);
//		homePage = pageObjectManager.getHomePage();
//		homePage.navigate_to_homePage();
//	}
//
//	@When("^user searches for \"([^\"]*)\"$")
//	public void user_searches_for(String arg1) throws Throwable {
//		homePage.perform_Search("Dress");
//	}

//	@When("^choose to buy the first item$")
//	public void choose_to_buy_the_first_item() throws Throwable {
//		productPage = pageObjectManager.getProductPage();
//		productPage.select_Product_List(0);
//		productPage.selectColor("White");
//		productPage.selectSize("Medium");	
//	}

//	@When("^moves to checkout from proceed to cart option$")
//	public void moves_to_checkout_from_proceed_to_cart_option() throws Throwable {
//		productPage.clickOn_AddCart();
//		productPage.clickOn_ViewCart();
//		cartPage = pageObjectManager.getCartPage();
//		cartPage.click_ProceedCheckout();
//	}

//	@When("^enter details on checkout page$")
//	public void enter_details_on_checkout_page() throws Throwable {
//		checkOutPage = pageObjectManager.getCheckOutPage();
//		checkOutPage.fill_CheckOutPage();
//		checkOutPage.click_termsConditions();
//	}
//
//	@When("^place the order$")
//	public void place_the_order() throws Throwable {
//		checkOutPage.click_placeOrder();
//	}
//
//	@Then("^Order should be sucessfully placed$")
//	public void order_should_be_sucessfully_placed() throws Throwable {
//		checkOutPage.get_confirm();
//		
//		File img = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(img,new File("C:\\Users\\prasa\\Pictures\\ToolSQA.png"));
//		webDriverManager.closeDriver();
//	}

}
