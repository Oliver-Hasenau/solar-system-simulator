# Solar System Simulator

A Java-based N-body simulation project modeling celestial bodies such as stars, planets, moons, asteroids, comets and compact stellar objects.
![Build](https://github.com/Oliver-Hasenau/solar-system-simulator/actions/workflows/build.yml/badge.svg)

## Features

- Newtonian gravitation
- N-body simulation
- Leapfrog / Velocity-Verlet integration
- Sun–Earth–Moon demonstration system
- CSV export for orbit analysis
- Energy monitoring
- Center-of-mass correction
- Object-oriented celestial body hierarchy

## Technology Stack

- Java 21
- Gradle
- JUnit 5
- IntelliJ IDEA
- Git / GitHub

## Project Structure

```text
de.nubidentis.ss.math
    Vector mathematics

de.nubidentis.ss.model
    Celestial body domain model

de.nubidentis.ss.engine
    Physics engine and numerical integration

de.nubidentis.ss.io
    CSV export

de.nubidentis.ss.demo
    Demo scenarios
```

## Running

Linux/macOS

```bash
./gradlew run
```

Windows

```powershell
.\gradlew.bat run
```

## Current Simulation

Currently implemented:

- Sun
- Earth
- Moon
- Newtonian gravity
- Leapfrog integration
- Stable one-year orbit simulation

## Roadmap

### v0.2

- Unit tests
- Collision detection
- JSON scenario loading

### v0.3

- Asteroid belts
- Comets
- Multiple star systems

### v0.4

- JavaFX visualization
- Real-time rendering
- Camera controls

### v1.0

- Configurable planetary systems
- Scenario editor
- Procedural generation

## License

MIT License