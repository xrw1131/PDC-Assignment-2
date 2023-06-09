/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workforceplanner;

/**
 *
  * @author xrw1131
 */
public abstract class Worker implements Comparable<Worker>{
    protected String id;
    private String lastName;
    private String firstName;    
    private int salary;        

    public Worker(String lastName, String firstName, int salary) {//constructor
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;    
    }
    
    public Worker(String id, String lastName, String firstName, int salary) {//constructor
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;        
    }
    
    public String getId() {//get method
        return id;
    }  
    
    public String getFirstName() {//get method
        return firstName;
    }

    public String getLastName() {//get method
        return lastName;
    }        
    
    public String getFullName() {//get method
        return lastName + ", " + firstName;
    }
    
    public int getSalary() {//get method
        return salary;
    }
    

    public void setFirstName(String firstName) {//set method
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {//set method
        this.lastName = lastName;
    }    

    public void setSalary(int salary) {//set method
        this.salary = salary;
    }    
    
    @Override
    public int compareTo(Worker worker){//overridden compareTo method to enable ArrayList sorting
        return this.id.compareTo(worker.id);
    }
  
}
