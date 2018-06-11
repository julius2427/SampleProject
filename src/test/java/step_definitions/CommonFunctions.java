package step_definitions;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CommonFunctions extends AbstractPageStepDefinitions{
	private static int lastrowNum;
//	private static String URL;
	public static void navigate_to(WebDriver driver, String url) {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("URL IS AS FOLLOWS!!! " + url);
		driver.navigate().to(url);
	}
	public static void send_element(WebDriver driver, String strLocType, String strLocValue, String Param1) {
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
			e.printStackTrace();
		}
	}
	
	
	public static void click_element(WebDriver driver, String strLocType, String strLocValue) {
		switch(strLocType) {
		case "id":
			driver.findElement(By.id(strLocValue)).click();
			break;
		case "xpath":
			driver.findElement(By.xpath(strLocValue)).click();
			break;
		case "css":
			driver.findElement(By.cssSelector(strLocValue)).click();
			break;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void clear_element(WebDriver driver, String strLocType, String strLocValue) {
		switch(strLocType) {
		case "id":
			driver.findElement(By.id(strLocValue)).clear();;
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
			e.printStackTrace();
		}
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
		assertTrue(actualString.contains(Param1));
	}
	public static void quit(WebDriver driver) {
		driver.quit();
	}
	
	
	public static String[][] FetchDataFromExcel(String path) throws IOException
	{

		//Change File name as per file location on machine
//				File excel= new File("F:\\Nilesh Selenium 14th May\\Data.xls");
				File excel= new File(path);
				FileInputStream fis= new FileInputStream(excel);
				HSSFWorkbook wb= new HSSFWorkbook(fis);
				HSSFSheet ws= wb.getSheet("ContactUs");
				
				int rowNum=ws.getLastRowNum()+1;
				System.out.println("LAST ROW NUMBER EQUALS!!! " + rowNum);
				setLastRowNum(rowNum);
				int colNum=ws.getRow(0).getLastCellNum();
				
				String[][] data= new String[rowNum][colNum];
				
				for(int i=0; i<rowNum; i++)
				{
					HSSFRow row=ws.getRow(i);
					for(int j=0; j<colNum; j++)
					{
						HSSFCell cell= row.getCell(j);
						String value=cellToString(cell);
						data[i][j]=value;				
					}
//					System.out.println("Value is "+ data[i][0] + data[i][1] + data[i][2] );
						//To write data in excel
//						HSSFCell cell1=row.createCell(5);
//						cell1.setCellType(Cell.CELL_TYPE_STRING);
//						cell1.setCellValue("Test1");
//					FileOutputStream fos=new FileOutputStream("F:\\Nilesh\\Data.xls");
//						wb.write(fos);
//						fos.close();						
				}
				wb.close();
				fis.close();
		return data;
		
	}

	public static String cellToString(HSSFCell cell){
//		int type;
		Object result;
		String strReturn = null;
		if (cell==null)
		{
			strReturn="";	
		}
		else
		{	
		switch (cell.getCellTypeEnum()){
			case NUMERIC: //Numeric
				result=cell.getNumericCellValue();
				strReturn=result.toString();
				break;				
			case STRING:
				result=cell.getStringCellValue();
				strReturn=result.toString();				
				break;
			default:
				strReturn=null;						
		}
	     }
		return strReturn;
	
	}
	public static void setLastRowNum(int lastrow) {
		CommonFunctions.lastrowNum = lastrow;
	}
	public static int getLastRowNum() {
		return lastrowNum;
	}
}
