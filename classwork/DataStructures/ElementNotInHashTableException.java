/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cofc.cs.csci230;

/**
 *
 * @author matt
 */
public class ElementNotInHashTableException extends Exception{
    public ElementNotInHashTableException(){
        super("given element not contained in Hash Table");
    }
}
