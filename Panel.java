/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workforceplanner;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author xrw1131
 */
public class Panel extends JPanel{
    private static Frame frame;
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JTextField tfSalary;
    private JTextField tfBonus;
    
    public Panel(int x, int y, int width, int height) {
        setLayout(null);
        setVisible(false);  
        setBounds(x, y, width, height);
    }

    public static void setFrame(Frame frame){
        Panel.frame = frame;        
    }
    
    public void showPanel(){
        setVisible(true);        
        frame.getWidth();
        frame.getHeight();
    }
    
    public void setInputPanel(){
        setBackground(Color.yellow);                                          //remember to remove this line
        setVisible(true);                                                   //remember to remove this line
        JLabel labelFirstName = new JLabel("Enter employee first name here:");
        labelFirstName.setSize(200, 30);
        labelFirstName.setLocation(20, 10);
        add(labelFirstName);
        
        tfFirstName = new JTextField();
        tfFirstName.setSize(200, 30);
        tfFirstName.setLocation(20, 50);
        add(tfFirstName);
        
        JLabel labelLasttName = new JLabel("Enter employee last name here:");
        labelLasttName.setSize(200, 30);
        labelLasttName.setLocation(250, 10);
        add(labelLasttName);
        
        tfLastName = new JTextField();
        tfLastName.setSize(200, 30);
        tfLastName.setLocation(250, 50);
        add(tfLastName);
        
        JLabel labelSalary = new JLabel("Enter employee salary here:");
        labelSalary.setSize(200, 30);
        labelSalary.setLocation(20, 100);
        add(labelSalary);
        
        tfSalary = new JTextField();
        tfSalary.setSize(200, 30);
        tfSalary.setLocation(20, 140);        
        add(tfSalary);
        
        JLabel labelBonus = new JLabel("Enter any bonus % here:");
        labelBonus.setSize(200, 30);
        labelBonus.setLocation(250, 100);
        add(labelBonus);
        
        tfBonus = new JTextField();
        tfBonus.setSize(200, 30);
        tfBonus.setLocation(250, 140);
        add(tfBonus);
        
        Button buttonAdd = new Button("Add", 515, 50, 150);
        add(buttonAdd);
    }
}
