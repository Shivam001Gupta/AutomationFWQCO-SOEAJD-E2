package GenericUtilities;
import java.sql.Date;
import java.util.Random;

/**
 * This class consists of all generic methods related to java
 * @author Shivam 
 *
 */

public class JavaUtility {

	public int getRandomNumber()
	{
		Random r = new Random();
		int ran = r.nextInt(1000);
		return ran;
				
	}
	
	public String getSystemDateInformat()
	{
		Date d = new Date(0);
		String[] date = d.toString().split(" ");
		String currentDate = date[2];
		String month = date[1];
		String year = date[5];
		String time = date[3].replace(";", "-");
		String dateInFormat = currentDate+"_"+month+"_"+year+"_"+time;
		return dateInFormat;
		
		
	}

}
