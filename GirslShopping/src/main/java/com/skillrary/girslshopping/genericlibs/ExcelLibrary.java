package com.skillrary.girslshopping.genericlibs;

import java.io.FileInputStream;
import java.time.LocalDateTime;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {
	public static Workbook workbook;
	
	static {
		try {
			FileInputStream fin = new FileInputStream(IAutoConstants.XL_PATH);
			workbook = WorkbookFactory.create(fin);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getStringData(String sheetName, int row, int cell) {
		return workbook.getSheet(sheetName).getRow(row).getCell(cell).toString();
	}
	
	public static int getIntegerData(String sheetName, int row, int cell) {
		return (int) workbook.getSheet(sheetName).getRow(row).getCell(cell).getNumericCellValue();
	}
	
	public static double getDoubleData(String sheetName, int row, int cell) {
		return workbook.getSheet(sheetName).getRow(row).getCell(cell).getNumericCellValue();
	}
	
	public static boolean getBooleanData(String sheetName, int row, int cell) {
		return workbook.getSheet(sheetName).getRow(row).getCell(cell).getBooleanCellValue();
	}
	
	public static LocalDateTime getDate(String sheetName, int row, int cell) {
		return workbook.getSheet(sheetName).getRow(row).getCell(cell).getLocalDateTimeCellValue();
	}
	
	public static String[][] getMultipleData(String sheetName) {
		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
		String[][] sarr = new String[rowCount-1][cellCount];

		for(int i=1, k=0;i<=rowCount-1;i++, k++) {
			for(int j=0;j<=cellCount-1;j++) {
				sarr[k][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return sarr;
	}
}
