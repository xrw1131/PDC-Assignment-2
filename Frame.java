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
    final int WINDOW_HEIGHT = 500;
    
    private Panel mainMenu;
    private Panel inputPanel;
    private Panel showPanel;

    public Frame(String name) {
        super(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(WINDOW_WIDTH, 135);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);        
        
        inputPanel = new Panel(0, 100, WINDOW_WIDTH, 200);        
        showPanel = new Panel(0, 100, WINDOW_WIDTH, 350);        
                
        setMainMenuPanel();                
        inputPanel.setInputPanel(); 
        setShowPanel();
        
        getContentPane().add(inputPanel);
        getContentPane().add(showPanel);
        Lists.addPanel(inputPanel);
        Lists.addPanel(showPanel);
    }
    
    private void setMainMenuPanel(){
        mainMenu = new Panel(0, 0, WINDOW_WIDTH, 100);
        mainMenu.setBackground(Color.LIGHT_GRAY);
        mainMenu.setVisible(true);                
        getContentPane().add(mainMenu);
        
        Button.setFrame(this);
        Check.setFrame(this);
        
        int y = 30;
        int width = 150;
        
        MainButton buttonShow = new MainButton(English.showEmp, 60, y, width); 
        buttonShow.addShow(showPanel);
        Lists.addMenuButton(buttonShow);
        mainMenu.add(buttonShow);
        
        MainButton buttonAdd = new MainButton(English.addEmp, 270, y, width); 
        buttonAdd.addEmployee(inputPanel);
        Lists.addMenuButton(buttonAdd);
        mainMenu.add(buttonAdd);
        
        MainButton buttonModify = new MainButton(English.modifyEmp, 480, y, width);          
        Lists.addMenuButton(buttonModify);
        mainMenu.add(buttonModify);        
    }    
    
    private void setShowPanel(){        
        int y = 20;
        Button showAll = new Button(English.showAll, 20, y, 150);
        Button showEmployeesOnly = new Button(English.employeeClass, 180, y, 150);
        Button showBonusOnly = new Button(English.bonusClass, 340, y, 160);
        Button showInternOnly = new Button(English.internClass, 510, y, 150);
        showPanel.add(showAll);
        showPanel.add(showEmployeesOnly);
        showPanel.add(showBonusOnly);
        showPanel.add(showInternOnly);
        
    }
    
}
