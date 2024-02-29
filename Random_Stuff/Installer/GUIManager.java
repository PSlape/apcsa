package Random_Stuff.Installer;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * Write a description of class GUIManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GUIManager {
    private JFrame window;
    private JTextField input;
    private JButton nextButton;
    
    private boolean isReadyForNext;
    
    public GUIManager() {
        window = new JFrame("Installer");
        
        JPanel panel = new JPanel();
        input = new JTextField(30);
        nextButton = new JButton();
        JTextArea infoLine = new JTextArea("Welcome to the installer, paste a link to get started.");
    
        panel.add(infoLine);
        panel.add(input);
        window.add(panel);
        window.add(nextButton);
        
        isReadyForNext = false;
        
        nextButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    isReadyForNext = true;
                }
            }
        );
    }
    
    public boolean isReady() {
        return isReadyForNext;
    }
    
    public void getInput() {
        input.getText();
    }
    
    public void show() {
        window.setVisible(true);
    }
}
