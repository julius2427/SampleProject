package commonfunctions;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class keywordPath {

	private static String keyword_path;
	private static Path screenshotpath;
	
	public static void setPathLocation() throws URISyntaxException {
	Path path = Paths.get(FileList.class.getResource("../.").toURI());
	path = path.getParent();
	path = path.getParent();	
	path = path.resolve("testcases");
	System.out.println(path.toString());
	keyword_path = path.toString(); 
	}
	
	public static String getPathLocation() {
		return keyword_path;
		
	}
	public static void setscreenshotpath() throws URISyntaxException{
		Path path = Paths.get(FileList.class.getResource("../.").toURI());
		path = path.getParent();
		path = path.getParent();
		path = path.resolve("logs/Screenshots");
		screenshotpath = path;
		
	}
	public static Path getscreenshotpath() {
		return screenshotpath;
	}

}
