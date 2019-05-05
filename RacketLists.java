package set09;

// creates an object of RacketLists
public class RacketLists {
	
	// GIVEN: no arguments
    // RETURNS: an empty RacketList<E>
    
    public static <E> RacketList<E> empty () {
        return new RacketList1<E>();
    }
    
    public static void main(String[] args){
    	// calls RacketListsTests to test RacketLists
    	RacketListsTests.main(args);
    
    }
}
