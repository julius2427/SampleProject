package step_definitions;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
/**
 * Unit test for simple App.
 */
public class AppTest extends AbstractPageStepDefinitions
{

	//Location of Keyword Document
	//private String keyword_path = "/Users/julius/eclipse-workspace/MavenWebDriverKeywordFramework-2/KeywordDrivenFramework.xls";
	private String keyword_path;
	
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
	public void getPathLocation() throws URISyntaxException {
	Path path = Paths.get(FileList.class.getResource("../.").toURI());
	path = path.getParent();
	path = path.getParent();
	path = path.resolve("testcases");
	System.out.println(path.toString());
	keyword_path = path.toString(); 
}

@Test
	public void FullRegression() throws Exception
    {
		
		
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

@Test
	public void singlePathsingleSheet() throws Exception{
	//Manually setting the path to workbook you want here
	String singlepath = "/Users/julius/eclipse-workspace/MavenWebDriverKeywordFramework-2/testcases/KeywordDrivenFramework.xls";
	String sheetname = "Location Finder";
	ExcelTestCaseSelector testcase = new ExcelTestCaseSelector(singlepath, sheetname);
	KeywordFramework.main(driver, testcase);
}

@Test
	public void singlePathMultipleSheet() throws Exception{
	String singlepath = "/Users/julius/eclipse-workspace/MavenWebDriverKeywordFramework-2/testcases/KeywordDrivenFramework.xls";
	ExcelTestCaseSelector testcase = new ExcelTestCaseSelector(singlepath);
	KeywordFramework.main(driver, testcase);
}

@After
	public void closeApp() {
		driver.quit();
	}
}
