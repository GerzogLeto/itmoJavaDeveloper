package com.grudnov.lessons.lesson26.hw_pizzeria;

public class Order {
    private int id;
    private String NamePizza;
    private String size;
    private int cost;

    public Order() {
        String[] name = {"fourCheez","margarita", "chikenRoyal","Tropikana","goldenFish"};
        String[] size = {"low", "medium", "big"};
        this.id = (int)(Math.random()*10_000);
        this.NamePizza = name[(int)(Math.random()* name.length)];
        this.size = name[(int)(Math.random()* size.length)];
        this.cost = (int)(200 + Math.random()*600);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", NamePizza='" + NamePizza + '\'' +
                ", size='" + size + '\'' +
                ", cost=" + cost +
                '}';
    }
}
