package set09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.PriorityQueue;


// test's the Schedules file

public class SchedulesTest {

	public static void main(String[] args) {
		
		Hashtable<String, Flight> deltaFlightTable = 
				SchedulesTest.flightAsHashTable(FlightExamples.deltaFlights);
		
		System.out.println("Testing.....");
		
		// canGetThere tests
		assert Schedules.canGetThere("LGA", "LGA", FlightExamples.deltaFlights)
			   == true : "can't get there";
		assert Schedules.canGetThere("DEN", "LAX", FlightExamples.deltaFlights)
			   == true : "can't get there";
		assert Schedules.canGetThere("DEN", "PDX", FlightExamples.deltaFlights)
			   == true : "can't get there";
		assert Schedules.canGetThere("BOS", "DTW", FlightExamples.deltaFlights)
			   == true : "can't get there";
		assert Schedules.canGetThere("LGA", "LGA", FlightExamples.panAmFlights)
			   == true : "can't get there";
		assert Schedules.canGetThere("BOS", "YTO", FlightExamples.deltaCycle)
		       == true : "can't get there";
		System.out.println("canGetThere tested");
		
		// travelTime tests
		assert Schedules.travelTime("LGA", "LGA", FlightExamples.deltaFlights)
		  	   == 0 : "wrong travel time";
		assert Schedules.travelTime("LGA", "PDX", FlightExamples.deltaFlights)
			   == 482 : "wrong travel time";
		assert Schedules.travelTime("BZN", "LGA", FlightExamples.deltaFlights)
			   == 2410 : "wrong travel time";
		assert Schedules.travelTime("BZN", "LHR", FlightExamples.deltaFlights)
			   == 2100 : "wrong travel time";
		
		System.out.println("travelTime tested");
	
		
		
		
		// fastestItinerary tests
		// Here is the itinerary from lga to pdx.
		FlightList lgaTopdx = new FlightList();
		
		lgaTopdx = lgaTopdx.cons(deltaFlightTable.get("Delta 0121"));
		lgaTopdx = lgaTopdx.cons(deltaFlightTable.get("Delta 2163"));
		
		assert lgaTopdx.isEqual(Schedules.fastestItinerary("LGA", "PDX", FlightExamples.deltaFlights)) == true : "wrong itinerary";
		assert (Schedules.fastestItinerary("LGA", "LGA", FlightExamples.panAmFlights)).isEmpty() == true : "wrong itinerary";
		assert (Schedules.fastestItinerary("LGA", "LGA", FlightExamples.deltaFlights)).isEmpty() == true : "wrong itinerary";	
		assert (Schedules.fastestItinerary("DEN", "DEN", FlightExamples.panAmFlights)).isEmpty() == true: "wrong itinerary";
	
		
		
		System.out.println("fastestItinerary tested");
		
		System.out.println ("All unit tests of Schedules passed.");
		
			
		/*
		LinkedList<Flight> sampleList = new LinkedList<Flight>();
		Flight sampleflight ;
		sampleflight = Flights.make("Delta 2167","PDX", 
						"MSP", 
						UTCs.make(22, 00),
						UTCs.make(12, 00));
		sampleList.add(sampleflight);
		System.out.println(Schedules.initializeNodes("MSP", sampleList));
		PriorityQueue<Node> PrioSAMPLEQUEUE = null;
		Node samplenode =  ["XYZ" 63 ("0604" "IJK" "XYZ" 1845 1948))]
		PrioSAMPLEQUEUE.add(samplenode);
		LinkedList<Node> SAMPLEList = null;
		SAMPLEList.add(samplenode);
		*/
		
	
	}
	// GIVEN: a RacketList of flights
	// RETURNS: a Hashtable of flights
	public static Hashtable<String, Flight> flightAsHashTable(
			RacketList<Flight> flights) {
		LinkedList<Flight> linkedListOfFlights = 
				Schedules.toLinkedList(flights);
		
		Hashtable<String, Flight> table = 
				new Hashtable<String, Flight>();
		
		for(Flight fl : linkedListOfFlights) {
			table.put(fl.name(), fl);
		}

		return table;
	}
	
	
	
	
		
	
	}
