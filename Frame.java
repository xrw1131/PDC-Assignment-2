/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workforceplanner;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author xrw1131
 */
public class Frame extends JFrame{
    
    final int WINDOW_WIDTH = 700;
    final int WINDOW_HEIGHT = 800;

    public Frame(String name) {
        super(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(WINDOW_WIDTH, 135);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
        setMainMenuPanel();
        setInputPanel();        
    }
    
    private void setMainMenuPanel(){
        Panel mainMenu = new Panel(0, 0, WINDOW_WIDTH, 100);
        mainMenu.setBackground(Color.LIGHT_GRAY);
        mainMenu.setVisible(true);                
        getContentPane().add(mainMenu);
        
        Button.setFrame(this);
        Button buttonShow = new Button("Show employees", 20, 30, 150); 
        buttonShow.addMainMenuListener();
        mainMenu.add(buttonShow);
        
        Button buttonAdd = new Button("Add new employee", 185, 30, 150);                        
        buttonAdd.addMainMenuListener();
        mainMenu.add(buttonAdd);
        
        Button buttonRemove = new Button("Remove employee", 350, 30, 150);  
        buttonRemove.addMainMenuListener();
        mainMenu.add(buttonRemove);
        
        Button buttonUpdate = new Button("Update employee", 515, 30, 150); 
        buttonUpdate.addMainMenuListener();
        mainMenu.add(buttonUpdate);
    }
    
    private void setInputPanel(){
        Panel inputPanel = new Panel(0, 100, WINDOW_WIDTH, 200);
        inputPanel.setInputPanel();                 
        getContentPane().add(inputPanel);
    }
}
