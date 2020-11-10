package com.grudnov.lessons.lesson11.hw2;

public enum Planet {
    MERKURIY(3.33E23, 2.44E3, 5.79E7),
    EARTH(5.97E24, 6.378E3, 1.496E8),
    VENERA(4.76E24, 6.051E3, 1.090E8),
    MARS(6.41E23, 3.396E3, 2.280E8),
    UPITER(1.86E27, 6.9911E4,7.790E8),
    SATURN(5.68E26, 5.8232E4, 1.43E3),
    URAN(8.68E25, 2.5362E4, 2.8E9),
    NEPTUN(1.02E26, 2.4622E4, 4.55E9);
    private double weight;
    private double radius;
    private double orbitalRadius;

    Planet(double weight, double radius, double orbitalRadius) {
        setWeight(weight);
        setRadius(radius);
        setOrbitalRadius(orbitalRadius);
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setOrbitalRadius(double orbitalRadius) {
        this.orbitalRadius = orbitalRadius;
    }

    public double getWeight() {
        return weight;
    }

    public double getRadius() {
        return radius;
    }

    public double getOrbitalRadius() {
        return orbitalRadius;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name=" + this.name() +
                ", weight=" + weight + " kg. " +
                ", radius=" + radius + " km. " +
                ", orbitalRadius=" + orbitalRadius + " km " +
                '}';
    }
}
