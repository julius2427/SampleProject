package keyworddriventesting.commonfunctions;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FilenameUtils;


public class FileList {

	public static String[] fileName(String directoryPath) throws IOException{
		String fileextension;
		File dir = new File(directoryPath);
		File[] listOfFiles = dir.listFiles();
		String[] filenames = new String[listOfFiles.length];
		for(int i=0; i<listOfFiles.length; i++) {
			fileextension = FilenameUtils.getExtension(listOfFiles[i].toString());
			if(fileextension.equals("xlsx")) {
				filenames[i] = listOfFiles[i].getPath();
			}			
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
	  public static String getContextFilePath(String directoryPath, String filePath) {
	      try {
	          File directory = new File(directoryPath);
	          File file = new File(filePath);

	          directoryPath = directory.getCanonicalPath();
	          filePath = file.getCanonicalPath();

	          // If the context directory does not have a File.separator
	          // at the end then add one explicitly
	          if(!directoryPath.endsWith(File.separator)){
	              directoryPath += File.separator;
	          }

	          // If the context dir contains both kinds of separator
	          // then standardize on using the File.separator
	          if ((directoryPath.indexOf('/') !=-1) && (directoryPath.indexOf('\\') !=-1)) {
	              directoryPath = directoryPath.replace('\\', File.separator.charAt(0));
	              directoryPath = directoryPath.replace('/', File.separator.charAt(0));
	          }

	          // If the file path contains both kinds of separator
	          // then standardize on using the File.separator
	          if ((filePath.indexOf('/') !=-1) && (filePath.indexOf('\\') !=-1)) {
	              filePath = filePath.replace('\\', File.separator.charAt(0));
	              filePath = filePath.replace('/', File.separator.charAt(0));
	          }

	          if (filePath.startsWith(directoryPath)) {
	              filePath = filePath.substring(directoryPath.length());
	          }
	      } catch (Exception e){
	          // ignore
	      }

	      return filePath;
	  }
	
	
}