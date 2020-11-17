package com.grudnov.lessons.lesson22.hw1;

import java.util.ArrayList;
import java.util.List;

public class FactoryCars {

    private List<Car> cars;

    public FactoryCars(int i){
        cars = new ArrayList<>();

        for (int j = 0; j < i; j++) {
            cars.add(new Car(getRandomInt(Source.weightMin, Source.weightMax),
                    getRandomInt(Source.powerMin, Source.powerMax),
                    getRandomInt(Source.priceMin, Source.priceMax),
                    getRandomInt(Source.ageMin,Source.ageMax),
                    getRandomInt(Source.odometerMin, Source.odometerMax),
                    getRandomInt(Source.damageMin,Source.damageMax),
                    getRandomStr(Source.names),
                    getRandomStr(Source.colors),
                    getRandomStr(Source.cities)
                    ));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    private int getRandomInt(int from, int to){
        return (int)(from + Math.random()*(to - from + 1));
    }

    private String getRandomStr(String[] strings){
        return strings[(int)(Math.random()* strings.length)];
    }
}
