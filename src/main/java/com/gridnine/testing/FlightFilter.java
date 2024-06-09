package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightFilter {
    public static List<Flight> departureBeforeCurrentTime() {
        return FlightBuilder.createFlights().stream().filter(f -> f.getSegments().get(0).getDepartureDate().isBefore(LocalDateTime.now())).toList();
    }

    public static List<Flight> arrivalDateEarlierThanDepartureDate() {
        return FlightBuilder.createFlights().stream().filter(f -> f.getSegments().get(0).getArrivalDate().isBefore(f.getSegments().get(0).getDepartureDate())).toList();
    }

    public static List<Flight> totalGroundTimeMoreThanTwoHours() {

        List<Flight> flights = FlightBuilder.createFlights();
        List<Flight> results = new ArrayList<>();

        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();

            long total = 0;
            for (int j = 0; j < segments.size() - 1; j++) {

                LocalDateTime arrivalDate = segments.get(j).getArrivalDate();
                LocalDateTime departureDate = segments.get(j + 1).getDepartureDate();

                long diffInHours = Math.abs(departureDate.getHour() - arrivalDate.getHour());
                total = total + diffInHours;
            }
            if (total > 2) {
                results.add(flight);
            }

        }

        return results;
    }
}
