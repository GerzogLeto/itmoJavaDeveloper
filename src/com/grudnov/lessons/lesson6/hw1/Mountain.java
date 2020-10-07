package com.grudnov.lessons.lesson6.hw1;

public class Mountain {
    private String name;
    private  String country;
    private int height;

    public  Mountain(String name, String country, int height){
        setName(name);
        setCountry(country);
        setHeight(height);
    }


    public void setName(String name) {
        if(name == null || name.length() < 4) {
            throw  new IllegalArgumentException("name of mountain must be more than 4 characters");
        }
        this.name = name;
    }

    public void setCountry(String country) {
        if(country == null || country.length() < 4) {
            throw  new IllegalArgumentException("Country must be more than 4 characters");
        }
        this.country = country;
    }

    public void setHeight(int height) {
        if(height  < 100) {
            throw  new IllegalArgumentException("heght must be more than 100 meters");
        }
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", height=" + height +
                '}';
    }
}
