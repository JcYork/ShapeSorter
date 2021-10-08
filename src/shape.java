import java.awt.*;

abstract class Shape implements Comparable<Shape> {
    //coordinates of the upper left point
    int xpos;
    int ypos;

    public int compareTo(Shape s) {
        return Double.compare(this.area(), s.area());

    }

    abstract double area();
    abstract void draw(Graphics2D g);
    public void setPos(int x, int y){
        xpos = x;
        ypos = y;
    }
}
