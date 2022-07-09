package com.gridnine.testing.rules;

import com.gridnine.testing.entities.Segment;
import com.gridnine.testing.entities.Flight;

import java.util.function.Predicate;
/*2.Исключить -	имеются сегменты с датой прилёта раньше даты вылета*/
public class ArrivalEarlierThenDepartureRule  implements Rule {
    @Override
    public boolean isValid(Flight flight) {
        return flight.getSegments()
                .stream()
                .noneMatch(arrivalEarlierThenDeparturePredicate());
    }

    private Predicate<Segment> arrivalEarlierThenDeparturePredicate() {
        return segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate());
    }
}