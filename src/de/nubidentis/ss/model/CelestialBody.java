package de.nubidentis.ss.model;

import de.nubidentis.ss.math.Vector3D;

public abstract class CelestialBody {
    protected String name;
    protected double mass;
    protected Vector3D position;
    protected Vector3D velocity;

    // Neuer, empfohlener Basis-Konstruktor
    protected CelestialBody(String name, double mass, Vector3D position, Vector3D velocity) {
        this.name = name;
        this.mass = mass;
        this.position = position;
        this.velocity = velocity;
    }

    public CelestialBody() {
    }

    // Getter/Setter wie bei dir vorhanden …
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public Vector3D getPosition() {
        return position;
    }

    public void setPosition(Vector3D position) {
        this.position = position;
    }

    public Vector3D getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector3D velocity) {
        this.velocity = velocity;
    }

    @Override
    public String toString() {
        return String.format("%s{name='%s', mass=%.3e, pos=(%.3e,%.3e,%.3e), vel=(%.3e,%.3e,%.3e)}",
                getClass().getSimpleName(), name, mass,
                position != null ? position.getX() : 0.0,
                position != null ? position.getY() : 0.0,
                position != null ? position.getZ() : 0.0,
                velocity != null ? velocity.getX() : 0.0,
                velocity != null ? velocity.getY() : 0.0,
                velocity != null ? velocity.getZ() : 0.0
        );
    }
}
