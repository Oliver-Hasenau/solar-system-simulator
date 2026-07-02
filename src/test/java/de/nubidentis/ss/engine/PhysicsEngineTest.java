package de.nubidentis.ss.engine;

import de.nubidentis.ss.math.Vector3D;
import de.nubidentis.ss.model.CelestialBody;
import de.nubidentis.ss.model.Planet;
import de.nubidentis.ss.model.Star;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PhysicsEngineTest {

    @Test
    void earthShouldRemainNearOneAUAfterOneYear() {
        double sunMass = 1.98847e30;
        double earthMass = 5.9722e24;
        double au = 1.496e11;
        double earthVelocity = 29_780.0;

        Star sun = new Star(
                "Sun",
                sunMass,
                new Vector3D(0, 0, 0),
                new Vector3D(0, 0, 0),
                3.828e26,
                "G2V"
        );

        Planet earth = new Planet(
                "Earth",
                earthMass,
                new Vector3D(au, 0, 0),
                new Vector3D(0, earthVelocity, 0)
        );

        List<CelestialBody> bodies = new ArrayList<>();
        bodies.add(sun);
        bodies.add(earth);

        PhysicsEngine engine = new PhysicsEngine(1e7);

        double dt = 3600.0;
        int steps = 24 * 365;

        for (int i = 0; i < steps; i++) {
            engine.step(bodies, dt);
        }

        double finalDistance = earth.getPosition().sub(sun.getPosition()).magnitude();
        double relativeError = Math.abs(finalDistance - au) / au;

        assertTrue(relativeError < 0.02,
                "Earth should remain within 2% of 1 AU after one year. Relative error: " + relativeError);
    }
}