package com.inetbanking.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static String[][] excel(String filepath, String sheetName) throws IOException {
		FileInputStream file = new FileInputStream(new File(filepath));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(1).getLastCellNum();
		String[][] resultArrayString = new String[rowCount][colCount];
 		for (int i = 1; i <= rowCount; i++) {
			Row currentRow = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				String resultString = currentRow.getCell(j).toString();
				resultArrayString[i-1][j] = resultString;
			}
		}
		workbook.close();
		return resultArrayString;
	}


}
