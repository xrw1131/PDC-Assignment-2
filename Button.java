/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workforceplanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author xrw1131
 */
public class Button extends JButton{
    
    private final int BUTTON_HEIGHT = 30;
    private static Frame frame;
    
    public Button(String name, int x, int y, int width) {
        super(name);
        setLayout(null);
        setBounds(x, y, width, BUTTON_HEIGHT);
    }
    
    public static void setFrame(Frame frame){
        Button.frame = frame;        
    }
    
    public void addMainMenuListener(){
        ActionListener MainMenuListener = (ActionEvent e) -> {
            if (frame.getHeight() != frame.WINDOW_HEIGHT){
                frame.setSize(frame.WINDOW_WIDTH, frame.WINDOW_HEIGHT);
                frame.setLocationRelativeTo(null);
            }                
        };
        addActionListener(MainMenuListener);
    }
}
