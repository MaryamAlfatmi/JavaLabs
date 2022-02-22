package Exercise2;

public class Main {
    public static void main(String[] args){
        Circle circle = new Circle(1.5);
        System.out.println("The area of circle is: " + circle.area() +" and the perimeter is: "+ circle.perimeter());

        Rectangle rectangle = new Rectangle(2,3);
        System.out.println("The area of rectangle is: " + rectangle.area() +" and the perimeter is: "+ rectangle.perimeter());

        Square square = new Square(4);
        System.out.println("The area of square is: " + square.area() +" and the perimeter is: "+ square.perimeter());

    }
}
