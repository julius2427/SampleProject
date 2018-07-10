package keyworddriventesting;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;

import excelreader.excelRead;
import keyworddriventesting.commonfunctions.CommonFunctions;

public class KeywordFramework extends CommonFunctions {
	static int last_row;
	private static String keywordPath;
	private static String sheetName;
	static String test_case;
	private static String[][] data;
	
	public static void main(WebDriver driver, ExcelTestCaseSelector identify) throws IOException, InterruptedException {

		
		//In the process of changing to use constructor to identify different objects.
		//Going through all Test Case Documents
		// Singlepath field not null then can be set immediately
		if(!identify.singlepath.isEmpty()) {
			keywordPath = identify.singlepath.toString();
		}
		//Full Regression
		if(identify.singlepath == null && identify.numberofsheets == true)
		{
			for(int k = 0; k < identify.path.length;k++) {
				keywordPath = identify.path[k].toString();

					int numberofsheets = excelRead.xlsxNumberofSheets(keywordPath);
					log.info("Test Scenarios: " + excelRead.getSheetName());
					log.info("Test File Location " + keywordPath);
					sendExcelSheets(driver, numberofsheets, null);
			}
				
		}
		//Single KeywordPath and Multiple Sheets
		else if(identify.singlepath != null && identify.numberofsheets == true) {
			keywordPath = identify.singlepath.toString();
			int numberofsheets = excelRead.xlsxNumberofSheets(keywordPath);
			log.info("Test Scenarios: " + excelRead.getSheetName());
			log.info("Test File Location " + keywordPath);
			sendExcelSheets(driver, numberofsheets, null);
		}
		//Single KeywordPath and Single Sheet
		else if(identify.singlepath != null && identify.sheetname !=null) {
			keywordPath = identify.singlepath.toString();
			sheetName = identify.sheetname.toString();
			sendExcelSheets(driver, 0, sheetName);
			
			
		}
		else {
			log.info("ERROR FOUND Matching Options available");
			Assert.fail();
		}
	}	
	
	//Send Excel Sheets to be processed
	public static void sendExcelSheets(WebDriver driver, int numberofsheets, String sheetName) throws IOException, InterruptedException {
		if(sheetName != null) {				
				data = excelRead.xlsxfetchExcelBySheetName(keywordPath, sheetName);
				sendToMethod(driver, data);
			}
		else {
			do {
				
				for(int j = 0; j<numberofsheets;j++) {
					
					data = excelRead.xlsxfetchDataFromExcelSheetNumber(keywordPath, j);
					sendToMethod(driver, data);
				}	
			}while(!driver.getTitle().contains("Sitefinity Trial Page"));
			driver.navigate().refresh();
			log.error("SITEFINITY TRIAL PAGE ERROR");

		}		
	}
	
	public static void sendToMethod(WebDriver driver, String data[][]) throws IOException, InterruptedException {
		last_row = excelRead.getLastRowNum();
		boolean displayed = false;
		for(int i = 2; i <last_row; i++) {
			if(data[i][0] != "") {
				//log.info("Test Case: " + data[i][0]);
				test_case = data[i][0];
				//System.out.println("Test Case: " + data[i][0]);
			}
			//log.info("Step " + data[i][1] + " Step Name: " + data[i][2]);
			//System.out.println("Step " + data[i][1] + " Step Name: " + data[i][2]);
			switch(data[i][3]) {
			case "navigate_to":
				navigate_to(driver,data[i][6]);
				log.info("Step No. " + data[i][1] + " Step Name " + data[i][2] + " Result: Pass");
				break;
			
			
			case "click_element":
				try {
				click_element(driver, data[i][4],data[i][5]);
				log.info("Step No. " + data[i][1] + " Step Name " + data[i][2] + " Result: Pass");
				}catch (NoSuchElementException e) {
					log.fatal("FATAL ERROR: Step No. " + data[i][1] + " Step Name " + data[i][2] + " Result: FAIL");
					log.fatal("Error Message: " + e);
				}
				break;
			
			
			
			case "send_element":
				try {
					send_element(driver, data[i][4], data[i][5], data[i][6]);
				}catch(NoSuchElementException e) {
					log.fatal("FATAL ERROR: Step No. " + data[i][1] + " Step Name " + data[i][2] + " Result: FAIL");
					log.fatal("Error Message: " + e);
				}


				break;
			
			
			case "clear_element":
				try {
					clear_element(driver, data[i][4], data[i][5]);
				}catch(NoSuchElementException e) {
					log.fatal("FATAL ERROR: Step No. " + data[i][1] + " Step Name " + data[i][2] + " Result: FAIL");
					log.fatal("Error Message: " + e);
				}
				break;
			
			
			case "verify_element":
				try {
				verify_element(driver, data[i][4], data[i][5], data[i][6]);
				log.info("Step No. " + data[i][1] + " Step Name " + data[i][2] + " Result: Pass");
				}catch(NoSuchElementException e) {
					log.fatal("FATAL ERROR: Step No. " + data[i][1] + " Step Name " + data[i][2] + " Result: FAIL");
					log.fatal("Error Message: " + e);
				}
				break;
			
			
			case "click_enter":
				try {
					
				click_enter(driver, data[i][4], data[i][5], data[i][6]);
				log.info("Step No. " + data[i][1] + " Step Name " + data[i][2] + " Result: Pass");
				}catch(NoSuchElementException e) {
					log.fatal("FATAL ERROR: Step No. " + data[i][1] + " Step Name " + data[i][2] + " Result: FAIL");
					log.fatal("Error Message: " + e);
				
				}catch(UnhandledAlertException e) {
					//Added UnhandledAlertException not sure why this keeps happening
					log.fatal("FATAL ERROR: Step No. " + data[i][1] + " Step Name " + data[i][2] + " Result: FAIL");
					log.fatal("Error Message: " + e);
				}
				break;
			case "resize_window": 
				resize_window(driver, data[i][6], data[i][7]);
				//log.info("Step No. " + data[i][1] + " Step Name " + data[i][2] + " Result: Pass");
				break;

			case "verify_displayed":
				displayed = false;
				try {
					
					displayed = verify_displayed(driver, data[i][4],data[i][5]);
				
				}catch(NoSuchElementException e) {
					
					log.fatal("FATAL ERROR: Step No. " + data[i][1] + " Step Name " + data[i][2] + " Result: FAIL");
					log.fatal("Error Message: " + e);
					
				}
				
				if(displayed) {
					log.info("Step No. " + data[i][1] + " Step Name " + data[i][2] + " Result: Pass");
				}else {
					log.info("Step No. " + data[i][1] + " Step Name " + data[i][2] + " Result: FAIL");
				}
				break;
				
				
			case "verify_url":
				try {
				verify_url(driver, data[i][6]);
				log.info("Step No. " + data[i][1] + " Step Name " + data[i][2] + " Result: Pass");
				}catch(NoSuchElementException e) {
					log.fatal("FATAL ERROR: Step No. " + data[i][1] + " Step Name " + data[i][2] + " Result: FAIL");
					log.fatal("Error Message: " + e);
				}
				
				break;
			case "takescreenshot":
				
				
				ScreenCapture.takeSnapShot(driver, data[i][3]);
				log.info("Step No. " + data[i][1] + " Step Name " + data[i][2] + " Result: Pass");
			case "quit":
				quit(driver);
				break;
			}
			
		}			
	}
		
}

