package com.nagarro.hibernate.assignment.manipulation;

//import Essential classes
import com.nagarro.hibernate.assignment.input.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

//this class is used for flight data manipulation and provide methods for flitering flights based on the user input
public class FlightDataManipulation implements FlightInterface{
	
	private SessionFactory sessionFactory;
	
	
	
	public FlightDataManipulation(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public List<FlightDataBaseCreationUsingEntity> takeFlights() {			
		Session Session = sessionFactory.openSession();
		Session.beginTransaction();
		Query<FlightDataBaseCreationUsingEntity> q = Session.createQuery("from FlightDataBaseCreationUsingEntity");
		List<FlightDataBaseCreationUsingEntity> flights = q.getResultList();
		Session.close();
		return flights;
	}
	

	public List<FlightDataBaseCreationUsingEntity> takeFlights(String departure, String arrival, String date, String seatClass,int preference){
		Session Session = sessionFactory.getCurrentSession();
		Session.beginTransaction();
		String sortCol = "fare";
		if(preference == 1)
			sortCol += ",flight_dur";
		Query q = Session.createQuery("from FlightDataBaseCreationUsingEntity f where f.departureLoc =: departure AND f.arrivalLoc =: arrival AND f.validTill >=: date"
				+ " AND f.seatClass =: seatClass"
				+" order by " + sortCol);
		q.setParameter("departure",departure);
		q.setParameter("arrival",arrival);
		q.setParameter("date",date);
		q.setParameter("seatClass",seatClass);		
		List<FlightDataBaseCreationUsingEntity> flights = q.getResultList();
		Session.getTransaction().commit();
		Session.close();
		if(!seatClass.equals("E")) {
			for(FlightDataBaseCreationUsingEntity f: flights)
				f.setFare(1.4 * f.getFare());
		}	
		return flights;
	}
	
	public void saveFlight() {
		
		File[] csvFiles = new File("CsvFiles\\")
				.listFiles((dir,name) -> 
		        name.endsWith(".csv"));
		
		List<String> fileNames = new ArrayList<>();
		
		for(File file: csvFiles)
			if(file.isFile())
				fileNames.add(file.getName());
		
		for(String fileName : fileNames) {
			String path = "CsvFiles\\" + fileName;
		
		File file = new File(path);
		
		try(BufferedReader bf = new BufferedReader(new FileReader(file))) {
			String line = bf.readLine();
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yogesh","root","root");
			Statement stmnt = connection.createStatement();
			
			while((line = bf.readLine()) != null) {
				String[] par = line.split("\\|");
				
				FlightDataBaseCreationUsingEntity flight = new FlightDataBaseCreationUsingEntity(par[0],par[1],par[2],par[3],par[4],Double.parseDouble(par[5]),Double.parseDouble(par[6]),par[7],par[8]);
				String sql = "insert into flights values('"+par[0]+"','"+par[1]+"','"+par[2]+"','"+par[3]+"','"+par[4]+"',"+Double.parseDouble(par[5])+","
				+Double.parseDouble(par[6])+",'"+par[7]+"','"+par[8]+"')";		
				
				ResultSet res = stmnt.executeQuery("select * from flights where flight_number = " +"'"+par[0]+"'");
				if(res.next())
					continue;
				stmnt.execute(sql);				
			}
			connection.close();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}}
		
		//sessionFactory.close();
	}


}
