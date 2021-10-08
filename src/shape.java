import java.awt.*;

abstract class Shape implements Comparable<Shape> {
    //coordinates of the upper left point
    int xpos;
    int ypos;
    Color color; //This parameter is not needed to render, however it will be useful to have it recorded if we ever need to redraw them.

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
