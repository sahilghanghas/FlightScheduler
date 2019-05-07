package set09;

public class RacketListsTests {

	public static void main(String[] args) {
		
		// test objects
		RacketList<Flight> fl1 = new RacketList1<Flight>();
		RacketList<Flight> fl2 = new RacketList1<Flight>();
		
		Flight f01 = Flights.make("Delta 2321", "LGA","MSP", UTCs.make(12, 43),UTCs.make(13, 24));
		Flight f03 = Flights.make("Delta 2421", "LAX","MSP", UTCs.make(13, 43),UTCs.make(13, 24));
		Flight f04 = Flights.make("Delta 2521", "PDX","MSP", UTCs.make(14, 43),UTCs.make(13, 24));
		
		// test
		assert fl1.isEmpty() == true : "not empty";
		
		fl1.cons(f01);
		
		assert fl1.first() == f01 : "first ! equal to f01";
		
		// test object
		Flight f02 = Flights.make("Delta 0121", "LGA", "MSP", UTCs.make(00, 21), UTCs.make(11, 12));
		fl1.cons(f02);
		fl2.cons(f02);
		fl1.cons(f03);
		fl1.cons(f04);
		fl2.cons(f03);
		fl2.cons(f04);
		
		// tests
		assert fl1.first() == f01 : "first ! equal to f01";
		assert fl1.rest() == fl2 : "rest ! equal";
		assert fl1.first() == f01 : "first ! equal to f01";
		
		System.out.println("All tests pass for RacketListsTests");

	}

}

