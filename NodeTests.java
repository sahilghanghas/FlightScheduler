package set09;

import java.util.LinkedList;

// test's the Node file
public class NodeTests {

	public static void main(String[] args) {
		
		//test objects
		LinkedList<Flight> itinerary1 = new LinkedList<Flight>();
		LinkedList<Flight> itinerary2 = new LinkedList<Flight>();
		
		itinerary1.add(FlightExamples.deltaFlights.first());
		itinerary2.add(FlightExamples.deltaFlights.rest().first());
		
		//test objects
		Node testNode1 = new Node("PDX", 242, itinerary1);
		Node testNode2 = new Node("LGA", 333, itinerary2);
		Node testNode3 = new Node("PDX", 242, itinerary1);
		
		//tests
		assert testNode1.compareTo(testNode2) == -1;
		assert testNode2.compareTo(testNode1) == 1;
		assert testNode1.compareTo(testNode3) == 0;
		
		System.out.print("All unit test of Node passed.");

	}

}
