package com.grudnov.lessons.lesson9.playlist;

import java.util.Objects;

public class Track implements Cloneable {
    private String name;
    private int duration;
    private Performer performer;

    public Track(String name, int duration, Performer performer) {
        setName(name);
        setDuration(duration);
        setPerformer(performer);
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "name must not be null");
    }

    public void setDuration(int duration) {
        if (duration <= 0){
            throw new IllegalArgumentException("duration must not be less than 0");
        }
        this.duration = duration;
    }

    public void setPerformer(Performer performer) {
        this.performer = Objects.requireNonNull(performer, "performer must not be null");
    }

    public Performer getPerformer() {
        return performer;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return duration == track.duration &&
                name.equals(track.name) &&
                performer.equals(track.performer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration, performer);
    }

    @Override
    protected Track clone() throws CloneNotSupportedException {
        Track tempTrack =  (Track) super.clone();
        tempTrack.performer = this.performer.clone();
        return tempTrack;
    }

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", performer=" + performer +
                '}';
    }
}
