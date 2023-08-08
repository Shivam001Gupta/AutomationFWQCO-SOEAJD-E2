package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	public void readDataFromExcel(String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet2");
		Row rw = sh.getRow(1);
		Cell cl = rw.getCell(1);
		cl.setCellValue(data);
		
		
		
		
		
		
		
	}

	
	

}
