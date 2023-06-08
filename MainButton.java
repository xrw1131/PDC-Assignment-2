/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workforceplanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static workforceplanner.Button.frame;

/**
 *
 * @author xrw1131
 */
public class MainButton extends Button{    
    
    
    public MainButton(String name, int x, int y, int width) {//constructor for main buttons
        super(name, x, y, width);        
        
        ActionListener MainMenuListener = (ActionEvent e) -> {
            if (frame.getHeight() != frame.WINDOW_HEIGHT){
                frame.setSize(frame.WINDOW_WIDTH, frame.WINDOW_HEIGHT);
                frame.setLocationRelativeTo(null);
            }   
            
            for (Button b: Lists.getMenuButtonList())
                if (b.isEnabled() == false)
                    b.setEnabled(true);            
            setEnabled(false);
        };
        addActionListener(MainMenuListener); 
        
    }    
     public void addShow(Panel panel){// addtional listener for 'buttonShow'
        ActionListener listener = (ActionEvent e) -> {
            hidePanels(panel);
            
        };
        addActionListener(listener);        
    }
     
    public void addEmployee(Panel panel){// addtional listener for 'buttonAdd'
        ActionListener listener = (ActionEvent e) -> {
            hidePanels(panel);
            
        };
        addActionListener(listener);        
    }
    
    private void hidePanels(Panel panel){//hides the secondary panels, except the one requested
        for (Panel p: Lists.getPanelList())
                if (p.isVisible())
                    p.setVisible(false);
        panel.setVisible(true);
    }
    
}
