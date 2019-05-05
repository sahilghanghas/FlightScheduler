package set09;
import java.util.*;

/*
 *	Schedules Class finds the fastest route to a location using given flights
 *	also find we can reach the destination using the current itinerary 
 */
 
public class Schedules {

	// constants
	private static final int MINUTES_IN_ONE_HOUR = 60;
	private static final int MINUTES_IN_23_HOURS = 60 * 23;
	private static final int HOURS_IN_ONE_DAY = 24;

	// GIVEN: the names of two airports, ap1 and ap2 (respectively),
    //     and a RacketList<Flight%gt; that describes all of the flights a
    //     traveller is willing to consider taking
    // RETURNS: true if and only if it is possible to fly from the
    //     first airport (ap1) to the second airport (ap2) using
    //     only the given flights
    // EXAMPLES:
    //     canGetThere ("06N", "JFK", FlightExamples.panAmFlights)  =>  false
    //     canGetThere ("JFK", "JFK", FlightExamples.panAmFlights)  =>  true
    //     canGetThere ("06N", "LAX", FlightExamples.deltaFlights)  =>  false
    //     canGetThere ("LAX", "06N", FlightExamples.deltaFlights)  =>  false
    //     canGetThere ("LGA", "PDX", FlightExamples.deltaFlights)  =>  true
	// DESIGN STRATEGY: Calling a simpler function

    public static boolean canGetThere (String ap1,
                                       String ap2,
                                       RacketList<Flight> flights) {
    	LinkedList<String> reached = new LinkedList<String>();
    	LinkedList<String> recent = new LinkedList<String>();
    	recent.add(ap1);
    	
    	
    	return reachableFromSource (reached, 
    								recent, 
    								ap2, 
    								toLinkedList(flights));
    }


    // GIVEN: a Racket list of flights
    // RETURNS: flights converted to linked list
    // STRATEGY: Call simpler functions
    // EXAMPLE: refer master methods canGetThere fastestItinerary for example
    public static LinkedList<Flight> toLinkedList(RacketList<Flight> flights) {
    	LinkedList<Flight> newFlights = new LinkedList<Flight>();
    	if(flights.isEmpty()) {
    		return newFlights;
    	}

    	else {
    		newFlights.add(flights.first());
    		newFlights.addAll(toLinkedList(flights.rest()));
    		return newFlights;
    	}
    }

    // GIVEN: a linked list of flights
    // RETURNS: flights converted to Racket list
    // STRATEGY: Call simpler functions
    // EXAMPLE: refer master methods canGetThere fastestItinerary for example
    public static RacketList<Flight> toRacketList(LinkedList<Flight> flights){
    	RacketList<Flight> newFlights = new RacketList1<Flight>();
    	if(flights.isEmpty()){
    		return newFlights;
    	}

    	else {
			for(Flight fl1 : flights) {
				newFlights.cons(fl1);
			}
			return newFlights;
    	}
    }
    
    
    // GIVEN: two lists of airport names, an airport name and a list of flights
    // RETURNS: true iff it is possible to reach the given airport 'tgt'
    // STRATEGY: recur on next-recent
    // HALTING MEASURE : length of recent or tgt in recent 
    // 		TERMINATION REASONING: If the invariant is true, then recent is
    // 		non-empty, so at the recursive call the number of airports _not_ in
    // 		'reached' is smaller.
    // EXAMPLE: see can-get-there? tests
	public static boolean reachableFromSource (LinkedList<String> reached,
			                                   LinkedList<String> recent,
			                                   String tgt,
			                                   LinkedList<Flight> flights){
		LinkedList<String> tempList = new LinkedList<String>();
		LinkedList<String> next_recent = new LinkedList<String>();
		
		
		if(recent.contains(tgt)){
			return true;
		}

		else if(recent.isEmpty()){
			return false;
		}

		else{
			reached.addAll(recent);
			tempList.addAll(allSuccessorAirports(recent,flights));
			//System.out.println(tempList);
			for(String str : tempList){
				if(! reached.contains(str)){
					next_recent.add(str);
				}
			}
			//System.out.println("Printing list");
			//printList(reached);
			//printList(next_recent);
		}
		
	     return reachableFromSource(reached, next_recent, tgt, flights);
    }
	
	public static void printList(LinkedList<String> lst) {
		for(String str : lst) {
			System.out.print(str + " ");
		}
	}


	// GIVEN: A list of airports names and a list of flight
	// RETURNS: a list of all the directly connected airports
	// STRATEGY: use while while loop on recent
	// HALTING MEASURE : length of recent
	// EXAMPLE: see test below the function
	public static LinkedList<String> allSuccessorAirports
											(LinkedList<String> recent,
    		                                 LinkedList<Flight> flights) {
		
		//Collection<String> liststr = new LinkedList<String>();
    	LinkedList<String> varList = new LinkedList<String>();
    	for(String str : recent){
    		//System.out.println(successorsOfSource(str,flights));
    		//liststr.addAll(successorsOfSource(str,flights));
    		//System.out.println(str);
    		varList.addAll(successorsOfSource(str,flights));
    		//System.out.println(varList);
    	}
    	/*while(!recent.isEmpty()){
    		varList.addAll(successorsOfSource(recent.getFirst(),flights));
    	}*/
    	return varList;
	}
	
	
	// GIVEN: an airport name and list of flight
	// RETURNS: list of successor airport names from given airport name 
	// STRATEGY: use for loop on flights
	// HALTING MEASURE : length of flights
	// EXAMPLE:(successorsOfSource 
	//           ("LGA", toLinkedList(FlightExamples.deltaFlights)))
	//    =>     [MSP, MSP, BOS, DEN, DTW, MSP]
	public static LinkedList<String> successorsOfSource( String element,
			                               	LinkedList<Flight> flights) {
		LinkedList<String> successors = new LinkedList<String>();
		if(flights.isEmpty()) {
			return successors;
		} 
		else {
			for(Flight fl : flights){
				//Flight f = flights.getFirst();
				if(element == fl.departs()) {
					successors.add(fl.arrives());
				}
				//LinkedList<Flight> flightsWithoutFirst = flights;
				//flightsWithoutFirst.removeFirst();
			
			}
		}
		//System.out.println(successors);
		return successors;
	}

	// GIVEN: the names of two airports, ap1 and ap2 (respectively),
    //     and a RacketList<Flight> that describes all of the flights a
    //     traveller is willing to consider taking
    // WHERE: it is possible to fly from the first airport (ap1) to
    //     the second airport (ap2) using only the given flights
    // RETURNS: a list of flights that tells how to fly from the
    //     first airport (ap1) to the second airport (ap2) in the
    //     least possible time, using only the given flights
    // NOTE: to simplify the problem, your program should incorporate
    //     the totally unrealistic simplification that no layover
    //     time is necessary, so it is possible to arrive at 1500
    //     and leave immediately on a different flight that departs
    //     at 1500
    // EXAMPLES:
    //     fastestItinerary ("JFK", "JFK", FlightExamples.panAmFlights)
    //         =>  RacketLists.empty()
    //
    //     fastestItinerary ("LGA", "PDX", FlightExamples.deltaFlights)
    // =>  RacketLists.empty().cons
    //         (Flights.make ("Delta 2163",
    //                        "MSP", "PDX",
    //                        UTCs.make (15, 0), UTCs.make (19, 2))).cons
    //             (Flights.make ("Delta 0121",
    //                            "LGA", "MSP",
    //                            UTCs.make (11, 0),
    //                            UTCs.make (14, 9)))
    //
    // (Note: The Java syntax for a method call makes those calls
    // to cons look backwards from what you're used to in Racket.)

    public static
        RacketList<Flight> fastestItinerary (String ap1,
                                             String ap2,
                                             RacketList<Flight> flights) {
        if((ap1 == ap2) || flights.isEmpty()){
        	return RacketLists.empty();
        }

        else if(flights.rest().isEmpty()){
        	if(ap1 == flights.first().departs() &&
        	   ap2 == flights.first().arrives()){

        		return flights;
        	}
        }

        else if(canGetThere(ap1,ap2,flights) == true){
        	PriorityQueue<Node> queue = new PriorityQueue<Node>();
        	queue = startUCS(ap1,
        					 ap2,
        					 reachableFlights(ap2,toLinkedList(flights)));

        	Node newNode = queue.poll();
        	System.out.println(newNode.travelTime);
        	return (toRacketList(newNode.itinerary));
        }
		return flights;
    }
    
    // GIVEN: a destination airport and a list of flights
    // RETURNS: a list of flights that have a route to the destination airport
    // STRATEGY: Use while loop on flights
    // HALTING MEASURE : length of flights
    // EXAMPLE: (reachable-flights "BOM" deltaFlights)
    //      => (RacketLists.empty().cons 
    // 				(Flights.make "Delta 0142" "LGA" "BOM"
    //                                       (UTCs.make 11 0)
    //                                       (UTCs.make 14 9)))
    public static LinkedList<Flight> reachableFlights(String ap2,
    		                                       LinkedList<Flight> flights){
    	LinkedList<Flight> varFlight = new LinkedList<Flight>();
    	for (Flight fl1 : flights){
    		
    		if(canGetThere(fl1.arrives(), ap2, toRacketList(flights)) == true){
    			//System.out.println("test flights" + varFlight);
    			varFlight.add(fl1);
    		}
    	}

    	return varFlight;
    }
    
    
    public static LinkedList<Flight> listDiff(LinkedList<Flight> lst1,
    										  LinkedList<Flight> lst2) {
    	LinkedList<Flight> newList = new LinkedList<Flight>();
    	for(Flight fl1 : lst1) {
	    	if(! lst2.contains(fl1)) {
	    		newList.add(fl1);
	    	}
    	}
    	return newList;
    }


    // GIVEN : the source airport, destination airport, and a list of flights
    // RETURNS : the node with least total travel time
    // STRATEGY: Use for loop on nodes
    // HALTING MEASURE : length of nodes
    // EXAMPLE: (startUCS "LGA" "PDX" FlightExamples.deltaFlights)
    //           => [("Delta 0121", "LGA", "MSP", 1100, 1409)
    //               ("Delta 2163", "MSP", "PDX", 1500, 1902)]
    public static PriorityQueue<Node> startUCS(	String source,
    											String dest,
    											LinkedList<Flight> flights) {
    	LinkedList<Node> nodes = new LinkedList<Node>();
    	LinkedList<Flight> flightsfromsource = new LinkedList<Flight>();
    	for(Flight flt : flights) {
    		if(flt.departs() == source) {
    			flightsfromsource.add(flt);
    		}
    	}
    	nodes = initializeNodes(source, flightsfromsource);
    	
    	//System.out.println("Starting nodes: " + nodes);
    	PriorityQueue<Node> newNodes = new PriorityQueue<Node>();
    	
    	
    	for( Node node: nodes ) {
    		
    		//System.out.println("Start node: " + node);
    		LinkedList<Flight> lstWithFirst = new LinkedList<Flight>();
    		lstWithFirst.add(node.itinerary.getFirst());
    		   		
    		
    		PriorityQueue<Node> queue = new PriorityQueue<Node>();
    		queue.add(node);

    		
    		Node newNode = UCS(dest, flights, queue).peek(); 
    		newNodes.add(newNode);
    		    		
    	}
    	
    	return newNodes;
    }
    
    
    // GIVEN : a list of flight 
    // RETURNS : a list of nodes, with a node for each flight
    // STRATEGY : Use for loop on flights
    // HALTING MEASURE : length of flights
    // EXAMPLES : initializeNodes("MSP", sampleList)
    //             =>  [(MSP, 840, [set09.Flight1@15db9742])]
    public static LinkedList<Node> initializeNodes(String source, 
    											LinkedList<Flight> flights) {
    	LinkedList<Node> nodes = new LinkedList<Node>();
    	for(Flight flight : flights) {
    		nodes.add(Node.fromFlight(source, flight));
    	}
    	return nodes;
    }


    // GIVEN: two UTC times
    // RETURNS: time difference between time1 and time2 in minutes
    // STRATEGY: Cases on time1 and time2 and combining simpler functions
    // EXAMPLE: (calculateTime (UTCs.make 22 33)(UTCs.make 00 11)) => 98
    public static int calculateTime(UTC time1, UTC time2) {
    	if(time1.hour() == time2.hour()) {
    		if( time1.minute() > time2.minute() ) {
    			return MINUTES_IN_23_HOURS + (time2.minute() - time1.minute());
    		} 
    		else {
    			return time2.minute() - time1.minute();
    		}
    	} 
    	else {
    		return (calculateHour(time1.hour(), time2.hour()) * 
    				MINUTES_IN_ONE_HOUR +
    				(time2.minute() - time1.minute()));
    	}
    }

    
    // GIVEN: two times in minutes
    // RETURNS: difference in the times in hours
    // STRATEGY: combining simpler functions
    // EXAMPLE: (calculateHour HOURS-IN-ONE-DAY HOURS-IN-ONE-DAY) => 0
    public static int calculateHour(int hour1, int hour2) {
    	return ((hour2 - hour1) + HOURS_IN_ONE_DAY) % HOURS_IN_ONE_DAY;
    }

    
    // GIVEN: destination airport, a list of flights and a list of nodes
    // RETURNS: a list of nodes with probable fastest itineraries 
    // STRATEGY: Combining simpler functions
    // EXAMPLE: Refer tests for fastestItinerary
    public static PriorityQueue<Node> UCS ( String dest,
    										LinkedList<Flight> flights,
    										PriorityQueue<Node> queue) {
    	
    	String tempdest = queue.peek().destination;
    	    
    	//System.out.println(tempdest);
        if(dest.equals(tempdest)) {
        	//System.out.println("In UCS: " + queue);
    		return queue;
    	} 
        
        else {
    		
    		PriorityQueue<Node> newNodes = new PriorityQueue<Node>();
    		newNodes = queue;
    		Node queueTop = newNodes.poll();
    		newNodes = insertNodes(newNodes, nextNodes( queueTop,
    										 flightsFromSource(
    												 queueTop.destination,
    												 flights
    												 )
    										 ));
    		
    		
    		return UCS(dest, flights, newNodes);
    	}


    }
    
    
    // GIVEN: the source airport abd a list of flights
    // RETURNS: a list of flights that are departing from the source airport   
    // STRATEGY: Use for loop over flights
    // HALTING MEASURE : length of flights
    // EXAMPLE: (flights-from-source "BOM" deltaFlights)
    //      => [("Delta 0122" "BOM" "IGI" 1500 1409)]
    public static LinkedList<Flight> flightsFromSource(String ap, 
    											LinkedList<Flight> flights) {
    	LinkedList<Flight> newFlights = new LinkedList<Flight>();

    	for(Flight fl : flights) {
    		if(fl.departs().equals(ap)) {
    			newFlights.add(fl);
    		}
    	}

    	return newFlights;
    }
    
    
    // GIVEN: a (Priority) Queue and a list of nodes for each arrival airport
    // RETURNS: sorted updated queue  
    // STRATEGY: Use for loop on lst
    // Halting Measure: length of lst
    // EXAMPLE: (insert-nodes PrioSAMPLEQUEUE SAMPLEList)
    //  =>  [("XYZ"
    //        63
    //        ("0604" "IJK" "XYZ" 1845 1948))
    //       ("XYZ"
    //        63
    //        ("0604" "IJK" "XYZ" 1845 19 48)]
    public static PriorityQueue<Node> insertNodes(PriorityQueue<Node> queue,
    										      LinkedList<Node> lst) {
    	if(lst.isEmpty()) {
    		return queue;
    	} else {
    		for(Node node : lst) {
    			queue.add(node);
    		}
    		//System.out.println("queue updated: " + queue);
    		return queue;
    	}	
    }


    // GIVEN: a node and a list of flights
    // RETURNS: a list of nodes of for each flight departing from arrival 
    //          airport (dest) of mem 
    // STRATEGY: Use for loop on flights
    // HALTING MEASURE : length of flights
    // EXAMPLE: (nextNodes (first PrioSAMPLEQUEUE) deltaFlights) => empty
    public static LinkedList<Node> nextNodes(Node mem, 
    										 LinkedList<Flight> flights) {
    	LinkedList<Node> newNodes = new LinkedList<Node>();

    	
    	
    	for(Flight fl : flights) {
    		LinkedList<Flight> newItinerary = new LinkedList<Flight>();
    		newItinerary.addAll(mem.itinerary);
    		newItinerary.add(fl);
    		//System.out.println("new itinerary : " + newItinerary);
    		newNodes.add(new Node(
    					fl.arrives(),
    					itineraryTime(newItinerary),
    					newItinerary
    				));
    	}
    	//System.out.println("In insertNodes : " + newNodes);
    	return newNodes;
    }

    
    // GIVEN: an itinerary from source to destination airport
    // RETURNS: total time to reach destination from source in minutes
    // STRATEGY: recur on flights
    // HALTING MEASURE: length of flights
    // EXAMPLE: (itineraryTime FlightExamples.deltaFlights) => 8882
    public static int itineraryTime(LinkedList<Flight> flights) {
    	if(flights.isEmpty()) {
    		return 0;
    	} else if(flights.size() == 1) {
    		return calculateTime(flights.getFirst().departsAt(),
    							 flights.getFirst().arrivesAt());
    	} else {
    		LinkedList<Flight> rest = (LinkedList<Flight>) flights.clone();
    		rest.removeFirst();
    		

    		return calculateTime(flights.getFirst().departsAt(),
    							 flights.getFirst().arrivesAt()) +
    			   calculateTime(flights.getFirst().arrivesAt(),
    					         flights.get(1).departsAt()) +
    			   itineraryTime(rest);
    	}
    }


    // GIVEN: the names of two airports, ap1 and ap2 (respectively),
    //     and a RacketList<Flight> that describes all of the flights a
    //     traveller is willing to consider taking
    // WHERE: it is possible to fly from the first airport (ap1) to
    //     the second airport (ap2) using only the given flights
    // RETURNS: the number of minutes it takes to fly from the first
    //     airport (ap1) to the second airport (ap2), including any
    //     layovers, by the fastest possible route that uses only
    //     the given flights
    // EXAMPLES:
    //     travelTime ("JFK", "JFK", FlightExamples.panAmFlights)  =>  0
    //     travelTime ("LGA", "PDX", FlightExamples.deltaFlights)  =>  482
    public static int travelTime (String ap1,
                                  String ap2,
                                  RacketList<Flight> flights) {
    	if((ap1 == ap2) || flights.isEmpty()){
        	return 0;
        }

        else if(flights.rest().isEmpty()){
        	if(ap1 == flights.first().departs() &&
        	   ap2 == flights.first().arrives()){

        		return calculateTime(flights.first().departsAt(),
        				             flights.first().arrivesAt());
        	}
        	else
        		return 0;
        }

        else if(canGetThere(ap1,ap2,flights) == true){
        	PriorityQueue<Node> queue = startUCS(ap1,
        										 ap2,
        						reachableFlights(ap2,toLinkedList(flights)));

        	return (queue.poll().travelTime);
        }
		return 0;
    }
    
    // main method
    public static void main (String[] args) {
    	
    	// calls SchedulesTest to test Schedules
    	SchedulesTest.main(args);
    
    }

}