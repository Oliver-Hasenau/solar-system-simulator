package de.nubidentis.ss.model;

import de.nubidentis.ss.math.Vector3D;

public class BlackHole extends Star {

    public BlackHole(
            String name,
            double mass,
            Vector3D position,
            Vector3D velocity) {

        super(name, mass, position, velocity, 0.0, "BH");
    }

    public BlackHole(
            String name,
            double mass,
            Vector3D position,
            Vector3D velocity,
            double radius) {

        super(name, mass, position, velocity, radius, 0.0, "BH");
    }
}