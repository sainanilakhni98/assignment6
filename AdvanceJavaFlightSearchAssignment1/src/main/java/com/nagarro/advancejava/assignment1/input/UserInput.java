package com.nagarro.advancejava.assignment1.input;

//import required classes
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserInput {

	public String departureLocation;
	public String arrivalLocation;
	public String flightDate;
	public String flightClass;
	public String outputPreference;

	BufferedReader br;

	//this function take input form user
	public void getInput() throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter departure location: ");
		departureLocation = br.readLine();
		departureLocation = varifyUserLocation(departureLocation);

		System.out.print("Enter arrival location: ");
		arrivalLocation = br.readLine();
		arrivalLocation = varifyUserLocation(arrivalLocation);

		System.out.print("Enter flight departure date(DD-MM-YYYY): ");
		flightDate = br.readLine();
		flightDate = varifyUserDate(flightDate);

		System.out.println("Enter the flight class[B for Business class/E for Economy class]: ");
		flightClass = br.readLine();
		flightClass = varifyUserFlightClass(flightClass);

		System.out.println("Enter the output preference[F for Sort by fare/FD for Sort by fare and flight duration]");
		outputPreference = br.readLine();
		outputPreference = varifyUserOutputPreference(outputPreference);
	}

	//this function verify the entered user location 
	private String varifyUserLocation(String location) throws IOException {

		while (location.length() != 3) {

			System.out.print("you have entered incorrect location. Please try again: ");
			location = br.readLine();
		}

		return location;
	}

	//this function verify the entered OutputPreference
	private String varifyUserOutputPreference(String preference) throws IOException {

		while (!(preference.equalsIgnoreCase("F") || preference.equalsIgnoreCase("FD"))) {

			System.out.print("you have entered incorrect preference. Please try again: ");
			preference = br.readLine();
		}

		return preference;
	}
	
	//this function verify the entered flight class
	private String varifyUserFlightClass(String flightClass) throws IOException {

		while (!(flightClass.equalsIgnoreCase("B") || flightClass.equalsIgnoreCase("E"))) {

			System.out.print("Sorry, you have entered incorrect class. Please try again: ");
			flightClass = br.readLine();
		}

		return flightClass;
	}
	
	//this function verify the entered user date
	private String varifyUserDate(String date) throws IOException {
		
		while(!varifyDateFormat(date)) {
			
			System.out.print("you have entered incorrect date format. Please try again: ");
			date = br.readLine();
		}
		
		return date;
	}
	
	//this function verify the entered date-format
	private boolean varifyDateFormat(String date) throws IOException {

		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		dateFormatter.setLenient(false);
		
		boolean isCorrectDate = false;
		
		try {
			
			dateFormatter.parse(date);
			isCorrectDate = true;
		}
		catch(ParseException pe) {
			
			isCorrectDate = false;
		}

		return isCorrectDate;
	}
}