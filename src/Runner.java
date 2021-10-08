import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;


public class Runner extends JPanel{
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(255, 0, 100));
        Rectangle r = new Rectangle(50, 80);
        r.setPos(20, 50);
        r.draw(g2d);
        Circle c = new Circle(80);
        c.setPos(150, 150);
        c.draw(g2d);
    }

    public static void main(String[] args){
        Runner image = new Runner();
        JFrame frame = new JFrame("Shabes :DDDDDD");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(image);
        frame.setSize(360, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
