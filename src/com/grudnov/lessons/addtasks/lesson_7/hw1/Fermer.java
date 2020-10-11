package com.grudnov.lessons.addtasks.lesson_7.hw1;

public class Fermer {
    private int resources;

    public Fermer(int resources) {
        this.resources = resources;
    }

    public void setResources(int resources) {
        this.resources += resources;
    }

    public int getResources() {
        return resources;
    }

    public int collectResources(Resource[] resources){
        int temp = 0;
        for (Resource resource: resources) {
            temp += resource.getResources();
        }
        return  temp;

    }
    public int eatingAnimal(Meet[] meets){
        int temp = 0;
        for (Meet meet : meets) {
            temp += meet.getMeet();
            if(temp != 0) return temp;
        }
        return temp;
    }

    public boolean attackWildAnimal(){
        if(Math.random() < 0.5) return true;
        else return false;
    }

    public void feedAnimals (HouseAnimal[] houseAnimals){
        for (HouseAnimal houseAnimal: houseAnimals) {
            houseAnimal.eat();
        }
    }
}
