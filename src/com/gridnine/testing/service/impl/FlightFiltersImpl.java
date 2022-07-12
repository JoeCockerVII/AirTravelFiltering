package com.gridnine.testing.service.impl;

import com.gridnine.testing.domain.entity.Flight;
import com.gridnine.testing.service.FlightFilters;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ilyin
 * @since 10.07.2022
 */
public class FlightFiltersImpl implements FlightFilters {

    public List<Flight> getFlightDepartureBeforeCurrentTime(List<Flight> flights){

        LocalDateTime currentTime = LocalDateTime.now();

        List<Flight> flightsFiltered = new ArrayList<>();
        for (Flight flight:flights) {
            if(flight.getSegments().stream().anyMatch(s -> s.getDepartureDate().isAfter(currentTime)))
                flightsFiltered.add(flight);
        }
        return flightsFiltered;
    }

    public List<Flight> getFlightArrivalDateLessDeparture(List<Flight> flights){
        List<Flight> flightsFiltered = new ArrayList<>();
        for (Flight flight:flights) {
            if(flight.getSegments().stream().anyMatch(s -> s.getArrivalDate().isAfter(s.getDepartureDate())))
                flightsFiltered.add(flight);
        }
        return flightsFiltered;
    }

    public List<Flight> getFlightTransferWaitMoreTwoHours(List<Flight> flights){

        List<Flight> flightsFiltered = new ArrayList<>();
        Duration waitTransferTime = Duration.ZERO;

        for (Flight flight:flights) {
            for (int i = 1; i < flight.getSegments().size(); i++) {
                waitTransferTime = waitTransferTime.plus(
                        Duration.between(flight.getSegments().get(i-1).getArrivalDate(), flight.getSegments().get(i).getDepartureDate())).abs();
            }
            if(waitTransferTime.toHours() <= 2) {
                flightsFiltered.add(flight);
            }
            waitTransferTime = Duration.ZERO;
        }
        return flightsFiltered;
    }

    public void showFlights(List<Flight> flights) {
        int j = 1;
        for (Flight flight : flights) {
            System.out.println("Flight " + flight.getId());
            for(int i = 0; i < flight.getSegments().size(); i++) {
                System.out.println("        Segment "+ i + " " + flight.getSegments().get(i));
            }
        }
    }

}
