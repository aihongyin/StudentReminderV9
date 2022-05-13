package application;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SignUp {  
	
	
	//create a text file to store the data
			public void createFile() {
				
				try {
				    File myObj = new File("\"database9.txt\"");
				   
				    
				    if (myObj.createNewFile()) {
				      System.out.println("");
				    } else {
				      System.out.println("");
				    }
				    
				  } catch (IOException e) {
				    System.out.println("An error occurred.");
				    e.printStackTrace();
				  }
				 

			}
 
  //save username and password to a file
  public void saveData(String usernameEx, String passwordEx){  
    try {  
    	
    	File file = new File("\"database9.txt\"");
        PrintWriter writer = new PrintWriter(new FileWriter(file, true));
             
        SRAccount user1 = new SRAccount();
  
        user1.setUsername(usernameEx);    
        user1.setPassword(passwordEx);  

        writer.println(user1.getUsername());
        writer.println(user1.getPassword());

        writer.close();  
      
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }  
  
  
  
    //check if the account has been used
    public boolean checkAccountForSignUp(String text1, String text2) {	
		    try {  
		    	File file = new File("\"database9.txt\"");
		        Scanner reader2 = new Scanner(file);	           
		        boolean found = false;
		    	while(reader2.hasNext() && !found) { 
		    		// check if the user is in the record
		    	    if (reader2.next().equals(text1))
		    	    {	    	
		    	        if (reader2.next().equals(text2))
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
		    	
		    	 reader2.close();
		    
		    } catch (IOException e) {
		     System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
			return true;
		    
}
    
}