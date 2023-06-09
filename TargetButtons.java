/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workforceplanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JList;

/**
 *
 * @author xrw1131
 */
public class TargetButtons extends Button{
    
    private static JList viewingList;
    
    public TargetButtons(String name, int x, int y, int width) {//constructor
        super(name, x, y, width);
    }
    
    public static void setViewingList(JList viewingList){
        TargetButtons.viewingList  = viewingList;
    }
    
    public void showRequestedType(ArrayList arrayList) {//set ActionListener that sets JList to show requested type
        ActionListener listener = (ActionEvent e) -> {
            int size = arrayList.size();
            String[] list;
            if (size != 0) {
                list = new String[size];
                Collections.sort(arrayList);
                for (int k = 0; k < size; k++) {
                    list[k] = English.toString((Worker)arrayList.get(k));
                }
            } else
                list = new String[]{English.JListNone};
            
            viewingList.setListData(list);
        };
        addActionListener(listener);
    }  
}
