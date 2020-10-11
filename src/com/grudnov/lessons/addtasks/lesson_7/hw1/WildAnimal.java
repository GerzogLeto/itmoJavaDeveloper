package com.grudnov.lessons.addtasks.lesson_7.hw1;

public class WildAnimal extends Animal {
    protected int force;
    protected int levelScare;

    public WildAnimal(String name, int weight, int speed, int force) {
        super(name, weight, speed);
        this.force = force;
        this.levelScare = 0;
    }

    public int getLevelScare() {
        return levelScare;
    }

    public void attack(HouseAnimal houseAnimal) {
        if(!houseAnimal.isOnFarm()) return;
        if(houseAnimal.getSpeed() > this.speed) {
            System.out.println(this.name + " dos not catch " + houseAnimal.name);
        } else if(houseAnimal.health - this.force <= 0) {
            System.out.println(this.name + " kill " + houseAnimal.name);
            houseAnimal.onFarm = false;
        } else {
            System.out.println(this.name + " wounded " + houseAnimal.name);
            houseAnimal.health -= this.force;
        }
    }

    public void scare(){
        this.levelScare++;
    }
}
