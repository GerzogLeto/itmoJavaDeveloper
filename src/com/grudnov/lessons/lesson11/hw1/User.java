package com.grudnov.lessons.lesson11.hw1;

public class User {
    private String fullName;
    private int salary;
    Position position;

    public User(String fullName, int salary, Position position) {
        setFullName(fullName);
        setSalary(salary);
        setPosition(position);
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", salary=" + salary +
                ", position=" + position +
                '}';
    }
}
