package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil1 {

	private static Workbook book;
	private static Sheet sheet;
	private static String TEST_DATA_SHEET_PATH = "./src/main/java/com/qa/hubspot/testdata/LoginTestdata.xlsx";

	public static Object[][] getTestData(String sheetName) {

		Object data[][] = null;

		try {
			FileInputStream ip = new FileInputStream(TEST_DATA_SHEET_PATH);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);

			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

			for (int i = 0; i < sheet.getLastRowNum(); i++) {

				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					 switch (sheet.getRow(1).getCell(j).getCellType()) {
		               case Cell.CELL_TYPE_NUMERIC:
		                   // Call 'getNumericCellValue()' here instead of using just 'getCell()'
		                   data[i][j] = sheet.getRow(1).getCell(j).getNumericCellValue();
		                   break;
		               case Cell.CELL_TYPE_STRING:
		                   // Call 'getStringCellValue()' here instead of using just 'getCell()'
		                   data[i][j] = sheet.getRow(1).getCell(j).getStringCellValue().trim();
		                   break;
		            }
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;

	}

}
