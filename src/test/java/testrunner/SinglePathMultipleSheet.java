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
public class SinglePathMultipleSheet extends AbstractPageStepDefinitions
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

//Copy this test if you want to test specific
@Test
	public void singlepathmultiplesheet() throws Exception{
	String singlepath = "/Users/julius/eclipse-workspace/MavenWebDriverKeywordFramework-2/testcases/KeywordDrivenFramework-2.xlsx";
	ExcelTestCaseSelector testcase = new ExcelTestCaseSelector(singlepath);
	KeywordFramework.main(driver, testcase);

	}


@After
	public void closeapp() {
		driver.quit();
	}
}
