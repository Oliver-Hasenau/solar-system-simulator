package de.nubidentis.ss.model;

import de.nubidentis.ss.math.Vector3D;

public class Comet extends SmallBody {
    private double tailLength;

    public Comet(
            String name,
            double mass,
            Vector3D position,
            Vector3D velocity,
            double tailLength) {

        super(name, mass, position, velocity);
        this.tailLength = tailLength;
    }

    public Comet(
            String name,
            double mass,
            Vector3D position,
            Vector3D velocity,
            double radius,
            double tailLength) {

        super(name, mass, position, velocity, radius);
        this.tailLength = tailLength;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }
}