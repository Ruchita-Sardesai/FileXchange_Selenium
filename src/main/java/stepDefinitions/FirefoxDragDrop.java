package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.testautomation.Utility.WebDriverFactory;

import ReusabilityMethods.CommonMethods;
import ReusabilityMethods.ExcelDataConfig;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class FirefoxDragDrop {
	
	WebDriverFactory webDriverFactory;
	public static WebDriver driver;
	ExcelDataConfig excel=new ExcelDataConfig();
	
	@Given("^Login for draganddrop$")
	public void Login_forDND() throws Throwable 
	{
		
		try {
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ruchi\\OneDrive\\Desktop\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		String baseUrl = "https://qa.flx.regalpayone.com/login"; 
		 
		driver.get(baseUrl);
		Thread.sleep(16000);
		
		    driver.findElement(By.xpath("//button[.='Login']")).click();
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
			System.out.println("ByFrom");
			
			// driver.findElement(By.xpath("/html/body/app-root/app-default-layout/app-side-nav/div/div[2]/app-profile-manage/div/div[2]")).click();
			WebElement ByTo= driver.findElement(By.xpath("/html/body/app-root/app-default-layout/app-side-nav/div/div[2]/app-profile-manage/div/div[2]/div[1]/div[1]"));
			System.out.println("ByTo");
			
					    //Actions class method to drag and drop 
						Actions builder = new Actions(driver);

						 
						Thread.sleep(2000);
						// builder.clickAndHold(ByFrom).moveToElement(ByTo).release().build().perform();
			            builder.dragAndDrop(ByFrom, ByTo).build().perform();
			            System.out.println("Done");
						 //builder.build();

			            	
			
		} 
		
		catch (AssertionError | Exception e) {
			System.out.println("Exception");
		throw new PendingException();
		}
			
		}	
	}

