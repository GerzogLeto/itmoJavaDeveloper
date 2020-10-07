package com.grudnov.lessons.lesson6.hw2;

public class NutritionalValue {
    private String name;
    private int proteins;
    private  int fats;
    private  int carbohydrates;
    private int calories;

    public  NutritionalValue(String name){
        setName(name);

    }

    public  NutritionalValue(String name, int proteins){
        this(name);
        setProteins(proteins);

    }

    public  NutritionalValue(String name, int proteins, int fats){
        this(name, proteins);
        setFats(fats);

    }

    public  NutritionalValue(String name, int proteins, int fats, int carbohydrates){
        this(name, proteins, fats);
        setCarbohydrates(carbohydrates);

    }

    public  NutritionalValue(String name, int proteins, int fats, int carbohydrates, int calories){
        this(name, proteins, fats, carbohydrates);
        setCalories(calories);

    }
    public void setName(String name) {
        if(name == null) {
            throw new IllegalArgumentException("Product name undefined");
        }
        this.name = name;
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

    public String getName() {
        return name;
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

    @Override
    public String toString() {
        return "NutritionalValue{" +
                "name='" + name + '\'' +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", carbohydrates=" + carbohydrates +
                ", calories=" + calories +
                '}';
    }
}
