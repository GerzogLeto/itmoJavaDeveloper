package com.grudnov.lessons.addtasks.lesson_7.hw1;

public class Cow
        extends HouseAnimal {
    public Cow(String name, int weight, int speed, int health, int resources) {
        super(name, weight, speed, health, resources);
    }

    @Override
    public int getMeet() {
        if(!this.onFarm) return 0;
        this.onFarm = false;
        return this.weight;
    }

    @Override
    public int getResources() {
        if(!this.onFarm || this.resources <= 0) return 0;
        this.resources -= 2;
        return 2;
    }
}
