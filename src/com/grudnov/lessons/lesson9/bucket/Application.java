package com.grudnov.lessons.lesson9.bucket;

public class Application {
    /*Создать класс Цветок со свойствами:
название
страна производитель
срок хранения (дни)
цена
Цветы можно собирать в букеты.
По каждому букету можно получить информацию:
стоимость
срок хранения (средний по цветам)
Букет можно продать и узнать сколько всего букетов было продано
*/
    public static void main(String[] args) {
        Flower flower1 = new Flower("Rosa","Niderland",4,90);
        Flower flower2 = new Flower("Tiulpan","Armenia",5,80);
        Flower flower3 = new Flower("Gvozdika","Russia",8,30);
        Bucket bucket = new Bucket();
        bucket.addFlower(flower1);
        bucket.addFlower(flower2);
        bucket.addFlower(flower3);
        System.out.println(bucket);
        System.out.println("Price of bucket: " + bucket.getPrice());
        System.out.println("Average of dayStorage: " + bucket.getAverageDayStorage());
        System.out.println("Buckets selling: " + bucket.getSellCount());
        bucket.sell();
        System.out.println("Buckets selling: " + bucket.getSellCount());
    }
}
