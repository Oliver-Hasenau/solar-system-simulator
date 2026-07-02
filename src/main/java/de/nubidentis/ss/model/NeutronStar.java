package de.nubidentis.ss.model;

import de.nubidentis.ss.math.Vector3D;

public class NeutronStar extends Star {

    public NeutronStar(
            String name,
            double mass,
            Vector3D position,
            Vector3D velocity,
            double radius,
            double luminosity,
            String spectralType) {

        super(name, mass, position, velocity, radius, luminosity, spectralType);
    }
}