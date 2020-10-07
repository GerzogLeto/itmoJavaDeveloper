package com.grudnov.lessons.lesson6.hw1;

public class Climber {
    private String name;
    private String countyOfResidence;

    public  Climber(String name, String countyOfResidence) {
        setName(name);
        setCountyOfResidence(countyOfResidence);
    }


    public void setName(String name) {
        if(name == null || name.length() < 3) {
            throw  new IllegalArgumentException("name of climber must be more than 3 characters");
        }
        this.name = name;
    }

    public void setCountyOfResidence(String countyOfResidence) {
        if(countyOfResidence == null || countyOfResidence.length() < 5) {
            throw  new IllegalArgumentException("Country must be more than 5 characters");
        }
        this.countyOfResidence = countyOfResidence;
    }

    public String getName() {
        return name;
    }

    public String getCountyOfResidence() {
        return countyOfResidence;
    }

    @Override
    public String toString() {
        return "Climber{" +
                "name='" + name + '\'' +
                ", countyOfResidence='" + countyOfResidence + '\'' +
                '}';
    }
}
