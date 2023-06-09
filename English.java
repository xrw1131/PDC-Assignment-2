/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workforceplanner;

/**
 *
 * @author xrw1131
 */
public class English {//stores the English display strings for all swing components, plus static functions   
    static String frame = "Workforce Planner";
    static String showAll = "Show all";    
    
    //worker classes
    static String employeeClass = "Employee";
    static String bonusClass = "Employee with bonus";
    static String internClass = "Intern";
    
    //main buttons
    static String showEmp = "Show employees";
    static String addEmp = "Add new employee";
    static String modifyEmp = "Modify employee";
    
    //input panel labels
    static String empFirstname = "Enter employee's first name here:";
    static String empLastname = "Enter employee's last name here:";
    static String empSalary = "Enter annual salary here:";
    static String bonus = "Enter bonus percentage here:";
    static String intFirstname = "Enter intern's first name here:";
    static String intLastname = "Enter intern's last name here:";
    static String intSalary = "Enter monthly salary here:";
    
    //input panel button/s 
    static String addButton = "Add";
    static String modifyButton = "Confirm changes";
    
    //error messages
    static String invalidInput = "Invalid Input";
    static String errorFirstname = "Please enter a valid first name (letters and hyphen allowed).";
    static String errorLastname = "Please enter a valid last name (letters and hyphen allowed).";
    
    //message dialog
    static String success = "Success";
    static String addEmpSuccess = "Successfully added new employee.";
    static String addBonusSuccess = "Successfully added new employee with bonus.";
    static String addIntSuccess = "Successfully added new intern.";
    
    //JList messages
    static String JListInitial = "Please choose a button to view the corresponding data type.";
    static String JListInitialModify = "Select the employee type, then select the employee you wish to modify";
    static String JListNone = "No record currently available.";
    
    
    public static String toString(Worker worker){ // static toString method for each of the worker subclasses
        String output = worker.getId() + "  ";        
        output += worker.getFullName() + ",  $";
        output += worker.getSalary();
        if (worker instanceof Bonus){
            Bonus temp = (Bonus)worker;
            output += " per annum (excl. bonus " + temp.getBonus() + "%)";
        } 
        else if (worker instanceof Employee)
            output += " per annum";           
        else if (worker instanceof Intern)
            output += " per month";
        return output;
    }
}
