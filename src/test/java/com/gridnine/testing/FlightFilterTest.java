package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FlightFilterTest {




    @Test
    void departureBeforeCurrentTime() {
        List<Flight> flights = FlightFilter.departureBeforeCurrentTime();
        System.out.println(flights.get(0).toString());
        System.out.println(LocalDateTime.now().isBefore(flights.get(0).getSegments().get(0).getDepartureDate()));
        assertTrue(LocalDateTime.now().isAfter(flights.get(0).getSegments().get(0).getDepartureDate()));
    }

    @Test
    void arrivalDateEarlierThanDepartureDate() {
        List<Flight> flights = FlightFilter.arrivalDateEarlierThanDepartureDate();
        assertTrue(flights.get(0).getSegments().get(0).getArrivalDate().isBefore(flights.get(0).getSegments().get(0).getDepartureDate()));
    }

    @Test
    void totalGroundTimeMoreThanTwoHours() {
        List<Flight> flights = FlightFilter.totalGroundTimeMoreThanTwoHours();

        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();

            long total = 0;
            for (int j = 0; j < segments.size() - 1; j++) {

                LocalDateTime arrivalDate = segments.get(j).getArrivalDate();
                LocalDateTime departureDate = segments.get(j + 1).getDepartureDate();

                long diffInHours = Math.abs(departureDate.getHour() - arrivalDate.getHour());
                total = total + diffInHours;
            }
            assertTrue(total > 2);

        }
    }
}