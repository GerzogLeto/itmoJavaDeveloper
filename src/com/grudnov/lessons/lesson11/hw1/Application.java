package com.grudnov.lessons.lesson11.hw1;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    /*Задача
Дано

enum должностей Position,
класс User со следующими полями: String fulName; int salary; Position position;
несколько массивов, в каждом массиве будут храниться объекты класса User с одинаковыми должностями
Пользователь вводит свои имя, фамилию и первую букву должности.
Ваша задача создать объект типа User и поместить его в соответствующий массив.
*/
    public static void main(String[] args) {
        User[][] users = new User[Position.values().length][5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = scanner.next();
        System.out.println("Enter your surname:");
        String surName = scanner.next();
        System.out.println("Enter your salary:");
        int salary = scanner.nextInt();
        System.out.println("Enter first character your  position:");
        String pos = scanner.next();
        for (Position value : Position.values()) {
            if (value.name().toLowerCase().charAt(0) ==
                    pos.toLowerCase().charAt(0)){
                for (int i = 0; i < users[value.ordinal()].length; i++) {
                        if(users[value.ordinal()][i] == null){
                            users[value.ordinal()][i] =
                                    new User(name +" " + surName, salary,value);
                            break;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(users));
    }
}
