package de.nubidentis.ss.engine;

import de.nubidentis.ss.math.Vector3D;
import de.nubidentis.ss.model.CelestialBody;
import de.nubidentis.ss.model.Planet;
import de.nubidentis.ss.model.Star;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FrameUtilsTest {

    private static final double EPSILON_POSITION = 1e-3;
    private static final double EPSILON_VELOCITY = 1e-12;

    @Test
    void recenterAtCOMShouldMoveCenterOfMassToOrigin() {
        List<CelestialBody> bodies = createSunEarthSystem();

        FrameUtils.recenterAtCOM(bodies);

        Vector3D centerOfMass = calculateCenterOfMass(bodies);

        assertEquals(0.0, centerOfMass.getX(), EPSILON_POSITION);
        assertEquals(0.0, centerOfMass.getY(), EPSILON_POSITION);
        assertEquals(0.0, centerOfMass.getZ(), EPSILON_POSITION);
    }

    @Test
    void recenterAtCOMShouldRemoveTotalSystemVelocity() {
        List<CelestialBody> bodies = createSunEarthSystem();

        FrameUtils.recenterAtCOM(bodies);

        Vector3D centerOfMassVelocity = calculateCenterOfMassVelocity(bodies);

        assertEquals(0.0, centerOfMassVelocity.getX(), EPSILON_VELOCITY);
        assertEquals(0.0, centerOfMassVelocity.getY(), EPSILON_VELOCITY);
        assertEquals(0.0, centerOfMassVelocity.getZ(), EPSILON_VELOCITY);
    }

    private List<CelestialBody> createSunEarthSystem() {
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
        return bodies;
    }

    private Vector3D calculateCenterOfMass(List<CelestialBody> bodies) {
        double totalMass = 0.0;
        Vector3D weightedPositionSum = new Vector3D(0, 0, 0);

        for (CelestialBody body : bodies) {
            totalMass += body.getMass();
            weightedPositionSum = weightedPositionSum.add(
                    body.getPosition().scale(body.getMass())
            );
        }

        return weightedPositionSum.scale(1.0 / totalMass);
    }

    private Vector3D calculateCenterOfMassVelocity(List<CelestialBody> bodies) {
        double totalMass = 0.0;
        Vector3D weightedVelocitySum = new Vector3D(0, 0, 0);

        for (CelestialBody body : bodies) {
            totalMass += body.getMass();
            weightedVelocitySum = weightedVelocitySum.add(
                    body.getVelocity().scale(body.getMass())
            );
        }

        return weightedVelocitySum.scale(1.0 / totalMass);
    }
}