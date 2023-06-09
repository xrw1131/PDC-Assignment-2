/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workforceplanner;

/**
 *
 * @author xrw1131
 */
public class Intern extends Worker{    
    
    private static String type = English.internClass;
        
    public Intern(String id, String lastName, String firstName, int salary) { //constructor
        super(id, lastName, firstName, salary);     
    }
    
    public Intern(String lastName, String firstName, int salary) { //constructor
        super(lastName, firstName, salary);            
        this.id = (Lists.getInternList().size() + 1) + "";
        while (this.id.length() < 3) {
            this.id = "0" + this.id;
        }
        this.id = firstName.toUpperCase().charAt(0) + this.id;
        this.id = lastName.toUpperCase().charAt(0) + this.id;
    }
    
    public static String getType(){//get method
        return type;
    }    
    
}
