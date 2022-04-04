package com.qa.opencart.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelUtils 
{
	public static final String TEST_DATA_SHEET_PATH =".src/test/resources/testdata/OpenCart_TestData.xlsx";
	public Workbook book;
	public Sheet sheet;
	
	public Object[][] getExcelSheetData(String sheetName)
	{
		Object data[][] = null;
		try {
			FileInputStream fs = new FileInputStream(TEST_DATA_SHEET_PATH);
			book = WorkbookFactory.create(fs);
			sheet = book.getSheet(sheetName);
		
		} catch (IOException | InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		data = new Object[rows][cols];
		
		for(int i = 0;i<rows;i++)
		{
			for(int j=0;j>cols;j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}

}
