/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workforceplanner;

/**
 *
  * @author xrw1131
 */
public class Bonus extends Employee {
    private static String type = English.bonusClass;    
    private int bonus;
    
    public Bonus(String id, String lastName, String firstName, int salary, int bonus) {//constructor
        super(id, lastName, firstName, salary);
        this.bonus = bonus;        
    }   
    
    public Bonus(String lastName, String firstName, int salary, int bonus) {//constructor
        super(lastName, firstName, salary);
        this.bonus = bonus;        
    }        
    
    public static String getType(){//get method
        return type;
    }
    
    public int getBonus() {//get method
        return bonus;
    }

    public void setBonus(int bonus) {//set method
        this.bonus = bonus;
    }    
}
