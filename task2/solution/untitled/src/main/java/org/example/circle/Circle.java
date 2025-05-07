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
        int distance = (int)Math.sqrt(Math.pow((other.getX() - this.getX()), 2));
        Intersections answer;
        boolean isInRadius = this.isOtherInRadius(other);
        if (this.isAllIntersections(other, distance)) {
            answer = Intersections.ALL_INTERSECTIONS;
        } else if(!isInRadius && this.isOtherFar(other, distance)) {
            answer = Intersections.NO_INTERSECTIONS;
        } else if (isInRadius && this.isOtherInNoIntersections(other, distance)) {
            answer = Intersections.NO_INTERSECTIONS;
        } else if (!isInRadius && this.isOneOutlineIntersection(other, distance)) {
            answer = Intersections.ONE_INTERSECTION;
        } else if (isInRadius && this.isOneInlineIntersection(other, distance)) {
            answer = Intersections.ONE_INTERSECTION;
        } else if (this.isTwoIntersections(other, distance)) {
            answer = Intersections.TWO_INTERSECTIONS;
        } else {
            answer = Intersections.NO_INTERSECTIONS;
        }
        return answer;
    }

    public int getMostLeftPoint() {
        return (this.getX() - this.getRadius());
    }

    public int getMostRightPoint() {
        return (this.getX() + this.getRadius());
    }

    private boolean isOtherInRadius(final Circle other) {
        int x, mostLeftPoint, mostRightPoint;
        boolean isOtherBigger = (this.getRadius() < other.getRadius());

        if(isOtherBigger) {
            mostLeftPoint = other.getMostLeftPoint();
            mostRightPoint = other.getMostRightPoint();
            x = this.getX();
        } else {
            mostLeftPoint = this.getMostLeftPoint();
            mostRightPoint = this.getMostRightPoint();
            x = other.getX();
        }
        return (mostLeftPoint <= x && x <= mostRightPoint);
    }

    private boolean isOtherFar(final Circle other, final int distance) {
        return (distance > (this.getRadius() + other.getRadius()));
    }

    private boolean isOtherInNoIntersections(final Circle other, final int distance) {
        return (distance < Math.abs(this.getRadius() - other.getRadius()));
    }

    private boolean isOneOutlineIntersection(final Circle other, final int distance) {
        return (distance == (this.getRadius() + other.getRadius()));
    }

    private boolean isOneInlineIntersection(final Circle other, final int distance) {
        return (distance == Math.abs(this.getRadius() - other.getRadius()));
    }

    private boolean isTwoIntersections(final Circle other, final int distance) {
        return ((distance < (this.getRadius() + other.getRadius())) && (distance > Math.abs(this.getRadius() - other.getRadius())));
    }

    private boolean isAllIntersections(final Circle other, final int distance) {
        return ((distance == 0) && (this.getRadius() == other.getRadius()));
    }
}
