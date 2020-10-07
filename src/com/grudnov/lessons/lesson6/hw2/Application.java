package com.grudnov.lessons.lesson6.hw2;

public class Application {
    public static void main(String[] args) {
        NutritionalValue[] nutritionalValues = {
                new NutritionalValue("potatoes", 100, 200, 300, 400),
                new NutritionalValue("bananas", 100, 100, 100, 100),
                new NutritionalValue("fish", 300, 400, 500, 300),
                new NutritionalValue("meat", 1000, 1000, 1000, 1000),
        };

        MyProductBasket myProductBasket = new MyProductBasket(700, 700,
                700, 700, 2);
        for (NutritionalValue temp: nutritionalValues) {
            myProductBasket.addProduct(temp);
        }

        System.out.println(myProductBasket);
    }
}
