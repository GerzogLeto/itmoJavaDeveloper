package com.grudnov.lessons.lesson15.hwCars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparingExample {
    public static void main(String[] args) {

        // сортировать по значениям свойств: price, color, brand
        Car blackOpel = new Car("black", "opel", 2000);
        Car redOpel = new Car("red", "opel", 2500);
        Car yellowMazda = new Car("yellow", "mazda", 3000);
        Car greenMazda = new Car("green", "mazda", 3000);

        Comparator<Car> comparator = new BrandComparator().thenComparing(new PriceComparator()
                .thenComparing(new ColorComparator()));

        List<Car> carList = new ArrayList<>();
        carList.add(blackOpel);
        carList.add(redOpel);
        carList.add(yellowMazda);
        carList.add(greenMazda);
        System.out.println(carList);
        Collections.sort(carList, comparator);
        System.out.println(carList);
    }
}