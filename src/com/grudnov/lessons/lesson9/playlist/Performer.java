package com.grudnov.lessons.lesson9.playlist;

import java.util.Objects;

public class Performer implements Cloneable {
    private String name;
    private String country;

    public Performer(String name, String country) {
        setName(name);
        setCountry(country);
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "name must not be null");
    }

    public void setCountry(String country) {
        this.country = Objects.requireNonNull(country, "country must not be null");
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Performer performer = (Performer) o;
        return name.equals(performer.name) &&
                country.equals(performer.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country);
    }

    @Override
    protected Performer clone() throws CloneNotSupportedException {
        return(Performer) super.clone();
    }

    @Override
    public String toString() {
        return "Performer{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
