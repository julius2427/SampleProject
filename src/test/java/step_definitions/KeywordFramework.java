package step_definitions;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class KeywordFramework extends CommonFunctions {
	public static void main(WebDriver driver, String TestCaseSheet) throws IOException, InterruptedException {
		int last_row;
		String data[][] = FetchDataFromExcel("/Users/julius/eclipse-workspace/MavenWebDriverKeywordFramework-2/KeywordDrivenFramework.xls");
		System.out.println("WE MADE IT INTO THE CLASS KEYWORDFRAMEWORK");
		last_row = getLastRowNum();
		for(int i = 2; i <last_row; i++) {

			switch(data[i][3]) {
			case "navigate_to":
				System.out.println("Made it into the first test case");
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
			case "quit":
				quit(driver);
			
			}
		}
	}
	

}
