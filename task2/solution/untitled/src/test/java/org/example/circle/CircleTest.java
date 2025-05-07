package org.example.circle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @ParameterizedTest(name = "x1={0}, r1={1}, x2={2}, r2={3} => expected: {4}")
    @CsvSource({
            "0,    3, 10,   3, NO_INTERSECTIONS",
            "0,    6, 0,    3, NO_INTERSECTIONS",
            "10,   3, 0,    3, NO_INTERSECTIONS",
            "0,    3, 0,    6, NO_INTERSECTIONS",
            "-10,  3, -20,  3, NO_INTERSECTIONS",
            "-10,  6, -10,  3, NO_INTERSECTIONS",
            "-20,  3, -10,  3, NO_INTERSECTIONS",
            "-10,  3, -10,  6, NO_INTERSECTIONS",
            "0,    3, 6,    3, ONE_INTERSECTION",
            "0,    3, 2,    1, ONE_INTERSECTION",
            "6,    3, 0,    3, ONE_INTERSECTION",
            "2,    1, 0,    3, ONE_INTERSECTION",
            "-10,  3, -16,  3, ONE_INTERSECTION",
            "-10,  3, -12,  1, ONE_INTERSECTION",
            "-16,  3, -10,  3, ONE_INTERSECTION",
            "-12,  1, -10,  3, ONE_INTERSECTION",
            "0,    3, 3,    2, TWO_INTERSECTIONS",
            "3,    2, 0,    3, TWO_INTERSECTIONS",
            "-10,  3, -13,  2, TWO_INTERSECTIONS",
            "-13,  2, -10,  3, TWO_INTERSECTIONS",
            "0,    3, 0,    3, ALL_INTERSECTIONS",
    })
    void getIntersectionsTest(int x1, int r1, int x2, int r2, Intersections expected) {
        Circle c1 = new Circle(x1, r1);
        Circle c2 = new Circle(x2, r2);
        assertEquals(expected, c1.getIntersections(c2));
    }
}