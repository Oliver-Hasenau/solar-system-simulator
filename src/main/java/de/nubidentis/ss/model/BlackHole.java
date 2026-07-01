package de.nubidentis.ss.model;

import de.nubidentis.ss.math.Vector3D;

public class BlackHole extends Star {
    public BlackHole(String name, double mass, Vector3D position, Vector3D velocity,
                     double luminosity, String spectralType) {
        super(name, mass, position, velocity, luminosity, spectralType);
    }

    // (Optional) Wenn du unbedingt die Short-Variante behalten willst:
    public BlackHole(double luminosity, String spectralType) {
        super(luminosity, spectralType);
    }
}
