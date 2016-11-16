package com.csrk.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonTest {

public static void main (String[]args) {
	
	String browser="Mozilla"; //here both chrome and mozilla re implementing this interface
	WebDriver driver=null;
	if(browser.equals("Mozilla")){
		driver=new FirefoxDriver();
	}
		else if(browser.equals("chrome")){
			System.setProperty("webdriver.driver.chrome","C://Drivers//chromedriver.exe");		}
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
}	
	
//driver.manage().window().maximize();	{
	

}