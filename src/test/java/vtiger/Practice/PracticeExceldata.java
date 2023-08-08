package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.IConstants;

public class PracticeExceldata {

	public static void main(String[] args) throws Throwable, IOException {
		 ExcelFileUtility eutil = new ExcelFileUtility();
		 String val = eutil.readDataFromExcel("2");
		 System.out.println(val);
		
		
		

	}

}
