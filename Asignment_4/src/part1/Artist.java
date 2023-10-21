package part1;
import java.util.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.*;

public class Artist {

	private String ID;
	private String Name;
	private String Address;
	private String Birthdate;
	private String Bio;
	private ArrayList <String> Occupations;
	private ArrayList <String> Genres;
	private ArrayList <String> Awards;
	
	public Artist(String id, String name, String address, String birthdate, String bio, ArrayList <String> occupations, ArrayList <String> genres, ArrayList <String> awards)
	{
		// constructor to initialize variables.
		ID=id;
		Name=name;
		Address=address;
		Birthdate=birthdate;
		Bio=bio;
		Occupations=occupations;
		Genres=genres;
		Awards=awards;
		
	}
	//This function is used to validate inputs based on the conditions specified in the requirements
	public boolean validateArtist(String id, String name, String address, String birthdate, String bio, ArrayList <String> occupations, ArrayList <String> genres, ArrayList <String> awards)
	{	
		String TID=id;
		String TName=name;
		String TAddress=address;
		String TBirthdate=birthdate;
		String TBio=bio;
		ArrayList <String> TOccupations=occupations;
		ArrayList <String> TGenres=genres;
		ArrayList <String> TAwards=awards;
		
		int len=TID.length(); // condition 1 - checking if Artist ID is 10 characters long
		if(len != 10)
		{	
			return false;
		}
		String first_three=TID.substring(0, 3); // condition 1 - checking if first three characters are numbers between 5 and 9
		if (!(first_three.matches("[5-9][5-9][5-9]"))) {
			
			return false;		    
		}
		
		for (int i = 3; i < 8; i++) { // condition 1 - checking if the characters 4th to 8th are uppercase (A-Z)
	        char ch = TID.charAt(i);
	        if (ch < 'A' || ch > 'Z') {
	            return false;
	        }
	    }
		if (TID.substring(8, 10).matches("[^a-zA-Z0-9]")) { // condition 1 - checking if last two characters are special characters
			
			return false;		    
		}
		
		// Condition 2 - checking if format is DD-MM-YYYY
		String datePattern ="\\d{1,2}-\\d{1,2}-\\d{4}";//Ref[1]		
		if (!(TBirthdate.matches(datePattern)))
		{	
			return false;
		}
		
		//condition 3 // checking if address format is City|State|Country
		String[] components = TAddress.split("\\|");	    
	    if(components.length!=3)
	    {	
	    	return false;
	    }
	    
		//condition 4 -checking if bio is between 10 and 30 words
	    int count = TBio.split("\\s").length;

	    if (count < 10 || count >30 )
	    {
	    	return false;    	//REF[2]	    	
	    }

	    // condition 5 - To check if occupation is between 1 and 5 occupations
	    int occ_count=TOccupations.size();
	    if (occ_count <1 || occ_count >5)
	    {
	    	return false;
	    }
	    
	    // condition 6 - To check if awards are not more than 3
	    int awards_size=TAwards.size();
	    if (awards_size>3)
	    {	
	    	return false;
	    }
	    //condition 6 - To check if award format is "Year,Title"
	    String awardformat = "\\d{4},([A-Za-z0-9\\s]{1,}){4,10}"; // d{4} means 4 digits for year
	    for(int i=0; i< awards_size; i++)
	    {	
	    	
	    	String value = TAwards.get(i);
	    	if (!(value.matches(awardformat)))
			{
				return false;
			}
	    }	    
	    // condition 7 - to check if artist is active in 2-5 genres
	    int genre_size=TGenres.size();
	    if(genre_size <2 || genre_size > 5)
	    {	
	    	return false;
	    }
	    // condition 7 - to check if artist is active in both pop and rock at the same time
	    if (TGenres.contains("pop") && TGenres.contains("rock")) {
	    	
            return false;
        }
	    			
		return true;
	}
	

	public boolean addArtist() //Function to addArtists
	{
		// calling validateArtist to check if input meets all of the conditions
		if(!validateArtist(ID, Name,Address,Birthdate,Bio,Occupations,Genres, Awards))
		{
			return false;			
		}			
		// writing to a file if input matches all of the conditions
		try {

		    FileWriter fileWriter = new FileWriter("artists.txt", true);
		    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		    
		    // creating string to insert into the file
		    String artistInfo = ID + ";" + Name + ";" + Address + ";" + Birthdate + ";" + Bio + ";" +
		            String.join(",", Occupations) + ";" + String.join(",", Genres) + ";" + String.join(",", Awards);

		    bufferedWriter.write(artistInfo);
		    bufferedWriter.newLine();
		    bufferedWriter.close();
		    
		} catch (IOException e) {
		    return false;
		}
		
	return true; // returns true if all actions are completed successfully
				
	}
	//Function to update artist
	public boolean updateArtist(String newID, String newName, String newAddress, String newBirthdate, String newBio,
            ArrayList<String> newOccupations, ArrayList<String> newGenres, ArrayList<String> newAwards)
	{
		//condition 1 - validates the inputs
		if(!validateArtist(newID,newName,newAddress,newBirthdate, newBio, newOccupations, newGenres, newAwards))
		{
			return false;
		}
		
		//condition 2- if an artist is born before 2000, occupation cannot be changed
		int birthYear = Integer.parseInt(newBirthdate.substring(6));		
        if (birthYear < 2000 && (!Occupations.equals(newOccupations))) {
            return false;
        }
        
        // condition 3 - if artist has an award before 2000, awards will not be updated
        if(!Awards.equals(newAwards))
        {
        	for (int i = 0; i < Awards.size(); i++) 
        	{
                String existingAward = Awards.get(i);
                int existingAwardYear = Integer.parseInt(existingAward.split(",")[0].trim());
                if (existingAwardYear < 2000) 
                {
                    return false; 
                }
        	}
        }
        
        //updating the file if all conditions are passed REF[4]
        try {
           File originalFile = new File("artists.txt");
           File tempFile = new File("temp.txt");

            BufferedReader br = new BufferedReader(new FileReader(new File("artists.txt")));
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("temp.txt")));
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                String artistID = currentLine.split(";")[0];
                if (artistID.equals(newID)) { // checking if the artist ID exists in the file
                    String updatedArtistInfo = ID + ";" + newName + ";" + newAddress + ";" + newBirthdate + ";" + newBio + ";" +
                            String.join(",", newOccupations) + ";" + String.join(",", newGenres) + ";" + String.join(",", newAwards);
                    bw.write(updatedArtistInfo); // writing to temp file
                }
                else {
                	bw.write(currentLine);
                }

                bw.newLine();
            }

            br.close();
            bw.close();
            originalFile.delete();  
            tempFile.renameTo(originalFile);

        } catch (IOException e) {
            return false;
        }
             
		return true;
	}		
}

/*REFERENCES
 * [1]How to check whether date is in proper format or not using Java (no date) Online Tutorials, Courses, and eBooks Library. Available at: https://www.tutorialspoint.com/javaexamples/regular_date.htm (Accessed: 11 October 2023). 
 * [2]Java how to count words (no date) Java How To Count Number of Words. Available at: https://www.w3schools.com/java/java_howto_count_words.asp (Accessed: 11 October 2023). 
 * [3]Paraschiv, W. by: E. (2023) Java - write to file, Baeldung. Available at: https://www.baeldung.com/java-write-to-file (Accessed: 11 October 2023). 
 * [4]Surisava et al. (1959) How to update the contain in .TXT file java, Stack Overflow. Available at: https://stackoverflow.com/questions/16383578/how-to-update-the-contain-in-txt-file-java (Accessed: 13 October 2023). 
 */


