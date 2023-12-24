package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс фильтрации перелетов, время пребывания на земле которых превышает 2 часа
 */
public class EarthTimeOverTwoHoursFilter implements FilterInterface {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> getEarthTime(flight) <= 2)
                .collect(Collectors.toList());
    }

    /**
     * Метод получения времени, проведенного в течение перелета на земле
     */
    private int getEarthTime(Flight flight) {
        List<Segment> segments = flight.getSegments();
        int earthTime = 0;
        for (int i = 0; i < segments.size() - 1; i++) {
            // дата прибытия отдельного взятого сегмента
            LocalDateTime arrival = segments.get(i).getArrivalDate();
            // дата отправки следующего сегмента
            LocalDateTime departure = segments.get(i + 1).getDepartureDate();
            // увеличение времени, проведенного на земле, на разницу часов полученных датs
            earthTime += arrival.until(departure, ChronoUnit.HOURS);
        }
        return earthTime;
    }
}
