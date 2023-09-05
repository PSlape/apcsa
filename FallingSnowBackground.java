

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class FallingSnowBackground {
    private static final int WIDTH = 2000;
    private static final int HEIGHT = 1000;
    private static final int NUM_SNOWFLAKES = 2000;

    private JFrame frame;
    private JPanel panel;
    private BufferedImage image;
    private Timer snowTimer;

    private Snowflake[] snowflakes;

    public FallingSnowBackground() {
        // Create the main frame
        frame = new JFrame("Popup Window with Falling Snow");

        // Set the size of the frame
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the content
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawBackground(g);
            }
        };

        // Load and display your image
        image = loadImage("SmallHouse.png");
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        panel.add(imageLabel);

        // Add the panel to the frame
        frame.add(panel);

        // Create snowflakes
        snowflakes = new Snowflake[NUM_SNOWFLAKES];
        for (int i = 0; i < NUM_SNOWFLAKES; i++) {
            snowflakes[i] = new Snowflake();
        }

        // Create a timer for the snowfall animation
        snowTimer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveSnowflakes();
                panel.repaint();
            }
        });

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);

        // Start the snowfall animation
        snowTimer.start();
    }

    private void drawBackground(Graphics g) {
        // Clear the panel
        g.setColor(new Color(0, 0, 50));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Draw snowflakes
        g.setColor(new Color(225,225,225));
        for (Snowflake snowflake : snowflakes) {
            g.fillRect(snowflake.getX(), snowflake.getY(), 3, 3);
        }

        // Draw snowy ground
        g.setColor(new Color(225,225,225));
        g.fillRect(0,5*HEIGHT/9, WIDTH, 2000);
    }

    private void moveSnowflakes() {
        for (Snowflake snowflake : snowflakes) {
            snowflake.fall();
        }
    }

    private static BufferedImage loadImage(String filename) {
        try {
            URL imageURL = FallingSnowBackground.class.getResource(filename);
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
            new FallingSnowBackground();
        });
    }
}

class Snowflake {
    
    private int x;
    private int y;
    private final int MAX_Y = 2000;
    private final int MAX_X = 2000;
    private final double WIND = 5;
    
    public Snowflake() {
        x = (int) (Math.random() * MAX_X);
        y = (int) (Math.random() * MAX_Y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void fall() {
        y++;
        x += WIND;
        if (y > MAX_Y) {
            y = 0;
            x = (int) (Math.random() * 2000);
        }
        if(x > MAX_X) {
            x = 0;
            y= (int) (Math.random() * 2000);
        }
    }
}


