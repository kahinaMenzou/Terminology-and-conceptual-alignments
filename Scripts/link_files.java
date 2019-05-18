public class DataBase {
	static ExtractEntities b =new ExtractEntities();

    public static void main(String[] args) throws IOException, ParseException {

    	
    	File folder = new File("/home/hichem/Bureau/essai10/r/");
    	File[] listOfFiles = folder.listFiles();

    	for (int i = 0; i < listOfFiles.length; i++) {
    	  if (listOfFiles[i].isFile()) {
    	    ExtractData.query_model("/home/hichem/Bureau/essai10/r/" + listOfFiles[i].getName());   	  
    	    
    	  } 
    	  
    	}
    }
}
