public class Circle extends Rectangle{


    public Circle(int length){
        super(length, length);
    }


    public double area(int length){
        double r = length / 2.0;
        return Math.PI * r * r;
    }
}
