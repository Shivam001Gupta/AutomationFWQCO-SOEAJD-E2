package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This Class consists Generic method related to property file
 * @author Shivam 
 *
 */

public class propertyFileUtility {
	/**
	 * This method is used for fetch data from properties file
	 * @return value
	 * @throws Throwable
	 */

	public String getDataFromPropertyFile(String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream(IConstants.propertyFilePath);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		

	}

}
