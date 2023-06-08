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
    private int salary;
    private String id;
    private static String type = English.employeeClass;
    private static int counter = 0;
    
    public Employee(String lastName, String firstName, int salary) {//constructor
        super(lastName, firstName);
        this.salary = salary;  
        counter++;        
        this.id = counter + "";
        while(this.id.length() < 4)
            this.id = "0" + this.id;
        this.id = lastName.toUpperCase().charAt(0) + firstName.toUpperCase().charAt(0) + this.id;
    }    
    
    public static String getType(){//get method
        return type;
    }

    public int getSalary() {
        return salary;
    }
    
    
/**
    public static int getBaseSalary() {//get method
        return baseSalary;
    }

    public int getAddSalary() {//get method
        return addSalary;
    }

    public static void setBaseSalary(int baseSalary) {//set method
        Employee.baseSalary = baseSalary;
    }

    public void setAddSalary(int addSalary) {//set method
        this.addSalary = addSalary;
    }
    
    public int getTotalSalary(){//get method
        return baseSalary + this.addSalary;
    }
    */
    @Override
    public String toString(){//toString method
        return getFirstName() + " " + getLastName() + ": $" + getSalary() + " per annum";
    }    
    
}
