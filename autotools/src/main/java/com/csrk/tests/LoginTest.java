package com.csrk.tests;


import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class LoginTest {
	public static final Logger LOG = LoggerFactory.getLogger(LoginTest.class);
	
	WebDriver webDriver; 
	
	@BeforeTest
	public void setup(){
		webDriver = new FirefoxDriver();
	
	}
	
@AfterTest
	
	public void teardown(){
		
		webDriver.quit();
		}
		
		
	
	@Test
	public void testValidLogin(){

		webDriver.get("http://24.106.206.2:10080/autotools/");
        webDriver.manage().window().maximize();
		webDriver.findElement(By.id("j_username")).sendKeys("divya@csrk.com");
	
		webDriver.findElement(By.id("j_password")).sendKeys("divya33");

		webDriver.findElement(By.className("checkbox")).click();
	
		webDriver.findElement(By.tagName("button")).click();
		
	
    WebDriverWait wait = new WebDriverWait(webDriver,15);
    	WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("p")));
    	
        Assert.assertNotNull(element);

        List<WebElement> anchorList = webDriver.findElements(By.tagName("a"));
        LOG.debug("Total number of anchors"+anchorList.size());


	}
}
       