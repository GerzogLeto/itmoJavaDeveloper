package com.grudnov.lessons.addtasks.lesson_6.hw1;

import java.util.Arrays;

public class Garden {
    private int age;
    private Tree[] trees;

    public Garden(int age, Tree[] trees) {
        if(age < 0 || age > 30) {
            throw new IllegalArgumentException("age must be more than 0 ");
        }
        if(trees == null) {
            throw new IllegalArgumentException("trees must not be null!");
        }
        this.age = age;
        this.trees = trees;
    }

    public int getAmountTrees() {
        int temp = 0;
        for (Tree tree:this.trees) {
            if(tree != null) temp++;
        }
        return temp;
    }
    public void addTree(Tree tree){
        for (int i = 0; i < this.trees.length; i++) {
            if(this.trees[i] == null) {
                this.trees[i] = tree;
                return;
            }
        }
        System.out.println("Tree already full!");
    }

    public void calculateOneDay() {
        this.age++;
        for (Tree tree:trees) {
            for (Apple apple:tree.getApples()) {
                if(apple != null){
                    apple.setAge(apple.getAge() + 1);
                    if(apple.getAge() >= 30 && apple.getAge() < 32) {
                        apple.setOnTree(false);
                    }
                    if(apple.getAge() >= 32) {
                        apple.setFresh(false);
                    }
                }
            }
        }
        if(this.age % 30 == 0) {
            for (Tree tree: trees) {
                tree.addApple(new Apple(0, true, true));
            }
        }
    }

    @Override
    public String toString() {
        return "Garden{" +
                "Age=" + age +
                ", trees=" + Arrays.toString(trees) +
                '}';
    }
}
