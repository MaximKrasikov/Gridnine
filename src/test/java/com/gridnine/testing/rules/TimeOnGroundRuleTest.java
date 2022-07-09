package com.gridnine.testing.rules;

import com.gridnine.testing.entities.Flight;
import com.gridnine.testing.entities.Segment;
import com.gridnine.testing.enums.TimeFlag;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimeOnGroundRuleTest {
    @Test
    void negativeCase() {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(
                LocalDateTime.of(2020, 12, 8, 12, 0),
                LocalDateTime.of(2020, 12, 8, 13,0)
        ));
        segments.add(new Segment(
                LocalDateTime.of(2020, 12, 8, 15, 49),
                LocalDateTime.of(2020, 12, 8, 17, 58)
        ));
        Flight testFlight = new Flight(segments);
        var rule = new TimeOnGroundRule(2, TimeFlag.OVER);

        assertFalse(rule.isValid(testFlight));
    }

    @Test
    void positiveCase() {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(
                LocalDateTime.of(2022, 7, 8, 12, 0),
                LocalDateTime.of(2022, 7, 8, 13,0)
        ));
        segments.add(new Segment(
                LocalDateTime.of(2022, 7, 8, 13, 49),
                LocalDateTime.of(2022, 7, 8, 17, 58)
        ));
        Flight testFlight = new Flight(segments);
        var rule = new TimeOnGroundRule(2, TimeFlag.OVER);

        assertTrue(rule.isValid(testFlight));
    }
}
