import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Integer;
import java.util.ArrayList;

public class GPACalcComp {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    
    private String inText;
    
    private JFrame frame, tooltip;
    private JPanel panel, lower;
    private JButton addGrade, giveGrade;
    private JTextField input, output, tip, except;
    private ArrayList<Integer> grades;
    
    private int total;
    
    int gradeIn;
    
    public static void main() {
        SwingUtilities.invokeLater(() -> {
            new GPACalcComp();
        });
    }
    
    public GPACalcComp() {
        
        frame = new JFrame("GPA Calculator");
        tooltip = new JFrame("Error");
        
        panel = new JPanel();
        lower = new JPanel();

        addGrade = new JButton("Add Grade");
        giveGrade = new JButton("Calculate Final GPA");
        
        input = new JTextField(20);
        output = new JTextField(15);
        tip = new JTextField(20);
        except = new JTextField(20);
        
        grades = new ArrayList<Integer>();
        
        total = 0;
        
        tooltip.add(tip);
        tooltip.add(except);
        
        tip.setEditable(false);
        except.setEditable(false);
        output.setEditable(false);
        
        addGrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                inText = input.getText();
                try {
                    gradeIn = Integer.parseInt(inText);
                } catch(Exception ex) {
                    tip.setText("Integers only. Close window to continue.");
                    except.setText(ex.toString());
                    tooltip.setVisible(true);
                } finally {
                    if(!tooltip.isVisible()) {
                        grades.add(gradeIn);
                        output.setText("Your GPA is: " + truncateDouble(calculateGpa()));
                    }
                }
            }
        });
        giveGrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                output.setText("Your final GPA is: " + truncateDouble(calculateGpa()));
                input.setEditable(false);
            }
        });
        
        
        panel.add(input);
        panel.add(addGrade);
        panel.add(giveGrade);
        panel.add(output);
        
        frame.add(panel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        tooltip.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tooltip.setPreferredSize(new Dimension(WIDTH,HEIGHT/2));
        tooltip.pack();
        tooltip.setLocationRelativeTo(frame);
        
        
    }
    
    private double calculateGpa() {
        total = 0;
        grades.forEach((n) -> addToTotal(n));
        if(grades.size() == 0) return 0;
        return (double) total / grades.size();
    }
    
    private void addToTotal(int n) {
        total += n;
    }
    
    private double truncateDouble(double n) {
        n *= Math.pow(10, 2);
        n = Math.floor(n);
        n = n / Math.pow(10, 2);
        return n;
    }
}