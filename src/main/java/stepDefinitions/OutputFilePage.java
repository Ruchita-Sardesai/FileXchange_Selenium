package stepDefinitions;


import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;

import com.testautomation.Utility.WebDriverFactory;
import Listeners.ExtentReportListener;
import ReusabilityMethods.CommonMethods;
import ReusabilityMethods.ExcelDataConfig;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class OutputFilePage extends ExtentReportListener {

	WebDriverFactory webDriverFactory;
	public static WebDriver driver;
	ExcelDataConfig excel=new ExcelDataConfig();
	
	
	public OutputFilePage (WebDriverFactory DriverFactory) throws Exception
	{
		super();
		webDriverFactory = new WebDriverFactory();
	}
	
	 
	@Given("^Login for OutputFile$")
	public void Login_forOutputFile()
	{
		test = extent.createTest(Feature.class,"OutputFile Page feature");							
		test=test.createNode(Scenario.class, "OutputFile Page Scenario");
		ExtentTest logInfo=null;
		try {
			
			  logInfo=test.createNode(new GherkinKeyword("Given"), "Login for OutputFile");
			     
			   WebDriverFactory.OpenBrowser( "chrome", "https://qa.flx.regalpayone.com/login");  //Launching the browser
			   Thread.sleep(3000);
		
				this.driver = webDriverFactory.driver; 

				Thread.sleep(3000);
			/*	driver.findElement(By.xpath("//button[@id='details-button']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
				Thread.sleep(3000); */
				driver.findElement(By.xpath("//button[.='Login']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='Username']")).sendKeys(excel.getData("Credentials", 0, 0));
				driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(excel.getData("Credentials", 0, 1));
				
				
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//button[@value='login']")).click();
				Thread.sleep(3000);
				
				//select the org from the dropdown
				WebElement  element= driver.findElement(By.xpath("//select[@id='ddlOrganizations']"));
				int index=1;
				CommonMethods.SelectValueFromDropDown(element,index);
				Thread.sleep(9000);
				
			
				
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
				Thread.sleep(16000);
				
				Thread.sleep(9000);
		     	logInfo.pass("user is on Home Page");
				logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
							
				
			} 
			
			catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);	
				
			}		
		}	
	
	
	
	@Then("^Verify click on Add OutputFile$")
	public void ClickAddOutputFile()

	{
		ExtentTest logInfo=null;
		try {
			 logInfo=test.createNode(new GherkinKeyword("Then"), "Verify click on Add Output File");
			 
			 //Click on OutputFile Tab
			driver.findElement(By.xpath("//strong[text()='Output Files']")).click();
			Thread.sleep(5000);
			
			//Click on Add Outputfile Button
			driver.findElement(By.xpath("//button[text()='Add Output File']")).click();
			Thread.sleep(5000);
			
			logInfo.pass("user able to click on Add Output File");
			 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
				 
		}
		
		catch(AssertionError | Exception e)
		{testStepHandle("FAIL",driver,logInfo,e);}
		
		
	}
	
	
	@Then("^Verify OutputFile is getting added$")
	public void Verify_AddOutputfile()
	{
		ExtentTest logInfo=null;
		try {
			 logInfo=test.createNode(new GherkinKeyword("Then"), "Verify OutputFile is getting added");
				
			
			//Create OutputFileName and send
			String value1=RandomStringUtils.randomAlphabetic(8);
		 	String OutputFileName= value1 + "Profile";
		 	try {
				excel.write("Sheet1" ,0 ,0 , OutputFileName);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	Thread.sleep(6000); 
		 	
    		logInfo= test.createNode(new GherkinKeyword("Then"), "Add the OutputFile name");
    		
    		driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(OutputFileName);
    		Thread.sleep(5000);
    		   		 
			 
			//Add Description 
            driver.findElement(By.xpath("//input[@formcontrolname='description']")).sendKeys("OFT Description");;
			Thread.sleep(3000);
				
				//Select outputType 
				WebElement  InputFIleTypeSelection= driver.findElement(By.xpath("//select[@formcontrolname='outputType']"));
				int index4=2;
				CommonMethods.SelectValueFromDropDown(InputFIleTypeSelection,index4);
				Thread.sleep(3000);
				
				
				logInfo.pass("User able to fill OutputFile details");
				 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
				 
				//Click on Save
				driver.findElement(By.xpath("//button[text()='Save']")).click();;
				Thread.sleep(5000);
				
				 logInfo.pass("User able to ADD the OutputFile");
				 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
				 
			 
			 
		}
		
		catch(AssertionError | Exception e)
		{testStepHandle("FAIL",driver,logInfo,e);}
		
		
	}

     
	@Then("^Search OutputFile$")
	public void SearchOutputfile()
	{
		ExtentTest logInfo=null;
		try {
			 logInfo=test.createNode(new GherkinKeyword("Then"), "Search OutputFile");
			 
			 //Click on OutputFile Tab
			 
				driver.findElement(By.xpath("//strong[text()='Output Files']")).click();
				Thread.sleep(5000);
		
			 //to search the OutputFile
			 Thread.sleep(5000);
		   
			 driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(excel.ReadDate("Sheet1", 0, 0));
			 //driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("222");
		     Thread.sleep(2000);
		         
		       
				
		}
			catch(AssertionError | Exception e)
			{testStepHandle("FAIL",driver,logInfo,e);}
			
			
		}

	@Then("^Update OutputFile$")
	public void UpdateOutputFile()
	{
		ExtentTest logInfo=null;
		try {
			 logInfo=test.createNode(new GherkinKeyword("Then"), "Verify OutputFile is getting Updated");
				
			 driver.findElement(By.xpath("/html/body/app-root/app-default-layout/app-side-nav/div/div[2]/app-output-file-list/div[4]/mat-table/mat-row[1]/mat-cell[5]/button/span/mat-icon")).click();
		     Thread.sleep(2000);
			 
			
			//click on update 
		     driver.findElement(By.xpath("//span[text()='Update']")).click();
		     Thread.sleep(2000);
		    
    				 
				//Add Description 
	            driver.findElement(By.xpath("//input[@formcontrolname='description']")).sendKeys("OFT update Description");;
				Thread.sleep(3000);
					
					//Select outputType 
					WebElement  InputFIleTypeSelection= driver.findElement(By.xpath("//select[@formcontrolname='outputType']"));
					int index4=3;
					CommonMethods.SelectValueFromDropDown(InputFIleTypeSelection,index4);
					Thread.sleep(3000);
					
						 
					//Click on save 
					driver.findElement(By.xpath("//button[text()='Save']")).click();;
					Thread.sleep(5000);
					

					 logInfo.pass("User able to Update the OutputFile");
					 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
					 
				
						}
			catch(AssertionError | Exception e)
			{testStepHandle("FAIL",driver,logInfo,e);}
			
			
		}


@And("^Manage OutputFile$")
public void ManageOutputFile()
{
	ExtentTest logInfo=null;
	try {
		 logInfo=test.createNode(new GherkinKeyword("And"), "Verify Manage OutputFile");
			
		 driver.findElement(By.xpath("/html/body/app-root/app-default-layout/app-side-nav/div/div[2]/app-output-file-list/div[4]/mat-table/mat-row[1]/mat-cell[5]/button/span/mat-icon")).click();
	     Thread.sleep(2000);
		 
	     //Search file
	     driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(excel.ReadDate("Sheet1", 0, 0));
		 Thread.sleep(2000);
	     
		//click on manage Outputfile 
	     driver.findElement(By.xpath("//span[text()='Manage']")).click();
	     Thread.sleep(2000);
	    
		//click on Add output file field	
	 	driver.findElement(By.xpath("//button[text()='Add output file field']")).click();
		Thread.sleep(5000);
		
	     //Add outputfileFieldName
		 driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Field1_ID");
		 Thread.sleep(3000);
	     
		//Select DataType 
		WebElement  InputFIleTypeSelection= driver.findElement(By.xpath("//select[@formcontrolname='type']"));
		int index4=1;
		CommonMethods.SelectValueFromDropDown(InputFIleTypeSelection,index4);
		Thread.sleep(3000);
	     
		//Add Max Allowed Length
		 driver.findElement(By.xpath("//input[@formcontrolname='maxLength']")).sendKeys("10");
		 Thread.sleep(3000);
	     
	     
	     //Select Mandatory checkBox
		 driver.findElement(By.xpath("//input[@formcontrolname='isMandatory']")).click();
		 Thread.sleep(3000);
		 
		    
		 //Select isFixedWidth checkBox
		 driver.findElement(By.xpath("//input[@formcontrolname='isFixedWidth']")).click();
		 Thread.sleep(3000);
				 
		 //Select isCustomValueAllowed checkBox
		 driver.findElement(By.xpath("//input[@formcontrolname='isCustomValueAllowed']")).click();
		 Thread.sleep(3000);
				 
	    //Select isDefaultValueAllowed checkBox
	    driver.findElement(By.xpath("//input[@formcontrolname='isDefaultValueAllowed']")).click();
		Thread.sleep(3000);	 
			
		logInfo.pass("User able to add OutputFile field");
		 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		 
		 
		//Click on Add OutputFile field
		driver.findElement(By.xpath("//button[text()='Save']")).click();;
		Thread.sleep(5000);
				

				 logInfo.pass("User able to Manage the OutputFile");
				 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
				 
			
	}
		catch(AssertionError | Exception e)
		{testStepHandle("FAIL",driver,logInfo,e);}
		
		
	}

}
	

	