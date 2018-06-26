package step_definitions;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import step_definitions.excel.excelRead;

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
		
		keywordPath = identify.singlepath.toString();
	
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
	public static void sendExcelSheets(WebDriver driver, int numberofsheets, String sheetName) throws IOException {
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
	
	public static void sendToMethod(WebDriver driver, String data[][]) throws IOException {
		last_row = excelRead.getLastRowNum();
		
		for(int i = 2; i <last_row; i++) {
			if(data[i][0] != "") {
				log.info("Test Case: " + data[i][0]);
				test_case = data[i][0];
				//System.out.println("Test Case: " + data[i][0]);
			}
			log.info("Step " + data[i][1] + " Step Name: " + data[i][2]);
			//System.out.println("Step " + data[i][1] + " Step Name: " + data[i][2]);
			switch(data[i][3]) {
			case "navigate_to":
				navigate_to(driver,data[i][6]);
				break;
			case "click_element":
				click_element(driver, data[i][4],data[i][5]);
				break;
			case "send_element":
				send_element(driver, data[i][4], data[i][5], data[i][6]);
				break;
			case "clear_element":
				clear_element(driver,data[i][4], data[i][5]);
				break;
			case "verify_element":
				verify_element(driver, data[i][4], data[i][5], data[i][6]);
				log.info("Step No. " + data[i][1] + " Step Name " + data[i][2] + " Result: Pass");
				
				break;
			case "click_enter":
				click_enter(driver, data[i][4], data[i][5], data[i][6]);
				break;
			case "resize_window": 
				resize_window(driver, data[i][6], data[i][7]);
				break;
			case "verify_displayed":
				verify_displayed(driver, data[i][4],data[i][5]);
				log.info("Step No. " + data[i][1] + " Step Name " + data[i][2] + " Result: Pass");
				break;
			case "verify_url":
				verify_url(driver, data[i][6]);
				log.info("Step No. " + data[i][1] + " Step Name " + data[i][2] + " Result: Pass");
				break;
			case "takescreenshot":
				ScreenCapture.takeSnapShot(driver, data[i][3]);
			case "quit":
				quit(driver);
				break;
			}
			
		}			
	}
		
}

