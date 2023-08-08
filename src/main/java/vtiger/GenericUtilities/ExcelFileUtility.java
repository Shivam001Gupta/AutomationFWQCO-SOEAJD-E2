package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	public String getDataFromExcel(String data, int a, int b) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(data);
		Row rw = sh.getRow(a);
		Cell cl = rw.getCell(b);
		data = cl.getStringCellValue();
        return data;
        
        
	}

        
       public Object [][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException
       { 
    	   FileInputStream fis = new FileInputStream(IConstants.excelFilePath);
    	   Workbook wb = WorkbookFactory.create(fis);
    	   Sheet sh = wb.getSheet(sheetName);
    	   int lastRow = sh.getLastRowNum();
    	   int lastcel = sh.getRow(0).getLastCellNum();
    	   
    	   Object[][] data  = new Object [lastRow] [lastcel];
    	   
    	   for(int i=0;i<lastRow;i++)
    	   {
    		   for (int j=0;j<lastcel;j++)
    		   {
    			   data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
    		   }
    	   }
    		   
    	   
        	return data;
        	
        }
		
        

//		
//	
//		cl.setCellValue(data);
		
		
      

	
		
		
		
		
		
	}

	
	


