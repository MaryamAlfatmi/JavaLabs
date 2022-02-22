package Exercise2;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {

    @Test
    public void area() {
        Square square = new Square(5);
        double area = square.area();
        assertEquals(25.0,area,0.0);
    }

    @Test
    public void perimeter() {
        Square square = new Square(5);
        double perimeter = square.perimeter();
        assertEquals(20.0,perimeter,0.0);

    }
}