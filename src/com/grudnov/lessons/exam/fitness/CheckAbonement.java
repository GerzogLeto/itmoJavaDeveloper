package com.grudnov.lessons.exam.fitness;

import java.time.LocalDate;
import java.time.LocalTime;

public interface CheckAbonement {
    public boolean checkAbonement(Area area, LocalTime currentTime, LocalDate currentDate);
}
