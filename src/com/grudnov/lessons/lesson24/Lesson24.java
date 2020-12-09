package com.grudnov.lessons.lesson24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CopyOnWriteArrayList;

public class Lesson24 {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Course> courses = new CopyOnWriteArrayList<>();

        // #1. создание потока
        Thread writer = new Writer(courses);
        writer.setName("WRITER");

        // передача потока 'планировщику'
        writer.start();

        // #2.1 создание потока
        Thread reader = new Thread(new Reader(courses));
        reader.setName("READER");
        reader.start();

        // #2.2
        Thread simpleTask = new Thread(()->{ // реализация метода run интерфейса Runnable
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println(Thread.currentThread().getName() +
                        " прочитал курсы " +
                        Files.readAllLines(Paths.get("sources/lesson24.txt")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        simpleTask.setName("SIMPLE_TASK");
        simpleTask.start();

        // завершение программы произойдет, когда завершатся все потоки
        // основной поток завершится, когда выполнит все свои инструкции
    }
}
