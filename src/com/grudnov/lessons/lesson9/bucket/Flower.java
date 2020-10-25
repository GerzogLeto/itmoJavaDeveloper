package com.grudnov.lessons.lesson9.bucket;

import java.util.Objects;

public class Flower {
    private String name;
    private String country;
    private int dayStorage;
    private int price;

    public Flower(String name, String country, int dayStorage, int price) {
        setName(name);
        setCountry(country);
        setDayStorage(dayStorage);
        setPrice(price);
    }

    public void setDayStorage(int dayStorage) {
        if(dayStorage <= 0){
            throw new IllegalArgumentException("dayStorage must not be less than 0");
        }
        this.dayStorage = dayStorage;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name,"name must not be null");
    }

    public void setCountry(String country) {
        this.country = Objects.requireNonNull(country,"country must not be null");
    }

    public void setPrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("price must not be less than 0");
        }
        this.price = price;
    }

    public int getDayStorage() {
        return dayStorage;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", dayStorage=" + dayStorage +
                ", price=" + price +
                '}';
    }
}
