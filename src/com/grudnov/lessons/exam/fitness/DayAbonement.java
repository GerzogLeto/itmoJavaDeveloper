package com.grudnov.lessons.exam.fitness;

import java.time.LocalTime;

public class DayAbonement extends Abonement {


    public DayAbonement(OwnerInform ownerInform) {
        super(ownerInform);
    }

    @Override
    public boolean checkAbonement(Area area, LocalTime currentTime) {
        if(!(area.equals(Area.valueOf(ConstantValues.AREA_FOR_GROUP)) ||
                area.equals(Area.valueOf(ConstantValues.AREA_FOR_GYM)))){
            System.out.println("Sorry but your type of abonenement not valid in this area");
            return false;
        }
        if(!(currentTime.isAfter(ConstantValues.START_ABONEMENT_DAY) &&
                currentTime.isBefore(ConstantValues.FINISH_ABONEMENT_DAY))){
            System.out.println("Sorry but your type of abonenement not valid in this time");
            return false;
        }
        return true;

    }

}
