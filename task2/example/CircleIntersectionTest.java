import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircleIntersectionTest {

    @ParameterizedTest(name = "x1={0}, r1={1}, x2={2}, r2={3} => expected: {4}")
    @CsvSource({
        "0, 3, 6, 3, 1",
        "0, 5, 2, 3, 1",
        "0, 5, 4, 3, 2",
        "0, 2, 10, 1, 0",
        "0, 5, 1, 1, 0",
        "0, 5, 0, 5, Infinite number of intersection points"
    })
    void testGetIntersectionPoints(int x1, int r1, int x2, int r2, String expected) {
        String result = CircleIntersection.getIntersectionPoints(x1, r1, x2, r2);
        assertEquals(expected, result);
    }
}
