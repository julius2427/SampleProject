package step_definitions;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeywordFramework extends CommonFunctions {
	public static void main(WebDriver driver) throws IOException, InterruptedException {
		int last_row;
		String KeywordPath = "/Users/julius/eclipse-workspace/MavenWebDriverKeywordFramework-2/KeywordDrivenFramework.xls";
		int numberofsheets = NumberofSheets(KeywordPath);

		do {
		for(int j = 0; j<numberofsheets;j++) {
			
			
			String data[][] = FetchDataFromExcel(KeywordPath, j);
			last_row = getLastRowNum();
			for(int i = 2; i <last_row; i++) {
				if(data[i][0] != "") {
					System.out.println("Test Case: " + data[i][0]);
				}
				System.out.println("Step " + data[i][1] + " Step Name: " + data[i][2]);
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
					break;
				case "click_enter":
					click_enter(driver, data[i][4], data[i][5], data[i][6]);
					break;
				case "resize_window": 
					resize_window(driver, data[i][6], data[i][7]);
					break;
				case "verify_displayed":
					verify_displayed(driver, data[i][4],data[i][5]);
					break;
				case "verify_url":
					verify_url(driver, data[i][6]);
					break;
				case "quit":
					quit(driver);
					break;
				}
				
			}
			
		} 
	
		}while(!driver.getTitle().contains("Sitefinity Trial Page"));
		driver.navigate().refresh();
		main(driver);
	}

}
