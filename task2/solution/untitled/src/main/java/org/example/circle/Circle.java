package org.example.circle;

public class Circle {
    private int x;
    private int radius;

    public Circle(final int x, final int radius) {
        this.x = x;
        this.radius = radius;
    }

    public int getX() {
        return this.x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(final int radius) {
        this.radius = radius;
    }

    public Intersections getIntersections(final Circle other) {
        
        return Intersections.NO_INTERSECTIONS;
    }
}
