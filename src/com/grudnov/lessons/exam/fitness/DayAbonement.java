package com.grudnov.lessons.exam.fitness;

import java.time.LocalDate;
import java.time.LocalTime;

public class DayAbonement extends Abonement {


    public DayAbonement(OwnerInform ownerInform, LocalDate registrDate, LocalDate endDate) {
        super(ownerInform, registrDate, endDate);
    }

    @Override
    public boolean checkAbonement(Area area, LocalTime currentTime, LocalDate currentDate) {
        if(!(area.equals(Area.valueOf(ConstantValues.AREA_FOR_GROUP)) ||
                area.equals(Area.valueOf(ConstantValues.AREA_FOR_GYM)))){
            System.out.println("Sorry but your type of abonenement not valid in this area");
            return false;
        }
        if(!(currentDate.isAfter(this.registrDate) &&
                currentDate.isBefore(this.endDate))){
            System.out.println("Sorry but your type of abonenement not valid in this date");
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
