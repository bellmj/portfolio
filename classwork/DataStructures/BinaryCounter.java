package binaryCounter;

import javax.swing.JOptionPane;

/**
 * This class contains is a Binary ones counter.
 * When main() is called it will take a user integer input and return the number of ones required to represent it in binary 
 *
 * STATUS: This class has been tested with multiple inputs, and situations; program is free of major bugs. 
 *
 * @author Matt Bell
 * @version 0.1.00
 * @since 8/28/16
 *
 */
public class BinaryCounter {
    
    /**
     * This method contains the program flow and all I/O for the Binary Ones Counter program.
     * This program will run until the user decides to exit
     * The actual binary counting is accomplished by a call to the method binaryCounter()
     * @param args A String array of command-line arguments
     */
    public static void main(String[] args){
        boolean again = true;
        while(again){
          int intInput = 0;
          String stringInput =  JOptionPane.showInputDialog(null,"Enter a number >= 0 and <= 2^31 - 1, and this program will return \nthe number of 1s needed to represent the number in binary.","Binary 1s Counter",JOptionPane.PLAIN_MESSAGE);
          if(stringInput == null){
              System.exit(0);
          }
          try{
             intInput = Integer.parseInt(stringInput);
          }
          catch(NumberFormatException e){
              JOptionPane.showMessageDialog(null,"Please enter a valid integer >= 0 and <= 2^31 - 1","Error",JOptionPane.ERROR_MESSAGE);
              continue;
          }
          try{
              JOptionPane.showMessageDialog(null, stringInput + " requires "+ binaryCounter(intInput)+ " ones to represent in binary");
          }
          catch(IllegalArgumentException e){
             JOptionPane.showMessageDialog(null,"Please enter an integer greater than 0","Error",JOptionPane.ERROR_MESSAGE);
             continue;
          }
          
          int response = JOptionPane.showConfirmDialog(null, "Would you like to enter another number?","Binary 1s Checker",JOptionPane.YES_NO_OPTION);
          
          if(response == JOptionPane.NO_OPTION || response == JOptionPane.CLOSED_OPTION || response == JOptionPane.CANCEL_OPTION){
              again = false;
          }
          
        }
        
    }
    
    /**
     * This is a recursive method that will return the number of 1's it takes to represent 
     * a number (n) that is greater or equal to zero.
     * @param n the the decimal number to determine binary 1's of
     * @return the number of 1s that it takes to represent n in binary 
     */
    public static int binaryCounter(int n) throws IllegalArgumentException{
        if(n < 0){
            throw new IllegalArgumentException("the number entered must be >= 0");
        }
        if(n == 0){
            return 0;
        }
        return n%2 + binaryCounter(n/2);
    }
    
}
