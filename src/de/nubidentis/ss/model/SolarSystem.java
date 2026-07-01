package de.nubidentis.ss.model;

import java.util.ArrayList;
import java.util.List;

public class SolarSystem {
    private String name;
    private List<Star> stars = new ArrayList<>();
    private List<Planet> planets = new ArrayList<>();
    private List<SmallBody> smallBodies = new ArrayList<>();
    private List<AsteroidBelt> asteroidBelts = new ArrayList<>();

    public void addStar(Star star) {
        stars.add(star);
    }

    public void addPlanet(Planet planet) {
        planets.add(planet);
    }

    public void addSmallBody(SmallBody body) {
        smallBodies.add(body);
    }

    public void addAsteroidBelt(AsteroidBelt belt) {
        asteroidBelts.add(belt);
    }
}
