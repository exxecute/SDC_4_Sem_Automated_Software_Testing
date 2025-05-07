/**
 * @file Circle.java
 * @brief Circle class
 * @author Uladzislau Mikhayevich
 */
package org.example.circle;

/**
 * @brief Circle class
 */
public class Circle {
    /**
     * @brief Circle position
     */
    private int x;
    /**
     * @brief Circle radius
     */
    private int radius;

    /**
     * @brief Circle constructor
     * @param x Circle position
     * @param radius Circle radius
     */
    public Circle(final int x, final int radius) {
        this.x = x;
        this.radius = radius;
    }

    /**
     * @brief Circle position getter
     * @return Circle position
     */
    public int getX() {
        return this.x;
    }

    /**
     * @brief Circle position setter
     * @param x Circle position
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * @brief Circle radius getter
     * @return Circle radius
     */
    public int getRadius() {
        return this.radius;
    }

    /**
     * @brief Circle radius setter
     * @param radius Circle radius
     */
    public void setRadius(final int radius) {
        this.radius = radius;
    }

    /**
     * @brief Intersections calculator
     * @param other Other circle
     * @return Intersections
     */
    public Intersections getIntersections(final Circle other) {
        int distance = (int) Math.sqrt(Math.pow((other.getX() - this.getX()), 2));
        Intersections answer;
        if (this.isAllIntersections(other, distance)) {
            answer = Intersections.ALL_INTERSECTIONS;
        } else if (this.isTwoIntersections(other, distance)){
            answer = Intersections.TWO_INTERSECTIONS;
        } else {
            if(this.isOtherInRadius(other)) {
                answer = this.getInlineIntersections(other, distance);
            } else {
                answer = this.getOutlineIntersections(other, distance);
            }
        }
        return answer;
    }

    /**
     * @brief Most left point getter
     * @return Most left point
     */
    public int getMostLeftPoint() {
        return (this.getX() - this.getRadius());
    }

    /**
     * @brief Most right point getter
     * @return Most right point
     */
    public int getMostRightPoint() {
        return (this.getX() + this.getRadius());
    }

    /**
     * @brief Inline intersections calculator
     * @param other Other circle
     * @param distance Distance between circles
     * @return Intersections
     */
    private Intersections getInlineIntersections(final Circle other, final int distance) {
        Intersections answer;
        if (this.isOtherInNoIntersections(other, distance)) {
            answer = Intersections.NO_INTERSECTIONS;
        } else if (this.isOneInlineIntersection(other, distance)) {
            answer = Intersections.ONE_INTERSECTION;
        } else {
            answer = Intersections.NO_INTERSECTIONS;
        }
        return answer;
    }

    /**
     * @brief Outline intersections calculator
     * @param other Other circle
     * @param distance Distance between circles
     * @return Intersections
     */
    private Intersections getOutlineIntersections(final Circle other, final int distance) {
        Intersections answer;
        if(this.isOtherFar(other, distance)) {
            answer = Intersections.NO_INTERSECTIONS;
        } else if (this.isOneOutlineIntersection(other, distance)) {
            answer = Intersections.ONE_INTERSECTION;
        } else {
            answer = Intersections.NO_INTERSECTIONS;
        }
        return answer;
    }

    /**
     * @brief Other circle in radius checker
     * @param other Other circle
     * @return True if other circle in radius
     */
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

    /**
     * @brief Other circle far checker
     * @param other Other circle
     * @param distance Distance between circles
     * @return True if other circle far
     */
    private boolean isOtherFar(final Circle other, final int distance) {
        return (distance > (this.getRadius() + other.getRadius()));
    }

    /**
     * @brief Other circle in no intersections checker
     * @param other Other circle
     * @param distance Distance between circles
     * @return True if other circle in no intersections
     */
    private boolean isOtherInNoIntersections(final Circle other, final int distance) {
        return (distance < Math.abs(this.getRadius() - other.getRadius()));
    }

    /**
     * @brief One outline intersection checker
     * @param other Other circle
     * @param distance Distance between circles
     * @return True if one intersection
     */
    private boolean isOneOutlineIntersection(final Circle other, final int distance) {
        return (distance == (this.getRadius() + other.getRadius()));
    }

    /**
     * @brief One inline intersection checker
     * @param other Other circle
     * @param distance Distance between circles
     * @return True if one inline intersection
     */
    private boolean isOneInlineIntersection(final Circle other, final int distance) {
        return (distance == Math.abs(this.getRadius() - other.getRadius()));
    }

    /**
     * @brief Two intersections checker
     * @param other Other circle
     * @param distance Distance between circles
     * @return True if two intersections
     */
    private boolean isTwoIntersections(final Circle other, final int distance) {
        return ((distance < (this.getRadius() + other.getRadius())) && (distance > Math.abs(this.getRadius() - other.getRadius())));
    }

    /**
     * @brief All intersections checker
     * @param other Other circle
     * @param distance Distance between circles
     * @return True if all intersections
     */
    private boolean isAllIntersections(final Circle other, final int distance) {
        return ((distance == 0) && (this.getRadius() == other.getRadius()));
    }
}
