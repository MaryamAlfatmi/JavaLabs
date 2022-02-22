package Exercise2;

public class Square {
    private int length;

    public double area(){
        return getLength() * getLength();
    }

    public double perimeter(){
        return 4*getLength();
    }

    public Square(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
