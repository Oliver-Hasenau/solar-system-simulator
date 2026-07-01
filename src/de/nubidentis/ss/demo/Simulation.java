package de.nubidentis.ss.demo;

import de.nubidentis.ss.engine.PhysicsEngine;
import de.nubidentis.ss.math.Vector3D;
import de.nubidentis.ss.model.CelestialBody;
import de.nubidentis.ss.model.Moon;
import de.nubidentis.ss.model.Planet;
import de.nubidentis.ss.model.Star;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    public static void main(String[] args) {
        // Konstanten (SI)
        double M_SUN = 1.98847e30;   // kg
        double M_EARTH = 5.9722e24;    // kg
        double M_MOON = 7.342e22;     // kg

        double AU = 1.496e11;     // m
        double V_EARTH = 29_780.0;     // m/s ~ mittlere Bahngeschwindigkeit der Erde
        double D_EM = 384_400e3;    // m Erde–Mond
        double V_MOON = 1_022.0;      // m/s ~ Umlaufgeschwindigkeit des Mondes relativ zur Erde

        // Sonne im Ursprung, ruht (Start)
        Star sun = new Star(
                "Sun", M_SUN,
                new Vector3D(0, 0, 0),
                new Vector3D(0, 0, 0),
                3.828e26, "G2V"
        );

        // Erde bei 1 AU auf x-Achse, Geschwindigkeit in +y
        Planet earth = new Planet(
                "Earth", M_EARTH,
                new Vector3D(AU, 0, 0),
                new Vector3D(0, V_EARTH, 0)
        );

        // Mond rechts von der Erde, Geschwindigkeit = Erde.v + V_MOON in +y
        Moon moon = new Moon(
                "de.nubidentis.ss.model.Moon", M_MOON,
                earth.getPosition().add(new Vector3D(D_EM, 0, 0)),
                earth.getVelocity().add(new Vector3D(0, V_MOON, 0)),
                earth
        );

        List<CelestialBody> bodies = new ArrayList<>();
        bodies.add(sun);
        bodies.add(earth);
        bodies.add(moon);

        // Physik-Engine mit Softening (z.B. 1e7 m, vermeidet extreme Beschleunigungen bei sehr kleinen Abständen)
        PhysicsEngine engine = new PhysicsEngine(1e7);

        // Simulationsschritt: 1 Stunde
        double dt = 60.0 * 60.0; // s
        int steps = 24 * 365;    // ~1 Jahr in Stunden

        for (int step = 0; step <= steps; step++) {
            if (step % (24 * 7) == 0) { // wöchentliche Ausgabe
                double rEarth = earth.getPosition().sub(sun.getPosition()).magnitude();
                double rMoon = moon.getPosition().sub(earth.getPosition()).magnitude();
                double vEarth = earth.getVelocity().magnitude() / 1000.0;
                double vMoonK = moon.getVelocity().magnitude() / 1000.0;
                System.out.printf(
                        "Tag %3d | r_E = %.3e m | r_M = %.3e m | v_E = %.2f km/s | v_M = %.2f km/s%n",
                        step / 24,
                        rEarth,
                        rMoon,
                        vEarth,
                        vMoonK
                );
            }
            engine.step(bodies, dt);
        }
    }
}
