package com.gridnine.testing;

import com.gridnine.testing.entities.Flight;
import com.gridnine.testing.rules.ArrivalEarlierThenDepartureRule;
import com.gridnine.testing.enums.TimeFlag;
import com.gridnine.testing.rules.FlyOffBeforeRule;
import com.gridnine.testing.rules.Rule;
import com.gridnine.testing.rules.TimeOnGroundRule;
import com.gridnine.testing.services.FlightFilterBuilder;
import com.gridnine.testing.services.FlightFilterBuilderImpl;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("\nBefore filtration\n");
        flights.forEach(System.out::println);

        FlightFilterBuilder flightFilterBuilder = new FlightFilterBuilderImpl();

        System.out.println("\nAfter filtration FlyOffBeforeRule\n");
        Rule[] rules1 = { new FlyOffBeforeRule(LocalDateTime.now())};
        List<Flight> filteredFlights = flightFilterBuilder.getFilteredFlights(flights, rules1);
        filteredFlights.forEach(System.out::println);

        System.out.println("\nAfter filtration ArrivalEarlierThenDepartureRule\n");

        Rule[] rules2 = {new ArrivalEarlierThenDepartureRule()};
        List<Flight> filteredFlights2 = flightFilterBuilder.getFilteredFlights(flights, rules2);
        filteredFlights2.forEach(System.out::println);

        System.out.println("\nAfter filtration TimeOnGroundRule\n");

        Rule[] rules3 = {new TimeOnGroundRule(2, TimeFlag.OVER)};
        List<Flight> filteredFlights3 = flightFilterBuilder.getFilteredFlights(flights, rules3);
        filteredFlights3.forEach(System.out::println);

    }
}
