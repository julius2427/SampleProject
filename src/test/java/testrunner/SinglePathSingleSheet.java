package testrunner;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import keyworddriventesting.ExcelTestCaseSelector;
import keyworddriventesting.KeywordFramework;
import keyworddriventesting.keywordPath;
import keyworddriventesting.commonfunctions.AbstractPageStepDefinitions;
import keyworddriventesting.commonfunctions.FileList;
/**
 * Unit test for simple App.
 */
public class SinglePathSingleSheet extends AbstractPageStepDefinitions
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
	public void singlepathsinglesheet() throws Exception{
	//Manually setting the path to workbook you want here
	String singlepath = "/Users/julius/eclipse-workspace/MavenWebDriverKeywordFramework-2/testcases/KeywordDrivenFramework-2.xlsx";
	String sheetname = "Search";
	ExcelTestCaseSelector testcase = new ExcelTestCaseSelector(singlepath, sheetname);
	KeywordFramework.main(driver, testcase);
}


@After
	public void closeapp() {
		driver.quit();
	}
}
