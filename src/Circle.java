import java.awt.*;

public class Circle extends Shape{
    int diameter;

    public Circle(int diameter, Color color){
        this.diameter = diameter;
        this.color = color;
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
