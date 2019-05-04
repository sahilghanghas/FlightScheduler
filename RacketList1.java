package set09;
import java.util.*;

/*
 * RacketList1 implements the methods of RacketList 
 */

public class RacketList1<E> implements RacketList<E> {
	
	
	LinkedList<E> al = new LinkedList<E>();
	
	// the Java constructor
	public RacketList1() {
		this.al = new LinkedList<E>();
	}
	
	// public methods
	
	// RETURNS: true iff the RacketList is empty
	public boolean isEmpty() {
		return al.isEmpty();
	}

	// RETURNS: the first element of the RacketList
	public E first() {
		return al.getFirst();
	}

	// RETURNS: rest of the elements of the list excluding the first one
	public RacketList<E> rest() {
		RacketList1<E> newList = new RacketList1<E>();
		E first = al.removeFirst();
		
		newList.al = (LinkedList<E>) this.al.clone();
		this.al.add(first);
		return newList;
	}
	
	// GIVEN: an object x of type E
	// RETURNS: a RacketList with the given object added to it
	public RacketList<E> cons(E x) {
		this.al.add(x);
		return this;
	}
	
	@Override
	public String toString() {
		String str = "";
		for(E e : al) {
			str += e;
		}
		return str;
	}
	
		
	public static void main (String[] args){
		
		// calls RacketList1Tests to test RacketList1
		RacketList1Tests.main(args);
	}
	
}
