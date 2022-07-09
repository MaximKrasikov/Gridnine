package com.gridnine.testing.services;

import com.gridnine.testing.entities.Flight;
import com.gridnine.testing.rules.Rule;

import java.util.List;

public interface FlightFilterBuilder {
    List<Flight> getFilteredFlights(List<Flight> flights, Rule... rules);
}
