/*
 * UTCs creates an object of class UTC
 */

public class UTCs {
	// GIVEN: the hour in [0,23] and the minute in [0,59]
    // RETURNS: a UTC with that hour and minute
    //int h;
    //int m;
    public static UTC make (int h, int m) {
        return new UTC1 (h, m);
    }
    
    public static void main (String[] args) {
    	// calls UTCs.Tests to test UTCs
    	UTCsTests.main (args);
    
    }
}
