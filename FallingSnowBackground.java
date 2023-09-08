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

public class FallingSnowBackground {
    private static final int WIDTH = 2000;
    private static final int HEIGHT = 1000;

    private JFrame frame;
    private JSlider spdSlider, snowSlider;
    private JPanel panel;
    private BufferedImage image;
    private Timer snowTimer, lightTimer;
    private GradientPaint bg;
    
    private int windSpeed, snowflakeCount, target, dir;
    private Snowflake[] snowflakes;

    public FallingSnowBackground() {
        // Create the main frame
        frame = new JFrame("Popup Window with Falling Snow");
        target = 0;
        dir = 1;
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
        spdSlider = new JSlider(-10, 10, 0);
        snowSlider = new JSlider(1,4000, 2000);
        panel.add(spdSlider);
        panel.add(snowSlider);
        panel.add(imageLabel);
        
        // Add the panel to the frame
        frame.add(panel);

        // Create snowflakes
        snowflakeCount = snowSlider.getValue();
        snowflakes = new Snowflake[snowflakeCount];
        for (int i = 0; i < snowflakeCount; i++) {
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
        
        lightTimer = new Timer(30, new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               target += dir;
               if(target > 254 || target < 1) {
                   dir *= -1;
               }
               bg = new GradientPaint(0, 100f, new Color(0,0, target*5/6), WIDTH/2, HEIGHT, new Color(10, 10, target/2));
           }
        });
        
        spdSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                windSpeed = spdSlider.getValue();
            }
        });
        
        snowSlider.addChangeListener(new ChangeListener() {
           @Override
           public void stateChanged(ChangeEvent e) {
               snowflakeCount = snowSlider.getValue();
               snowflakes = new Snowflake[snowflakeCount];
               for(int i = 0; i < snowflakeCount; i++) {
                   snowflakes[i] = new Snowflake();
               }
           }
        });
        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);

        // Start the snowfall animation
        snowTimer.start();
        lightTimer.start();
    }

    private void drawBackground(Graphics g) {
        // Clear the panel
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(bg);
        g2D.fillRect(0, 0, WIDTH, HEIGHT);

        // Draw snowflakes
        g2D.setColor(new Color(225,225,225));
        for (Snowflake snowflake : snowflakes) {
            g2D.fillRect(snowflake.getX(), snowflake.getY(), 3, 3);
        }

        // Draw snowy ground
        g2D.setColor(new Color(225,225,225));
        g2D.fillRect(0,5*HEIGHT/9, WIDTH, 2000);
    }

    private void moveSnowflakes() {
        for (Snowflake snowflake : snowflakes) {
            snowflake.fall(windSpeed, WIDTH);
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
    
    public Snowflake() {
        x = (int) (Math.random() * MAX_X);
        y = (int) (Math.random() * MAX_Y);
    }
    public Snowflake(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public Pair getCoords() {
        return new Pair(x, y);
    }
    public void fall(double wind, int width) {
        y++;
        x += wind;
        if (y > MAX_Y) {
            y = 0;
            x = (int) (Math.random() * MAX_X);
        }
        if(x > MAX_X) {
            x = 0;
            y = (int) (Math.random() * MAX_Y);
        }
        if(x < 0) {
            x = MAX_X;
            y = (int) (Math.random() * 2000);
        }
    }
}

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


