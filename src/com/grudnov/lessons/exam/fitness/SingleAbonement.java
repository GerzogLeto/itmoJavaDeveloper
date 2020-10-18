package com.grudnov.lessons.exam.fitness;

import java.time.LocalTime;

public class SingleAbonement extends Abonement {


    public SingleAbonement(OwnerInform ownerInform) {
        super(ownerInform);
    }

    @Override
    public boolean checkAbonement(Area area, LocalTime currentTime) {
        if(!(area.equals(Area.valueOf(ConstantValues.AREA_FOR_SWIMMING)) ||
                area.equals(Area.valueOf(ConstantValues.AREA_FOR_GYM)))){
            System.out.println("Sorry but your type of abonenement not valid in this area");
            return false;
        }
        if(!(currentTime.isAfter(ConstantValues.START_ABONEMENT_SINGLE) &&
                currentTime.isBefore(ConstantValues.FINISH_ABONEMENT_SINGLE))){
            System.out.println("Sorry but your type of abonenement not valid in this time");
            return false;
        }
        return true;

    }
}
