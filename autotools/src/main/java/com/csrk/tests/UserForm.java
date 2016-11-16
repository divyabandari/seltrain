package com.csrk.tests;


	  



	import org.openqa.selenium.By;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	//import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	//import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class UserForm{
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
		public void testUserForm(){

			webDriver.get("http://24.106.206.2:10080/autotools/");
	       // webDriver.manage().window().maximize();
			webDriver.findElement(By.id("j_username")).sendKeys("divya@csrk.com");
		
			webDriver.findElement(By.id("j_password")).sendKeys("divya33");

			webDriver.findElement(By.className("checkbox")).click();
		
			webDriver.findElement(By.tagName("button")).click();
			
		
	    	WebDriverWait wait = new WebDriverWait(webDriver,15);
	    	WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("p")));
	    	
	Assert.assertNotNull(element);

	  String text= webDriver.findElement(By.className("brand")).getAttribute("href");
	  System.out.println(text);

	  
	webDriver.findElement(By.className("dropdown-toggle")).click(); //username dropdon


	webDriver.findElement(By.linkText("My Profile")).click();//opened userform page

	WebElement  UserFormHeader = webDriver.findElement(By.tagName("h1"));// user form header verification

	LOG.debug("The content of the h1 tag is"+ UserFormHeader.getText());

	Assert.assertEquals(UserFormHeader.getText(),"User Form");

	WebElement FirstNameMan =webDriver.findElement(By.className("control-label"));

	LOG.debug("The content of control-label is"+"First Name");

	Assert.assertEquals(FirstNameMan.getText(), "First Name");
		
	 // tets pas -skippin F/N
	    webDriver.findElement(By.id("user.firstName")).clear();//error message is displayed
		webDriver.findElement(By.className("btn-primary")).click();
		//clicking save button
		

		
		//test pased
			
			webDriver.findElement(By.id("user.firstName")).sendKeys("divya");
		    webDriver.findElement(By.className("btn-primary")).click();           
			

		//skipin L/N and clic sign button-test passed
		
		webDriver.findElement(By.className("control-label"));
		
		webDriver.findElement(By.id("user.lastName"));
		
		//LOG.debug("The content of control-label is"+"Last Name");
		
//		Assert.assertEquals(LastNameMan.getText(), "Last Name");
		
		webDriver.findElement(By.id("user.lastName")).clear();  
		
		webDriver.findElement(By.className("btn-primary")).click();  
		
		//sending keys in L/N
		
		webDriver.findElement(By.id("user.lastName")).sendKeys("Bandari");
		
		
		
		//skippin title field
		
		webDriver.findElement(By.className("control-label"));
		webDriver.findElement(By.id("user.title")).clear();
		webDriver.findElement(By.className("btn-primary")).click();

		
		//skippin org field
		
		webDriver.findElement(By.className("control-label"));
		
		webDriver.findElement(By.id("user.organization")).sendKeys("Org");
		//webDriver.findElement(By.id("user.organization")).clear();
		webDriver.findElement(By.xpath(".//*[@id='userAndPassword']/div[8]/button")).click();

		
		//it is not a man firld the page is save dsuceess if the org field is skipped
		webDriver.findElement(By.id("user.organization")).clear();
		
	//here html locate is showing invalid selector thats y i used xpath 	
		//webDriver.findElement(By.className("btn btn-primary")).click();;
		webDriver.findElement(By.xpath(".//*[@id='userAndPassword']/div[8]/button")).click();


		}
}
