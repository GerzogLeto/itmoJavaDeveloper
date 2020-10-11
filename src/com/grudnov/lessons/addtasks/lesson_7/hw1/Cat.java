package com.grudnov.lessons.addtasks.lesson_7.hw1;

public class Cat
    extends HouseAnimal {
    public Cat(String name, int weight, int speed, int health, int resources) {
        super(name, weight, speed, health, resources);
    }

    @Override
    public int getMeet() {
        return 0;
    }

    @Override
    public int getResources() {
        return 0;
    }
}
