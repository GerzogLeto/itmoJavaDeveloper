package com.grudnov.lessons.lesson9.bucket;

import java.util.Arrays;
import java.util.Objects;

public class Bucket {
    private Flower[] flowers;
    private int sellCount;

    public Bucket(){
        flowers = new Flower[13];
        sellCount = 0;
    }

    public void addFlower(Flower flower){
        Objects.requireNonNull(flower,"flower must not be null");
        for (int i = 0; i < flowers.length; i++) {
            if (flowers[i] == null){
                flowers[i] = flower;
                return;
            }
        }
        System.out.println("Bucket is full");
        return;
    }

    public Flower[] getFlowers() {
        return flowers;
    }

    public int getSellCount() {
        return sellCount;
    }

    public int getPrice(){
        int sum = 0;
        for (Flower flower : flowers) {
            if(flower != null){
                sum += flower.getPrice();
            }
        }
        return sum;
    }

    public int getAverageDayStorage(){
        int aver = 0;
        int count = 0;
        for (Flower flower : flowers) {
            if(flower != null){
                aver += flower.getDayStorage();
                count++;
            }
        }
        if(count == 0) return 0;
        return aver / count;
    }

    public void sell(){
        sellCount++;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "flowers=" + Arrays.toString(flowers) +
                ", sellCount=" + sellCount +
                '}';
    }
}
