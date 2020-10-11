package com.grudnov.lessons.addtasks.lesson_7.hw1;

public class Rabbit extends HouseAnimal {
    public Rabbit(String name, int weight, int speed, int health, int resources) {
        super(name, weight, speed, health, resources);
    }

    @Override
    public int getMeet() {
        if (!this.onFarm) return 0;
        this.onFarm = false;
        return this.weight;
    }

    @Override
    public int getResources() {
        return 0;
    }
}
