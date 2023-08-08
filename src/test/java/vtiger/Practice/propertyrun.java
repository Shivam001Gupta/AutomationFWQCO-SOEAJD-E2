package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertyrun {

	public static void main(String[] args) throws IOException  {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty("url");
		System.out.println(value);
		
		

	}

}
