package Exercise2;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircleTest {

    @Test
    public void area() {
        Circle c = new Circle(4.0);
        double area = c.area();
        assertEquals(50.26548245743669,area,0.0);
    }

    @Test
    public void perimeter() {
        Circle c= new Circle(4.0);
        double perimeter = c.perimeter();
        assertEquals(25.132741228718345,perimeter,0.0);
    }

}