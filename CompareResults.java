package MySearchEngine;

import java.util.Comparator;
import java.util.Map;


public	class CompareResults implements Comparator<String> {
	    public Map<String, Integer> base;
	    
	    //constructor for CompareResults
	    public CompareResults(Map<String, Integer> base) {
	        this.base = base;
	    }

	   //Compares the values associated with the String keys to check witch is greater 
	    public int compare(String a, String b) {
	        if (base.get(a) >= base.get(b)) {
	            return -1;
	        } else {
	            return 1;
	        } 
	    } //end compare
	    
	} //end class Compare results



