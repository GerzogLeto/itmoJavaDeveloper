package com.grudnov.lessons.lesson7.hwschool;

public class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        if(name == null){
            throw new IllegalArgumentException("name must not be null!");
        }
        if(age <= 0){
            throw new IllegalArgumentException("age must  be more than 0");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
