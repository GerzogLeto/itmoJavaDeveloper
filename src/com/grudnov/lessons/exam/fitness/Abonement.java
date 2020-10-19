package com.grudnov.lessons.exam.fitness;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public abstract class Abonement implements CheckAbonement {
    protected LocalDate registrDate;
    protected LocalDate endDate;
    protected OwnerInform ownerInform;
    protected String visitArea;

    public Abonement(OwnerInform ownerInform, LocalDate registrDate, LocalDate endDate) {
        this.registrDate = Objects.requireNonNull(registrDate, "registrDate must not be null");
        this.endDate = Objects.requireNonNull(endDate, "endDate must not be null");
        if(registrDate.isAfter(endDate)){
            throw new IllegalArgumentException("registration date must be less than date of end registration");
        }
        this.ownerInform = Objects.requireNonNull(ownerInform, "ownerInform must not be null");
    }


    public void setVisitArea(String visitArea) {
        this.visitArea = visitArea;
    }

    public OwnerInform getOwnerInform() {
        return ownerInform;
    }

    @Override
    public String toString() {
        return "Abonement{" +
                "ownerInformSurname=" + ownerInform.getSurname() +
                ", ownerInformName=" + ownerInform.getName() +
                ", visitArea=" + visitArea +
                ", registrDate=" + registrDate +
                ", endDate=" + endDate +
                '}';
    }
}
