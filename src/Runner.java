import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Runner extends JPanel{
    public final int NUM_SHAPES = 6;
    public static int PANEL_WIDTH = 600;
    public static int PANEL_HEIGHT = 650;
    public static int MINIMUM_SIZE = 5;
    Shape[] shapes = new Shape[NUM_SHAPES];
    Random rng = new Random();
    boolean drawSignal = false;
    boolean sortSignal = false;


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if(drawSignal) {
            drawShapes(shapes, g2d);
            drawSignal = false;
        }
        if(sortSignal) {
            SortingTechnique.InsertionSort(shapes);
            redisplayAfterSort(shapes, g2d);
            sortSignal = false;
        }
    }

    public void redisplayAfterSort(Shape[] shapes, Graphics2D g2d){
        for (int i = 0; i < shapes.length; i++) {
            g2d.setColor(shapes[i].color);
            shapes[i].setPos(PANEL_WIDTH/2, (i*80) + 50);
            shapes[i].draw(g2d);
        }
    }


    public void drawShapes(Shape[] shapes, Graphics2D g2d){
        for(int i =0; i < NUM_SHAPES; i++){
            g2d.setColor(new Color(rng.nextInt(236) + 20, rng.nextInt(256), rng.nextInt(256)));
            int shapeSelection = rng.nextInt() % 3;
            if(shapeSelection == 0) {
                shapes[i] = ShapeFactory.getRectangle(rng.nextInt(55) + MINIMUM_SIZE , rng.nextInt(55) + MINIMUM_SIZE, g2d.getColor()); //the +20 ensures a minimum size
                shapes[i].setPos(PANEL_WIDTH/2,  (i * 80)+50);
                shapes[i].draw(g2d);
            }
            else if (shapeSelection == 1) {
                shapes[i] = ShapeFactory.getSquare(rng.nextInt(55) + MINIMUM_SIZE, g2d.getColor());
                shapes[i].setPos(PANEL_WIDTH/2, (i * 80) + 50);
                shapes[i].draw(g2d);
            }
            else {
                shapes[i] = ShapeFactory.getCircle(rng.nextInt(55) + MINIMUM_SIZE, g2d.getColor());
                shapes[i].setPos(PANEL_WIDTH/2, (i * 80) + 50);
                shapes[i].draw(g2d);
            }
        }
    }

    public static void main(String[] args){
        Runner image = new Runner();
        JFrame frame = new JFrame("Shabes :DDDDDD");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(image, "Center");
        frame.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        frame.setLocationRelativeTo(null);


        JPanel buttonsPanel = new JPanel();
        JButton load = new JButton("Load Shapes");
        buttonsPanel.add(load);

        load.addActionListener(e -> {
            image.drawSignal = true;
            image.repaint();
        });

        JButton sort = new JButton("Sort Shapes");
        buttonsPanel.add(sort);
        sort.addActionListener(e -> {
            image.sortSignal = true;
            image.repaint();
        });
        frame.add(buttonsPanel, "North");
        frame.setVisible(true);
    }
}
