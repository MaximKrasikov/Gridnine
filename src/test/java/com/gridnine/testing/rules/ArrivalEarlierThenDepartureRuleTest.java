package com.gridnine.testing.rules;

import com.gridnine.testing.entities.Flight;
import com.gridnine.testing.entities.Segment;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrivalEarlierThenDepartureRuleTest {
    @Test
    void negativeCase() {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(
                LocalDateTime.of(2022, 07, 8, 13, 0),
                LocalDateTime.of(2022, 07, 8, 12,0)
        ));
        segments.add(new Segment(
                LocalDateTime.of(2022, 07, 8, 13, 49),
                LocalDateTime.of(2022, 07, 8, 17, 58)
        ));
        Flight testFlight = new Flight(segments);
        var rule = new ArrivalEarlierThenDepartureRule();

        assertFalse(rule.isValid(testFlight));
    }

    @Test
    void positiveCase() {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(
                LocalDateTime.of(2022, 07, 8, 12,0),
                LocalDateTime.of(2022, 07, 8, 13, 0)
        ));
        segments.add(new Segment(
                LocalDateTime.of(2022, 07, 8, 13, 49),
                LocalDateTime.of(2022, 07, 8, 17, 58)
        ));
        Flight testFlight = new Flight(segments);
        var rule = new ArrivalEarlierThenDepartureRule();

        assertTrue(rule.isValid(testFlight));
    }
}
