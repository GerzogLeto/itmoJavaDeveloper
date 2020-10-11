package com.grudnov.lessons.addtasks.lesson_6.hw1;

public class Application {
    public static void main(String[] args) {
        Apple[] apples1 = {
                new Apple(27, true, true),
                new Apple(28, true, true),
                new Apple(29, true, true),
                null,
                null
        };
        Apple[] apples2 = {
                new Apple(14, true, true),
                new Apple(10, true, true),
                new Apple(5, true, true),
                null,
                null
        };

        Garden garden = new Garden(0, new Tree[]{new Tree(apples1), new Tree(apples2)});
        System.out.println(garden);
        for (int i = 0; i < 18; i++) {
            garden.calculateOneDay();
        }
        System.out.println(garden);
    }
}
