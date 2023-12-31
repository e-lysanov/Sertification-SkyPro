package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;

import java.util.List;

/**
 * Интерфейс фильтрации перелетов
 */
public interface FilterInterface {
    List<Flight> filter(List<Flight> flights);
}
