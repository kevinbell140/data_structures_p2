/*
Author: Kevin Bell
Course: COP3538
Project#: 2
Title: Priority Queues
Due Date: 10/4/2106

Builds and updates a priority queue of president objects with a stack
 */
package ds_p2;
import java.io.IOException;

/**
 *
 * Builds and updates a priority queue of president objects
 */
public class Main {
        
    /**
     * Builds and updates a priority queue of president objects
     * @return void
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        //sort type vars
        int unsorted = 1;
        int sorted = 2;
        int updated = 3;
        
        QueueDrvr prezQDrvr = new QueueDrvr();  //creates instance of type Queue
        
        File prezData = new File("presidents.txt");  //reads data file     
        prezData.parse(); //parses file
        
        for (Presidents president: prezData.getFileData()){ 
            prezQDrvr.insert(president);      //inserts data into queues
        }//end for
        
        prezQDrvr.display(unsorted);  //displays queue
        prezQDrvr.selectionSort();    //sorts queue on number        
        prezQDrvr.display(sorted);    //displays priority queue
        
        File update = new File("presidentsupdate.txt");   //reads update file
        update.parseUpdate();     //parses update file
        
        for (Presidents president: update.getFileData()){   
            prezQDrvr.getUpdate(president);   //inserts data into stack
        }//end for
        
        prezQDrvr.displayStack();     //displays update stack      
        prezQDrvr.update();           //updates the priority queue from the stack       
        prezQDrvr.display(updated);    //displays updated priority queue
    }//end main()
}//end Main class