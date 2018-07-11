package testrunner;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import commonfunctions.AbstractPageStepDefinitions;
import commonfunctions.FileList;
import commonfunctions.keywordPath;
import keywordframework.ExcelTestCaseSelector;
import keywordframework.KeywordFramework;
/**
 * Unit test for simple App.
 */
public class FullRegression extends AbstractPageStepDefinitions
{

	//Location of Keyword Document
	//private String keyword_path = "/Users/julius/eclipse-workspace/MavenWebDriverKeywordFramework-2/KeywordDrivenFramework.xls";
	
	WebDriver driver = getDriver();
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
/*    public AppTest( String testName )
    {
        super( testName );
    }
*/
    /**
     * @return the suite of tests being tested
     */
/*    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
*/
    /**
     * Rigourous Test :-)
     * @throws URISyntaxException 
     * @throws Exception 
     */
@Before
// Poopy way to get the file path
	public void setLocation() throws URISyntaxException {
		keywordPath.setPathLocation();
	}

@Test
	public void fullregression() throws Exception
    {

		String keyword_path;
		keyword_path = keywordPath.getPathLocation();
		
		//This is used to go through main functionality of Keyword Driven Approach.
		//
		
	//String List of all test cases to run
		String[] list = FileList.fileName(keyword_path);
		for(int i=0;i<list.length;i++) {
			System.out.println("LISTING CRAP OUT " + list[i].toString());
		}
		ExcelTestCaseSelector regression = new ExcelTestCaseSelector(list, true);
		KeywordFramework.main(driver, regression);
    }

@After
	public void closeapp() {
		driver.quit();
	}
}
