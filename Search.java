package MySearchEngine;

import java.io.File;
import java.io.FileNotFoundException;
//Importing java input/output classes
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;




//Open a PDF document scan through it for a given string and returns the number of times the pdf contains the string 

public class Search {
	
	//String that we will search the text file for 
	private String searchterm;
	
	//name of the text file to be searched
	private String filename ;
	
	//Count of how many occurrences a string is in the text file
	private int equalcount;
	
	public int SearchFile (String searchterm , String filename) {
		
		File file = new File(filename);
		
		try {
			
		//Create FileReader and BufferedReader Objects 
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		//Put the text file into a String array that can be searched 
		String[] searcharray = null;
		String [] wordsarray = null;
		//String word will be iterated and compared to the desired string 
		String line = " ";
		String words;
		
		
			//While the next line is not null
			while((line = br.readLine() ) != null)
			{
				//Splits the lines up when there is a whitespace
				searcharray = line.split(" ");
				
				//search though the array and compare it to the searchterm the user entered 
				//RegionMatches ignores case and is true if the searchterm is part of a substring of the string being compared
				for(int i = 0 ; i < searcharray.length ; i++)
				{	
					
					if(searcharray[i].regionMatches(true, 0, searchterm, 0, 3))
					{
						//count how many times the searchterm is in the lines
						equalcount++;
					}//end if
					
					
				} //end for
				
			}//end while
			
			//close the file
			br.close();
			
			return equalcount;
		}
		catch (FileNotFoundException e )
		{
			System.out.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return equalcount;
	
	}//end searchFile
} //End class Search
	

