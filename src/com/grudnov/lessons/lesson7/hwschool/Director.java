package com.grudnov.lessons.lesson7.hwschool;

public class Director extends Person {

    public Director(String name, int age) {
        super(name, age);
    }

    public void startEducation(){
        System.out.println("run education!");
    }
    public void endEducation(){
        System.out.println("finish education!");
    }
}
