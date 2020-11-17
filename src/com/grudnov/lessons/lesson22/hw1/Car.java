package com.grudnov.lessons.lesson22.hw1;

public class Car {
    private int weight;
    private int power;
    private int price;
    private int age;
    private int odometer;
    private int damage;
    private String name;
    private String color;
    private String city;

    public Car(int weight, int power, int price, int age, int odometer, int damage, String name, String color, String city) {
        this.weight = weight;
        this.power = power;
        this.price = price;
        this.age = age;
        this.odometer = odometer;
        this.damage = damage;
        this.name = name;
        this.color = color;
        this.city = city;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public int getWeight() {
        return weight;
    }

    public int getPower() {
        return power;
    }

    public int getPrice() {
        return price;
    }

    public int getAge() {
        return age;
    }

    public int getOdometer() {
        return odometer;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Car{" +
                "weight=" + weight +
                ", power=" + power +
                ", price=" + price +
                ", age=" + age +
                ", odometer=" + odometer +
                ", damage=" + damage +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
