package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.management.RuntimeErrorException;

import enums.DriverType;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "C:\\Users\\prasa\\eclipse-workspace\\AutomationChallengeIDC\\configs\\configuration.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeErrorException(null, "Configuration file is not present at" + propertyFilePath);
		}
	}

	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!=null) {
			return driverPath;
		}
		else throw new RuntimeErrorException(null, "Driver Path not specified in the Configuration.properties file");
	}

	public String getBinaryPath() {
		String binaryPath = properties.getProperty("binaryPath");
		if(binaryPath!=null) {
			return binaryPath;
		}
		else throw new RuntimeErrorException(null,"Binary Path not specified in the Configuration.properties file");

	}

	public String getURL() {
		String url =  properties.getProperty("url");
		if(url!=null) {
			return url;
		}
		else throw new RuntimeErrorException(null,"url not specified in the Configuration.properties file");
	}	

	public long getImplicitWaitTime() {
		String implicitWaitTime = properties.getProperty("implicitWaitTime");
		if(implicitWaitTime!=null) {
			return Long.parseLong(implicitWaitTime);
		}
		else throw new RuntimeErrorException(null,"Implicit Wait Time not specified in the Configuration.properties file");
	}

	public boolean getBrowserWindowSize() {
		String windowSize=properties.getProperty("windowMaximum");
		if(windowSize!=null) return Boolean.valueOf(windowSize);
		else { return true;
		}
	}

	public DriverType getDriverType() {
		String browserName = properties.getProperty("browser");
		if(browserName==null||browserName.equalsIgnoreCase("chrome")) 
			return DriverType.CHROME;
		else if (browserName.equalsIgnoreCase("firefox")) 
			return DriverType.FIREFOX;
		else if (browserName.equalsIgnoreCase("internetExplorer")) 
			return DriverType.INTERNETEXPLORER;
		else throw new RuntimeErrorException(null,"Driver Type not specified in the Configuration.properties file");
	}

	public boolean getHeadlessValue() {
		String headless = properties.getProperty("headless");
		if(headless != null) return Boolean.valueOf(headless);
		else return false;
	}

}
