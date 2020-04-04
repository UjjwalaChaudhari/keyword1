package com.Keyword;

import java.io.FileReader;
import java.util.NoSuchElementException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Fileutility.PropertiesFile;
public class Customerservice
{
	public static void customer()
	{
		Keyword.clickitem(PropertiesFile.getLocator("customer")[0],PropertiesFile.getLocator("customer")[1]); 
		System.out.println("Clicked Customer Service");
	}
	public static void loginviacustomerservice() throws InterruptedException
	{
		Keyword.enterText(PropertiesFile.getLocator("email")[0],PropertiesFile.getLocator("email")[1],"7083155351");
		Keyword.clickitem(PropertiesFile.getLocator("continueclick")[0],PropertiesFile.getLocator("continueclick")[1]); 
		System.out.println("Enter Email/mobile no Successfully ");
		Keyword.enterText(PropertiesFile.getLocator("pwd")[0],PropertiesFile.getLocator("pwd")[1],"Abc@123");
		Keyword.clickitem(PropertiesFile.getLocator("sign")[0],PropertiesFile.getLocator("sign")[1]); 
		Thread.sleep(3000);
		System.out.println("Enter password Sucessfully");
		}
	
	public static void customerpage1() {
	JavascriptExecutor js=(JavascriptExecutor)Constant.driver;
	js.executeScript("window.scrollBy(0,700)");
	try
    {
	JSONParser parser = new JSONParser();
	Object obj = parser.parse(new FileReader("E:\\JavaProgram\\com.amazonapplication\\src\\main\\resources\\Helptopics.json"));
	JSONObject uj=(JSONObject)obj;
	JSONArray unit = (JSONArray)uj.get("Recommended Topics");
	//System.out.println(unit+"\n");
	 for(int i=0;i<unit.size();i++) 
	 {
		 System.out.println(unit.get(i));
	 }
	 Thread.sleep(3000);
     Assert.assertTrue(Keyword.verifyTextPresent("Browser"));
     System.out.println("Assert true");
   }
   catch (Exception e)
   {
   e.printStackTrace();	
   }
   }
	public static void customerpage2() throws InterruptedException //Search as Order  
	{
		Keyword.enterText(PropertiesFile.getLocator("order")[0],PropertiesFile.getLocator("order")[1],"Order");   
		Keyword.clickitem(PropertiesFile.getLocator("go")[0],PropertiesFile.getLocator("go")[1]); 
		Thread.sleep(2000);
		System.out.println("Clicked searchbox as Order ");
		Keyword.clickitem(PropertiesFile.getLocator("backcustomerservice")[0],PropertiesFile.getLocator("backcustomerservice")[1]); 
	}
	public static void customerpage3() throws InterruptedException //Yours Orders 
	{
		Keyword.clickitem(PropertiesFile.getLocator("yourorder")[0],PropertiesFile.getLocator("yourorder")[1]);
		loginviacustomerservice();
		Thread.sleep(2000);
		System.out.println("Clicked on Your Order");
		Keyword.clickitem(PropertiesFile.getLocator("backcustomerservice1")[0],PropertiesFile.getLocator("backcustomerservice1")[1]); 
	 }
	public static void customerpage4() throws InterruptedException //payment setting
	{
		Keyword.clickitem(PropertiesFile.getLocator("paymentsetting")[0],PropertiesFile.getLocator("paymentsetting")[1]); 
		Thread.sleep(2000);
		System.out.println("Clicked on payment setting");
		
	}
}
