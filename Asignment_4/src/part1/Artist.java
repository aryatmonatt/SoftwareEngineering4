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
		ID=id;
		Name=name;
		Address=address;
		Birthdate=birthdate;
		Bio=bio;
		Occupations=occupations;
		Genres=genres;
		Awards=awards;
		
	}
	public boolean validateArtist(String id, String name, String address, String birthdate, String bio, ArrayList <String> occupations, ArrayList <String> genres, ArrayList <String> awards)
	{	
		String TID=id;
		//String TName=name;
		String TAddress=address;
		String TBirthdate=birthdate;
		String TBio=bio;
		ArrayList <String> TOccupations=occupations;
		ArrayList <String> TGenres=genres;
		ArrayList <String> TAwards=awards;
		
		int len=TID.length(); //
		if(len != 10)
		{	
			return false;
		}
		String first_three=TID.substring(0, 3);
		if (!(first_three.matches("[5-9][5-9][5-9]"))) {
			
			return false;		    
		}
		
		for (int i = 3; i < 8; i++) {
	        char ch = TID.charAt(i);
	        if (ch < 'A' || ch > 'Z') {
	            return false;
	        }
	    }
		if (TID.substring(8, 10).matches("[^a-zA-Z0-9]")) {
			
			return false;		    
		}
		
		// CONDITION 2 //DD-MM-YYYY
		//String datePattern = "^(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])-[0-9]{4}$";
		String datePattern ="\\d{1,2}-\\d{1,2}-\\d{4}";
		// https://www.tutorialspoint.com/javaexamples/regular_date.htm

		if (!(TBirthdate.matches(datePattern)))
		{	
			return false;
		}
		//condition 3 // City|State|Country
		String[] components = TAddress.split("\\|");
	    //System.out.print(components.length);
	    
	    if(components.length!=3)
	    {	
	    	return false;
	    }
		//condition 4 bio should be 10 to 30 words
	    int count = TBio.split("\\s").length;

	    if (count < 10 || count >30 )
	    {
	    	return false;
	    	//https://www.w3schools.com/java/java_howto_count_words.asp
	    	
	    }

	    // condition 5 - atleast 1 ot less than 5
	    int occ_count=TOccupations.size();
	    if (occ_count <1 || occ_count >5)
	    {
	    	return false;
	    }

	    
	    // condition 6 - zero to three awards, Year, Title. 4-10 words title
	    int awards_size=TAwards.size();
	    if (awards_size>3)
	    {	
	    	System.out.print("nine");
	    	return false;
	    }

	    String awardformat = "\\d{4},([A-Za-z\\s]{1,}){4,10}";
	    for(int i=0; i< awards_size; i++)
	    {	
	    	
	    	String value = TAwards.get(i);
	    	if (!(value.matches(awardformat)))
			{
				return false;
			}
	    }

	    
	    // condition 7
	    int genre_size=TGenres.size();
	    if(genre_size <2 || genre_size > 5)
	    {	
	    	return false;
	    }
	    if (TGenres.contains("pop") && TGenres.contains("rock")) {
	    	
            return false;
        }
	    			
		return true;
	}
	
	

	public boolean addArtist()
	{
		
		if(!validateArtist(ID, Name,Address,Birthdate,Bio,Occupations,Genres, Awards))
		{
			return false;
			
		}			
		
		try {
		    // Open the file for appending
		    FileWriter fileWriter = new FileWriter("artists.txt", true);
		    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		    
		    // Append the artist's information to the file
		    String artistInfo = ID + ";" + Name + ";" + Address + ";" + Birthdate + ";" + Bio + ";" +
		            String.join(",", Occupations) + ";" + String.join(",", Genres) + ";" + String.join(",", Awards);

		    bufferedWriter.write(artistInfo);
		    bufferedWriter.newLine();

		    // Close the file
		    bufferedWriter.close();
		} catch (IOException e) {
		    return false;
		}


			return true;
				
	}
	public boolean updateArtist(String newID, String newName, String newAddress, String newBirthdate, String newBio,
            ArrayList<String> newOccupations, ArrayList<String> newGenres, ArrayList<String> newAwards)
	{


		
		if(!validateArtist(newID,newName,newAddress,newBirthdate, newBio, newOccupations, newGenres, newAwards))
		{
			return false;
		}
		
		
		int birthYear = Integer.parseInt(newBirthdate.substring(6));
		
        if (birthYear < 2000 && (!Occupations.equals(newOccupations))) {
            return false;
        }
        
        if(!Awards.equals(newAwards))
        {
        	for (int i = 0; i < Awards.size(); i++) 
        	{
                String existingAward = Awards.get(i);
                int existingAwardYear = Integer.parseInt(existingAward.split(",")[0].trim());

                // Check if the artist already has an award before 2000
                if (existingAwardYear < 2000) 
                {
                    return false; // Return false as the artist has an award before 2000
                }
        	}
        }
              
        
        String fileName = "artists.txt";

        try {
           File originalFile = new File(fileName);
           File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(new File("artists.txt")));
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("temp.txt")));

            String currentLine;

            // Iterate through the existing file
            while ((currentLine = reader.readLine()) != null) {
                String artistID = currentLine.split(";")[0];

                // Check if the artist in the file matches the updated artist's ID
                if (artistID.equals(newID)) {
                    // If it matches, write the updated artist's information
                    String updatedArtistInfo = ID + ";" + newName + ";" + newAddress + ";" + newBirthdate + ";" + newBio + ";" +
                            String.join(",", newOccupations) + ";" + String.join(",", newGenres) + ";" + String.join(",", newAwards);
                    writer.write(updatedArtistInfo);
                } else {
                    // If it doesn't match, write the current line as it is
                	writer.write(currentLine);
                }

                writer.newLine();
            }

            reader.close();
            writer.close();
            originalFile.delete(); 
            tempFile.renameTo(originalFile);

        } catch (IOException e) {
            return false;
        }
             
		return true;
	}		
}

/*REFERENCES
 * 
 */


