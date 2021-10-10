import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Runner extends JPanel{
    public final int NUM_SHAPES = 6; //No guarantees on correctness if you change this value.
    public static int PANEL_WIDTH = 600;
    public static int PANEL_HEIGHT = 650;
    public static int SHAPE_INITIAL_Y_POS = 50;
    public static int MINIMUM_SIZE = 7;
    Shape[] shapes = new Shape[NUM_SHAPES]; //stores object representations of all shapes on screen.
    Random rng = new Random();

    boolean drawSignal = false;
    boolean sortSignal = false;

    @Override
    public void paintComponent(Graphics g) { //This is called automatically by lots of things
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if(drawSignal) { //changed by a button press
            drawShapes(shapes, g2d);
            drawSignal = false;
        }
        if(sortSignal) { //changed by a button press
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

            //Select a random shape to create
            int shapeSelection = rng.nextInt() % 3;
            if(shapeSelection == 0) {
                shapes[i] = ShapeFactory.getRectangle(rng.nextInt(55) + MINIMUM_SIZE , rng.nextInt(55) + MINIMUM_SIZE, g2d.getColor());
                shapes[i].setPos(PANEL_WIDTH/2,  (i * 80) + SHAPE_INITIAL_Y_POS); //shapes start
                shapes[i].draw(g2d);
            }
            else if (shapeSelection == 1) {
                shapes[i] = ShapeFactory.getSquare(rng.nextInt(55) + MINIMUM_SIZE, g2d.getColor());
                shapes[i].setPos(PANEL_WIDTH/2, (i * 80) + SHAPE_INITIAL_Y_POS);
                shapes[i].draw(g2d);
            }
            else {
                shapes[i] = ShapeFactory.getCircle(rng.nextInt(55) + MINIMUM_SIZE, g2d.getColor());
                shapes[i].setPos(PANEL_WIDTH/2, (i * 80) + SHAPE_INITIAL_Y_POS);
                shapes[i].draw(g2d);
            }
        }
    }

    public static void main(String[] args){
        //boiler plate code to create a window.
        Runner image = new Runner();
        JFrame frame = new JFrame("Display Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(image, "Center");
        frame.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        frame.setLocationRelativeTo(null);

        //Button which loads shapes
        JPanel buttonsPanel = new JPanel();
        JButton load = new JButton("Load Shapes");
        buttonsPanel.add(load);

        load.addActionListener(e -> {
            image.drawSignal = true; //drawSignal indicates to paintComponent that drawShapes() should be run
            image.repaint();
        });

        //Button which sorts shapes
        JButton sort = new JButton("Sort Shapes");
        buttonsPanel.add(sort);
        sort.addActionListener(e -> {
            image.sortSignal = true;
            image.repaint();
        });
        frame.add(buttonsPanel, "North");
        frame.setVisible(true); //rendering the frame at the very end ensures all elements are visible
    }
}
