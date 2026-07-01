package de.nubidentis.ss.model;

import de.nubidentis.ss.math.Vector3D;

import java.util.ArrayList;
import java.util.List;

public class Planet extends CelestialBody {
    private final List<Moon> moons = new ArrayList<>();

    public Planet(String name, double mass, Vector3D position, Vector3D velocity) {
        super(name, mass, position, velocity);
    }

    public void addMoon(Moon moon) {
        moons.add(moon);
    }

    public List<Moon> getMoons() {
        return moons;
    }
}
