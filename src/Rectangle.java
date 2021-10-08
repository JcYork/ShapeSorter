public class Rectangle extends Shape{

    int width;
    int length;




    public double area(){
        return this.length * this.width;
    }

    public Rectangle(int width, int length){
        this.width = width;
        this.length = length;

    }
}

