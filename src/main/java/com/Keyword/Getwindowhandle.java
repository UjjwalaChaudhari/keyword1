package com.Keyword;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;

public class Getwindowhandle 
{
	public static void Handlewindow()
	{
		Set<String> childwindow=Constant.driver.getWindowHandles();
		System.out.println("get window index");
		ArrayList<String> reqwindow=new ArrayList(childwindow);
		Constant.driver.switchTo().window(reqwindow.get(0));
		System.out.println(childwindow);
	}
}
