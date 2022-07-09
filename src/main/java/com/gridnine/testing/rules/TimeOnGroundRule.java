package com.gridnine.testing.rules;

import com.gridnine.testing.entities.Segment;
import com.gridnine.testing.entities.Flight;
import com.gridnine.testing.enums.TimeFlag;

import java.time.Duration;
import java.util.List;

/*3.Исключить -	общее время, проведённое на земле превышает два часа (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним)*/
public class TimeOnGroundRule implements Rule{
    private final long hoursInMs;
    TimeFlag timeFlag;
    private long duration = 0L;
    public TimeOnGroundRule(long hours, TimeFlag timeFlag) {
        this.hoursInMs =  hours * 3_600_000;
        this.timeFlag = timeFlag;
    }
    @Override
    public boolean isValid(Flight flight) {
        List<Segment> segments = flight.getSegments();
        for (int i = 1; i < segments.size(); i++) {
             duration += Duration.between(segments.get(i - 1).getArrivalDate(), segments.get(i).getDepartureDate()).toMillis();
        }
        if(timeFlag.equals(TimeFlag.OVER))
        return duration <= hoursInMs;
        return false;
    }
}
