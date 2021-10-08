import java.awt.*;

public class Circle extends Shape{
    int diameter;

    public Circle(int diameter){
        this.diameter = diameter;
    }

    @Override
    double area() {
        double r = diameter / 2.0;
        return Math.PI * r * r;
    }

    @Override
    void draw(Graphics2D g) {
        g.fillRoundRect(xpos, ypos, diameter, diameter, diameter, diameter);
    }

}
