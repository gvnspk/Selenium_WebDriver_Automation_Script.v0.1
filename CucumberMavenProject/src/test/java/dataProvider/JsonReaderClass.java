package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.management.RuntimeErrorException;

import gherkin.deps.com.google.gson.Gson;
import managers.FileReaderManager;
import testDataTypes.CustomerDetails;

public class JsonReaderClass {
	private final String customerFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath();
	private List<CustomerDetails> customerList;
	
	public JsonReaderClass() {
		customerList = getCustomerData();
	}
	private List<CustomerDetails> getCustomerData(){
		Gson gson = new Gson(); //Gson is used for converting Json to JAVA
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(customerFilePath));
			CustomerDetails[] customers = gson.fromJson(bufferReader, CustomerDetails[].class);
			return Arrays.asList(customers);
		}catch(FileNotFoundException e) {
			throw new RuntimeErrorException(null,"Json file not found at path : "+customerFilePath);
		}finally {
			try {
				if(bufferReader !=null) bufferReader.close();
			}
			catch(IOException ignore) {}
			}
	}
	public final CustomerDetails getCustomerByName(String customerName) {
		for(CustomerDetails customer : customerList) {
			if(customer.firstName.equalsIgnoreCase(customerName)) return customer;
		}
		return null;
		//return customerList.stream().filter(x -> x.firstName.equalsIgnoreCase(customerName)).findAny().get();
	}
}
