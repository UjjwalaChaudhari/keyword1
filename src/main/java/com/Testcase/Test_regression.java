package com.Testcase;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Fileutility.Log;
import com.Fileutility.PropertiesFile;
import com.Keyword.Constant;
import com.Keyword.Customerservice;
import com.Keyword.Getwindowhandle;
import com.Keyword.Keyword;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Test_regression {
	
	static ExtentTest test;
	static ExtentReports report;
	@BeforeClass
	public static void startTest()
	{
	report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
	test = report.startTest("ExtentDemo");
	}
	//Open Url with Chrome
	@BeforeTest
		 public void Tc_01() throws InterruptedException, IOException 
		 {
		 Log.info("Amazon");
		 PropertyConfigurator.configure("E:\\JavaProgram\\com.amazonapplication\\src\\main\\resources\\log4j.properties");
 
   		 Keyword.openBrowser("Chrome"); 
		 Keyword.openurl("https://www.amazon.in");
		 Log.info("Browser Opened");
		 
		 Constant.driver.manage().window().maximize();
		 Constant.driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		 System.out.println("Amazon on Chrome"); 
		 Log.info("Amazon Open");
		 if(Constant.driver.getTitle().equals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"))
		 {
		 System.out.println(" "+Constant.driver.getTitle());
		 //test.log(LogStatus.PASS, "Navigated to the specified URL");
		 }
		 else
		 {
		 //test.log(LogStatus.FAIL, "Test Failed");
		 test.log(LogStatus.FAIL,test.addScreenCapture(Keyword.capture(Constant.driver))+ "Test Failed");
		 }
		 }
		
		@Test(priority=1)
		 public void Signclick()
		 {
			 Keyword.clickitem(PropertiesFile.getLocator("lgn")[0],PropertiesFile.getLocator("lgn")[1]); 
		 }
		 @Test(priority=2)
		 public void Tc_02() throws IOException, InterruptedException 
		 {
		 //Constant.driver.findElement(By.xpath("//*[@id='nav-link-accountList']")).click(); 
		 Keyword.enterText(PropertiesFile.getLocator("email")[0],PropertiesFile.getLocator("email")[1],"7083155351");
		 Keyword.clickitem(PropertiesFile.getLocator("continueclick")[0],PropertiesFile.getLocator("continueclick")[1]); 
		 Log.info("Username enter Successfully"); 
		 //Log.error("Username Incorrect");
		 System.out.println("Enter Email/mobile no Successfully ");
		 Keyword.enterText(PropertiesFile.getLocator("pwd")[0],PropertiesFile.getLocator("pwd")[1],"Abc@123");
		 Log.info("Password enter Successfully"); 
		 //Log.error("Password Incorrect");
		 Keyword.clickitem(PropertiesFile.getLocator("sign")[0],PropertiesFile.getLocator("sign")[1]); 
		 System.out.println("Login Sucessfully....");
		 Log.info("Login Sucessfully"); 
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
		 //Constant.driver.findElement(By.xpath("//*[@id='nav-link-accountList']")).click(); 
		 Keyword.clickitem(PropertiesFile.getLocator("lgn")[0],PropertiesFile.getLocator("lgn")[1]); 
		 Keyword.enterText(PropertiesFile.getLocator("email")[0],PropertiesFile.getLocator("email")[1],"7083155351");
		 Keyword.clickitem(PropertiesFile.getLocator("continueclick")[0],PropertiesFile.getLocator("continueclick")[1]); 
		 System.out.println("Enter Email/mobile no Successfully ");
		 Keyword.enterText(PropertiesFile.getLocator("pwd")[0],PropertiesFile.getLocator("pwd")[1],"Abc@123");
		 Keyword.clickitem(PropertiesFile.getLocator("sign")[0],PropertiesFile.getLocator("sign")[1]); 
		 Keyword.tearDown(); 
		 }
		
		 //Search product1:-Mobile
		 @Test(enabled=false)
		 public void Tc_04() throws Exception 
		 {
			 Keyword.enterText(PropertiesFile.getLocator("product1")[0],PropertiesFile.getLocator("product1")[1],"Grocery items");
			 Keyword.clickitem(PropertiesFile.getLocator("searchproduct1")[0],PropertiesFile.getLocator("searchproduct1")[1]); 
			 WebDriverWait wait=new WebDriverWait(Constant.driver,2);
			 Assert.assertTrue(Constant.driver.getTitle().equals("Amazon.in: Grocery items"));
			 System.out.println(Constant.driver.getTitle());
			 
			 Constant.driver.findElement(By.xpath("//img[@alt='Maggi 2-Minute Noodles Masala, 70g (Pack of 12)']")).click();
		     System.out.println("items dispaly");
		     Assert.assertTrue(Constant.driver.getTitle().equals("Amazon.in: Grocery items"));
			 System.out.println(" "+Constant.driver.getTitle());
			  //Constant.driver.findElement(By.xpath("//i[@class='a-icon a-icon-cart']")).click();
			  //Getwindowhandle.Handlewindow();
			     
			  //Keyword.takescreenshot(); 
		      //Keyword.down(); //Keyword.up();
		    //Constant.driver.findElement(By.xpath("//a[@class='nav-logo-link']")).click();
		    //System.out.println("Return home");
		      //Keyword.returnpage(); 
			
		 }
		 
		 @Test(enabled=false)
		 public void Tc_05() 
		  { 
			 try {
		  Keyword.clickitem(PropertiesFile.getLocator("todaydeal")[0],PropertiesFile.getLocator("todaydeal")[1]); 
		  Thread.sleep(3000); 
		  Keyword.down();
		  Keyword.capturescreen(); 
		  Thread.sleep(3000); 
		  Keyword.up();
		  Keyword.returnpage(); 
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
		  Keyword.clickitem(PropertiesFile.getLocator("submit")[0],PropertiesFile.getLocator("submit")[1]);
		  System.out.println("select dress");
		  Keyword.returnpage(); 
		 }
		
	
	//------------------------------------------------------------------------------------------------	
		@Test(enabled=false)
		public void Tc_09() 		 {
		 Keyword.clickitem(PropertiesFile.getLocator("amazonpay")[0],PropertiesFile.getLocator("amazonpay")[1]); 
		 Assert.assertTrue(Constant.driver.getTitle().equals(""));
		 System.out.println(Constant.driver.getTitle());
		 }
		
	//---------------------------------------------------------------------------------------------------------------------------	
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
		
	//-------------------------------------------------------------------------------------------------
		//Customer Service page
		 @Test(enabled=false)
		 public void Tc_08() throws IOException, InterruptedException 
			{
			 Customerservice.customer();
			 Customerservice.customerpage1();
			 Customerservice.customerpage2(); 
			 Thread.sleep(3000);
			 Customerservice.customerpage3(); 
			 Customerservice.customerpage4();
			 Keyword.returnpage();
			 String ActualTitle =Constant.driver.getTitle(); 
			 String ExpectedTitle ="Your Account"; 
			 Assert.assertEquals(ActualTitle,ExpectedTitle); 
			 System.out.println("Assert passed");
		 
			 }
	//Closed Browser
	  @Test(enabled=false)
	  public void Tc_10() throws InterruptedException 
	  {
	  Keyword.tearDown(); 
	  }

}
