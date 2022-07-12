package com.gridnine.testing;

import com.gridnine.testing.domain.entity.Flight;
import com.gridnine.testing.service.impl.FlightFiltersImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Flight> flightsList = FlightBuilder.createFlights();

        FlightFiltersImpl flightFilters = new FlightFiltersImpl();

        System.out.println("====================================================");
        System.out.println("=============== List Of All Flights ================");
        System.out.println("====================================================");
        flightFilters.showFlights(flightsList);

        System.out.println("====================================================");
        System.out.println("= Filter 1 - Exclude Departure Before Current time =");
        System.out.println("====================================================");
        List<Flight> filter1Result = flightFilters.getFlightDepartureBeforeCurrentTime(flightsList);
        flightFilters.showFlights(filter1Result);

        System.out.println("====================================================");
        System.out.println("==== Filter 2 - Exclude Arrival Before Departure ===");
        System.out.println("====================================================");
        List<Flight> filter2Result = flightFilters.getFlightArrivalDateLessDeparture(flightsList);
        flightFilters.showFlights(filter2Result);

        System.out.println("====================================================");
        System.out.println(" Filter 3 - Exclude Transfer Time More Than 2 hours ");
        System.out.println("====================================================");
        List<Flight> filter3Result = flightFilters.getFlightTransferWaitMoreTwoHours(flightsList);
        flightFilters.showFlights(filter3Result);
    }
}
