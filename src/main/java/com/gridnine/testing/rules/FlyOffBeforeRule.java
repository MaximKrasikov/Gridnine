package com.gridnine.testing.rules;

import com.gridnine.testing.entities.Flight;
import com.gridnine.testing.entities.Segment;

import java.time.LocalDateTime;
import java.util.Comparator;
/*1.Исключить -	вылет до текущего момента времени*/
public class FlyOffBeforeRule implements Rule {
    private final LocalDateTime insertedTime;

    @Override
    public boolean isValid(Flight flight) {
        return flight.getSegments()
                .stream()
                .min(Comparator.comparing(Segment::getDepartureDate))
                .map(Segment::getDepartureDate)
                .filter(firstDepartDate -> firstDepartDate.isAfter(insertedTime))
                .isPresent();
    }

    public FlyOffBeforeRule(LocalDateTime time) {
        this.insertedTime = time;
    }
}
