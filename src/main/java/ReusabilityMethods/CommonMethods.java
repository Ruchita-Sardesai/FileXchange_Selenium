package ReusabilityMethods;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class  CommonMethods  {
	
	static WebElement driver;
	
	public static void performClickOnobject(WebElement element)
	{
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argument[0].click();", " ");
	}
	
	public static void ScrolldownToTheObject(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argument[0].scrollIntoView(true);",element);	
	}


	public static void SelectValueFromDropDown(WebElement element, int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public static void dragdrop(By ByFrom, By ByTo) {
	    WebElement LocatorFrom = driver.findElement(ByFrom);
	    WebElement LocatorTo = driver.findElement(ByTo);
	    String xto=Integer.toString(LocatorTo.getLocation().x);
	    String yto=Integer.toString(LocatorTo.getLocation().y);
	    ((JavascriptExecutor)driver).executeScript("function simulate(f,c,d,e){var b,a=null;for(b in eventMatchers)if(eventMatchers[b].test(c)){a=b;break}if(!a)return!1;document.createEvent?(b=document.createEvent(a),a==\"HTMLEvents\"?b.initEvent(c,!0,!0):b.initMouseEvent(c,!0,!0,document.defaultView,0,d,e,d,e,!1,!1,!1,!1,0,null),f.dispatchEvent(b)):(a=document.createEventObject(),a.detail=0,a.screenX=d,a.screenY=e,a.clientX=d,a.clientY=e,a.ctrlKey=!1,a.altKey=!1,a.shiftKey=!1,a.metaKey=!1,a.button=1,f.fireEvent(\"on\"+c,a));return!0} var eventMatchers={HTMLEvents:/^(?:load|unload|abort|error|select|change|submit|reset|focus|blur|resize|scroll)$/,MouseEvents:/^(?:click|dblclick|mouse(?:down|up|over|move|out))$/}; " +
	    "simulate(arguments[0],\"mousedown\",0,0); simulate(arguments[0],\"mousemove\",arguments[1],arguments[2]); simulate(arguments[0],\"mouseup\",arguments[1],arguments[2]); ",
	    LocatorFrom,xto,yto);
	}
	
/*	
	public static void dragAndDropElement(WebElement dragFrom, WebElement dragTo, int xOffset)
	throws Exception {
	        //Setup robot
	        Robot robot = new Robot();
	        robot.setAutoDelay(50);

	        //Fullscreen page so selenium coordinates work
	        robot.keyPress(KeyEvent.VK_F11);
	        Thread.sleep(2000);

	        //Get size of elements
	        Dimension fromSize = dragFrom.getSize();
	        System.out.println("Byfrom = " +fromSize.getHeight());
	        System.out.println("Byfrom = " +fromSize.getWidth());
	        
	        Dimension toSize = dragTo.getSize();
	        System.out.println("tosize = " +toSize.getHeight());
	        System.out.println("tosize = " +toSize.getWidth());
	        
	        //Get centre distance
	      /*  int xCentreFrom = fromSize.width / 2;
	        int yCentreFrom = fromSize.height / 2;
	        int xCentreTo = toSize.width / 2;
	        int yCentreTo = toSize.height / 2;*/

	  /*      //Get x and y of WebElement to drag to
	        Point toLocation = dragTo.getLocation();
	        System.out.println("tolocation = " +toLocation);
	        Point fromLocation = dragFrom.getLocation();
	        System.out.println("fromLocation = " +fromLocation);
	        
	        //Make Mouse coordinate centre of element
	        //toLocation.x += xOffset + xCentreTo;
	      /*  toLocation.x +=  xCentreTo;
	        toLocation.y += yCentreTo;
	        fromLocation.x += xCentreFrom;
	        fromLocation.y += yCentreFrom;*/

	   /*     //Move mouse to drag from location
	        robot.mouseMove(fromLocation.x, fromLocation.y);
            
	        //Click and drag
	       robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
          
	        //Drag events require more than one movement to register
	        //Just appearing at destination doesn't work so move halfway first
	     /*   robot.mouseMove(((toLocation.x - fromLocation.x) / 2) , ((toLocation.y
	- fromLocation.y) / 2));*/

	       /*robot.mouseMove(((toLocation.x - fromLocation.x) / 2) + fromLocation.x, ((toLocation.y
	        		- fromLocation.y) / 2) + fromLocation.y);*/
	  /*      //Move to final position
	        robot.mouseMove(toLocation.x, toLocation.y);

	        //Drop
	        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	    }

	public static void drag_and_drop(source,target)
	{

	String js_filepath="C:\\Users\\ruchi\\FX_Selenium\\FIleXchange\\drag_and_drop_helper.js";
    StringBuffer buffer = new StringBuffer();
    String line;
	  BufferedReader br = new BufferedReader(new FileReader(js_filepath));
	  while((line = br.readLine())!=null)
	      buffer.append(line);

	  String javaScript = buffer.toString();
	  javaScript = javaScript +  "simulateDragDrop(arguments[0], arguments[1])", sourceElement, destinationElement);
	 ((JavascriptExecutor)driver).executeScript(javaScript);

	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	*/
	
	
	
	

	
	
	

}
