package keyworddriventesting;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import keyworddriventesting.commonfunctions.FileList;

public class keywordPath {

	private static String keyword_path;
	
	
	public static void setPathLocation() throws URISyntaxException {
	Path path = Paths.get(FileList.class.getResource("../.").toURI());
	path = path.getParent();
	path = path.getParent();	
	path = path.resolve("testcases");
	System.out.println(path.toString());
	keyword_path = path.toString(); 
	System.out.println("keyword_path = " + keyword_path);
	}
	
	public static String getPathLocation() {
		return keyword_path;
		
	}

}
