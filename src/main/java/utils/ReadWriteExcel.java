package utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcel {
	
	XSSFWorkbook workBook;
	XSSFSheet workSheet;
	XSSFCell workCell;
	
	void readExcel() {
	String path = "D:\\eclipse_workspace\\SeleniumFramework\\src\\test\\resources\\TestData.xlsx";
	String sheetName = "Sheet1";
	
	try {
		FileInputStream excelFile = new FileInputStream(path);
		workBook = new XSSFWorkbook(excelFile);
		workSheet = workBook.getSheet(sheetName);
		
		workCell = workSheet.getRow(1).getCell(1);
		String cellData = workCell.getStringCellValue();
		System.out.println(cellData);
	} catch(Exception e) {
		e.printStackTrace();
	}
	}
}
