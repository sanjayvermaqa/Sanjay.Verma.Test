package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentProperties {

    /**
     * This method is used to get the current environment name.
     */
	public String getCurrentEnvironmentName() throws Exception {
		Properties propMainEnvFile = new Properties();
		InputStream inputStreamMain = new FileInputStream(GenericFunctions.resourcePathHelper()+"environment.Properties/");
		try {
			propMainEnvFile.load(inputStreamMain);
		} catch(FileNotFoundException e) {
			System.out.println("Environment Properties File - env.properties Not Found");
		} catch(IOException e) {
			System.out.println("Error while Opening env.properties file");
		}

		String currentEnvironment = propMainEnvFile.getProperty("environment.to.be.used");
		propMainEnvFile.setProperty("environment.to.be.used", currentEnvironment);
		return currentEnvironment;
	}

    /**
     * This method is used to get the property file for the current
     * environment and look for key value
     * @param key - This is the input parameter whose value need to be
     *            reached in property file
     * @return String - This returns the strung value of searched key.
     */
	public String getProperty(String key) throws Exception {
		String currentEnvironment = getCurrentEnvironmentName()+".properties";
				
		//Use the current environment property file to get environment specific data
		Properties properties = new Properties();
		InputStream inputStream = new FileInputStream(GenericFunctions.resourcePathHelper()+currentEnvironment);
		try {
			properties.load(inputStream);
			inputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Environment Properties File - " + currentEnvironment + " Not Found");
		} catch (IOException e) {
			System.out.println("Error while Opening " + currentEnvironment + " file");
		}
		
		String value = properties.getProperty(key);
		return value;
	}
}
