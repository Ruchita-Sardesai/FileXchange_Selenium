/*package stepDefinitions;


import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
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


public class ProfilePage extends ExtentReportListener {

	WebDriverFactory webDriverFactory;
	public static WebDriver driver;
	//ExcelDataConfig excel=new ExcelDataConfig("C:\\Users\\ruchi\\FX_Selenium\\FIleXchange\\TestData(2).xlsx");
	ExcelDataConfig excel=new ExcelDataConfig();
	
	
	/*public ProfilePage (WebDriverFactory DriverFactory) throws Exception
	{
		super();
		webDriverFactory = new WebDriverFactory();
	}*/
	/*
	 
	@Given("^Login for Profiles$")
	public void Login_forProfile()
	{
		test = extent.createTest(Feature.class,"Profile Page feature");							
		test=test.createNode(Scenario.class, "Profile Page Scenario");
		//ExtentTest logInfo=null;
		try {
			
			System.setProperty("webdriver.gecko.driver","C:\\Users\\ruchi\\OneDrive\\Desktop\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			WebDriver driver= new FirefoxDriver();
			
			 // logInfo=test.createNode(new GherkinKeyword("Given"), "Login for Profiles");
			  String baseUrl = "https://qa.flx.regalpayone.com/login"; 
			  driver.get(baseUrl);
			  // WebDriverFactory.OpenBrowser( "IE", "https://qa.flx.regalpayone.com/login");  //Launching the browser
			   Thread.sleep(16000);
		
				//this.driver = webDriverFactory.driver; 

				Thread.sleep(3000);
			/*	driver.findElement(By.xpath("//button[@id='details-button']")).click();
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
				Thread.sleep(9000);
				
				//Select Tenant FileXchange
				WebElement  TenantSelection= driver.findElement(By.xpath("//select[@id='ddlCompanies']"));
				int index1=1;
				CommonMethods.SelectValueFromDropDown(TenantSelection,index1);
				Thread.sleep(3000);
				
				//click on submit button
				driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
				
				Thread.sleep(20000);
				Thread.sleep(16000);
				 Thread.sleep(20000);
				Thread.sleep(16000);
				Thread.sleep(20000);
				//driver.findElement(By.xpath("/html/body/app-root/app-default-layout/app-side-nav/div/div[2]/app-profile-manage/div/div[1]/div[1]/div[1]/app-dynamic-draggable/div")).click();
				Thread.sleep(1000);
				WebElement ByFrom = driver.findElement(By.xpath("/html/body/app-root/app-default-layout/app-side-nav/div/div[2]/app-profile-manage/div/div[1]/div[1]/div[1]/app-dynamic-draggable/div"));				 
				System.out.println("Hello");

			   // driver.findElement(By.xpath("/html/body/app-root/app-default-layout/app-side-nav/div/div[2]/app-profile-manage/div/div[2]")).click();
				//WebElement ByTo= driver.findElement(By.xpath("/html/body/app-root/app-default-layout/app-side-nav/div/div[2]/app-profile-manage/div/div[2]/div[1]/div[1]"));
				System.out.println("Hello");
				//CommonMethods.dragdrop(Byfrom1, ByTo1);
			    //Actions class method to drag and drop 
				//Actions builder = new Actions(driver);

				//new Actions(driver).dragAndDropBy(ByFrom, 4, 8).build().perform();
				
	          /*  int x2 =ByFrom.getLocation().getX();
	            int y2 = ByTo.getLocation().getY();
	            builder.clickAndHold(ByFrom);
	            builder.moveByOffset(x2,y2);
	            builder.moveToElement(ByTo);
	            builder.release();
	            builder.perform();
	            builder.clickAndHold(ByFrom).moveByOffset(x2,y2).moveToElement(ByTo).release().build().perform();
	            System.out.println("done");*/
	        /*    
				Thread.sleep(2000);
			//builder.clickAndHold(ByFrom).moveToElement(ByTo).release().build().perform();
	          // builder.dragAndDrop(ByFrom, ByTo).build().perform();
	           // System.out.println("Done");
				  //builder.build();
		     	
				
			} 
			
			catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,null,e);	
				
			}		
		}	
	
}*/