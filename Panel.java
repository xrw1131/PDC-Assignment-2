/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workforceplanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author xrw1131
 */
public class Panel extends JPanel{
    private static Frame frame;
    private ButtonGroup bgType;
    
    private JTextField tfFirstName;
    private JTextField tfLastName;
    
    private SpinnerModel smEmpSalary;
    private SpinnerModel smIntSalary;
    private SpinnerModel smBonus;
    
    private JSpinner spinEmpSalary;
    private JSpinner spinIntSalary;
    private JSpinner spinBonus;
    
    private JLabel labelFirstName;
    private JLabel labelLasttName;
    private JLabel labelSalary;
    private JLabel labelBonus;
    
    public Panel(int x, int y, int width, int height) {
        setLayout(null);
        setVisible(false);  
        setBounds(x, y, width, height);
    }

    public static void setFrame(Frame frame){
        Panel.frame = frame;        
    }
    
    public void showPanel(){
        setVisible(true);  
    }
    
    public void setInputPanel(){
        //setBackground(Color.yellow);                                          //remember to remove this line
        //this.setVisible(true);
        
        labelFirstName = new JLabel(English.empFirstname);
        labelFirstName.setBounds(20, 10, 200, 30);
        add(labelFirstName);
        
        tfFirstName = new JTextField();
        tfFirstName.setBounds(20, 50, 200, 30);        
        add(tfFirstName);
        
        labelLasttName = new JLabel(English.empLastname);
        labelLasttName.setBounds(250, 10, 200, 30);
        add(labelLasttName);
        
        tfLastName = new JTextField();
        tfLastName.setBounds(250, 50, 200, 30);
        add(tfLastName);
        
        labelSalary = new JLabel(English.empSalary);
        labelSalary.setBounds(20, 100, 200, 30);        
        add(labelSalary);
        
        smEmpSalary = new SpinnerNumberModel(50000, 50000, 1000000, 100);
        spinEmpSalary = new JSpinner(smEmpSalary);
        spinEmpSalary.setBounds(20, 140,100, 30);        
        add(spinEmpSalary);
        
        smIntSalary = new SpinnerNumberModel(3500, 3500, 10000, 10);
        spinIntSalary = new JSpinner(smIntSalary);
        spinIntSalary.setBounds(20, 140,100, 30);
        spinIntSalary.setVisible(false);
        add(spinIntSalary);
        
        labelBonus = new JLabel(English.bonus);
        labelBonus.setBounds(250, 100,200, 30);
        labelBonus.setVisible(false);
        add(labelBonus);
        
        smBonus = new SpinnerNumberModel(1, 1, 100, 1);
        spinBonus = new JSpinner(smBonus);
        spinBonus.setBounds(250, 140, 40, 30);
        spinBonus.setVisible(false);
        add(spinBonus);
        
        setButtonGroupType();        
        setAddButton();        
    }
    
    private void setButtonGroupType(){ // setting the radio buttons and grouping them
        bgType = new ButtonGroup();
        JRadioButton rbEmployee = new JRadioButton(English.employeeClass);
        JRadioButton rbBonus = new JRadioButton(English.bonusClass);
        JRadioButton rbIntern = new JRadioButton(English.internClass);
        rbEmployee.setSelected(true);
        rbEmployee.setBounds(515, 110, 100, 20);
        rbBonus.setBounds(515, 130, 150, 20);
        rbIntern.setBounds(515, 150, 100, 20);
        rbEmployee.setActionCommand(English.employeeClass);
        rbBonus.setActionCommand(English.bonusClass);
        rbIntern.setActionCommand(English.internClass);
        
        ActionListener bgTypeListener = (ActionEvent e) -> {
            String input = e.getActionCommand();
            if (input.equals(English.employeeClass) || input.equals(English.bonusClass)){
                labelFirstName.setText(English.empFirstname);
                labelLasttName.setText(English.empLastname);
                labelSalary.setText(English.empSalary);                
                
                spinIntSalary.setVisible(false);
                spinEmpSalary.setVisible(true);
                
                if (input.equals(English.bonusClass)) {
                    labelBonus.setVisible(true);
                    spinBonus.setVisible(true);
                } else {
                    labelBonus.setVisible(false);
                    spinBonus.setVisible(false);
                }
            }            
            else if (input.equals(English.internClass)){
                labelFirstName.setText(English.intFirstname);
                labelLasttName.setText(English.intLastname);
                labelSalary.setText(English.intSalary);
                
                labelBonus.setVisible(false);
                spinBonus.setVisible(false);
                spinEmpSalary.setVisible(false);
                
                spinIntSalary.setVisible(true);
            }
        };
        rbEmployee.addActionListener(bgTypeListener);
        rbBonus.addActionListener(bgTypeListener);
        rbIntern.addActionListener(bgTypeListener);        
        bgType.add(rbEmployee);
        bgType.add(rbBonus);
        bgType.add(rbIntern);
        add(rbEmployee);
        add(rbBonus);
        add(rbIntern);     
        
    }
    
    private void setAddButton(){//setting the add button
        Button buttonAdd = new Button(English.addButton, 515, 50, 150);
        ActionListener addListener = (ActionEvent e) -> {
            if(Check.textField(tfFirstName, English.errorFirstname))
                if(Check.textField(tfLastName, English.errorLastname)){
                    String firstName = tfFirstName.getText().trim();
                    String lastName = tfLastName.getText().trim();
                    String input = bgType.getSelection().getActionCommand();

                    if (input.equals(English.employeeClass) || input.equals(English.bonusClass)) {
                        int salary = (int) spinEmpSalary.getValue();
                        if (input.equals(English.bonusClass)) {//only for bonus employee
                            int bonus = (int) spinBonus.getValue();

                        } else {//only for regular employee
                            Employee newEmployee = new Employee(lastName, firstName, salary);
                            Lists.addEmployee(newEmployee);
                            JOptionPane.showMessageDialog(frame, English.addEmpSuccess, English.success, JOptionPane.PLAIN_MESSAGE);
                        }
                    } else if (input.equals(English.internClass)) {//only for interns
                        int salary = (int) spinIntSalary.getValue();

                    }

                    //resets input fields
                    tfFirstName.setText("");
                    tfLastName.setText("");
                    spinEmpSalary.setValue(50000);
                    spinIntSalary.setValue(3500);
                    spinBonus.setValue(1);
                }            
        };//end of listener
        
        buttonAdd.addActionListener(addListener);
        add(buttonAdd);
    }
}
