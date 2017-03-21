package PalindromeChecker;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * This class is an object oriented solution to HW1 part one. "a palindrome checker program
 * that first prompts the user to enter a string that is a combination
 * of digits (0-9) and letters (a-z), and then
 * displays if the entered string is a palindrome."
 * To use this class create an instance of PalindromeChecker and use the isPalindrome(String c) method
 * This class also functions as a standalone class if you execute main().
 * This class will record all valid strings that it checks accessible by getCheckedStrings().
 *
 * STATUS: This class has been tested with multiple inputs, and situations; program is free of major bugs. 
 *
 * @author Matt Bell
 * @version 0.1.04
 * @since 8/26/16
 *
 */
public class PalindromeChecker {
    /*
     * A stored list of Strings that have been checked 
     */
    ArrayList<String> checkedStrings;
    
    /**
     * The default constructor for the PalindromeChecker class
     */
    public PalindromeChecker(){
        checkedStrings = new ArrayList<>();
    }
    
    /**
     * This method takes a String c and return true if c is a palindrome, false if not.
     *
     * Throws IllegalArgumentExeception if any character other than a-z, 0-9, or \\u0020 has been passed.
     * @param c A string for the method to check if it is a palindrome
     * @return True if palindrome, false if not.
     * @throws IllegalArgumentException is thrown if a character other than a-z,0-9, or \\u0020 has been passed.
     */
    public boolean isPalindrome(String c) throws IllegalArgumentException{
        c = c.toLowerCase();
        
        /*
        * \u0020 is the unicode value for space
        * "[^a-z0-9\u0020]" is a regex in java noting the character classes of not a-z not 0-9 or not space
        * see http://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
        */
        if(!c.equals(c.replaceAll("[^a-z0-9\u0020]",""))){
            throw new IllegalArgumentException("A character other than a-z,"
                    + " 0-9, or \\u0020 has been entered");
        }
        checkedStrings.add(c);
        c = c.replaceAll("\u0020","");//removes all spaces from string
        int cLen = c.length();
        if(cLen<1){
           return false;
        }
        for(int i = 0;i < ((cLen/2));i++){
            if(c.charAt(i) != c.charAt((cLen-1)-i)){
                return false;
            }
        }
        return true;
    }
    
    /**
     * returns all of the strings that have been checked by this object.
     * @return an array of Strings containing all of the valid Strings that have been checked by this object
     */
    public String[] getCheckedStrings(){
        return checkedStrings.toArray(new String[checkedStrings.size()]);
    }
    
    /**
     * The main method for running the palindromeChecker Program, handles I/O, and program flow.
     * For simplicity's sake, and to prevent you from having to use two java files, this will be
     * the method that will be called to execute the palindromeChecker program
     * JOptonPane is used statically for all dialogue
     * Program repeats until user exits
     * @param args A String array of command-line arguments
     */
    public static void main(String args[]){
        PalindromeChecker c = new PalindromeChecker();
        boolean repeatProgram = true;
        while(repeatProgram){
            String inputString = JOptionPane.showInputDialog(null,"Please enter a possible palindrome to check "
                    + "that is a combination of digits (0-9) \nand letters (a-z), the space character "
                    + "is allowed but ommitted in the calculation.","Palindrome Checker",JOptionPane.PLAIN_MESSAGE);
            try{
                if(c.isPalindrome(inputString)){
                    JOptionPane.showMessageDialog(null, "\""+inputString+ "\" IS a palindrome");
                }
                else{
                    JOptionPane.showMessageDialog(null, "\""+inputString+ "\" is NOT a palindrome");
                }
            }
            catch(NullPointerException e){
                System.exit(0);//exiting due to cancel or exit being pressed
            }
            catch(IllegalArgumentException e){
                JOptionPane.showMessageDialog(null,"A character other "
                        + "than a-z, 0-9, or space has been entered","Invalid Input"
                        , JOptionPane.ERROR_MESSAGE);
            }
            finally{
                repeatProgram = false;
                int reply = JOptionPane.showConfirmDialog(null, "Would you like to "
                        + "check another palindrome?","Palindrome Checker",JOptionPane.YES_NO_OPTION);
                if(reply == JOptionPane.YES_OPTION){
                    repeatProgram = true;
                }
            }
            
        }
    }
}