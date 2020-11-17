package com.grudnov.lessons.lesson22.hw1;

public class Taxi {
    private Driver driver;
    private Car automobile;

    public Taxi(Driver driver, Car automobile) {
        this.driver = driver;
        this.automobile = automobile;
    }


    @Override
    public String toString() {
        return "Taxi{" +
                "driver=" + driver +
                ", automobile=" + automobile +
                '}';
    }
}
