package com.grudnov.lessons.lesson6.hw1;

import java.util.Arrays;

public class Group {
    private  boolean isRecruiting;
    private Climber[] climbers;
    private  Mountain mountain;
    private  int sizeGroup;

    public Group(boolean isRecruiting, Mountain mountain, int sizeGroup) {
        setRecruiting(isRecruiting);
        setMountain(mountain);
        setSizeGroup(sizeGroup);
        setClimbers(sizeGroup);
    }

    public void setSizeGroup(int sizeGroup) {
        if(sizeGroup < 1) {
            throw new IllegalArgumentException("Size of group must be more than 0 person");
        }
        this.sizeGroup = sizeGroup;
    }

    public void setRecruiting(boolean recruiting) {
        isRecruiting = recruiting;
    }

    public void setClimbers(int sizeGroup) {
        if(sizeGroup < 1) {
            throw new IllegalArgumentException("Size of group must be more than 0 person");
        }
        this.climbers = new Climber[sizeGroup];
    }

    public void setMountain(Mountain mountain) {
        if(mountain == null) {
            throw new IllegalArgumentException("mountain == null");
        }
        this.mountain = mountain;
    }

    public boolean isRecruiting() {
        return isRecruiting;
    }

    public Climber[] getClimbers() {
        return climbers;
    }

    public Mountain getMountain() {
        return mountain;
    }

    public int getSizeGroup() {
        return sizeGroup;
    }

    public void addClimber(Climber climber) {
        if(climber == null) {
            throw new IllegalArgumentException("Error when trying add an empty climber to tht group.");
        }
        if(isRecruiting) {
            for (int i = 0; i < climbers.length; i++) {
                if(climbers[i] == null){
                    climbers[i] = climber;
                    if(i == climbers.length - 1) setRecruiting(false);
                    return;
                }

            }
        } else {
            setRecruiting(false);
            System.out.println("Recruiting in the group is over");
        }
    }

    @Override
    public String toString() {
        return "Group{" +
                "isRecruiting=" + isRecruiting +
                ", climbers=" + Arrays.toString(climbers) +
                ", mountain=" + mountain +
                ", sizeGroup=" + sizeGroup +
                '}';
    }
}
