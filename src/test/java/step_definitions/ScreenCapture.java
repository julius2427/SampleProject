package step_definitions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenCapture {

	
    public static void takeSnapShot(WebDriver driver, String screenshotname) throws IOException{
    	String fileWithPath = "/Users/julius/eclipse-workspace/MavenWebDriverKeywordFramework-2/logs/Screenshots";
        //Convert web driver object to TakeScreenshot
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath);

                //Copy file at destination

                FileUtils.copyFile(SrcFile, new File(DestFile + "_" + screenshotname + ".png"));
    }
    
    //Need to add deletion file to automatically remove oldest batch of Screencaptures after data limit is reached
}
