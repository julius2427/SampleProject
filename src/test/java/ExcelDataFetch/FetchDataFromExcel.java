package ExcelDataFetch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class FetchDataFromExcel {
	public static String[][] FetchDataFromExcel(String path) throws IOException
	{

		//Change File name as per file location on machine
//				File excel= new File("F:\\Nilesh Selenium 14th May\\Data.xls");
				File excel= new File(path);
				FileInputStream fis= new FileInputStream(excel);
				HSSFWorkbook wb= new HSSFWorkbook(fis);
				HSSFSheet ws= wb.getSheet("Sheet1");
				
				int rowNum=ws.getLastRowNum()+1;
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

}
