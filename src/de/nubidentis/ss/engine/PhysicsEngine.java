package de.nubidentis.ss.engine;

import de.nubidentis.ss.math.Vector3D;
import de.nubidentis.ss.model.CelestialBody;

import java.util.List;

public class PhysicsEngine {
    public static final double G = 6.67430e-11; // m^3 kg^-1 s^-2
    private final double softening;             // in Metern

    public PhysicsEngine() {
        this(1e7); // Default-Softening – bewährt für Sonnensystem-Skalen
    }

    public PhysicsEngine(double softening) {
        this.softening = softening;
    }

    public void step(List<? extends CelestialBody> bodies, double dt) {
        Vector3D[] acc = accelerations(bodies);

        // v(t+dt/2)
        for (int i = 0; i < bodies.size(); i++) {
            CelestialBody b = bodies.get(i);
            b.setVelocity(b.getVelocity().add(acc[i].scale(0.5 * dt)));
        }
        // x(t+dt)
        for (CelestialBody b : bodies) {
            b.setPosition(b.getPosition().add(b.getVelocity().scale(dt)));
        }
        // a(t+dt)
        Vector3D[] acc2 = accelerations(bodies);
        // v(t+dt)
        for (int i = 0; i < bodies.size(); i++) {
            CelestialBody b = bodies.get(i);
            b.setVelocity(b.getVelocity().add(acc2[i].scale(0.5 * dt)));
        }
    }

    private Vector3D[] accelerations(List<? extends CelestialBody> bodies) {
        int n = bodies.size();
        Vector3D[] acc = new Vector3D[n];
        for (int i = 0; i < n; i++) acc[i] = new Vector3D(0, 0, 0);

        for (int i = 0; i < n; i++) {
            CelestialBody bi = bodies.get(i);
            for (int j = i + 1; j < n; j++) {
                CelestialBody bj = bodies.get(j);
                Vector3D r = bj.getPosition().sub(bi.getPosition());
                double dist2 = r.dot(r) + softening * softening;
                double invR = 1.0 / Math.sqrt(dist2);
                double invR3 = invR / dist2;

                Vector3D a_i = r.scale(G * bj.getMass() * invR3);
                Vector3D a_j = r.scale(-G * bi.getMass() * invR3);

                acc[i] = acc[i].add(a_i);
                acc[j] = acc[j].add(a_j);
            }
        }
        return acc;
    }
}
