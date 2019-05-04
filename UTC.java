//A UTC is an object of any class that implements UTC.
//
//Interpretation: A UTC represents a Universal Coordinated Time.

public interface UTC {

 // RETURNS: the hour, between 0 and 23 inclusive.

 int hour ();

 // RETURNS: the minute, between 0 and 59 inclusive.

 int minute ();
 
 // GIVEN: time t2 of type UTC
 // RETURNS: true iff the given UTC is equal to this UTC.

 boolean isEqual (UTC t2);
}

