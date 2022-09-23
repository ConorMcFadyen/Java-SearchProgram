package MySearchEngine;

import java.util.LinkedHashMap;
import java.util.TreeMap;


public class RankResults {
	
	LinkedHashMap<String, Integer> results = new LinkedHashMap<String, Integer>();
	
	CompareResults compare = new CompareResults(results);
	
	TreeMap<String , Integer> sort = new TreeMap<String, Integer>(compare);
	
	
	public Object SortResults () {
		    
			//Puts all results into the TreeMap ordered
	        sort.putAll(results);
	      
			return sort;
		
		
	}// end SortResults

	public void Dictionary(int count, String string) {
		
		//Add the string and count from FolderSearch to the LinkedHashMap
		results.put(string, count);
		
	}//end Dictionary

}//end class RankedResults