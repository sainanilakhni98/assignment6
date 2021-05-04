package com.nagarro.hibernate.assignment.input;

//Import Essential Classes
import java.util.List;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.nagarro.hibernate.assignment.manipulation.*;

//This is our main Class App in which we take input from user and create seesion factory for con
public class FlightSearchLauncher 
{
	
	public static void main(String[] args) {
		
		System.out.println("Welcome for Flight Searching Platform : ");
		Scanner sc = new Scanner(System.in);
		String departure,arrival,date,seatClass;
		
		System.out.print("Flight Departure Location: ");
		departure = sc.nextLine();		
		System.out.print("Flight Arrival Location: ");
		arrival = sc.nextLine();
		System.out.print("Date(dd-mm-yyyy): ");
		date = sc.nextLine();
		System.out.print("Flight Class[E or EB]: ");
		seatClass = sc.nextLine();
		System.out.print("Output Preference[0 - sort flights based on fare] [1- for both fare and duration]: ");
		int output = sc.nextInt();
		
		try(SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(FlightDataBaseCreationUsingEntity.class).buildSessionFactory()){
			FlightDataManipulation fdm = new FlightDataManipulation(factory); 
			
			//new thread to load data
			fdm.saveFlight();
			new Thread(() ->{
				fdm.saveFlight();
			}).start();
			
			List<FlightDataBaseCreationUsingEntity> flightList = fdm.takeFlights(departure.toUpperCase(),arrival.toUpperCase(),date,seatClass.toUpperCase(),output);
			if(flightList.size() == 0)
				System.out.println("Sorry! No flight is available");
			else
				flightList.forEach(System.out::println);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
