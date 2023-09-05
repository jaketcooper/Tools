package com.github.mikephil.charting.matrix;

public final class Vector3 {
    public static final Vector3 UNIT_X = new Vector3(1.0f, 0.0f, 0.0f);
    public static final Vector3 UNIT_Y = new Vector3(0.0f, 1.0f, 0.0f);
    public static final Vector3 UNIT_Z = new Vector3(0.0f, 0.0f, 1.0f);
    public static final Vector3 ZERO = new Vector3(0.0f, 0.0f, 0.0f);

    /* renamed from: x */
    public float f65x;

    /* renamed from: y */
    public float f66y;

    /* renamed from: z */
    public float f67z;

    public Vector3() {
    }

    public Vector3(float[] array) {
        set(array[0], array[1], array[2]);
    }

    public Vector3(float xValue, float yValue, float zValue) {
        set(xValue, yValue, zValue);
    }

    public Vector3(Vector3 other) {
        set(other);
    }

    public final void add(Vector3 other) {
        this.f65x += other.f65x;
        this.f66y += other.f66y;
        this.f67z += other.f67z;
    }

    public final void add(float otherX, float otherY, float otherZ) {
        this.f65x += otherX;
        this.f66y += otherY;
        this.f67z += otherZ;
    }

    public final void subtract(Vector3 other) {
        this.f65x -= other.f65x;
        this.f66y -= other.f66y;
        this.f67z -= other.f67z;
    }

    public final void subtractMultiple(Vector3 other, float multiplicator) {
        this.f65x -= other.f65x * multiplicator;
        this.f66y -= other.f66y * multiplicator;
        this.f67z -= other.f67z * multiplicator;
    }

    public final void multiply(float magnitude) {
        this.f65x *= magnitude;
        this.f66y *= magnitude;
        this.f67z *= magnitude;
    }

    public final void multiply(Vector3 other) {
        this.f65x *= other.f65x;
        this.f66y *= other.f66y;
        this.f67z *= other.f67z;
    }

    public final void divide(float magnitude) {
        if (magnitude != 0.0f) {
            this.f65x /= magnitude;
            this.f66y /= magnitude;
            this.f67z /= magnitude;
        }
    }

    public final void set(Vector3 other) {
        this.f65x = other.f65x;
        this.f66y = other.f66y;
        this.f67z = other.f67z;
    }

    public final void set(float xValue, float yValue, float zValue) {
        this.f65x = xValue;
        this.f66y = yValue;
        this.f67z = zValue;
    }

    public final float dot(Vector3 other) {
        return (this.f65x * other.f65x) + (this.f66y * other.f66y) + (this.f67z * other.f67z);
    }

    public final Vector3 cross(Vector3 other) {
        return new Vector3((this.f66y * other.f67z) - (this.f67z * other.f66y), (this.f67z * other.f65x) - (this.f65x * other.f67z), (this.f65x * other.f66y) - (this.f66y * other.f65x));
    }

    public final float length() {
        return (float) Math.sqrt((double) length2());
    }

    public final float length2() {
        return (this.f65x * this.f65x) + (this.f66y * this.f66y) + (this.f67z * this.f67z);
    }

    public final float distance2(Vector3 other) {
        float dx = this.f65x - other.f65x;
        float dy = this.f66y - other.f66y;
        float dz = this.f67z - other.f67z;
        return (dx * dx) + (dy * dy) + (dz * dz);
    }

    public final float normalize() {
        float magnitude = length();
        if (magnitude != 0.0f) {
            this.f65x /= magnitude;
            this.f66y /= magnitude;
            this.f67z /= magnitude;
        }
        return magnitude;
    }

    public final void zero() {
        set(0.0f, 0.0f, 0.0f);
    }

    public final boolean pointsInSameDirection(Vector3 other) {
        return dot(other) > 0.0f;
    }
}
