package com.nagarro.advancejava.assignment1.manipulation;

//import required classes
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.util.HashMap;

public class CsvExtractor implements Runnable {
	
	File file;
	
	public CsvExtractor(File file) {
		
		this.file = file;
	}
	
	@Override
	public void run() {
		
		try {
			
			CsvReader obj = CsvReader.getInstance();
			obj.addFlightDetails(extractCsv(file));
			
		} catch (IOException | CsvException e) {
			
			e.printStackTrace();
		}
	}

	private List<Map<String, String>> extractCsv(File file) throws IOException, CsvException {
		
		CSVReader csvReader = new CSVReader(new FileReader(file));
		
		List<String[]> csvContent = csvReader.readAll();
		
		return transformCsvToList(csvContent);
	}
	
	// this function is used to transform the csv file to list using spliting the data by | 
	private List<Map<String, String>> transformCsvToList(List<String[]> csvContent) {
		
		List<Map<String, String>> flightDetails = new ArrayList<>();
		
		String[] headers = csvContent.get(0)[0].split("\\|");
		
		for(int i = 1; i < csvContent.size(); i++) {
			
			String[] cols = csvContent.get(i)[0].split("\\|");
			
			Map<String, String> keyValueflightDetails = new HashMap<>();
			
			for(int j = 0; j < cols.length; j++) {
				
				keyValueflightDetails.put(headers[j], cols[j]);
			}
			flightDetails.add(keyValueflightDetails);
		}
		
		return flightDetails;
	}
}
