package application;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SignIn {	
	
	public boolean checkAccountForSignIn(String text1, String text2) {	
		    try {  
		    	
		    	//Get user's information from the file
		    	File file = new File("\"database9.txt\"");
		        Scanner reader = new Scanner(file);	           
		        boolean found = false;
		    	while(reader.hasNext() && !found) { 
		    		// check if the user is in the record
		    	    if (reader.next().equals(text1))
		    	    {	    	
		    	        if (reader.next().equals(text2))
		    	        {
		    	            found = true;   
		    	            return true;
		    	            }
		    	        } 	 
		    	    }
		    		    	
		    	 if(!found) 
		    	 {
		    		 return false;
		    	 }
		    	
		    	reader.close();
		    
		    } catch (IOException e) {
		     System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
			return true;
		    
}
}
	