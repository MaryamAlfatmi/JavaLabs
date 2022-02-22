package Exercise2;

import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {

    @Test
    public void area() {
        Rectangle r = new Rectangle(2,4);
        double area = r.area();
        assertEquals(8.0,area,0.0);
    }

    @Test
    public void perimeter() {
        Rectangle r = new Rectangle(2,4);
        double perimeter = r.perimeter();
        assertEquals(12.0,perimeter,0.0);
    }
}