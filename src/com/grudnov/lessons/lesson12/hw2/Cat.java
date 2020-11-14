package com.grudnov.lessons.lesson12.hw2;

public class Cat<T> {
    private T age;

    public Cat(T age) {
        this.age = age;
    }

    public T getAge() {
        return age;
    }
}
