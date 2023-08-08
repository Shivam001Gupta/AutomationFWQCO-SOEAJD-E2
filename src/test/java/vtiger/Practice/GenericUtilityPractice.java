package vtiger.Practice;

import GenericUtilities.JavaUtility;
import GenericUtilities.propertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws Throwable {
		JavaUtility jutil = new JavaUtility();
		int value = jutil.getRandomNumber();
		System.out.println(value);
		
		propertyFileUtility putil = new propertyFileUtility();
		String value1 = putil.getDataFromPropertyFile("password");
		System.out.println(value1);
		
		

	}

}
