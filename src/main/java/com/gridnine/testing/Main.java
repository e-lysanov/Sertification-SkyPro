package com.gridnine.testing;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // создаем экземпляры фильтров
        FilterInterface arrivalBeforeDeparture = new ArrivalBeforeDepartureFilter();
        FilterInterface departureBeforeNow = new DepartureBeforeNowFilter();
        FilterInterface earthTimeOverTwoHours = new EarthTimeOverTwoHoursFilter();

        // получаем заданные перелеты
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("ПЕРЕЛЕТЫ ДО ФИЛЬТРАЦИИ:");
        printFlights(flights);

        // получаем отфильтрованные перелеты
        System.out.println("\nПЕРЕЛЕТЫ, ВРЕМЯ ПРИБЫТИЯ КОТОРЫХ ПОСЛЕ ВРЕМЕНИ ОТПРАВКИ:");
        printFlights(arrivalBeforeDeparture.filter(flights));
        System.out.println("\nПЕРЕЛЕТЫ, ВРЕМЯ ОТПРАВКИ КОТОРЫХ ЕЩЕ НЕ ПРОШЛО:");
        printFlights(departureBeforeNow.filter(flights));
        System.out.println("\nПЕРЕЛЕТЫ, ВРЕМЯ ПРЕБЫВАНИЯ НА ЗЕМЛЕ КОТОРЫХ НЕ ПРЕВЫШАЕТ 2 ЧАСА:");
        printFlights(earthTimeOverTwoHours.filter(flights));
    }

    /**
     * Метод вывода перелетов
     * @param flights
     */
    private static void printFlights(List<Flight> flights) {
        for (int i = 1; i < flights.size(); i++) {
            System.out.println("Перелет: " + i);
            for (Segment segment : flights.get(i).getSegments()) {
                System.out.println(segment.getDepartureDate() + "---" + segment.getArrivalDate() + "\n");
            }
        }
    }
}
