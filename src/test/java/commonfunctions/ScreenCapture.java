package commonfunctions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import excelreader.excelRead;

public class ScreenCapture {
	static long yourmilliseconds = System.currentTimeMillis();
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss");
	static Date resultdate = new Date(yourmilliseconds);
	private static String path;
	
    public static void takeSnapShot(WebDriver driver, String screenshotname) throws IOException{
    	String sheetname = excelRead.getSheetName();
    	
    	//Attempt to create new directories based on the sheet name
    	path = keywordPath.getscreenshotpath().resolve(sheetname).toString();
    	createfiledirectory(sheetname);
    	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	try {
    		//MANUALLY SET THE SCREENSHOT SAVE LOCATION. DEBATING SETTING THIS UP IN SPREADSHEET UNDER PARAM2 or need a better way to do this.
			FileUtils.copyFile(src, new File(path + "/" + screenshotname + sdf.format(resultdate) +".png"));

    	}catch(IOException e) {
    		System.out.println(e.getMessage());
    	}
    	
    }
    public static void createfiledirectory(String sheetname) {
    	File theDir = new File(path);
    	if (!theDir.exists()) {
    	    System.out.println("creating directory: " + theDir.getName());
    	    boolean result = false;

    	    try{
    	        theDir.mkdir();
    	        result = true;
    	    } 
    	    catch(SecurityException se){
    	        //handle it
    	    }        
    	    if(result) {    
    	        System.out.println("DIR created");  
    	    }
    	}
    }
    //Need to add deletion file to automatically remove oldest batch of Screencaptures after data limit is reached
}
