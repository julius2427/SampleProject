package excelreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelRead {
	private static int lastrowNum;
	private static String SheetName;

	static Logger log = Logger.getLogger(Logger.class.getName());
	
	public static String[][] xlsfetchDataFromExcelSheetNumber(String path, int sheetNumber) throws IOException
	{

		//Change File name as per file location on machine
//				File excel= new File("F:\\Nilesh Selenium 14th May\\Data.xls");
				File excel= new File(path);
				FileInputStream fis= new FileInputStream(excel);
				HSSFWorkbook wb= new HSSFWorkbook(fis);
				
				HSSFSheet ws= wb.getSheetAt(sheetNumber);
				//HSSFSheet ws = wb.getSheet(sheetName);
				
				
				int rowNum=ws.getLastRowNum()+1;
				setLastRowNum(rowNum);
				int colNum=ws.getRow(0).getLastCellNum();
				
				String[][] data= new String[rowNum][colNum];
				
				for(int i=0; i<rowNum; i++)
				{
					HSSFRow row=ws.getRow(i);
					for(int j=0; j<colNum; j++)
					{
						
						HSSFCell cell= row.getCell(j);
						String value=xlscellToString(cell);
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
	
	public static String[][] xlsfetchExcelBySheetName(String path, String sheetname) throws IOException
	{

		//Change File name as per file location on machine
//				File excel= new File("F:\\Nilesh Selenium 14th May\\Data.xls");
				File excel= new File(path);
				FileInputStream fis= new FileInputStream(excel);
				HSSFWorkbook wb= new HSSFWorkbook(fis);
				
				HSSFSheet ws = wb.getSheet(sheetname);
				
				
				int rowNum=ws.getLastRowNum()+1;
				setLastRowNum(rowNum);
				int colNum=ws.getRow(0).getLastCellNum();
				
				String[][] data= new String[rowNum][colNum];
				
				for(int i=0; i<rowNum; i++)
				{
					HSSFRow row=ws.getRow(i);
					for(int j=0; j<colNum; j++)
					{
						
						HSSFCell cell= row.getCell(j);
						String value=xlscellToString(cell);
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
	
	public static String xlscellToString(HSSFCell cell){
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
	
	public static String[][] xlsxfetchDataFromExcelSheetNumber(String path, int sheetNumber) throws IOException
	{

		//Change File name as per file location on machine
//				File excel= new File("F:\\Nilesh Selenium 14th May\\Data.xls");
				File excel= new File(path);
				FileInputStream fis= new FileInputStream(excel);
				XSSFWorkbook wb= new XSSFWorkbook(fis);
				
				XSSFSheet ws= wb.getSheetAt(sheetNumber);
				//HSSFSheet ws = wb.getSheet(sheetName);
				String setsheetname;

				//Set the sheet name for test scenarios to indicate properly
				setsheetname = wb.getSheetName(sheetNumber);
				setSheetName(setsheetname);
				int rowNum=ws.getLastRowNum()+1;
				setLastRowNum(rowNum);
				int colNum=ws.getRow(0).getLastCellNum();
				
				String[][] data= new String[rowNum][colNum];
				
				for(int i=0; i<rowNum; i++)
				{
					XSSFRow row=ws.getRow(i);
					for(int j=0; j<colNum; j++)
					{
						
						XSSFCell cell= row.getCell(j);
						String value=xlsxcellToString(cell);
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
	
	public static String[][] xlsxfetchExcelBySheetName(String path, String sheetname) throws IOException
	{
		//Change File name as per file location on machine
//				File excel= new File("F:\\Nilesh Selenium 14th May\\Data.xls");
				File excel= new File(path);
				FileInputStream fis= new FileInputStream(excel);
				XSSFWorkbook wb= new XSSFWorkbook(fis);
				
				XSSFSheet ws = wb.getSheet(sheetname);
				setSheetName(sheetname);
				
				int rowNum=ws.getLastRowNum()+1;
				setLastRowNum(rowNum);
				int colNum=ws.getRow(0).getLastCellNum();
				
				String[][] data= new String[rowNum][colNum];
				
				for(int i=0; i<rowNum; i++)
				{
					XSSFRow row=ws.getRow(i);
					for(int j=0; j<colNum; j++)
					{
						
						XSSFCell cell= row.getCell(j);
						String value=xlsxcellToString(cell);
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
	
	public static String xlsxcellToString(XSSFCell cell){
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
	
	
	public static int xlsNumberofSheets(String path) throws IOException{
		int numberofsheets;
		String initialSheetname;
	
		File excel= new File(path);
		FileInputStream fis= new FileInputStream(excel);
		HSSFWorkbook wb= new HSSFWorkbook(fis);
		numberofsheets = wb.getNumberOfSheets();
		//Setting the first Sheet to be completed throughout for remaining sheets via FetchDataFromExcel method
		initialSheetname = wb.getSheetName(0);
		setSheetName(initialSheetname);
		wb.close();
		fis.close();
		return numberofsheets;
	}
	
	public static int xlsxNumberofSheets(String path) throws IOException{
		int numberofsheets;
		String initialSheetname;
		File excel= new File(path);
		
		FileInputStream fis= new FileInputStream(excel);
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		numberofsheets = wb.getNumberOfSheets();
		//Setting the first Sheet to be completed throughout for remaining sheets via FetchDataFromExcel method
		initialSheetname = wb.getSheetName(0);
		setSheetName(initialSheetname);
		wb.close();
		fis.close();
		return numberofsheets;
	}
	
 	public static void setLastRowNum(int lastrow) {
		excelRead.lastrowNum = lastrow;
	}
	public static int getLastRowNum() {
		return lastrowNum;
	}
	public static void setSheetName(String SheetName) {
		excelRead.SheetName = SheetName;
	}
	public static String getSheetName() {
		return SheetName;
	}
}
