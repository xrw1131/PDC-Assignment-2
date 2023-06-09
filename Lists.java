/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workforceplanner;

import java.util.ArrayList;

/**
 *
 * @author xrw1131
 */
public class Lists {
    private static ArrayList<Button> menuButtonList = new ArrayList<>();
    private static ArrayList<Panel> panelList = new ArrayList<>();
    
    private static ArrayList<Employee> employeeList = new ArrayList<>();
    private static ArrayList<Bonus> bonusList = new ArrayList<>();
    private static ArrayList<Intern> internList = new ArrayList<>();
    
    public static ArrayList<Button> getMenuButtonList(){//get method for menuButtonList
        return menuButtonList;
    }
    
    public static ArrayList<Panel> getPanelList(){//get method for panelList
        return panelList;
    }        

    public static ArrayList<Employee> getEmployeeList() {//get method for employeeList
        return employeeList;
    }    
    
    public static ArrayList<Bonus> getBonusList() {//get method for bonusList 
        return bonusList;
    }
    
    public static ArrayList<Intern> getInternList() {//get method for internList
     return internList;
    }
    
    //add methods
    public static void addMenuButton(MainButtons mainButton){//add method for menuButtonList
        menuButtonList.add(mainButton);
    }
    
    public static void addPanel(Panel panel){//add method for panelList
        panelList.add(panel);
    }
    
    public static void addEmployee(Employee employee){//add method for employeeList
        employeeList.add(employee);
    }
    
    public static void addBonus(Bonus bonus){//add method for bonusList
        bonusList.add(bonus);
    }    
    
    public static void addIntern(Intern intern){//add method for internList
        internList.add(intern);
    }
    
    public static int sizeEmpB(){//get method for both employeeList & bonusList
        return employeeList.size() + bonusList.size();
    }
}
