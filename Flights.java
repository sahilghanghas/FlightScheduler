public class Flights {
	
    String s;
    String ap1;
    String ap2;
    UTC1 t1;
    UTC1 t2;
    
    // GIVEN: the name of a flight, the name of the airport from
    //     which the flight departs, the name of the airport at
    //     which the flight arrives, the time of departure in UTC,
    //     and the time of arrival in UTC
    // RETURNS: a flight value that encapsulates the given information
    public static Flight make (String s, String ap1, String ap2, UTC t1, UTC t2) {
        return new Flight1 (s, ap1, ap2, t1, t2);
    }
    
    public static void main(String[] args){
    	FlightsTests.main (args);
    }
}
