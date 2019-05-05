import java.util.*;

// Flight class is used for equating itineraries
public class FlightList extends RacketList1<Flight> {
	
	// the Java constructor
	public FlightList() {
		this.al = new LinkedList<Flight>();
	}
	
	
	
	// RETURNS: rest of the elements of the list excluding the first one
	public FlightList rest() {
		FlightList newList = new FlightList();
		Flight first = al.removeFirst();
		
		newList.al = (LinkedList<Flight>) this.al.clone();
		this.al.add(first);
		return newList;
	}
	
	// GIVEN: a Flight
	// RETURNS: this FlightList with the flight 
	//  added to it.
	public FlightList cons(Flight fl) {
		FlightList newList = new FlightList();
		newList.al = (LinkedList<Flight>) this.al.clone();
		newList.al.add(fl);
		
		return newList;
	}
	
	// GIVEN: a FlightList
	// RETURNS: whether this FlightList is equal
	//  to the given FlightList
	public boolean isEqual(RacketList<Flight> otherFlights) {
		FlightList otherFlightList = FlightList.fromRacketList(otherFlights);
		if(this.length() == otherFlightList.length()) {
			for(int i = 0; i < otherFlightList.al.size(); i++) {
				if(!this.al.get(i).isEqual(otherFlightList.al.get(i))) {
					return false;
				}
			}
			return true;
		} else {
			System.out.println("False 2");
			return false;
		}
	}
	
	
	
	
	public static FlightList fromRacketList(RacketList<Flight> flights) {
		Flight cur = flights.first();
		RacketList<Flight> rest = flights.rest();
		FlightList newFlightList = new FlightList();
		
		
		while(!rest.isEmpty()) {
			newFlightList.al.add(cur);
			cur = rest.first();
			rest = rest.rest();
		}
		newFlightList.al.add(cur);
		
		return newFlightList;
	}
	
	// RETURNS: the length of the FlightList
	public int length() {
		return al.size();
	}
	
		
	// RETURNS: a LinkedList version of the RacketList.
	public LinkedList<Flight> toLinkedList() {
		return al;
	}
	
	
	public void fromLinkedList(LinkedList<Flight> flights) {
		this.al = flights;
	}
	
	

	
	
	// RETURNS: a string representing this object
	@Override
	public String toString() {
		String str = "";
		for(Flight e : al) {
			str += e.toString();
		}
		return str;
	}
	
		
	public static void main (String[] args){
		
		// calls FlightListTests to test FlightList
		FlightListTests.main(args);
	
	}
	
}
