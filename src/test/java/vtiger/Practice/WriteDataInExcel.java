package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class WriteDataInExcel {

	public static void main(String[] args) throws Throwable, IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.createSheet("TrialNow");
		
		Row rw = sh.createRow(4);
		
		Cell ce = rw.createCell(3);
		
		ce.setCellValue("spiderman");
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		wb.write(fos);
		System.out.println("data added");
		
		wb.close();
		
		System.out.println("work book closed");
		
		
		
		
		

	}

}
