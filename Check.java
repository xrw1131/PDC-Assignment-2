/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workforceplanner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author xrw1131
 */
public class Check {
    
    private static Frame frame;
    
    public static void setFrame(Frame frame){
        Check.frame = frame;        
    }
    
    public static boolean textField(JTextField textField, String errorMessage){//tests whether textField has valid input
        String input = textField.getText().trim();
        boolean valid = true;
        if (input.length() == 0){            
            valid = false;
        } else {            
            for(int k = 0; k < input.length() && valid; k++) {
                char letter = input.charAt(k);
                if(!(Character.isLetter(letter) || letter == '-' || letter == ' '))
                    valid = false;
            }                
        }          
        if (valid)
            return true;
        else {
            JOptionPane.showMessageDialog(frame, errorMessage, English.invalidInput, JOptionPane.ERROR_MESSAGE);
            textField.requestFocus();
            return false;
        }
    }
}
