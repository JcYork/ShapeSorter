import java.awt.*;

public class ShapeFactory {
    public static Square getSquare(int length, Color color){
        return new Square(length, color);
    }

    public static Rectangle getRectangle(int length, int width, Color color){
        return new Rectangle(length, width, color);
    }

    public static Circle getCircle(int diameter, Color color){
        return new Circle(diameter, color);
    }


}
