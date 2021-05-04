package com.nagarro.hibernate.assignment.input;

//import essential classes
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


//This class is used for database creation using hibernate and its annotations(like entity,id) and 
//provide getter and setter methods to get and set the flight data.
@Entity
@Table(name = "flights")
public class FlightDataBaseCreationUsingEntity {
	@Id
	@Column(name = "flight_number")
	String flightNumber;
	
	@Column(name = "departure_loc")
	String departureLoc;
	
	@Column(name = "arrival_loc")
	String arrivalLoc;
	
	@Column(name = "valid_till")
	String validTill;
	
	@Column(name = "flight_time")
	String flightTime;
	
	@Column(name = "flight_duration")
	double flightDuration;
	
	@Column(name = "fare")
	double fare;
	
	@Column(name = "seat_availablity")
	String isAvailable;
	
	@Column(name = "class")
	String seatClass;

	
	
	public FlightDataBaseCreationUsingEntity() {
	}
	
	//parameterized constructor for setting the class variables. it will use when we create object of  this class and pass the values
	public FlightDataBaseCreationUsingEntity(String flightNumber, String departureLoc, String arrivalLoc, String validTill, String flightTime, double flightDuration,
			double fare, String isAvailable, String seatClass) {
		this.flightNumber = flightNumber;
		this.departureLoc = departureLoc;
		this.arrivalLoc = arrivalLoc;
		this.validTill = validTill;
		this.flightTime = flightTime;
		this.flightDuration = flightDuration;
		this.fare = fare;
		this.isAvailable = isAvailable;
		this.seatClass = seatClass;
	}

	
	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDepartureLoc() {
		return departureLoc;
	}

	public void setDepartureLOC(String departureLoc) {
		this.departureLoc = departureLoc;
	}

	public String getArrivalLoc() {
		return arrivalLoc;
	}

	public void setArrivalLOC(String arrivalLoc) {
		this.arrivalLoc = arrivalLoc;
	}

	public String getValidTill() {
		return validTill;
	}

	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}

	public String getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	public double getFlightDur() {
		return flightDuration;
	}

	public void setFlightDur(double flightDuration) {
		this.flightDuration = flightDuration;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

	@Override
	public String toString() {
		return "Flight [flightNumber= " + flightNumber + ", departureLoc=" + departureLoc + ", arrivalLoc=" + arrivalLoc + ", validTill=" + validTill
				+ ", flightTime=" + flightTime + ", flightDuration=" + flightDuration + ", fare=" + fare + ", isAvailable="
				+ isAvailable + ", seatClass=" + seatClass + "]";
	}
	
	
}
