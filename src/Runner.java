import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.util.Random;

public class Runner extends JPanel{
    public final int NUM_SHAPES = 6;
    public static int PANEL_WIDTH = 360;
    public static int PANEL_HEIGHT = 650;
    Shape[] shapes = new Shape[NUM_SHAPES];
    Random rng = new Random();


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for(int i =0; i < NUM_SHAPES; i++){
            g2d.setColor(new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256)));

            int shapeSelection = rng.nextInt() % 3;
            if(shapeSelection == 0) {
                shapes[i] = new Rectangle(rng.nextInt(75), rng.nextInt(75));
                shapes[i].setPos(PANEL_WIDTH/2,  i * 80);
                shapes[i].draw(g2d);
            }
            else if (shapeSelection == 1) {
                shapes[i] = new Square(rng.nextInt(75));
                shapes[i].setPos(PANEL_WIDTH/2, i * 80);
                shapes[i].draw(g2d);
            }
            else {
                shapes[i] = new Circle(rng.nextInt(75));
                shapes[i].setPos(PANEL_WIDTH/2, i * 80);
                shapes[i].draw(g2d);
            }
        }
    }

    public static void main(String[] args){
        Runner image = new Runner();
        JFrame frame = new JFrame("Shabes :DDDDDD");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(image);
        frame.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
