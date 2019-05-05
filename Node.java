import java.util.LinkedList;
import java.util.*;
import java.lang.Comparable;

/*
 *	Node class used to create nodes for every airport which which is reachable  
 */

public class Node implements Comparable {
	
	
	public String destination; // name of the destination
	public int travelTime; // time taken to reach here
	public LinkedList<Flight> itinerary; // route taken to here
	
	// Java Constructor
	
	public Node(String destination, 
				int travelTime, LinkedList<Flight> itinerary) {
		this.destination = destination;
		this.travelTime = travelTime;
		this.itinerary = itinerary;
	}
	
	// public methods
	
	// GIVEN: name of source airport and a flight
	// RETURNS: Node of of the arrival airport from the given source
	// STRATEGY: combine simpler functions
	// EXAMPLE: fromFlight("LAG", ("delta 2113","LGA","MSP",1100,1202))
	//   =>
	//   [("MSP",62,("delta 2113","LGA","MSP",1100,1202))]
	public static Node fromFlight(String src,Flight flight) {
		LinkedList<Flight> newItinerary = new LinkedList<Flight>();
		newItinerary.add(flight);
		
		return new Node(
					flight.arrives(),
					Schedules.calculateTime(flight.departsAt(), 
							                flight.arrivesAt()),
					newItinerary
				);
	}

	@Override 
	// RETURNS: Node details as a string
	public String toString() {
		return "(" + this.destination + ", " + this.travelTime + ", " + this.itinerary + ")";
	}
	
	@Override
	// GIVEN: a object 
	// RETURN: an integer value after comparison
	public int compareTo(Object o) {
		Node node = (Node) o;
		if(this.travelTime == node.travelTime) {
			return 0;
		} else {
			return this.travelTime > node.travelTime ? 1 : -1;
		}
	}
	
	public static void main (String[] args) {
		
		// calls NodeTests to test Node 
		NodeTests.main(args);
	}
	
}
