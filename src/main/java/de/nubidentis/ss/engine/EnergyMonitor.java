package de.nubidentis.ss.engine;

import de.nubidentis.ss.math.Vector3D;
import de.nubidentis.ss.model.CelestialBody;

import java.util.List;

public class EnergyMonitor {
    private static final double G = PhysicsEngine.G;

    public static double kineticEnergy(List<? extends CelestialBody> bodies) {
        double T = 0.0;
        for (CelestialBody b : bodies) {
            double v2 = b.getVelocity().dot(b.getVelocity());
            T += 0.5 * b.getMass() * v2;
        }
        return T;
    }

    public static double potentialEnergy(List<? extends CelestialBody> bodies, double softening) {
        double U = 0.0;
        for (int i = 0; i < bodies.size(); i++) {
            CelestialBody bi = bodies.get(i);
            for (int j = i + 1; j < bodies.size(); j++) {
                CelestialBody bj = bodies.get(j);
                double r2 = bi.getPosition().sub(bj.getPosition()).dot(bi.getPosition().sub(bj.getPosition()));
                double r = Math.sqrt(r2 + softening * softening);
                U += -G * bi.getMass() * bj.getMass() / r;
            }
        }
        return U;
    }

    public static Vector3D totalMomentum(List<? extends CelestialBody> bodies) {
        double px = 0, py = 0, pz = 0;
        for (CelestialBody b : bodies) {
            px += b.getMass() * b.getVelocity().getX();
            py += b.getMass() * b.getVelocity().getY();
            pz += b.getMass() * b.getVelocity().getZ();
        }
        return new Vector3D(px, py, pz);
    }

    public static double angularMomentumZ(List<? extends CelestialBody> bodies) {
        // Lz = sum m (r x v)_z
        double Lz = 0.0;
        for (CelestialBody b : bodies) {
            Vector3D r = b.getPosition();
            Vector3D v = b.getVelocity();
            // Kreuzprodukt z-Komponente: rx*vy - ry*vx
            Lz += b.getMass() * (r.getX() * v.getY() - r.getY() * v.getX());
        }
        return Lz;
    }
}
