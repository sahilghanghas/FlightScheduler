package set09;

//tests the RacketList1 file
public class RacketList1Tests {
	
	
	// test object
	RacketList<String> testList = new RacketList1<String>();

	public static void main(String[] args) {
		
		// test object
		RacketList<String> testList = new RacketList1<String>();
		assert testList.isEmpty() == true;
				
		testList.cons("Test1");
		testList.cons("Test2");
				
		// first test
		assert testList.first() == "Test1";
				
		// rest test
		assert testList.rest().first() == "Test2";
				
		System.out.println("All unit tests of RacketList1 have passed.");
		
	}

}
