package com.grudnov.lessons.exam.fitness;

public class Logger {

    static final void getInformAboutAbonement(Abonement abonement) {
        System.out.println(abonement);
    }

    static final void getInformAboutAbonements(){
        for (Area area :Area.values() ) {
            System.out.println("members of " + area);
            for (Abonement abonement : area.getAbonements() ) {
                if(abonement != null){
                    System.out.println(abonement);
                }
            }

        }
    }

}
