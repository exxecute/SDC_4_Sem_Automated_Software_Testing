package org.example;

import org.example.circle.Circle;

public class Main {
    private static final String APPLICATION_HEADER = "TASK 2 Automated Software Testing Java, Uladzislau Mikhayevich JA2";
    public static void main(String[] args) {
        System.out.println(APPLICATION_HEADER);
        Circle c1 = new Circle(10, 10);
        Circle c2 = new Circle(20, 1);

        System.out.println(c1.getIntersections(c2));
    }
}