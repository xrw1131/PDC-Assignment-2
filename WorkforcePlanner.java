/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package workforceplanner;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author xrw1131
 */
public class WorkforcePlanner{  
    
    static final String USER_NAME = "xrw1131"; 
    private static final String PASSWORD = "pdc"; 
    private static final String URL = "jdbc:derby:WorkforcePlanner_Ebd; create=true";
    
    static final String TABLE_EMP = "EMPLOYEES";
    static final String TABLE_BON = "EMPBONUS";
    static final String TABLE_INT = "INTERNS";
    
    public static void main(String[] args) { // main method
        DBManager dbm = new DBManager(URL, USER_NAME, PASSWORD);
        String fields = "ID VARCHAR(6), lastName VARCHAR(30), firstName VARCHAR(30), Salary INT".toUpperCase();
        dbm.createTable(TABLE_EMP, fields);
        fields += ", Bonus int".toUpperCase();
        dbm.createTable(TABLE_BON, fields);
        fields = "ID VARCHAR(5), lastName VARCHAR(30), firstName VARCHAR(30), Salary INT".toUpperCase();
        dbm.createTable(TABLE_INT, fields);               
                
        dbm.getAllReccords(TABLE_EMP, Lists.getEmployeeList());
        dbm.getAllReccords(TABLE_BON, Lists.getBonusList());
        dbm.getAllReccords(TABLE_INT, Lists.getInternList());
                
        Frame wfp = new Frame(English.frame);
        wfp.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dbm.updateDB("DELETE FROM " + TABLE_EMP);
                dbm.updateDB("DELETE FROM " + TABLE_BON);
                dbm.updateDB("DELETE FROM " + TABLE_INT);
                
                
                for (Employee emp : Lists.getEmployeeList()) {
                    String values = "'";
                    values += emp.getId() + "', '" + emp.getLastName() + "', '" + emp.getFirstName() + "', " + emp.getSalary();
                    dbm.insertRecord(TABLE_EMP, values);
                }
                for (Bonus b : Lists.getBonusList()) {
                    String values = "'";
                    values += b.getId() + "', '" + b.getLastName() + "', '" + b.getFirstName() + "', " + b.getSalary() + ", " + b.getBonus();
                    dbm.insertRecord(TABLE_BON, values);
                }
                for (Intern i : Lists.getInternList()) {
                    String values = "'";
                    values += i.getId() + "', '" + i.getLastName() + "', '" + i.getFirstName() + "', " + i.getSalary();
                    dbm.insertRecord(TABLE_INT, values);
                }
                
                dbm.closeConnections();
                System.out.println("System closing");
                System.exit(0);
            }
        });
    }
    
}
