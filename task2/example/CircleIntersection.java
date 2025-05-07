import java.util.Scanner;

public class CircleIntersection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter x1 r1 x2 r2 (separated by space):");
        int x1 = scanner.nextInt();
        int r1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int r2 = scanner.nextInt();
        scanner.close();

        String result = getIntersectionPoints(x1, r1, x2, r2);
        System.out.println("Result: " + result);
    }

    public static String getIntersectionPoints(int x1, int r1, int x2, int r2) {
        if (x1 == x2 && r1 == r2) {
            return "Infinite number of intersection points";
        }

        int distance = Math.abs(x1 - x2);
        int rSum = r1 + r2;
        int rDiff = Math.abs(r1 - r2);

        if (distance > rSum || distance < rDiff) {
            return "0";
        } else if (distance == rSum || (distance == rDiff && r1 != r2)) {
            return "1";
        } else {
            return "2";
        }
    }
}
