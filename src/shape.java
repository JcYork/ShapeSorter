import java.awt.*;

abstract class Shape implements Comparable<Shape> {
    //coordinates of the upper left point
    int xpos;
    int ypos;

    Color color;

    public int compareTo(Shape s) {
        return Double.compare(this.area(), s.area());
    }
    public void setPos(int x, int y){
        xpos = x;
        ypos = y;
    }

    abstract double area(); //Calculate area for the respective shape
    abstract void draw(Graphics2D g); //Use swing library to draw the respective shape
}
