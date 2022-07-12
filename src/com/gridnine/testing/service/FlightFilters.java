package com.gridnine.testing.service;

import com.gridnine.testing.domain.entity.Flight;
import java.util.List;

/**
 * @author ilyin
 * @since 10.07.2022
 */
public interface FlightFilters {
    List<Flight> getFlightDepartureBeforeCurrentTime(List<Flight> flights);
    List<Flight> getFlightArrivalDateLessDeparture(List<Flight> flights);
    List<Flight> getFlightTransferWaitMoreTwoHours(List<Flight> flights);
    void showFlights(List<Flight> flights);
}
