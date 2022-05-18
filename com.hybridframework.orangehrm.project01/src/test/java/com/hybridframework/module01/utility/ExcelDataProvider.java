package com.hybridframework.module01.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook Workbook;
	public ExcelDataProvider(String fname) throws Exception {
		File fls=new File(fname);
		try {
			FileInputStream fins=new FileInputStream(fls);
			Workbook=new XSSFWorkbook(fins);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String getStringCellValue(String Sheetname,int row,int cell) {
		return Workbook.getSheet(Sheetname).getRow(row).getCell(cell).getStringCellValue();
	}
	public String getStringCellValue(int Sheetindex,int row,int cell) {
		return Workbook.getSheetAt(Sheetindex).getRow(row).getCell(cell).getStringCellValue();
	}
	public int getNumericCellValue(String Sheetname,int row,int cell) {
		return (int)Workbook.getSheet(Sheetname).getRow(row).getCell(cell).getNumericCellValue();
	}
	public int getNumericCellValue(int Sheetindex,int row,int cell) {
		return (int)Workbook.getSheetAt(Sheetindex).getRow(row).getCell(cell).getNumericCellValue();
	}
	
	public Object[][] get_Excel_Data(String Sheetname) {
		XSSFSheet Sheet = Workbook.getSheet(Sheetname);
		int RowCount = Sheet.getLastRowNum();
		short CellCount = Sheet.getRow(0).getLastCellNum();		
		System.out.println("total row count:"+RowCount);
		System.out.println("total cell count:"+CellCount);
		
		Object[][] data =new Object[RowCount][CellCount];
				for(int i=0;i<RowCount;i++) {
					for(int j=0;j<CellCount;j++) {
						data[i][j]=Sheet.getRow(i+1).getCell(j).toString();
					}
				}
				return data;	
	}
}
 