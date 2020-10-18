package com.grudnov.lessons.exam.fitness;

import java.time.LocalTime;
import java.util.Objects;

public class Fitness {

    private LocalTime currentTime;
    private Area swimming;
    private Area gym;
    private Area group;

    public Fitness(Area swimming, Area gym, Area group) {
        this.swimming = Objects.requireNonNull(swimming,"swimming must not be null");
        this.gym = Objects.requireNonNull(gym,"gym must not be null");
        this.group = Objects.requireNonNull(group,"group must not be null");
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = Objects.requireNonNull(currentTime,"currentTime must not be null");
    }

    public void nextAbonement(Area area, Abonement abonement){
        if(abonement == null) {
            throw new IllegalArgumentException("abonement must not be null");
        }
        if(area == null) {
            throw new IllegalArgumentException("area must not be null");
        }
        if(currentTime.isAfter(ConstantValues.NIGHT_TIME)){
            System.out.println("Sorry but we don't work at night");
            return;
        }
        if(area.isFull()){
            System.out.println("Sorry mister but area " + area + " is full");
            return;
        }
        if(swimming.findAbonement(abonement) || gym.findAbonement(abonement) ||
                group.findAbonement(abonement) ) return;
        if(abonement.checkAbonement(area, currentTime)){
            abonement.setRegistrTime(currentTime);
            abonement.setEndTime(ConstantValues.FINISH_ABONEMENT_SINGLE);
            abonement.setVisitArea(area.name());
            area.pushAbonement(abonement);
            Logger.getInformAboutAbonement(abonement);
        }

    }

    public void getAboutAbonementsInfo(){
        Logger.getInformAboutAbonements();
    }
    public void closeClub(){
        gym.clear();
        swimming.clear();
        group.clear();
    }
}
