/*This is a standalone flight search program in Java that lists matching flights for a traveller
who is looking to fly between 2 locations on a given date. The input locations should be 3 letter
 location code format as present in airlines flight data.
*/

package com.nagarro.advancejava.assignment1.input;    

//Import Essential Classesdel

import com.nagarro.advancejava.assignment1.input.UserInput;
import com.nagarro.advancejava.assignment1.manipulation.*;
import java.io.IOException;
import java.text.ParseException;
import com.opencsv.exceptions.CsvException;


/*FlightSearch Class provide main function and inside this we class another functions which get all data
from user and perform search related operations
*/
public class FlightSearch {

	public static void main(String[] args) throws IOException, CsvException, ParseException {
		
		UserInput user = new UserInput();         
		user.getInput();                                   //function calling for taking input from user
		
		CsvReader reader = CsvReader.getInstance();			
		reader.displayFlights(user);                       //function calling for display filtered flights
	}

}
