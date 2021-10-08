import java.awt.*;

public class Rectangle extends Shape{

    int width;
    int length;




    public double area(){
        return this.length * this.width;
    }

    @Override
    void draw(Graphics2D g) {
        g.fillRect(xpos, ypos, width, length);
    }

    public Rectangle(int width, int length){
        this.width = width;
        this.length = length;

    }


}

