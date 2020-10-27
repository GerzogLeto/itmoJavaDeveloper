package com.grudnov.lessons.addtasks.lesson_10.hw3;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Application {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        LocalDate finishDate = LocalDate.of(2020, Month.DECEMBER,21);
        int countDays = 0;
        System.out.println(currentDate);
        while(currentDate.isBefore(finishDate)){
            currentDate = currentDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            if(currentDate.isAfter(finishDate)) break;
            countDays++;
        }
        currentDate = LocalDate.now();
        while(currentDate.isBefore(finishDate)){
            currentDate = currentDate.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
            if(currentDate.isAfter(finishDate)) break;
            countDays++;
        }
        currentDate = LocalDate.now();
        while(currentDate.isBefore(finishDate)){
            currentDate = currentDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
            if(currentDate.isAfter(finishDate)) break;
            countDays++;
        }
        System.out.println("remaining lectures: " + countDays);
        System.out.println("Exam will be: " + finishDate.plusWeeks(2));
    }
}
