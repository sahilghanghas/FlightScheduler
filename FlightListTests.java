// test's the FLightList
public class FlightListTests {
	
	// GIVEN: the name of a flight, the airports of departure and
    //     arrival, and the departure and arrival times represented
    //     as integers using the encoding of Problem Set 00,
    // RETURNS: a flight with the given name, airports, and times
	// Function from FlightExamples.java

    private static Flight flt (String s, String ap1, String ap2,
                               int t1, int t2) {
        UTC lv = UTCs.make (t1 / 100, t1 % 100);
        UTC ar = UTCs.make (t2 / 100, t2 % 100);
        return Flights.make (s, ap1, ap2, lv, ar);
    }
	
	public static void main(String[] args) {
		/*
		 * FlightList adds three new functions
		 * to the RacketList1 class:
		 * 	**isEqual
		 * I'll assume these are tested for now because they 
		 * are such simple functions.
		 *  length
		 *  toLinkedList 
		 *  fromLinkedList
		 *  toString
		 */
		
		
		// test object
		FlightList testList1 = new FlightList();
		FlightList testList2 = new FlightList();
		assert testList1.isEmpty() == true;
		assert testList2.isEmpty() == true;
		
		testList1 = testList1.cons(flt 
				("Delta 0105", "BOS", "ATL", 1950, 2259));
		testList1 = testList1.cons(flt 
				("Delta 1894", "BOS", "MSP", 1355, 1730));
		
		testList2 = testList2.cons(flt 
				("Delta 0105", "BOS", "ATL", 1950, 2259));
		testList2 = testList2.cons(flt 
				("Delta 1894", "BOS", "MSP", 1355, 1730));
		
		
		System.out.println(testList1);
		System.out.println(testList2);

		// isEqual test
		assert testList1.isEqual(testList2) == true;
		
		// first test
		assert testList1.first().isEqual(flt 
				("Delta 0105", "BOS", "ATL", 1950, 2259)) == true;
		
		// rest test
		assert testList1.rest().first().isEqual(flt 
				("Delta 1894", "BOS", "MSP", 1355, 1730)) == true;
		
		System.out.println("All unit tests of RacketList1 have passed.");		
	}

	

}
