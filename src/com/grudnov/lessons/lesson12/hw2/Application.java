package com.grudnov.lessons.lesson12.hw2;

import com.sun.source.tree.NewArrayTree;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        RuntimeException[] exceptions = new RuntimeException[9];
        int i = 0;
        try {
            int number = 100/0;
        }catch (ArithmeticException e){
            exceptions[i] = e;
            i++;
        }
        try{
            int[] arr = new int[5];
            arr[10] = 50;
        } catch (ArrayIndexOutOfBoundsException e){
            exceptions[i] = e;
            i++;
        }
        try{
           String[] str;
           str = Arrays.copyOf(exceptions,exceptions.length, String[].class);
        }catch (ArrayStoreException e){
            exceptions[i] = e;
            i++;
        }
        try{
           Cat<Integer> cat1 = new Cat(4);
           Cat<String> cat2 = new Cat("4");
           Cat[] cat3 =  new Cat[2];
           cat3[0] = cat1;
           cat3[1] = cat2;
           String str;
            for (Cat cat : cat3) {
                str = (String) cat.getAge();
            }
        }catch (ClassCastException e){
            exceptions[i] = e;
            i++;
        }
        try{
            someMeth(7);
        }catch (IllegalArgumentException e){
            exceptions[i] = e;
            i++;
        }
        try{
            String str = null;
            int count = str.length();
        }catch (NullPointerException e){
            exceptions[i] = e;
            i++;
        }
        try{
            String str = "Nope";
            int x = Integer.parseInt(str);
        }catch (NumberFormatException e){
            exceptions[i] = e;
            i++;
        }
        try{
            int i1 = -1;
            int[] arr = new int[i1];
        }catch (NegativeArraySizeException e){
            exceptions[i] = e;
            i++;
        }
        try{
            LocalDateTime localDateTime = LocalDateTime.of(1986,13,45,15,90);
        }catch (DateTimeException e){
            exceptions[i] = e;
            i++;
        }
        for (RuntimeException exception : exceptions) {
            if(exception != null) System.out.println(exception);
        }
    }

    public static void someMeth(int j){
        if(j > 5) throw new IllegalArgumentException("argument must be less than 5");
    }
}
