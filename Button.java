/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workforceplanner;

import javax.swing.JButton;

/**
 *
 * @author xrw1131
 */
public class Button extends JButton{
    
    private final int BUTTON_HEIGHT = 30;
    protected static Frame frame;
    
    
    public Button(String name, int x, int y, int width) {//constructor
        super(name);
        setLayout(null);
        setBounds(x, y, width, BUTTON_HEIGHT);
    }
    
    public static void setFrame(Frame frame){//setting static variable frame. Necessary for adjusting frame size
        Button.frame = frame;        
    }

}
