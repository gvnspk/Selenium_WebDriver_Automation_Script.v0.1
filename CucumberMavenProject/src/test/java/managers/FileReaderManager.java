package managers;

import dataProvider.ConfigFileReader;
import dataProvider.JsonReaderClass;

public class FileReaderManager {
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
	private static JsonReaderClass jsonReaderClass;
	
	private FileReaderManager() {
		
	}
	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}
	public ConfigFileReader getConfigReader() {
		return(configFileReader==null) ? new ConfigFileReader():configFileReader;
	}
	public JsonReaderClass getJsonReader() {
		return(jsonReaderClass==null) ? new JsonReaderClass() : jsonReaderClass;
	}
}
