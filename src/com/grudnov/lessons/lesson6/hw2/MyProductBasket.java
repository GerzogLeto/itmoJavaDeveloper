package com.grudnov.lessons.lesson6.hw2;

import java.util.Arrays;

public class MyProductBasket {
    private int proteins;
    private  int fats;
    private  int carbohydrates;
    private int calories;
    private  NutritionalValue[] nutritionalValues;
    private int sizeBasket;


    public  MyProductBasket(int proteins, int fats, int carbohydrates, int calories, int sizeBasket) {
        setProteins(proteins);
        setFats(fats);
        setCarbohydrates(carbohydrates);
        setCalories(calories);
        setSizeBasket(sizeBasket);
        setNutritionalValues(sizeBasket);
    }

    public void setProteins(int proteins) {
        if(proteins < 0) {
            throw new IllegalArgumentException("volume of protein undefined");
        }
        this.proteins = proteins;
    }

    public void setFats(int fats) {
        if(fats < 0) {
            throw new IllegalArgumentException("volume of fats undefined");
        }
        this.fats = fats;
    }

    public void setCarbohydrates(int carbohydrates) {
        if(carbohydrates < 0) {
            throw new IllegalArgumentException("volume of carbohydrates undefined");
        }
        this.carbohydrates = carbohydrates;
    }

    public void setCalories(int calories) {
        if(calories < 0) {
            throw new IllegalArgumentException("volume of calories undefined");
        }
        this.calories = calories;
    }

    public void setSizeBasket(int sizeBasket) {
        if(sizeBasket < 0) {
            throw new IllegalArgumentException("sizeBasket undefined");
        }
        this.sizeBasket = sizeBasket;
    }

    public void setNutritionalValues(int sizeBasket) {
        this.nutritionalValues = new NutritionalValue[sizeBasket];
    }

    public int getProteins() {
        return proteins;
    }

    public int getFats() {
        return fats;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public int getCalories() {
        return calories;
    }

    public NutritionalValue[] getNutritionalValues() {
        return nutritionalValues;
    }

    public int getSizeBasket() {
        return sizeBasket;
    }
    public void addProduct(NutritionalValue nutritionalValue) {
            if(nutritionalValue.getProteins() > this.getProteins()) {
                System.out.println("Product " + nutritionalValue.getName() +
                        " cannot be added to basket. Product have too much proteins.");
                return;
            }
            if(nutritionalValue.getFats() > this.getFats()) {
                    System.out.println("Product " + nutritionalValue.getName() +
                            " cannot be added to basket. Product have too much fats.");
                return;
            }
            if(nutritionalValue.getCarbohydrates() > this.getCarbohydrates()) {
                System.out.println("Product " + nutritionalValue.getName() +
                        " cannot be added to basket. Product have too much carbohydrates.");
                return;
            }
            if(nutritionalValue.getCalories() > this.getCalories()) {
                System.out.println("Product " + nutritionalValue.getName() +
                        " cannot be added to basket. Product have too much calories.");
                return;
            }
            for (int i = 0; i < nutritionalValues.length; i++) {
                if(nutritionalValues[i] == null) {
                    nutritionalValues[i] = nutritionalValue;
                    return;
                }
                if (i == nutritionalValues.length - 1 ){
                    System.out.println("Basket is full!");
                }
            }
    }

    @Override
    public String toString() {
        return "MyProductBasket{" +
                "nutritionalValues=" + Arrays.toString(nutritionalValues) +
                '}';
    }
}
