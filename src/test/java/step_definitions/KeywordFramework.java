package step_definitions;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class KeywordFramework extends CommonFunctions {
	static int last_row;
	private static String KeywordPath;
	static String test_case;
	
	public static void main(WebDriver driver, String[] path) throws IOException, InterruptedException {

//		String KeywordPath = "/Users/julius/eclipse-workspace/MavenWebDriverKeywordFramework-2/TestCases/KeywordDrivenFramework.xls";

		

		//Going through all Test Case Documents
		for(int k = 0; k < path.length;k++) {
			KeywordPath = path[k].toString();
			
			int numberofsheets = NumberofSheets(KeywordPath);
			
			log.info("Test File Location " + KeywordPath);
			
			//Going through all 
			do {
				
	//		for(int j = 0; j<numberofsheets;j++) {
				
				int j = 0;
				String data[][] = FetchDataFromExcel(KeywordPath, j);
				SendToMethod(driver, data);
				
				
				
				/*
				last_row = getLastRowNum();
				
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
					
				}*/
			
	//	} 
	
		}while(!driver.getTitle().contains("Sitefinity Trial Page"));
		driver.navigate().refresh();
		main(driver, path);

		}
	}
	
	public static void SendToMethod(WebDriver driver, String data[][]) throws IOException {
		last_row = getLastRowNum();
		
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
