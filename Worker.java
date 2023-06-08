/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workforceplanner;

/**
 *
  * @author xrw1131
 */
public class Worker implements Comparable<Worker>{
    private String lastName;
    private String firstName;        
    private static int counter = 0;

    public Worker(String lastName, String firstName) {//constructor
        this.firstName = firstName;
        this.lastName = lastName;
        counter++;
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
    

    public void setFirstName(String firstName) {//set method
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {//set method
        this.lastName = lastName;
    }    
    
    @Override
    public int compareTo(Worker worker){//overridden compareTo method to enable ArrayList sorting
        return this.getFullName().compareTo(worker.getFullName());
    }
  
}
