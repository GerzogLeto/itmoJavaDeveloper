package com.grudnov.lessons.lesson6.hw1;

public class Application {
    public static void main(String[] args) {
        Climber[] climbers = {
                new Climber("Mike", "America"),
                new Climber("Kolya", "Russia"),
                new Climber("Denis", "Germany"),
        };

        Mountain[] mountains = {
                new Mountain("Elbrus", "Russia", 5642),
                new Mountain("Everest", "Nepal", 5545),
                new Mountain("Orisaba", "Mexico", 5636),
        };

        Group[] groups = {
                new Group(true, mountains[0], 3),
                new Group(true, mountains[1], 2),
                new Group(true, mountains[2], 2),
        };

        for(int i = 0; i < 3; i++) {
            groups[0].addClimber(climbers[i]);
        }
        for(int i = 0; i < 2; i++) {
            groups[1].addClimber(climbers[i]);
        }
        for(int i = 1; i < 3; i++) {
            groups[2].addClimber(climbers[i]);
        }
        

        for (Group group: groups) {
            System.out.println(group.toString());
            System.out.println(" ######### ");
        }
    }
}
