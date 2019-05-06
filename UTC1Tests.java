// test's the UTC1 file
public class UTC1Tests {
	
	public static void main (String[] args) {
        
		// test objects
		UTC t1 = new UTC1 (15, 31);
        UTC t2 = new UTC1 (14, 31);
        UTC t3 = new UTC1 (15, 32);
        UTC t4 = new UTC1 (15, 31);
        
        // tests
        assert t1.hour() == 15 : "wrong hour for t1";
        assert t1.minute() == 31 : "wrong minute for t1";

        assert t1.isEqual (t1) : "isEqual says this doesn't equal this";
        assert t1.isEqual (t4) : "isEqual says this doesn't equal that";
        assert ! (t1.isEqual (t2)) : "isEqual true but hour different";
        assert ! (t1.isEqual (t3)) : "isEqual true but minute different";

        System.out.println ("All unit tests of UTC1 passed.");
    }
}
