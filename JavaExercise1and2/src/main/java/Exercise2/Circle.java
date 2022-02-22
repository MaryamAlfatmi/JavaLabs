package Exercise2;

public class Circle {
    private double radius;

    public double area(){
        return Math.PI*getRadius()*getRadius();
    }

    public double perimeter(){
        return 2 * Math.PI * getRadius();
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
