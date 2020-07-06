package makeMyTrip_test;

import org.testng.annotations.Test;

import makeMyTrip_Pages.SearchFlight;

public class TC_flights_home extends Setup {
	
  @Test
  public void BookFlight() throws Exception {
	  searchFlight = new SearchFlight(webDriver,pageDriver);
	  searchFlight.clearLogin();
	  searchFlight.flightFrom();
//	  searchFlight.flightTo();
//	  searchFlight.departureDate();
//	  searchFlight.returnDate();
//	  searchFlight.flightSearch();
  }
}
