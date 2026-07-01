package de.nubidentis.ss.engine;

import de.nubidentis.ss.math.Vector3D;
import de.nubidentis.ss.model.CelestialBody;

import java.util.List;

public class FrameUtils {
    public static void recenterAtCOM(List<? extends CelestialBody> bodies) {
        double M = 0, cx = 0, cy = 0, cz = 0, cvx = 0, cvy = 0, cvz = 0;
        for (CelestialBody b : bodies) {
            M += b.getMass();
            cx += b.getMass() * b.getPosition().getX();
            cy += b.getMass() * b.getPosition().getY();
            cz += b.getMass() * b.getPosition().getZ();
            cvx += b.getMass() * b.getVelocity().getX();
            cvy += b.getMass() * b.getVelocity().getY();
            cvz += b.getMass() * b.getVelocity().getZ();
        }
        Vector3D comPos = new Vector3D(cx / M, cy / M, cz / M);
        Vector3D comVel = new Vector3D(cvx / M, cvy / M, cvz / M);

        for (CelestialBody b : bodies) {
            b.setPosition(b.getPosition().sub(comPos));
            b.setVelocity(b.getVelocity().sub(comVel));
        }
    }
}
