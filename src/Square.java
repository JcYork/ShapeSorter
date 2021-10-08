public class Square extends Rectangle{

    public double area(){
        return this.length * this.length;
    }

    public Square(int length){
        super(length, length);
    }
}
