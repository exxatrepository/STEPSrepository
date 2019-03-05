package automation.ExcelReader;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {
	
	//Get xls data
			public String GetXLSData(String ExcelFilename,String sheet, int row,int col) 
			{
				 try

		         {

		             FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "//resources//DataFile//"+ExcelFilename);
		             Workbook wb = WorkbookFactory.create(fis);

		             Cell cell = wb.getSheet(sheet).getRow(row).getCell(col);
		             
		             //new DataFormatter().formatCellValue(cell);
		             return cell.getStringCellValue().toString();
		       
		             
		         }

		         catch (Exception e)

		         {

		             return "";

		         }

		    }

}
