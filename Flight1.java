/*
 * Flight1 implements the methods of the Flight
 */

public class Flight1 implements Flight{
	
    String s; // name of the flight
    String ap1; // name of the departure airport
    String ap2; // name of the arrival airport
    UTC1 t1; // departure time in UTC
    UTC1 t2; // arrival time in UTC
    
    // the public methods
    
    // the java constructor
    
    Flight1(String s, String ap1, String ap2, UTC t1, UTC t2){
    	this.s = s;
    	this.ap1 = ap1;
    	this.ap2 = ap2;
    	this.t1 = (UTC1)t1;
    	this.t2 = (UTC1)t2;
    }

	// RETURNS: name of the flight
	public String name() {
		return s;
	}

	
	// RETURNS: name of the departure airport
	public String departs() {
		return ap1;
	}

	// RETURNS: name of the arrival airport
	public String arrives() {
		return ap2;
	}

	// RETURNS: departure time of the flight
	public UTC departsAt() {
		return t1;
	}

	// RETURNS: arrival time of the flight
	public UTC arrivesAt() {
		return t2;
	}

	// GIVEN: flight
	// RETURNS: true iff the flight is equal to comparing flight
	public boolean isEqual(Flight f2) {
		return this.name().equals(f2.name()) &&
				   this.arrives().equals(f2.arrives()) &&
				   this.departs().equals(f2.departs()) &&
				   this.arrivesAt().isEqual(f2.arrivesAt()) &&
				   this.departsAt().isEqual(f2.departsAt());
	}
	

	public String toString() {
		return "(" + this.name() + 
				", " + this.departs() + 
				", " + this.arrives() + ")";
	/*	
		", " + this.arrivesAt() + 
		", " + this.departsAt() + 
	*/
	}
    
	// main method
	public static void main(String[] args){
		
		// calls Flight1Tests to test Flight1
		Flight1Tests.main(args);
	
	}
}
