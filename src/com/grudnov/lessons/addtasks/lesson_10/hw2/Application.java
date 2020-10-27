package com.grudnov.lessons.addtasks.lesson_10.hw2;

import java.time.LocalTime;

public class Application {
    public static void main(String[] args) {
        LocalTime currentTime = LocalTime.now();
        if(currentTime.isAfter(LocalTime.of(7,00)) &&
                currentTime.isBefore(LocalTime.of(15,00))){
            System.out.println("First working time");
            return;
        }
        if(currentTime.isAfter(LocalTime.of(15,00)) &&
                currentTime.isBefore(LocalTime.of(23,00))){
            System.out.println("Second working time");
            return;
        }
        if(currentTime.isAfter(LocalTime.of(23,00)) &&
                currentTime.isBefore(LocalTime.of(07,00))){
            System.out.println("Third working time");
            return;
        }
    }
}
