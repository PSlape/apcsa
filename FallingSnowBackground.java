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

public class FallingSnowBackground {
    private static final int WIDTH = 2000;
    private static final int HEIGHT = 1000;

    private JFrame frame;
    private JSlider spdSlider, snowSlider;
    private JPanel panel;
    private BufferedImage image;
    private Timer snowTimer, lightTimer;
    private GradientPaint bg;
    
    private int windSpeed, snowflakeCount, dir;
    private double target;
    private Snowflake[] snowflakes;

    public FallingSnowBackground() {
        // Create the main frame
        frame = new JFrame("Popup Window with Falling Snow");
        target = 0;
        
        // Set the size of the frame
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
               target += 0.001;
               Pair center = new Pair(WIDTH/2, HEIGHT);
               Pair point = circlePair((double) target, 300.0, center);
               bg = gradPair(center, new Color(0,0,60), point, new Color(102, 178, 255));
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
    
    private static Pair circlePair(double deg, double rad) {
        return new Pair(rad*Math.sin(deg), rad*Math.cos(deg));
    }
    private static Pair circlePair(double deg, double rad, Pair offset) {
        return new Pair(rad*Math.sin(deg) + offset.x, rad*Math.cos(deg) + offset.y);
    }
    
    private static GradientPaint gradPair(Pair pair, Color col1, Pair pair2, Color col2) {
        return new GradientPaint((float) pair.x, 
            (float) pair.y, 
            col1, 
            (float) pair2.x, 
            (float) pair2.y, 
            col2
        );
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
    double x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Pair(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Pair(float x, float y) {
        this.x = x;
        this.y = y;
    }
}



