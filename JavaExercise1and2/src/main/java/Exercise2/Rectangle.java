package Exercise2;

public class Rectangle {
    private double breadth;
    private double height;

    public double area(){
        return (getBreadth() * getHeight());
    }
    public double perimeter(){
        return 2*(getBreadth() + getHeight());
    }

    public double getBreadth() {
        return breadth;
    }

    public Rectangle(double breadth, double height) {
        this.breadth = breadth;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }
}
