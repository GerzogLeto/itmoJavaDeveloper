package com.grudnov.lessons.exam.fitness;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        Fitness fitness = new Fitness(Area.SWIMMING, Area.GYM, Area.GROUP);
        fitness.setCurrentDate(LocalDate.of(2020, 10, 20));
        SingleAbonement[] singleAbonements = new SingleAbonement[20];
        for (int i = 0; i < singleAbonements.length; i++) {
            singleAbonements[i] = new SingleAbonement(new OwnerInform("Kolya", "Kozlov",
                    (int)(1960 + Math.random() * 40)),LocalDate.of(2020, 10, 20),
                    LocalDate.of(2020, 10, 20));

        }
        DayAbonement[] dayAbonements = new DayAbonement[20];
        for (int i = 0; i < dayAbonements.length; i++) {
            dayAbonements[i] = new DayAbonement(new OwnerInform("Vasya", "Novikov",
                    (int)(1960 + Math.random() * 50)), LocalDate.of(2020, 10, 3),
                    LocalDate.of(2020, 10, 28));

        }
        FullAbonement[] fullAbonements = new FullAbonement[20];
        for (int i = 0; i < fullAbonements.length; i++) {
            fullAbonements[i] = new FullAbonement(new OwnerInform("Misha", "Zotnikov",
                    (int)(1960 + Math.random() * 30)), LocalDate.of(2020, 10, 3),
                    LocalDate.of(2020, 10, 28));

        }
        for (int i = 0; i < 100; i++) {
            if(Math.random() < 0.3){
                fitness.setCurrentTime(ConstantValues.getCurrentTime());
                fitness.nextAbonement(Area.SWIMMING, singleAbonements[(int)(Math.random() * 20)]);
                fitness.setCurrentTime(ConstantValues.getCurrentTime());
                fitness.nextAbonement(Area.GYM, singleAbonements[(int)(Math.random() * 20)]);
                fitness.setCurrentTime(ConstantValues.getCurrentTime());
                fitness.nextAbonement(Area.GROUP, singleAbonements[(int)(Math.random() * 20)]);
            }
            if(Math.random() < 0.6){
                fitness.setCurrentTime(ConstantValues.getCurrentTime());
                fitness.nextAbonement(Area.SWIMMING, dayAbonements[(int)(Math.random() * 20)]);
                fitness.setCurrentTime(ConstantValues.getCurrentTime());
                fitness.nextAbonement(Area.GYM, dayAbonements[(int)(Math.random() * 20)]);
                fitness.setCurrentTime(ConstantValues.getCurrentTime());
                fitness.nextAbonement(Area.GROUP, dayAbonements[(int)(Math.random() * 20)]);
            }
            if(Math.random() < 0.9){
                fitness.setCurrentTime(ConstantValues.getCurrentTime());
                fitness.nextAbonement(Area.SWIMMING, fullAbonements[(int)(Math.random() * 20)]);
                fitness.setCurrentTime(ConstantValues.getCurrentTime());
                fitness.nextAbonement(Area.GYM, fullAbonements[(int)(Math.random() * 20)]);
                fitness.setCurrentTime(ConstantValues.getCurrentTime());
                fitness.nextAbonement(Area.GROUP, fullAbonements[(int)(Math.random() * 20)]);
            }
        }
        System.out.println("In swimming area " + Area.SWIMMING.getCount() + " clients");
        System.out.println("In GYM area " + Area.GYM.getCount() + " clients");
        System.out.println("In GROUP area " + Area.GROUP.getCount() + " clients");
        fitness.getAboutAbonementsInfo();
        fitness.closeClub();
        fitness.getAboutAbonementsInfo();
    }
}
