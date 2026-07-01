package de.nubidentis.ss.model;

import de.nubidentis.ss.math.Vector3D;

public class Star extends CelestialBody {
    private double luminosity;
    private String spectralType;

    // Empfohlener voller Konstruktor
    public Star(String name, double mass, Vector3D position, Vector3D velocity,
                double luminosity, String spectralType) {
        super(name, mass, position, velocity);
        this.luminosity = luminosity;
        this.spectralType = spectralType;
    }

    public Star() {
    }

    // (Optional) Behalte diesen nur, wenn du ihn wirklich brauchst:
    public Star(double luminosity, String spectralType) {
        super(null, 0.0, null, null);
        this.luminosity = luminosity;
        this.spectralType = spectralType;
    }

    public double getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(double luminosity) {
        this.luminosity = luminosity;
    }

    public String getSpectralType() {
        return spectralType;
    }

    public void setSpectralType(String spectralType) {
        this.spectralType = spectralType;
    }
}
