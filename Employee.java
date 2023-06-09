/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workforceplanner;

/**
 *
  * @author xrw1131
 */
public class Employee extends Worker {        
    
    private static String type = English.employeeClass;    
    
    public Employee(String id, String lastName, String firstName, int salary) {//constructor
        super(id, lastName, firstName, salary);                
    } 
    
    public Employee(String lastName, String firstName, int salary) {//constructor
        super(lastName, firstName, salary);        
                
        this.id = (Lists.sizeEmpB() + 1)+ "";
        while(this.id.length() < 4)
            this.id = "0" + this.id;
        this.id = firstName.toUpperCase().charAt(0) + this.id;
        this.id = lastName.toUpperCase().charAt(0) + this.id;
    }    
  
    
    public static String getType(){//get method
        return type;
    }     
    
}
