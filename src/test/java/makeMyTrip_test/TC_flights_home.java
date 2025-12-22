package makeMyTrip_test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import makeMyTrip_Pages.SearchFlight;

public class TC_flights_home extends Setup {

	@Test
	public void BookFlight() throws Exception {
		long startTime = System.currentTimeMillis();
		searchFlight = new SearchFlight(webDriver, pageDriver);
		searchFlight.clearLogin();
		searchFlight.flightFrom();
		// searchFlight.flightTo();
		// searchFlight.departureDate();
		// searchFlight.returnDate();
		// searchFlight.flightSearch();
		// assertEquals(0, 1);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;

		extendTest.log(Status.INFO, "Total test time: " + totalTime + " milliseconds");
	}
}
