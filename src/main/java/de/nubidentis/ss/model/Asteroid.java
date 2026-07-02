package de.nubidentis.ss.model;

import de.nubidentis.ss.math.Vector3D;

public class Asteroid extends SmallBody {

    public Asteroid(
            String name,
            double mass,
            Vector3D position,
            Vector3D velocity) {

        super(name, mass, position, velocity);
    }

    public Asteroid(
            String name,
            double mass,
            Vector3D position,
            Vector3D velocity,
            double radius) {

        super(name, mass, position, velocity, radius);
    }
}