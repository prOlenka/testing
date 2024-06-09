package com.gridnine.testing;

public class TestingApplication {

	public static void main(String[] args) {

		System.out.println(FlightBuilder.createFlights());

		System.out.println(FlightFilter.departureBeforeCurrentTime());
		System.out.println(FlightFilter.arrivalDateEarlierThanDepartureDate());
		System.out.println(FlightFilter.totalGroundTimeMoreThanTwoHours());
	}

}
