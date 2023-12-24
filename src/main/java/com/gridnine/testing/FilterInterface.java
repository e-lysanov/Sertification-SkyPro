package com.gridnine.testing;

import java.util.List;

/**
 * Интерфейс фильтрации перелетов
 */
public interface FilterInterface {
    List<Flight> filter(List<Flight> flights);
}
