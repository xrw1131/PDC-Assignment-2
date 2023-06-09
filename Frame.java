/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workforceplanner;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;

/**
 *
 * @author xrw1131
 */
public class Frame extends JFrame{
    
    final int WINDOW_WIDTH = 700;
    final int WINDOW_HEIGHT = 610;         

    public Frame(String name) {//constructor
        super(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(WINDOW_WIDTH, 135);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);        
        
        Panel inputPanel = new Panel(0, 100, WINDOW_WIDTH, 200);        
        Panel modifyPanel = new Panel(0, 100, WINDOW_WIDTH, 450);        
        Panel showPanel = new Panel(0, 100, WINDOW_WIDTH, 450);        
        
        setMainMenuPanel(inputPanel, modifyPanel, showPanel);                
        inputPanel.setInputPanel(); 
        setModifyPanel(modifyPanel);
        modifyPanel.setModifyPanel(); 
        setShowPanel(showPanel);
        
        getContentPane().add(inputPanel);
        getContentPane().add(modifyPanel);
        getContentPane().add(showPanel);
        Lists.addPanel(inputPanel);
        Lists.addPanel(modifyPanel);
        Lists.addPanel(showPanel);
    }
    
    private void setMainMenuPanel(Panel inputPanel, Panel modifyPanel, Panel showPanel){//sets the main menu
        Panel mainMenu = new Panel(0, 0, WINDOW_WIDTH, 100);
        mainMenu.setBackground(Color.LIGHT_GRAY);
        mainMenu.setVisible(true);                
        getContentPane().add(mainMenu);
        
        Button.setFrame(this);
        Check.setFrame(this);
        
        int y = 30;
        int width = 150;
        
        MainButtons buttonShow = new MainButtons(English.showEmp, 60, y, width); 
        buttonShow.showEmployees(showPanel);
        Lists.addMenuButton(buttonShow);
        mainMenu.add(buttonShow);
        
        MainButtons buttonAdd = new MainButtons(English.addEmp, 270, y, width); 
        buttonAdd.addEmployee(inputPanel);
        Lists.addMenuButton(buttonAdd);
        mainMenu.add(buttonAdd);
        
        MainButtons buttonModify = new MainButtons(English.modifyEmp, 480, y, width);
        buttonModify.modifyEmployee(modifyPanel);
        Lists.addMenuButton(buttonModify);        
        mainMenu.add(buttonModify);                                           //in progress ...
    }    
    
    private void setShowPanel(Panel showPanel){//setup for showPanel 
        setJList(showPanel);
        setShowButtons(showPanel);
    }
    
    private void setJList(Panel showPanel){//sets the component that displays records
        String[] list = new String[]{English.JListInitial};
        JList viewingList = new JList(list);        
        viewingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        viewingList.setLayoutOrientation(JList.VERTICAL);
        viewingList.setVisibleRowCount(-1);
                
        JScrollPane scrollPane = new JScrollPane(viewingList);
        scrollPane.setBounds(20, 75, 480, 375);
        scrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
        
        showPanel.add(scrollPane);   
        ShowButtons.setViewingList(viewingList);
    }
    
    private void setShowButtons(Panel showPanel){//sets the buttons that toggle data to be shown
        int y = 20;
        ShowButtons showAll = new ShowButtons(English.showAll, 20, y, 150);
        ShowButtons showEmployeesOnly = new ShowButtons(English.employeeClass, 180, y, 150);
        ShowButtons showBonusOnly = new ShowButtons(English.bonusClass, 340, y, 160);
        ShowButtons showInternOnly = new ShowButtons(English.internClass, 510, y, 150);
        showAll.showAll();
        showEmployeesOnly.showRequestedType(Lists.getEmployeeList());
        showBonusOnly.showRequestedType(Lists.getBonusList());        
        showInternOnly.showRequestedType(Lists.getInternList());        
        showPanel.add(showAll);
        showPanel.add(showEmployeesOnly);
        showPanel.add(showBonusOnly);
        showPanel.add(showInternOnly);
    }
    
    private void setModifyPanel(Panel modifyPanel) {//setup for modifyPanel
        setJListModify(modifyPanel);
        setTargetButtons(modifyPanel);
    }
    
    private void setJListModify(Panel modifyPanel){//sets the component that displays records
        String[] list = new String[]{English.JListInitialModify};
        JList viewingList = new JList(list);        
        viewingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        viewingList.setLayoutOrientation(JList.VERTICAL);
        viewingList.setVisibleRowCount(-1);
                
        JScrollPane scrollPane = new JScrollPane(viewingList);
        scrollPane.setBounds(20, 200, 480, 250);
        scrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
        
        modifyPanel.add(scrollPane);
        TargetButtons.setViewingList(viewingList);
    }
    
    private void setTargetButtons(Panel modifyPanel){//sets the buttons that toggle data to be shown
        int x = 515;
        TargetButtons targetEmployeesOnly = new TargetButtons(English.employeeClass, x, 300, 150);
        TargetButtons targetBonusOnly = new TargetButtons(English.bonusClass, x, 360, 155);
        TargetButtons targetInternOnly = new TargetButtons(English.internClass, x,420, 150);
        
        targetEmployeesOnly.showRequestedType(Lists.getEmployeeList());
        targetBonusOnly.showRequestedType(Lists.getBonusList());        
        targetInternOnly.showRequestedType(Lists.getInternList());        
        
        modifyPanel.add(targetEmployeesOnly);
        modifyPanel.add(targetBonusOnly);
        modifyPanel.add(targetInternOnly);        
    }
    
}
