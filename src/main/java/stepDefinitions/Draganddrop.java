/*package stepDefinitions;


import static org.testng.Assert.assertEquals;

import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;		

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.sun.xml.bind.Locatable;
import com.testautomation.Utility.WebDriverFactory;
import Listeners.ExtentReportListener;
import ReusabilityMethods.CommonMethods;
import ReusabilityMethods.ExcelDataConfig;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Draganddrop extends ExtentReportListener {

	
	WebDriverFactory webDriverFactory;
	public static WebDriver driver;
	//ExcelDataConfig excel=new ExcelDataConfig("C:\\Users\\ruchi\\FX_Selenium\\FIleXchange\\TestData(2).xlsx");
	ExcelDataConfig excel=new ExcelDataConfig();
	
	
	public Draganddrop (WebDriverFactory DriverFactory) throws Exception
	{
		super();
		webDriverFactory = new WebDriverFactory();
	}
	
	 
	@Given("^Login for Profiles$")
	public void Login_forProfile()
	{
		test = extent.createTest(Feature.class,"Profile Page feature");							
		test=test.createNode(Scenario.class, "Profile Page Scenario");
		ExtentTest logInfo=null;
		try {
			
			//System.setProperty("webdriver.gecko.driver","C:\\Users\\ruchi\\OneDrive\\Desktop\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			//WebDriver driver= new FirefoxDriver();
			
			  logInfo=test.createNode(new GherkinKeyword("Given"), "Login for Profiles");
			 // String baseUrl = "https://qa.flx.regalpayone.com/login"; 
			  //driver.get(baseUrl);
			   WebDriverFactory.OpenBrowser( "Chrome", "https://qa.flx.regalpayone.com/login");  //Launching the browser
			   Thread.sleep(9000);
		
				this.driver = webDriverFactory.driver; 

				/*Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@id='details-button']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
				Thread.sleep(3000); */
		    /*	driver.findElement(By.xpath("//button[.='Login']")).click();
				Thread.sleep(16000);
				driver.findElement(By.xpath("//input[@id='Username']")).sendKeys(excel.getData("Credentials", 0, 0));
				driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(excel.getData("Credentials", 0, 1));
				
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//button[@value='login']")).click();
				Thread.sleep(3000);
				
				//select the org from the dropdown
				WebElement  element= driver.findElement(By.xpath("//select[@id='ddlOrganizations']"));
				int index=1;
				CommonMethods.SelectValueFromDropDown(element,index);
				Thread.sleep(3000);

				//click on submit button
				driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
				Thread.sleep(6000);
				
				//Select Tenant FileXchange
				WebElement  TenantSelection= driver.findElement(By.xpath("//select[@id='ddlCompanies']"));
				int index1=1;
				CommonMethods.SelectValueFromDropDown(TenantSelection,index1);
				Thread.sleep(3000);
				
				//click on submit button
				driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
				Thread.sleep(9000);
				 
		     	logInfo.pass("User is on Home Page");
				logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
							
				
			} 
			
			catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);	
				
			}		
		}	
	
	@Then("^Verify Mapping2$")
	public void VerifyMapping6()
	{
		ExtentTest logInfo=null;
		try {
			
			Thread.sleep(20000);
			Thread.sleep(20000);
			
			WebElement dragFrom = driver.findElement(By.xpath("/html/body/app-root/app-default-layout/app-side-nav/div/div[2]/app-profile-manage/div/div[1]/div[1]/div[1]/app-dynamic-draggable/div/div"));				 
			WebElement dragTo= driver.findElement(By.xpath("//app-dynamic-dropable/div[@id='output1']"));
		
			
		/*	
			var dragAndDrop = require('html-dnd').code;
			var webdriver = require('selenium-webdriver');
			var By = webdriver.By;

			var draggable = driver.findElement(By.id('draggable'));
			var droppable = driver.findElement(By.id('droppable'));

			driver.executeScript(dragAndDrop, draggable, droppable);

			driver.quit();
			*/
			
			
		/*	WebElement dragFrom = driver.findElement(By.xpath("/html/body/app-root/app-default-layout/app-side-nav/div/div[2]/app-profile-manage/div/div[1]/div[1]/div[1]/app-dynamic-draggable/div/div"));				 
			WebElement dragTo= driver.findElement(By.xpath("//app-dynamic-dropable/div[@id='output1']"));
			Thread.sleep(2000);
			
			new Actions(driver).dragAndDropBy(dragFrom, 495, 484).build().perform();
			//int x1=495;
			//int x2 =dragTo.getLocation().getX();
		    //CommonMethods.dragAndDropElement(dragFrom, dragTo, x2);*/

			/*String filePath = "C://Users//ruchi//FX_Selenium//FIleXchange//helper.js";
			  StringBuffer buffer = new StringBuffer();

			  String line;
			  BufferedReader br = new BufferedReader(new FileReader(filePath));
			  while((line = br.readLine())!=null)
			      buffer.append(line);

			  String javaScript = buffer.toString();
			  
			  ((JavascriptExecutor) webDriver).executeScript(getJsDndHelper() + "simulateDragDrop(arguments[0], arguments[1])", sourceElement, destinationElement)
			  javaScript = javaScript +  "simulateDragDrop(arguments[0], arguments[1])", sourceElement, destinationElement);
			// ((JavascriptExecutor)driver).executeScript(javaScript);
		
		   //Drag 1st control to layout
	   /* String js_filepath = "C:\\Users\\ruchi\\FX_Selenium\\FIleXchange\\helper.js";
	    String java_script="";
	    String text;

	    BufferedReader input = new BufferedReader(new FileReader(js_filepath));
	    StringBuffer buffer = new StringBuffer();

	    while ((text = input.readLine()) != null)
	        buffer.append(text + " ");
	        java_script = buffer.toString();

	    input.close();

	    String source = "/html/body/app-root/app-default-layout/app-side-nav/div/div[2]/app-profile-manage/div/div[1]/div[1]/div[1]/app-dynamic-draggable/div/div";
	    String target = "/html/body/app-root/app-default-layout/app-side-nav/div/div[2]/app-profile-manage/div/div[2]/div[1]/div[1]";
	    java_script = java_script+"$('#"+source+"').simulate( '#" +target+ "');" ;
	    ((JavascriptExecutor)driver).executeScript(java_script);*/
		  
	/*			 logInfo.pass("User able to Map the field");
				 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
				
		}
		
		catch(AssertionError | Exception e)
		{testStepHandle("FAIL",driver,logInfo,e);
					}
		
	}
	
	
}






/*
@Then("^Verify Mapping222$")
public void VerifyMapping1()
{
	ExtentTest logInfo=null;
	try {
		
		Thread.sleep(20000);
		Thread.sleep(20000);
		//Thread.sleep(20000);
		Thread.sleep(3000);
		 logInfo=test.createNode(new GherkinKeyword("Then"), "Verify Mapping of Profile");

		//driver.findElement(By.xpath("/html/body/app-root/app-default-layout/app-side-nav/div/div[2]/app-profile-manage/div/div[1]")).click();
		
		//By Byfrom1=By.xpath("/html/body/app-root/app-default-layout/app-side-nav/div/div[2]/app-profile-manage/div/div[1]/div[1]/div[1]/app-dynamic-draggable/div");
		//By ByTo1=By.xpath("/html/body/app-root/app-default-layout/app-side-nav/div/div[2]/app-profile-manage/div/div[2]/div[1]/div[1]");
		 //To this field
		
	   // driver.findElement(By.xpath("/html/body/app-root/app-default-layout/app-side-nav/div/div[2]/app-profile-manage/div/div[2]")).click();
	
		//CommonMethods.dragdrop(Byfrom1, ByTo1);
	    //Actions class method to drag and drop 
		
		 	
		// Code1
	//	 Actions builder = new Actions(driver);
		 //Action dragAndDrop =
		 //builder.clickAndHold(ElementFrom).moveToElement(ElementTo).release(ElementTo).build();
		 //Thread.sleep(2000);
		 //dragAndDrop.perform();
		 
		 //Perform drag and drop
		// Robot r = new Robot();
	     //r.mouseMove(0,0);
		  
		 Robot robot = new Robot();
		  
		  robot.keyPress(KeyEvent.VK_ALT);
          robot.keyPress(KeyEvent.VK_SPACE);
          robot.keyRelease(KeyEvent.VK_SPACE);
          robot.keyRelease(KeyEvent.VK_ALT);
          robot.keyPress(KeyEvent.VK_CAPS_LOCK);
          robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
          Thread.sleep(1000);
          robot.keyPress(KeyEvent.VK_N);
          //robot.keyRelease(KeyEvent.VK_N);
          System.out.println("Minimize");
          
          //driver.findElement(By.xpath("/html/body/app-root/app-default-layout/app-side-nav/div/div[2]/app-profile-manage/div/div[1]/div[1]/div[1]/app-dynamic-draggable/div")).click();
         WebElement from=  driver.findElement(By.xpath("//app-dynamic-draggable/div[@id='input4881']"));
			//WebElement ByFrom = driver.findElement(By.xpath("/html/body/app-root/app-default-layout/app-side-nav/div/div[2]/app-profile-manage/div/div[1]/div[1]/div[1]/app-dynamic-draggable/div"));				 
			System.out.println("Byfrom");
			WebElement to=  driver.findElement(By.xpath("//app-dynamic-dropable/div[@id='output1']")); 
			//WebElement ByTo= driver.findElement(By.xpath("/html/body/app-root/app-default-layout/app-side-nav/div/div[2]/app-profile-manage/div/div[2]/div[1]/div[1]"));
			//System.out.println("Byto");
			
		//Actions builder = new Actions(driver);
		
         new Actions(driver).dragAndDrop(from, to).build().perform();
		  //robot.keyPress(KeyEvent.VK_ESCAPE);
		  //robot.keyRelease(KeyEvent.VK_ESCAPE);
		  
		 
		// Actions builder = new Actions(driver);
		 
		  
		// Code 3
		 
		Thread.sleep(1000);
		//builder.clickAndHold(ByFrom).moveToElement(ByTo).release().build().perform();
		//Thread.sleep(5000);
		
      // builder.dragAndDrop(ByFrom, ByTo).build().perform();
       
       //Thread.sleep(9000);
       //System.out.println("Done");
        //System.out.println("Done");
		  //builder.build();
		 
		 /*code4
		 Point coordinates1 = ElementFrom.getLocation();
		 Point coordinates2 = ElementTo.getLocation();  
		 Robot robot = new Robot();           
		 robot.mouseMove(coordinates1.getX(), coordinates1.getY());
		 //robot.mouseRelease(InputEvent.BUTTON1_MASK);
		 robot.mousePress(InputEvent.BUTTON1_MASK);
		 robot.mouseMove(coordinates2.getX(), coordinates2.getY());
		 robot.mouseRelease(InputEvent.BUTTON1_MASK);
		 Thread.sleep(2000);*/
		 
		// code 7 Actions move = new Actions(driver);
         //move.moveToElement(ElementTo, ElementFrom, );
         //move.build().perform(); 
		 
		 
          //Actions builder=new Actions(driver);
         // builder.moveToElement(driver.findElement(By.xpath("/html/body/app-root/app-default-layout/app-side-nav/div/div[2]/app-profile-manage/div/div[1]/div[1]/div[1]/app-dynamic-draggable/div/div"))).build().perform();
          //Thread.sleep(2000);
	/* WebElement LocatorFrom = driver.findElement(By.xpath("//app-dynamic-draggable/div[@id='input5091']"));
		 
		    WebElement LocatorTo = driver.findElement(By.xpath("//app-dynamic-dropable/div[@id='output1']"));
		    System.out.println("locatorto");
		    String xto=Integer.toString(LocatorTo.getLocation().x);
		    System.out.println("x");
		    String yto=Integer.toString(LocatorTo.getLocation().y);
		    System.out.println("Y");
		    ((JavascriptExecutor)driver).executeScript("function simulate(f,c,d,e){var b,a=null;for(b in eventMatchers)if(eventMatchers[b].test(c)){a=b;break}if(!a)return!1;document.createEvent?(b=document.createEvent(a),a==\"HTMLEvents\"?b.initEvent(c,!0,!0):b.initMouseEvent(c,!0,!0,document.defaultView,0,d,e,d,e,!1,!1,!1,!1,0,null),f.dispatchEvent(b)):(a=document.createEventObject(),a.detail=0,a.screenX=d,a.screenY=e,a.clientX=d,a.clientY=e,a.ctrlKey=!1,a.altKey=!1,a.shiftKey=!1,a.metaKey=!1,a.button=1,f.fireEvent(\"on\"+c,a));return!0} var eventMatchers={HTMLEvents:/^(?:load|unload|abort|error|select|change|submit|reset|focus|blur|resize|scroll)$/,MouseEvents:/^(?:click|dblclick|mouse(?:down|up|over|move|out))$/}; " +
		    "simulate(arguments[0],\"mousedown\",0,0); simulate(arguments[0],\"mousemove\",arguments[1],arguments[2]); simulate(arguments[0],\"mouseup\",arguments[1],arguments[2]); ",
		    LocatorFrom,xto,yto);
		    System.out.println("done");
		   
        
    /*    WebElement source = driver.findElement(By.xpath("//tbody[@class ='lt-body']//tr[@data-test-id='table-row-id-20']//td[contains(@id,'ember')]//div[contains(@id,'ember')]//*[name()='svg']//*[name()='ellipse']"));
        WebElement destination = driver.findElement(By.xpath("//tbody[@class ='lt-body']//tr[@data-test-id='table-row-id-3']//td[contains(@id,'ember')]//div[contains(@id,'ember')]//*[name()='svg']//*[name()='ellipse']"));
*/
      /*  Actions builder = new Actions(driver);
        int x2 =ByFrom.getLocation().getX();
        int y2 = ByTo.getLocation().getY();
        builder.clickAndHold(ByFrom);
        builder.moveByOffset(x2,y2);
        builder.moveToElement(ByTo);
        builder.release();
        builder.perform();
        builder.clickAndHold(ByFrom).moveByOffset(x2,y2).moveToElement(ByTo).release().build().perform();
        System.out.println("done");*/
        /*
       new Actions(driver).moveToElement(source).pause(Duration.ofSeconds(1)).clickAndHold(source).pause(Duration.ofSeconds(1)).moveByOffset(1, 0)
        .moveToElement(destination)
        .moveByOffset(1, 0)
        .pause(Duration.ofSeconds(1))
        .release().perform();
        
		 //.perform();
		 Thread.sleep(5000);
	//	  logInfo.pass("User able to drag and Drop the field");
	//	logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		 //verify text changed in to 'Drop here' box 
		// String textTo = to.getText();
		 
		if(textTo.equals("I")) {
		 System.out.println("PASS: Source is dropped to target as expected");
		 }else {
		 System.out.println("FAIL: Source couldn't be dropped to target as expected");
		 } */
		/*   				
			 logInfo.pass("User able to Map the field");
			 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			
	}
	
	catch(AssertionError | Exception e)
	{testStepHandle("FAIL",driver,logInfo,e);
				}
	
}


}
*/

	
