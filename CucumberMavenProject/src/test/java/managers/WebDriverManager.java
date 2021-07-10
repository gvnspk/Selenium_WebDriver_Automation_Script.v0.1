package managers;

import java.util.concurrent.TimeUnit;
import javax.management.RuntimeErrorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import enums.DriverType;
import enums.EnvironmentType;

public class WebDriverManager {
private WebDriver driver;
private static DriverType driverType;
private static EnvironmentType environmentType;
private static final String CHROME_DRIVER_PROPERTY="webdriver.chrome.driver";

public WebDriver getDriver() {
	if(driver==null) driver = createDriver();
	return driver;
}
public WebDriverManager() {
	driverType = FileReaderManager.getInstance().getConfigReader().getDriverType();
	environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironmentType();
}
public WebDriver createDriver() {
	switch(environmentType) {
	case LOCAL : driver = createLocalDriver();
	break;
	case REMOTE : driver = createRemoteDriver();
	break;
	}
	return driver;
}

private WebDriver createRemoteDriver() {
	throw new RuntimeErrorException(null,"Remote web driver is not yet implemented");
}

private WebDriver createLocalDriver() {
	switch(driverType) {
	case FIREFOX : driver = new FirefoxDriver();
	break;
	case INTERNETEXPLORER :driver = new InternetExplorerDriver();
	break;
	case CHROME :
		System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
		ChromeOptions options = new ChromeOptions();
		options.setBinary(FileReaderManager.getInstance().getConfigReader().getBinaryPath());
		if(FileReaderManager.getInstance().getConfigReader().getHeadlessValue()) {
			options.addArguments("--headless");
		}
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		driver = new ChromeDriver(options);
		if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) {
			driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitWaitTime(), TimeUnit.SECONDS);
	break;
	}
	return driver;
}
public void closeDriver() {
//driver.quit();
driver.close();
}
}

