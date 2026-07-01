package de.nubidentis.ss.io;

import de.nubidentis.ss.math.Vector3D;
import de.nubidentis.ss.model.CelestialBody;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvLogger implements AutoCloseable {
    private final FileWriter fw;

    public CsvLogger(String file) throws IOException {
        this.fw = new FileWriter(file);
        fw.write("t_days,name,x,y,z,vx,vy,vz\n");
    }

    public void write(double tDays, List<? extends CelestialBody> bodies) throws IOException {
        for (CelestialBody b : bodies) {
            Vector3D p = b.getPosition();
            Vector3D v = b.getVelocity();
            fw.write(String.format("%.6f,%s,%.9e,%.9e,%.9e,%.9e,%.9e,%.9e\n",
                    tDays, b.getName(),
                    p.getX(), p.getY(), p.getZ(),
                    v.getX(), v.getY(), v.getZ()));
        }
    }

    @Override
    public void close() throws IOException {
        fw.close();
    }
}
