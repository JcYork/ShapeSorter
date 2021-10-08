abstract class Shape implements Comparable<Shape> {
    //coordinates of the upper left point
    int xpos;
    int ypos;

    public int compareTo(Shape s) {
        return Double.compare(this.area(), s.area());

    }

    abstract double area();
}
