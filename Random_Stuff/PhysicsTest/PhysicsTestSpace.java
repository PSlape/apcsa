package Random_Stuff.PhysicsTest;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.geom.Point2D;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import java.lang.Math;

public class PhysicsTestSpace {
    private static final int WIDTH = 1920;
    private static final int HEIGHT = 1080;
    private JFrame frame;
    private JSlider tickRateSlider;
    private JPanel panel;
    private BufferedImage image;
    private Timer tickRate;
    private GradientPaint bg;
    

    public PhysicsTestSpace() {
        // Create the main frame
        frame = new JFrame("Popup Window with Falling Snow");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        
        // Create a panel to hold the content
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawBackground(g);
            }
        };

        // Load and display your image
        // image = loadImage("SmallHouse.png");
        // JLabel imageLabel = new JLabel(new ImageIcon(image));
        // panel.add(imageLabel);
        tickRateSlider = new JSlider(-10, 10, 0);  
        
        // Add the panel to the frame
        frame.add(panel);

        // Create a timer for the snowfall animation
        tickRate = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {}
        });
        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);

        // Start the snowfall animation
        tickRate.start();
    }
    
    private void drawBackground(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
    }

    private static BufferedImage loadImage(String filename) {
        try {
            URL imageURL = PhysicsTestSpace.class.getResource(filename);
            if (imageURL != null) {
                return ImageIO.read(imageURL);
            } else {
                System.err.println("Image file not found: " + filename);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PhysicsTestSpace();
        });
    }
}


