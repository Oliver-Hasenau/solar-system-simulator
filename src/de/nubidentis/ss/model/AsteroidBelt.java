package de.nubidentis.ss.model;

import java.util.ArrayList;
import java.util.List;

public class AsteroidBelt {
    private String name;
    private List<Asteroid> asteroids = new ArrayList<>();

    public void addAsteroid(Asteroid asteroid) {
        asteroids.add(asteroid);
    }
}
