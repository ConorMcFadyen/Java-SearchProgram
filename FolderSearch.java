package MySearchEngine;

import java.io.File;
import java.io.IOException;


public class FolderSearch {
	//String array of filenames that can be searched
	private String[] filename = {"BreakIterator.txt" , "Bidi.txt" , "text.txt" , "SQLData.txt" , "SQLDataException.txt", "SQLException.txt" , "SQLFeatureNotSupportedException.txt" , "SQLInput.txt" , "SQLIntegrityConstraintViolationException.txt", "FilterOutputStream.txt" , "FilterInputStream.txt" , "FileWriter.txt" , "FileReader.txt"};
	
	
	
	public Object SelectFiles(String searchterm) throws IOException
	{
		//Gets the path of this new file on users computer
		String canonical = new File(".").getCanonicalPath();
		
		//The final part of the file path 
		String sourcestring = "src\\MySearchEngine\\";
		
		//Creates a RankResults object so the for loop can call mehods from RankResults
		RankResults r1 = new RankResults();
		
		
		//Call the search class on each filename
		for (int i = 0; i < filename.length ; i++)
		{
			String fullpath = (canonical + File.separator + sourcestring +filename[i] );
			Search search = new Search();
			int count = search.SearchFile(searchterm , fullpath);
			
			//add the result and filename to the RankResults Dict 
			r1.Dictionary(count, filename[i]);

			
			
		} // end for
		
		//calls for the Dictionary we populated in R1.Dictionary is sorted
		return r1.SortResults();
		
	
		
		
		
		
		
	} // End SelectFiles
}// End class FolderSearch
