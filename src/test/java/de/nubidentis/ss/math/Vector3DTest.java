package de.nubidentis.ss.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Vector3DTest {

    private static final double EPSILON = 1e-9;

    @Test
    void addShouldReturnVectorSum() {
        Vector3D a = new Vector3D(1, 2, 3);
        Vector3D b = new Vector3D(4, 5, 6);

        Vector3D result = a.add(b);

        assertEquals(5, result.getX(), EPSILON);
        assertEquals(7, result.getY(), EPSILON);
        assertEquals(9, result.getZ(), EPSILON);
    }

    @Test
    void subShouldReturnVectorDifference() {
        Vector3D a = new Vector3D(5, 7, 9);
        Vector3D b = new Vector3D(1, 2, 3);

        Vector3D result = a.sub(b);

        assertEquals(4, result.getX(), EPSILON);
        assertEquals(5, result.getY(), EPSILON);
        assertEquals(6, result.getZ(), EPSILON);
    }

    @Test
    void scaleShouldMultiplyAllComponents() {
        Vector3D v = new Vector3D(1, -2, 3);

        Vector3D result = v.scale(3);

        assertEquals(3, result.getX(), EPSILON);
        assertEquals(-6, result.getY(), EPSILON);
        assertEquals(9, result.getZ(), EPSILON);
    }

    @Test
    void dotShouldReturnScalarProduct() {
        Vector3D a = new Vector3D(1, 2, 3);
        Vector3D b = new Vector3D(4, -5, 6);

        double result = a.dot(b);

        assertEquals(12, result, EPSILON);
    }

    @Test
    void magnitudeShouldReturnVectorLength() {
        Vector3D v = new Vector3D(3, 4, 12);

        double result = v.magnitude();

        assertEquals(13, result, EPSILON);
    }

    @Test
    void normalizeShouldReturnUnitVector() {
        Vector3D v = new Vector3D(3, 0, 4);

        Vector3D result = v.normalize();

        assertEquals(1.0, result.magnitude(), EPSILON);
        assertEquals(0.6, result.getX(), EPSILON);
        assertEquals(0.0, result.getY(), EPSILON);
        assertEquals(0.8, result.getZ(), EPSILON);
    }
}