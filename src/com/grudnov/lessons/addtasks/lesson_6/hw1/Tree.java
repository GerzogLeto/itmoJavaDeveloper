package com.grudnov.lessons.addtasks.lesson_6.hw1;

import java.util.Arrays;

public class Tree {
    private Apple[] apples;

    public Tree(Apple[] apples) {
        if(apples == null){
            throw new IllegalArgumentException("apples must not be null!");
        }
        this.apples = apples;
    }

    public Apple[] getApples() {
        return apples;
    }

    public void addApple(Apple apple){
        for (int i = 0; i < this.apples.length; i++) {
            if(this.apples[i] == null) {
                this.apples[i] = apple;
                return;
            }
        }
        System.out.println("Tree already full!");
    }

    public int getAmountApples() {
        int temp = 0;
        for (Apple apple:this.apples) {
            if(apple != null) temp++;
        }
        return temp;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "apples=" + Arrays.toString(apples) +
                '}';
    }
}
