package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс фильтрации перелетов, время прибытия которых раньше времени отправки
 */
public class ArrivalBeforeDepartureFilter implements FilterInterface {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
