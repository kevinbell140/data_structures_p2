/*
Author: Kevin Bell
Course: COP3538
Project#: 2
Title: Priority Queues
Due Date: 10/4/2106

Builds and updates a priority queue of president objects with a stack

 */
package ds_p2;
import java.util.ArrayList;


/**
 * Provides properties and methods for the update stack
 */
public class StackDrvr {
        private ArrayList<Presidents> prezStack;
        private int stackElem;
        private int top;
    
        
    /**
     * Constructor for StackDrvr Class
     * @return constructor
     * @param none
     */
    public StackDrvr(){
        prezStack = new ArrayList<>();
        top = -1;
        stackElem = 0; 
    }//end constructor
    
    
    /**
     * Pushes presidents onto the update stack
     * @return void
     * @param president The president object to be pushed onto stack 
     */
    public void push(Presidents president){
        prezStack.add(president);
        ++top;
        stackElem++; 
    }//end push
    
    
    /**
     * Pops presidents off of the update stack
     * @return The president removed from the top of the stack
     * @param none
     */
    public Presidents pop(){
        return prezStack.get(top--);   
    }//end pop
    
    
    
    /**
     * Determines if the stack is empty
     * @return True if stack is empty
     * @param none
     */
    public boolean isEmpty(){
        return (top == -1);
    }//end isEmpty()
        
    
    
    /**
     * Returns the number of objects in the stack
     * @return The number of objects in the stack
     * @param none
     */
    public int size(){
        return stackElem;
    }
    
    /**
     * Displays the update stack
     * @return void
     * @param none
     */
    public void display(){
        getHeader();
        
        System.out.println("Top of Stack");
        for (int i = top; i>=0; i--){
             System.out.println(prezStack.get(i).toString());        
        }//end for
        System.out.println("Bottom of Stack");
    }//end display
    
    
    /**
     * Gets header for the update stack display
     * @return void
     * @param none
     */
    private void getHeader(){
        System.out.format("\n\n\n%-23s%-10s\n", "Input Stack for Updating Priority Queues", " "); //prints report title
        System.out.println(String.format("\n%-3s%-20s%-20s\n", "#", "Name", "Party")); //format header        
    }//end getHeader()
}