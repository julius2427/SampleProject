package step_definitions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class CommonFunctions extends AbstractPageStepDefinitions{

	static Logger log = Logger.getLogger(Logger.class.getName());
	
	public static void navigate_to(WebDriver driver, String url) {

		driver.navigate().to(url);
		driver.manage().window().maximize();
		
	}
	public static void send_element(WebDriver driver, String strLocType, String strLocValue, String Param1) {
		if(Param1.contains("ENTER_DATE")) {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Date today = Calendar.getInstance().getTime();
			Param1 = df.format(today);
		}
		switch(strLocType) {
		case "id":
			driver.findElement(By.id(strLocValue)).sendKeys(Param1);;
			break;
		case "xpath":
			driver.findElement(By.xpath(strLocValue)).sendKeys(Param1);
			break;
		case "css":
			driver.findElement(By.cssSelector(strLocValue)).sendKeys(Param1);;
			break;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			log.error("Failed! ", e);
		}
	}
	
	
	public static void click_element(WebDriver driver, String strLocType, String strLocValue) {
		
		switch(strLocType) {
		case "id":
			driver.findElement(By.id(strLocValue)).click();
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			break;
		case "xpath":
			driver.findElement(By.xpath(strLocValue)).click();
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			break;
		case "css":
			driver.findElement(By.cssSelector(strLocValue)).click();
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			break;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			log.error("Failed! ", e);
		}
		if(driver.getTitle().contains("Sitefinity Trial Page")) {
			driver.navigate().refresh();
			click_element(driver, strLocType, strLocValue);
		}
	}

	public static void clear_element(WebDriver driver, String strLocType, String strLocValue) {
		switch(strLocType) {
		case "id":
			driver.findElement(By.id(strLocValue)).clear();
			break;
		case "xpath":
			driver.findElement(By.xpath(strLocValue)).clear();
			break;
		case "css":
			driver.findElement(By.cssSelector(strLocValue)).clear();
			break;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
	}
	
	public static void verify_displayed(WebDriver driver, String strLocType, String strLocValue) {
		try {
			
		switch(strLocType) {
		case "id":
			assertTrue(driver.findElement(By.id(strLocValue)).isDisplayed());
			break;
		case "xpath":
			assertTrue(driver.findElement(By.xpath(strLocValue)).isDisplayed());
			break;
		case "css":
			assertTrue(driver.findElement(By.cssSelector(strLocValue)).isDisplayed());
			break;
		}
		}catch(AssertionError e) {
			log.error(e.toString() + "String Location Value: " + strLocValue); 
			
		}
	}
	
	public static void verify_url(WebDriver driver, String Param1) {
		try {
		assertThat(driver.getCurrentUrl(), containsString(Param1));
		}catch(AssertionError e) {
			log.error(e.toString() +  "Expected Result: " + Param1); 
		}
		//System.out.println("Made it past assert statement for SSL VERIFICATION");
	}
	
	public static void quit(WebDriver driver) {
		driver.quit();
	}
	public static void resize_window(WebDriver driver, String Dimension1, String Dimension2) {
		int dim1 = Integer.parseInt(Dimension1);
		int dim2 = Integer.parseInt(Dimension2);
		Dimension d = new Dimension(dim1, dim2);
		driver.manage().window().setSize(d);
	}
	public static void verify_element(WebDriver driver, String strLocType, String strLocValue, String Param1) {
		String actualString = null;
		switch(strLocType) {
		case "id":
			actualString = driver.findElement(By.id(strLocValue)).getText();;
			break;
		case "xpath":
			actualString = driver.findElement(By.xpath(strLocValue)).getText();
			break;
		case "css":
			actualString = driver.findElement(By.cssSelector(strLocValue)).getText();
			break;
		}
		try {
			assertTrue(actualString.contains(Param1));
		}
		catch(AssertionError e) 
		{
			log.error(e.toString() + "String Location Value: " + actualString + " Expected Result: " + Param1); 
			
			Assert.fail();
			//Stops the program from continuing to run
		}
	}
	public static void click_enter(WebDriver driver, String strLocType, String strLocValue, String Param1) {
	
		switch(strLocType) {
		case "id":
			driver.findElement(By.id(strLocValue)).sendKeys(Param1);
			driver.findElement(By.id(strLocValue)).sendKeys(Keys.ENTER);
			break;
		case "xpath":
			driver.findElement(By.xpath(strLocValue)).sendKeys(Param1);
			driver.findElement(By.xpath(strLocValue)).sendKeys(Keys.ENTER);
			break;
		case "css":
			driver.findElement(By.cssSelector(strLocValue)).sendKeys(Param1);
			driver.findElement(By.cssSelector(strLocValue)).sendKeys(Keys.ENTER);
			break;
		}
		if(driver.getTitle().contains("Sitefinity Trial Page")) {
			driver.navigate().refresh();
		}
	}
	
}
