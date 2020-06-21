package com.health.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datafromexcel {
	XSSFWorkbook wb;
	
	public datafromexcel() throws Exception
	{
		File src=new File("C:\\Users\\user\\workspace\\Splitbilling340B\\TestData\\Logincredentials.xlsx");
		FileInputStream fis=new FileInputStream(src);
		wb=new XSSFWorkbook(fis);
	}
	
	public String datainstring(int sheetindex, int row,int col)
	{
		
		return wb.getSheetAt(sheetindex).getRow(row).getCell(col).getStringCellValue();
	}
	public String datainstring(String sheetname, int row,int col)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
	}
	public double datainnumeric(String sheetname,int row,int col)
	{
	return wb.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
	}
}
