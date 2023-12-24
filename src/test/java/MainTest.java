import com.gridnine.testing.builder.FlightBuilder;
import com.gridnine.testing.filter.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.filter.DepartureBeforeNowFilter;
import com.gridnine.testing.filter.EarthTimeOverTwoHoursFilter;
import com.gridnine.testing.filter.FilterInterface;
import com.gridnine.testing.model.Flight;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MainTest {
    // экземпляры фильтров
    FilterInterface arrivalBeforeDeparture = new ArrivalBeforeDepartureFilter();
    FilterInterface departureBeforeNow = new DepartureBeforeNowFilter();
    FilterInterface earthTimeOverTwoHours = new EarthTimeOverTwoHoursFilter();

    // заданные перелеты
    List<Flight> flights = FlightBuilder.createFlights();

    @Test
    public void testArrivalBeforeDepartureFilter() {
        List<Flight> filteredFlights = arrivalBeforeDeparture.filter(flights);
        assertEquals(5, filteredFlights.size());
        assertEquals(filteredFlights.get(0), flights.get(0));
    }

    @Test
    public void testDepartureBeforeNowFilter() {
        List<Flight> filteredFlights = departureBeforeNow.filter(flights);
        assertEquals(5, filteredFlights.size());
        assertEquals(filteredFlights.get(0), flights.get(0));
    }

    @Test
    public void testEarthTimeOverTwoHoursFilter() {
        List<Flight> filteredFlights = earthTimeOverTwoHours.filter(flights);
        assertEquals(4, filteredFlights.size());
        assertEquals(filteredFlights.get(0), flights.get(0));
    }
}
