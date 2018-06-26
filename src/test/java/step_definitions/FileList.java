package step_definitions;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileList {

	public static String[] fileName(String directoryPath) throws IOException{
		File dir = new File(directoryPath);
		File[] listOfFiles = dir.listFiles();
		String[] filenames = new String[listOfFiles.length];
		for(int i=0; i<listOfFiles.length; i++) {
			filenames[i] = listOfFiles[i].getPath();
		}
		return filenames;
	}

	public static void PrintClassPath() throws URISyntaxException {
		// TODO Auto-generated method stub
		
		
		//Jankiest way ever to get parent path I want. Theres a better way to do this gotta be but didn't want to take anymore time dicking with this
		
		Path path = Paths.get(FileList.class.getResource("../.").toURI());
		path = path.getParent();
		path = path.getParent();
		System.out.println(path.toString());
		
		/* File location testing
        ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(sysClassLoader);
        //Get the URLs
        URL[] urls = ((URLClassLoader)sysClassLoader).getURLs();
 
        for(int i=0; i< urls.length; i++)
        {
            System.out.println(urls[i].getFile());
        }*/  
	}
}