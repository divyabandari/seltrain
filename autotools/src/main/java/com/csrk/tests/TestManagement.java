package com.csrk.tests;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestManagement {

	public final Logger LOG = LoggerFactory.getLogger(TestManagement.class);
	
	WebDriver webDriver; 
	
	@BeforeTest
	public void setup(){
		webDriver = new FirefoxDriver();
	
	}
	
	@AfterTest
	
	public void teardown(){
		
		//webDriver.quit();
		}

    	
    	@Test
    	public void clickManagement(){
    		

    		webDriver.get("http://24.106.206.2:10080/autotools/");
            webDriver.manage().window().maximize();
    		webDriver.findElement(By.id("j_username")).sendKeys("divya@csrk.com");
    	
    		webDriver.findElement(By.id("j_password")).sendKeys("divya33");

    		webDriver.findElement(By.className("checkbox")).click();
    	
    		webDriver.findElement(By.tagName("button")).click();


        WebDriverWait wait =  new WebDriverWait(webDriver,12);
    	WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div/div/div/ul/li[2]/a")));
    
    	List<WebElement> anchors = webDriver.findElements(By.xpath("html/body/div[1]/div/div/div/ul/li[2]/a"));
	LOG.debug("The no of anchors in page:"+anchors.size());
	
	WebElement UserProfileMenu=null;
	
	WebElement testManagement =null;
	
		for(WebElement anchor : anchors){
	LOG.debug("The anchor name is:"+anchor.getText());

                 switch(anchor.getText()){
                 case "Divya Bandari"://this hard coding not good practise
                 break;

                 case "Test Management":
	              testManagement=anchor;
	
	             break;

}	

	testManagement.click();

	//this is test status header test is passed but to inspect teststatus colu im commenimting
	webDriver.findElement(By.linkText("Test Status")).click();
	
WebElement  TestStatusHeader = webDriver.findElement(By.tagName("h1"));// test status header verification
LOG.debug("The content of the h1 tag is"+ TestStatusHeader.getText());

//Assert.assertEquals(TestStatusHeader.getText(),"Test Status");

	
//TestStatus ID-pass


WebElement TestStatusID =webDriver.findElement(By.className("number"));

LOG.debug("The content of className is"+TestStatusID.getText());
		
		Assert.assertEquals(TestStatusID.getText(),"Test Status ID");
		
	
		
  //test description -passwed
	WebDriverWait wait1 =  new WebDriverWait(webDriver,29);
	WebElement element1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/table/thead/tr/th[2]")));
    
	List<WebElement> tagheaders = webDriver.findElements(By.xpath("html/body/div[2]/table/thead/tr/th[2]"));
LOG.debug("The no of th in page:"+tagheaders.size());

WebElement TestStatusID1=null;

WebElement TestDescription =null;

	for(WebElement th2 : tagheaders){
LOG.debug("The anchor name is:"+th2.getText());

             switch(th2.getText()){
             case "Test Status ID"://this hard coding not good practise
             break;

             case "Test Description":
              TestDescription=th2;

             break;

             }

TestDescription.click();
 



   
/*
 
  int rowCount =webDriver.findElements(By.tagName("td")).size();
  System.out.println("Row count:"+rowCount);
int columncnt = webDriver.findElements(By.tagName("th")).size();
System.out.println("Column count:"+columncnt);

*/

//clicked on 1st start button 
          WebElement Start=	webDriver.findElement(By.tagName("button"));
          Start.click();

//latestReportLink -passed 
          webDriver.findElement(By.partialLinkText("Latest ReportLink")).click();

//LatestReportHeader-text displayed -passed

          WebElement     TestRunReportHeader     =	webDriver.findElement(By.tagName("b"));
          LOG.debug("The content of the b tag is"+ TestRunReportHeader.getText());
          Assert.assertEquals(TestRunReportHeader.getText(),"Test Run Report.");

            


	}
    	}


    	}
    	
		
	
	
	}

	
		
	
	
		


    	
