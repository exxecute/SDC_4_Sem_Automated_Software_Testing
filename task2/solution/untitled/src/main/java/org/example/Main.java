/**
 * @file Main.java
 * @author Uladzislau Mikhayevich
 * @brief Task 2 Automated Software Testing Java
 */
package org.example;

import org.example.circle.Circle;

import java.util.Scanner;

/**
 * @brief Main class
 */
public class Main {
    /**
     * @brief Application header
     */
    private static final String APPLICATION_HEADER = "TASK 2 Automated Software Testing Java, Uladzislau Mikhayevich JA2";
    /**
     * @brief Enter params message
     */
    private static final String ENTER_PARAMS_MESSAGE = "Enter x1 r1 x2 r2 (separated by space):";
    /**
     * @brief Main method
     */
    public static void main(String[] args) {
        System.out.println(APPLICATION_HEADER);

        Scanner scanner = new Scanner(System.in);
        System.out.println(ENTER_PARAMS_MESSAGE);
        int x1 = scanner.nextInt();
        int r1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int r2 = scanner.nextInt();
        scanner.close();

        Circle c1 = new Circle(x1, r1);
        Circle c2 = new Circle(x2, r2);

        System.out.println(c1.getIntersections(c2));
    }
}