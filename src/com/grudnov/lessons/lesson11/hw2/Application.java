package com.grudnov.lessons.lesson11.hw2;

import java.util.Arrays;
/*Задача:
написать enum, который перечисляет планеты Солнечной системы
и возвращает массу планеты, ее радиус и радиус орбиты.*/
public class Application {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Planet.values()));
    }
}
