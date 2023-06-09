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
public class ShowButtons extends Button{
    
    private static JList viewingList;
    
    public ShowButtons(String name, int x, int y, int width) {//constructor
        super(name, x, y, width);
    }
    
    public static void setViewingList(JList viewingList){
        ShowButtons.viewingList  = viewingList;
    }
    
    public void showAll() { //set ActionListener that sets JList to show all available records
        ActionListener listener = (ActionEvent e) -> {
            ArrayList<Worker> arrayList = new ArrayList<>();
            arrayList.addAll(Lists.getEmployeeList());
            arrayList.addAll(Lists.getBonusList());
            arrayList.addAll(Lists.getInternList());
            int size = arrayList.size();
            String[] list;
            if (size != 0) {
                list = new String[size];
                Collections.sort(arrayList);
                for (int k = 0; k < size; k++) {
                    list[k] = English.toString(arrayList.get(k));
                }
            } else
                list = new String[]{English.JListNone};
            
            viewingList.setListData(list);
        };
        addActionListener(listener);
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
