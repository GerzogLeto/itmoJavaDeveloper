package com.grudnov.lessons.addtasks.lesson_7.hw1;

public class Application {
    public static void main(String[] args) {
        Fermer fermer = new Fermer(5);
        HouseAnimal[] houseAnimals = {
                new Cow("Burenka", 200, 5, 8, 6),
                new Cat("Matroskin", 8, 15, 25, 0),
                new Chicken("Zipa", 6, 5, 4, 4),
                new Chicken("Koko", 6, 5, 4, 4),
                new Rabbit("Lucky", 3, 28, 3, 0)
        };

        WildAnimal[] wildAnimals = {
                new Wolf("Grey", 70, 25, 3),
                new Bear("Toptun", 300, 6, 5),
                new Fox("Foxy", 50, 29, 2)
        };
        while (true) {
            System.out.println(fermer.getResources());
            fermer.setResources(-2);
            if (fermer.getResources() <= 0) {
                System.out.println("Game Over");
                return;
            }
            HouseAnimal houseAnimal = houseAnimals[(int) (Math.random() * houseAnimals.length)];
            WildAnimal wildAnimal = wildAnimals[(int) (Math.random() * wildAnimals.length)];
            if (!fermer.attackWildAnimal() && wildAnimal.getLevelScare() < 4) {
                wildAnimal.attack(houseAnimal);
            } else {
                wildAnimal.scare();
            }
            fermer.feedAnimals(houseAnimals);
            int collectResources = fermer.collectResources(houseAnimals);
            System.out.println("Collect resources: " + collectResources);
            fermer.setResources(collectResources);
            if (collectResources == 0) {
                int meetResources = fermer.eatingAnimal(houseAnimals);
                System.out.println("Collect meet: " + meetResources);
                fermer.setResources(meetResources);
            }

        }
    }
}
