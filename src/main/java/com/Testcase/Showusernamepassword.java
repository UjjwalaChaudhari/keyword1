package com.Testcase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Showusernamepassword {
	//Read data from excel and Dispaly it on console	
	
			@Test(dataProvider="Data")
			public void showdata(String uname,String pass) 
			{
				System.out.println("username-"+uname+"passwd--"+pass);
			}
		
	@DataProvider(name="Data")
	public String[][] provider() throws IOException {
		String[][] data=null;
		FileInputStream fis =null; 
		Workbook book = null;
		try {
		fis=new FileInputStream("E:\\JavaProgram\\com.amazonapplication\\src\\main\\resources\\Data.xlsx");
		book=new XSSFWorkbook(fis);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet=(XSSFSheet) book.getSheet("Sheet1");
		int rows = sheet.getLastRowNum();
		Row row=sheet.getRow(0);
		 data= new String[rows][row.getLastCellNum()];
		 for (int i = 1; i <=rows; i++) {
			  row = sheet.getRow(i);
			int cells=row.getLastCellNum();
			for (int j = 0; j <cells; j++) {
				XSSFCell cell =(XSSFCell) row.getCell(j);
				
				DataFormatter d=new DataFormatter();			   
				data[i-1][j]=d.formatCellValue(cell);
			}
		}
		return data;
	}
}
