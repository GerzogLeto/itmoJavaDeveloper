package com.grudnov.lessons.exam.fitness;

import java.time.LocalTime;

public class FullAbonement extends Abonement {

    public FullAbonement(OwnerInform ownerInform) {
        super(ownerInform);
    }

    @Override
    public boolean checkAbonement(Area area, LocalTime currentTime) {
        if(!(area.equals(Area.valueOf(ConstantValues.AREA_FOR_SWIMMING)) ||
                area.equals(Area.valueOf(ConstantValues.AREA_FOR_GYM)) ||
                area.equals(Area.valueOf(ConstantValues.AREA_FOR_GROUP)))){
            System.out.println("Sorry but your type of abonenement not valid in this area");
            return false;
        }
        if(!(currentTime.isAfter(ConstantValues.START_ABONEMENT_FULL) &&
                currentTime.isBefore(ConstantValues.FINISH_ABONEMENT_FULL))){
            System.out.println("Sorry but your type of abonenement not valid in this time");
            return false;
        }
        return true;

    }
}
