// test's the UTCs file
public class UTCsTests {
	public static void main (String[] args) {

        // We'll do these tests several times, to increase the
        // probability that objects of different classes will be created.

        int NTESTS = 5;    // how many times we'll run each test

        for (int i = 0; i < NTESTS; i = i + 1) {
            
        	// test objects
        	UTC t0000 = UTCs.make (0, 0);      // always test boundary cases
            UTC t0059 = UTCs.make (0, 59);
            UTC t2300 = UTCs.make (23, 0);
            
            // tests
            assert t0000.hour() == 0    : "wrong hour for t0000";
            assert t0000.minute() == 0  : "wrong minute for t0000";
            assert t0059.hour() == 0    : "wrong hour for t0059";
            assert t0059.minute() == 59 : "wrong minute for t0059";
            assert t2300.hour() == 23 : "wrong minute for t2300";
            assert t2300.minute() == 0 : "wrong minute for t2300";
            
        }
		
        
		System.out.println ("UTCs tests passed.");
    }
}
