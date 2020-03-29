package com.Testcase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Fileutility.PropertiesFile;
import com.Keyword.Constant;
import com.Keyword.Keyword;
public class Test_regression {

	//Open Url with Chrome
		 @BeforeTest
		 public void Tc_01() throws InterruptedException 
		 {
		 Keyword.openBrowser("Chrome"); 
		 Keyword.openurl("https://www.amazon.in");
		 Constant.driver.manage().window().maximize();
		 Constant.driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		 System.out.println("Amazon on Chrome"); 
		 }
	
		 @Test(enabled=true)
		 public void Tc_02() throws IOException, InterruptedException 
		 {
		 Constant.driver.findElement(By.xpath("//*[@id='nav-link-accountList']")).click(); 
		 //Keyword.clickitem(PropertiesFile.getLocator("lgn")[0],PropertiesFile.getLocator("lgn")[1]); 
		 Keyword.enterText(PropertiesFile.getLocator("email")[0],PropertiesFile.getLocator("email")[1],"7083155351");
		 Keyword.clickitem(PropertiesFile.getLocator("continueclick")[0],PropertiesFile.getLocator("continueclick")[1]); 
		 System.out.println("Enter Email/mobile no Successfully ");
		 Keyword.enterText(PropertiesFile.getLocator("pwd")[0],PropertiesFile.getLocator("pwd")[1],"Abc@123");
		 Keyword.clickitem(PropertiesFile.getLocator("sign")[0],PropertiesFile.getLocator("sign")[1]); 
		 System.out.println("Enter password Sucessfully");
		 Thread.sleep(2000);
		 Keyword.capturescreen();
			
		 }
		 
		 //Login in with another browser firefox for parallel testing
		 @Test(enabled=false)
		 public void Tc_03() throws InterruptedException 
		 {
		 Keyword.openBrowser("Firefox"); 
		 Keyword.openurl("https://www.amazon.com");
		 Constant.driver.manage().window().maximize();
		 Constant.driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		 System.out.println("amazon 2");
		 Constant.driver.findElement(By.xpath("//*[@id='nav-link-accountList']")).click(); 
		 Keyword.enterText(PropertiesFile.getLocator("email")[0],PropertiesFile.getLocator("email")[1],"7083155351");
		 Keyword.clickitem(PropertiesFile.getLocator("continueclick")[0],PropertiesFile.getLocator("continueclick")[1]); 
		 System.out.println("Enter Email/mobile no Successfully ");
		 Keyword.enterText(PropertiesFile.getLocator("pwd")[0],PropertiesFile.getLocator("pwd")[1],"Abc@123");
		 Keyword.clickitem(PropertiesFile.getLocator("sign")[0],PropertiesFile.getLocator("sign")[1]); 
		 Keyword.tearDown(); 
		 }
		
		 //Search product1:-Mobile
		 @Test(priority=1)
		 public void Tc_04() 
		 {
			 Keyword.enterText(PropertiesFile.getLocator("product1")[0],PropertiesFile.getLocator("product1")[1],"Mobile");
			 Keyword.clickitem(PropertiesFile.getLocator("searchproduct1")[0],PropertiesFile.getLocator("searchproduct1")[1]); 
			 Keyword.down();
			 try {
				Thread.sleep(2000);
			 	Keyword.takescreenshot();
			 	}
			 catch (InterruptedException | IOException e) 
			 {
				e.printStackTrace();
			}
			 Keyword.up();
			 Keyword.returnhomepage(); 
			 //Keyword.verifyLaunchPage();
		 }
		 
		 @Test(priority=2)
		 public void Tc_05() 
		  { 
			 try {
		  Keyword.clickitem(PropertiesFile.getLocator("todaydeal")[0],PropertiesFile.getLocator("todaydeal")[1]); 
		  Thread.sleep(3000); 
		  Keyword.down();
		  Keyword.capturescreen(); 
		  Thread.sleep(3000); 
		  Keyword.up();
		  Keyword.returnhomepage(); 
		  } 
		  catch (Exception e) { 
		   e.printStackTrace();
		  System.out.println("Error"); 
		  }
		  }
	
		@Test(enabled=false)
		 public void Tc_06()  
		 { 
		  Select book=new Select(Constant.driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
		  book.selectByVisibleText("Amazon Fashion");
		  System.out.println("select Amazon Fashion");
		  Keyword.enterText(PropertiesFile.getLocator("amazondress")[0],PropertiesFile.getLocator("amazondress")[1],"Dresses for Women");
		  Keyword.clickitem(PropertiesFile.getLocator("submit")[0],PropertiesFile.getLocator("submit")[1]); System.out.println("select dress");
		  Keyword.returnhomepage(); 
		 }
		
	
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
	//------------------------------------------------------------------------------------------------	
		 @Test(enabled=false)
		 public void Tc_07() throws IOException 
			{
			 Keyword.clickitem(PropertiesFile.getLocator("buy")[0],PropertiesFile.getLocator("buy")[1]); 
			 Keyword.capturescreen();
			 String ActualTitle =Constant.driver.getTitle();
			 String ExpectedTitle ="Hi, Ujjwala. What can we help you with?";
			 Assert.assertEquals(ActualTitle, ExpectedTitle);
			 System.out.println("Assert passed");
			 }	
		
	  //Closed Browser
	  @AfterTest
	  public void Tc_10() throws InterruptedException 
	  {
	  Keyword.tearDown(); 
	  }

}
