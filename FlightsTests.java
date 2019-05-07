public class FlightsTests {
	
	public static void main (String[] args){
		Flight fl1 = Flights.make("Delta 0121", "LGA", "MSP", UTCs.make(00, 21), UTCs.make(11, 12));
		
		assert fl1.name() == "Delta 0121" : "wrong name";
		assert fl1.departs() == "LGA" : "wrong departs";
		assert fl1.arrives() == "MSP" : "wrong arrives";
		assert fl1.departsAt().isEqual(UTCs.make(00, 21)) : "wrong departsAt";
		assert fl1.arrivesAt().isEqual(UTCs.make(11, 12)) : "wrong arrivesAt";
		
		
		System.out.println("all test cases passed for FlightTests");
	
	
	}

}

