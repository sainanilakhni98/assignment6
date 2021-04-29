package com.nagarro.advancejava.assignment1.manipulation;

//import required Classes 
import com.nagarro.advancejava.assignment1.input.*;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.opencsv.exceptions.CsvException;


public class CsvReader {
	
	private static CsvReader obj;
	
	private CsvReader() {}
	
	//this function return the object of the CsvReader class
	public static synchronized CsvReader getInstance() {
		
		if(obj == null)
			obj = new CsvReader();
		
		return obj;
	}
	
	public List<List<Map<String, String>>> flightDetails = new ArrayList<>();
	
	public synchronized void addFlightDetails(List<Map<String, String>> airlineDetails) {
		
		flightDetails.add(airlineDetails);
	}

	
	//this function get the CSV file.
	private File[] getFiles() {
		
		String filePathDir = System.getProperty("user.dir") + "\\CsvFiles";
		
		File airlineDir = new File(filePathDir);
		
		File [] airlineFiles = airlineDir.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				
				return name.toLowerCase().endsWith(".csv");
			}
		});
		
		return airlineFiles;
	}
	
	
	// This Function is used for display the flight details
	public void displayFlights(UserInput user) throws IOException, CsvException, ParseException {
		
		lookFeaturesInFlight();
		
		List<Map<String, String>> filterFlights = new ArrayList<>();
		
		for(int i = 0; i < flightDetails.size(); i++) {
			
			filterFlights.addAll(filterFiles(flightDetails.get(i), user));
		}
		
		if(filterFlights.size() == 0) {
			
			System.out.println("Sorry, there are no flights available for the inputs provided.");
			return;
		}
		
		sortFlights(filterFlights, user.outputPreference);
			
		  if(user.flightClass.equalsIgnoreCase("B"))
			  updateBusinessClassFare(filterFlights);
		 
		
		for(Map<String, String> flight : filterFlights) {
			
			System.out.println(flight);
		}
	}
	
	private void lookFeaturesInFlight() throws IOException, CsvException {
		
		File[] allFiles = getFiles();
		
		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		for(File file : allFiles) {
			
			Runnable extractContent = new CsvExtractor(file);
			executor.execute(extractContent);
		}
		
		executor.shutdown();
        while (!executor.isTerminated()) {
        }
	}
	
	
	private List<Map<String, String>> filterFiles(List<Map<String, String>> airlineToFilter, UserInput user) throws ParseException {
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy"); 
		
		for(int i = 0; i < airlineToFilter.size(); i++) {
			
			Date d1 = dateFormatter.parse(airlineToFilter.get(0).get("VALID_TILL"));
			Date d2 = dateFormatter.parse(user.flightDate);
			
			if(!airlineToFilter.get(i).get("DEP_LOC").equalsIgnoreCase(user.departureLocation)) {
				
				airlineToFilter.remove(i);
				i--;
			}
			
			else if(!airlineToFilter.get(i).get("ARR_LOC").equalsIgnoreCase(user.arrivalLocation)) {
				
				airlineToFilter.remove(i);
				i--;
			}
			
			else if(!airlineToFilter.get(i).get("CLASS").toUpperCase().contains(user.flightClass.toUpperCase())) {
				
				airlineToFilter.remove(i);
				i--;
			}
			
			else if(airlineToFilter.get(i).get("SEAT_AVAILABILITY").equalsIgnoreCase("N")) {
				
				airlineToFilter.remove(i);
				i--;
			}
			
			else if(d1.compareTo(d2) < 0) {
				
				airlineToFilter.remove(i);
				i--;
			}
		}
		
		return airlineToFilter;
	}
	
	//this function will return sorted flights based on the fare or(fare and duration both) 
	
	private void sortFlights(List<Map<String, String>> filterFlights, String sortingPreference) {
		
		filterFlights.sort(new Comparator<Map<String, String>>() {

			@Override
			public int compare(Map<String, String> o1, Map<String, String> o2) {
				
				if(sortingPreference.equalsIgnoreCase("FD")) {
					
					if(o1.get("FARE").compareTo(o2.get("FARE")) == 0)
						return o1.get("FLIGHT_TIME").compareTo(o2.get("FLIGHT_TIME"));
				}
				
				return o1.get("FARE").compareTo(o2.get("FARE"));
			}
		});
	}
	
	
	//this function is for update Business class fare by increasing the 40% of the Base Fare
	private void updateBusinessClassFare(List<Map<String, String>> flights) {
		
		for(Map<String, String> flight : flights) {
			
			int fare = Integer.parseInt(flight.get("FARE"));
			
			fare = fare + (fare * 40) / 100; 
			
			flight.put("FARE", String.valueOf(fare));
		}
	}
}
