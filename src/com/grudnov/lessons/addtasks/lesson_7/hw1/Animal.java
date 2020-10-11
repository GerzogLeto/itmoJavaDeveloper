package com.grudnov.lessons.addtasks.lesson_7.hw1;

public class Animal {
    protected String name;
    protected int weight;
    protected int speed;

    public Animal(String name, int weight, int speed) {
        this.name = name;
        this.weight = weight;
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}
