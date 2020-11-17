package com.grudnov.lessons.lesson22.hw1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class TestFunctionInterfaces {

    public static void main(String[] args) {
        Predicate<Car> someSort = (car)->car.getPrice() < 2000 && (car.getName().equals("Nissan")||
                car.getName().equals("Toyota"));
        FactoryCars listCars = new FactoryCars(50);
        /*System.out.println(listCars.getCars());
        System.out.println("#######################");
        System.out.println(sortCars(listCars.getCars(),someSort));*/
        Function<Car, Taxi> builderTaxi = (car)->new Taxi(new Driver("Ashot",34),car);
        UnaryOperator<Car> rebuildCar = (car)->{car.setDamage(0); return car;};
        BinaryOperator<Car> getBestPrice = (car1, car2)->{
            if(car1.getPrice() > car2.getPrice()) return car2;
            else return car1;
        };

        Consumer<Car> changeColor = (car)->car.setColor("Aquamarine");
        //System.out.println(builderTaxi.apply(listCars.getCars().get(5)));
        /*System.out.println(listCars.getCars().get(5));
        changeColor.accept(listCars.getCars().get(5));
        System.out.println(listCars.getCars().get(5));*/
        //System.out.println(rebuildCar.apply(listCars.getCars().get(5)));
        //System.out.println(getBestPrice.apply(listCars.getCars().get(5),listCars.getCars().get(6)));
        listCars.getCars().sort(Comparator.comparing(Car::getName).thenComparing(Car::getColor).
                thenComparing(Car::getCity));
        System.out.println(listCars.getCars());

    }

    public static List<Car> sortCars (List<Car> cars, Predicate<Car> predicate){
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if(predicate.test(car)) result.add(car);
        }
        return  result;
    }

}
