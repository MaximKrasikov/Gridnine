package com.gridnine.testing.services;

import com.gridnine.testing.entities.Flight;
import com.gridnine.testing.rules.Rule;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightFilterBuilderImpl implements FlightFilterBuilder {

    @Override
    public List<Flight> getFilteredFlights(List<Flight> flights, Rule... rules) {
        Stream<Flight> stream = flights.stream();
        for(Rule rule : rules){
            stream = stream.filter(rule::isValid);
        }

        return stream.collect(Collectors.toList());
    }
}
