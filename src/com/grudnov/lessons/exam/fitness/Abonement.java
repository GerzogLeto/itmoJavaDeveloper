package com.grudnov.lessons.exam.fitness;

import java.time.LocalTime;
import java.util.Objects;

public abstract class Abonement implements CheckAbonement {
    protected LocalTime registrTime;
    protected LocalTime endTime;
    protected OwnerInform ownerInform;
    protected String visitArea;

    public Abonement(OwnerInform ownerInform) {
        this.ownerInform = Objects.requireNonNull(ownerInform, "ownerInform must not be null");
    }

    public void setRegistrTime(LocalTime registrTime) {
        this.registrTime = Objects.requireNonNull(registrTime, "registrTime must not be null");
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = Objects.requireNonNull(endTime, "endTime must not be null");
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
                ", registrTime=" + registrTime +
                ", endTime=" + endTime +
                '}';
    }
}
