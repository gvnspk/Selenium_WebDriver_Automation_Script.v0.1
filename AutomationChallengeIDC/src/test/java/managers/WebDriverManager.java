package managers;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import dataProvider.ConfigFileReader;
import enums.DriverType;

public class WebDriverManager {
	private static ConfigFileReader configFileReader = new ConfigFileReader() ;
	private WebDriver driver;
	private static DriverType driverType;
	private static final String CHROME_DRIVER_PROPERTY="webdriver.chrome.driver";

	public WebDriverManager() {
		driverType = configFileReader.getDriverType();
	}

	public WebDriver getDriver() {
		if(driver==null) driver = createLocalDriver();
		return driver;
	}

	private WebDriver createLocalDriver() {
		switch(driverType) {
		case FIREFOX : driver = new FirefoxDriver();
		break;
		case INTERNETEXPLORER :driver = new InternetExplorerDriver();
		break;
		case CHROME :
			System.setProperty(CHROME_DRIVER_PROPERTY, configFileReader.getDriverPath());
			ChromeOptions options = new ChromeOptions();
			options.setBinary(configFileReader.getBinaryPath());
			if(configFileReader.getHeadlessValue()) {
				options.addArguments("--headless");
			}
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(capabilities);
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			if(configFileReader.getBrowserWindowSize()) {
				driver.manage().window().maximize();
			}
			driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitWaitTime(), TimeUnit.SECONDS);
			break;
		}
		return driver;
	}
	public void closeDriver() {
		//driver.quit();
		driver.close();
	}
	public void takeScreenshot(String screenshotName) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("C:\\Users\\prasa\\eclipse-workspace\\AutomationChallengeIDC\\screenshots\\"+screenshotName+".png"));
	}
}


