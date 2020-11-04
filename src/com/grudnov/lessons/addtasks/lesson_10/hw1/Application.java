package com.grudnov.lessons.addtasks.lesson_10.hw1;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Application {
    /*Самолет летит из Сиднея в Оттаву с двумя остановками в Хьюстоне и Вашингтоне.
    Самолет вылетает из Сиднея (дата любая, например 16 июня 2020) в 19:00 (время местное для Сиднея).

    Время в пути Сидней -  Хьюстон - 15 часов 35 минут
    Время ожидания в аэропорту Хьюстона - 1 час
    Время в пути  Хьюстон - Вашингтон - 2 часа 49 минут
    Время ожидания в аэропорту Вашингтона - 1 час 10 минут
    Время в пути Вашингтон - Оттава - 1 час 40 минут

    Вывести в консоль:
    Время прибытия! в аэропорт Оттавы (время местное для Оттавы)
    Время вылета! из аэропорта Хьюстона (время местное для Хьюстона)
    Время вылета! из аэропорта Вашингтона (время местное для Вашингтона)

    Часовые пояса:
    Сидней - Australia/Sydney
    Хьюстон - America/Chicago
    Вашингтон - America/New_York
    Оттава - America/Toronto */

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2020, 6,
                16, 19, 00);
        System.out.println(localDateTime);
        ZonedDateTime sid = localDateTime.atZone(ZoneId.of("Australia/Sydney"));
        System.out.println("Sidney departure: " + sid);
        sid = sid.plusHours(15).plusMinutes(35);
        ZonedDateTime hjuston = sid.withZoneSameInstant(ZoneId.of("America/Chicago"));
        System.out.println("Hjuston arrivel: " + hjuston);
        hjuston = hjuston.plusHours(1);
        System.out.println("Hjuston departure: " + hjuston);
        hjuston = hjuston.plusHours(2).plusMinutes(49);
        ZonedDateTime washington = hjuston.
                withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("Washington arrival: " + washington);
        washington = washington.plusHours(1).plusMinutes(10);
        System.out.println("Washington departure: " + washington);
        washington = washington.plusHours(1).plusMinutes(40);
        ZonedDateTime ottava = washington.withZoneSameInstant(ZoneId.of("America/Toronto"));
        System.out.println("Ottava arrival: " + ottava);
    }
}