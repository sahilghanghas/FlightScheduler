package set09;

/*
 * UTC1 implements the methods of the UTC
 */

class UTC1 implements UTC {
    
    int h;    // the hour, limited to [0,23]
    int m;    // the minute, limited to [0,59]

    // the Java constructor

    UTC1 (int h, int m) {
        this.h = h;
        this.m = m;
    }

    // public methods

    // RETURNS: the hour, between 0 and 23 inclusive.

    public int hour () { return h; }

    // RETURNS: the minute, between 0 and 59 inclusive.

    public int minute () { return m; }
    
    // GIVEN: t2 of UTC type
    // RETURNS: true iff the given UTC is equal to this UTC.

    public boolean isEqual (UTC t2) {
        return (h == t2.hour()) && (m == t2.minute());
    }
    
    public static void main (String[] args) {
    	// calls UTC1Tests file to test UTC1
    	UTC1Tests.main(args);
    
    }

}


