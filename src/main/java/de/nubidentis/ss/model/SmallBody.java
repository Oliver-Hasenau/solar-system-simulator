package de.nubidentis.ss.model;

import de.nubidentis.ss.math.Vector3D;

public abstract class SmallBody extends CelestialBody {

    protected SmallBody(
            String name,
            double mass,
            Vector3D position,
            Vector3D velocity) {

        super(name, mass, position, velocity);
    }

    protected SmallBody(
            String name,
            double mass,
            Vector3D position,
            Vector3D velocity,
            double radius) {

        super(name, mass, position, velocity, radius);
    }
}