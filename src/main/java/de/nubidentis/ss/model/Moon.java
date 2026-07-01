package de.nubidentis.ss.model;

import de.nubidentis.ss.math.Vector3D;

public class Moon extends CelestialBody {
    private final Planet parentPlanet;

    public Moon(String name, double mass, Vector3D position, Vector3D velocity, Planet parentPlanet) {
        super(name, mass, position, velocity);
        this.parentPlanet = parentPlanet;
    }

    public Planet getParentPlanet() {
        return parentPlanet;
    }
}
