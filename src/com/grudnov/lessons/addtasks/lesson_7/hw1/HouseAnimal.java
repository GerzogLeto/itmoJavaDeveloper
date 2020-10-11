package com.grudnov.lessons.addtasks.lesson_7.hw1;

public abstract class HouseAnimal extends Animal implements Resource, Meet {
    protected int health;
    protected int resources;
    protected int startHelth;
    protected boolean onFarm = true;


    public HouseAnimal(String name, int weight, int speed, int health, int resources) {
        super(name, weight, speed);
        this.health = health;
        this.resources = resources;
        this.startHelth = health;
    }

    public boolean isOnFarm() {
        return onFarm;
    }

    public void run(){

    }
    public void eat(){
        if(this.startHelth > this.health + 1) this.health++;

    }
}
