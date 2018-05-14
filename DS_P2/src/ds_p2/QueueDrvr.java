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
 * Provides properties and methods for 3 Queues
 */
public class QueueDrvr {
    
        private ArrayList<Presidents> demQueue; 
        private int demFront;
        private int demRear;
        private int demElem;
        
        private ArrayList<Presidents> repQueue;
        private int repFront;
;        private int repRear;
        private int repElem;
        
        private ArrayList<Presidents> whigQueue;
        private int whigFront;
        private int whigRear;
        private int whigElem;
        
        private StackDrvr prezStack;
        
        
    /**
     * Constructor for QueueDrvr class
     * @return constructor
     * @param none
     */
    public QueueDrvr(){
        demQueue = new ArrayList<>();
            demFront = 0;
            demRear = -1;
            demElem = 0;
        
        repQueue = new ArrayList<>();
            repFront = 0;
            repRear = -1;
            repElem = 0;
        
        whigQueue = new ArrayList<>();
            whigFront = 0;
            whigRear = -1;
            whigElem = 0;
        
        prezStack = new StackDrvr();
    }//end constructor
    

    /**
     * Determines if the Democratic Queue is empty
     * @return True if Queue is empty
     * @param none
     */
    public boolean isEmptyDem(){
        return (demElem == 0);
    }//end isEmptyDem
    
    /**
     * Determines if the Republican Queue is empty
     * @return True if the Queue is empty
     * @param none
     */
    public boolean isEmptyRep(){
        return (repElem ==0);
    }//end isEmptyDem
    
    /**
     * Determines if the Whig Queue is empty
     * @return True if the Queue is empty
     * @param none
     */
    public boolean isEmptyWhig(){
        return (whigElem == 0);
    }//end isEmptyWhig()
    
    
    /**
    * Adds a president to the proper queue
    * @return void
    * @param president The president object to be inserted 
    */
    public void insert(Presidents president){
               
            String party = president.getParty();
            
            switch (party){
                case "Democrat":
                    insertDem(president);
                    break;
                case "Republican":
                    insertRep(president);
                    break;
                case "Whig":
                    insertWhig(president);
                    break;
            }//end switch
    }//end insert()
    
    
    /**
     * Inserts a president into the Democratic Queue
     * @return void
     * @param president The president object to be inserted 
     */
    private void insertDem(Presidents president){
        demQueue.add(president);
        ++demRear;
        demElem++;
    }//end insertDem()
    
    /**
     * Inserts a president into the Republican Queue
     * @return void
     * @param president The president object to be inserted 
     */
    private void insertRep(Presidents president){
        repQueue.add(president);
        ++repRear;
        repElem++;
    }//end insertRep()
    
    /**
     * Inserts a president into the Whig Queue
     * @return void
     * @param president The president object to be inserted 
     */
    private void insertWhig(Presidents president){
        whigQueue.add(president);
        ++whigRear;
        whigElem++;   
    }//end insertWhig()
    
    
    /**
     * Displays president queues and priority queues
     * @return void
     * @param dispType Determines whether to display queue or priority queue 
     */
    public void display(int dispType){
        
        int dem = 1;
        int rep = 2;
        int whig = 3;
        int demUpdate = 4;
        int repUpdate = 5;
        int whigUpdate = 6;
        
        switch(dispType){
            case 1:     //unsorted
                getQHeader(dem);                
                displayDem();
                
                getQHeader(rep);
                displayRep();
                
                getQHeader(whig);
                displayWhig();
                break;
            case 2: //sorted
                getPQHeader(dem);
                displayDem();
                
                getPQHeader(rep);
                displayRep();
                
                getPQHeader(whig);
                displayWhig();  
                break;
            case 3: //updated
                getPQHeader(demUpdate);
                displayDem();
                
                getPQHeader(repUpdate);
                displayRep();
                
                getPQHeader(whigUpdate);
                displayWhig();
                        
        }//end switch()
    }//end display()

    /**
     * Displays the proper header for the queue
     * @return void
     * @param type Determines which header to display
     */
    private void getQHeader(int type){
        switch(type){
            case 1:
                System.out.format("\n%-23s%-10s\n", "Queue 1: Democrats", " "); //prints report title
                break;
            case 2:
                 System.out.format("\n\n%-23s%-10s\n", "Queue 2: Republicans", " "); //prints report title
                 break;
            case 3:
                System.out.format("\n\n%-23s%-10s\n", "Queue 3: Whigs", " "); //prints report title
                break;
        }//end switch
        System.out.println(String.format("\n%-3s%-20s%-20s\n", "#", "Name", "Party")); //format header
    }//end getQHeader()
    
    /**
     * Displays the proper header for the priority queue
     * @return void
     * @param type Determines which header to display
     */
    private void getPQHeader(int type){
        switch (type){
            case 1:
                System.out.format("\n\n%-23s%-10s\n", "Sorted Priorty Queue: Democrats", " "); //prints report title
                break;
            case 2:
                System.out.format("\n\n%-23s%-10s\n", "Sorted Priorty Queue: Republicans", " "); //prints report title
                break;
            case 3:
                System.out.format("\n\n%-23s%-10s\n", "Sorted Priorty Queue: Whigs", " "); //prints report title
                break;
            case 4:
                System.out.format("\n\n%-23s%-10s\n", "Updated Priorty Queue: Democrats", " ");
                break;
            case 5:
                System.out.format("\n\n%-23s%-10s\n", "Updated Priorty Queue: Republicans", " ");
                break;
            case 6:
                System.out.format("\n\n%-23s%-10s\n", "Updated Priorty Queue: Whigs", " ");
                break;
        }//end switch
        System.out.println(String.format("\n%-3s%-20s%-20s\n", "#", "Name", "Party")); //format header
    }//end getPQHeader()
    
    /**
     * Displays the Democratic Queue
     * @return void
     * @param none
     */
    private void displayDem(){
        for (int i = 0; i<demQueue.size(); i++){
            System.out.println(demQueue.get(i).toString());
        }//end for
    }//end displayDem()
    
    /**
     * Displays the Republican Queue
     * @return void
     * @param none
     */
    private void displayRep(){
        for (int i = 0; i<repQueue.size(); i++){
            System.out.println(repQueue.get(i).toString());
        }//end for
    }//end displayRep()
    
    /**
     * Displays the Whig Queue
     * @return void
     * @param none
     */
    private void displayWhig(){
        for (int i = 0; i<whigQueue.size(); i++){
            System.out.println(whigQueue.get(i).toString());  
        }//end for
    }//end displayWhig()
    
   
    
    /**
     * Sorts the presidents in the queues by number using selection sort
     * @return void
     * @param none
     */
    public void selectionSort(){
        sortDem();
        sortRep();
        sortWhig();
    }//end selectionSort()
    
    
    /**
     * Sorts the Democratic Queue
     * @return void
     * @param none
     */
    private void sortDem(){
        int in, out, min;
        int democrat = 1;
        
        for (out = 0; out<demElem-1; out++){
            min = out;
            for (in = out+1; in<demElem; in++){
                if(demQueue.get(in).getNumber() < demQueue.get(min).getNumber()){
                    min = in;
                }//end if
            }//end for
            swapDem(out, min);
        }//end for       
    }//end sortDem()
    
    /**
     * Sorts the Republican Queue
     * @return void
     * @param none
     */
    private void sortRep(){
        int in, out, min;
        int republican = 2;
        
        for (out = 0; out<repElem-1; out++){
            min = out;
            for (in = out+1; in<repElem; in++){
                if(repQueue.get(in).getNumber() < repQueue.get(min).getNumber()){
                    min = in;
                }//end if
            }//end for
            swapRep(out, min);
        }//end for
    }//end sortRep()
    
    /**
     * Sorts the Whig Queue
     * @return void
     * @param none
     */
    private void sortWhig(){
        int in, out, min;
        int whig = 3;
        
        for (out = 0; out<whigElem-1; out++){
            min = out;
            for (in = out+1; in<whigElem; in++){
                if(whigQueue.get(in).getNumber() < whigQueue.get(min).getNumber()){
                    min = in;
                }//end if
            }//end for
            swapWhig(out, min);        
        }//end for        
    }//end sortWhig()
    
    /**
     * Swaps the values between the two specified locations in Democratic Queue
     * @return void
     * @param one The position of the first value to swap
     * @param two The position of the second value to swap
     */
    private void swapDem(int one, int two){
        Presidents demTemp = demQueue.get(one);
        
        demQueue.set(one, demQueue.get(two));
        demQueue.set(two, demTemp);   
    }//end swapDem()    

    /**
     * Swaps the values between the two specified locations in Republican Queue
     * @return void
     * @param one The position of the first value to swap
     * @param two The position of the second value to swap
     */
    private void swapRep(int one, int two){ 
        Presidents repTemp = repQueue.get(one);      
        
        repQueue.set(one, repQueue.get(two));
        repQueue.set(two, repTemp);                
    }//end swapRep()
    
    /**
     * Swaps the values between the two specified locations in Whig Queue
     * @return void
     * @param one The position of the first value to swap
     * @param two The position of the second value to swap
     */
    private void swapWhig(int one, int two){
        Presidents whigTemp = repQueue.get(one);
        
        repQueue.set(one, repQueue.get(two));
        repQueue.set(two, whigTemp);  
    }//end swapWhig()    
    
    
    /**
     * Inserts a president into the update stack
     * @return void
     * @param president The president object to be inserted 
     */
    public void getUpdate(Presidents president){

        prezStack.push(president); 
    }//end getUpdate

    
    /**
     * Updates the priority queues from the update stack
     * @return void
     * @param none
     */
    public void update(){
        
        for (int j = 0; j<prezStack.size(); j++){ //loop thru update stack
            Presidents popPrez = prezStack.pop();
            
            switch(popPrez.getParty()){
                case "Democrat": 
                    updateDem(popPrez);
                    break;

                case "Republican":
                    updateRep(popPrez);
                    break;                    
                case "Whig":
                    updateWhig(popPrez);
                    break;          
            }//end switch   
        }//end for
        
    }//end update()
    
    
    /**
     * Inserts updates into Democratic priority queue
     * @return void
     * @param popPrez The president object to be inserted 
     */
    private void updateDem(Presidents popPrez){
        int i =0;
        
        if (isEmptyDem()){
            demQueue.add(popPrez);
        }else{
            for (i= demElem-1; i>=0; i--){
                if(popPrez.getNumber() <= demQueue.get(i).getNumber()){
                    demQueue.add(i+1,demQueue.get(i));
                    demQueue.remove(i);
                }
                else{
                    break;
                }//end if                        
            }//end for
            demQueue.add(i+1, popPrez);
            ++demRear;
            demElem++;    
        }//end if
    }//end updateDem()
    
    
    /**
     * Inserts updates into Republican priority queue
     * @return void
     * @param popPrez The president object to be inserted 
     */
    private void updateRep(Presidents popPrez){
        int k=-1;

        if (isEmptyRep()){
            repQueue.add(popPrez);
        }else{
            for (k= repElem-1; k>=0; k--){
                if(popPrez.getNumber() <= repQueue.get(k).getNumber()){
                    repQueue.add(k+1,repQueue.get(k));
                    repQueue.remove(k);         
                }
                else{
                    break;
                }//end if                        
            }//end for
            repQueue.add(k+1, popPrez);
            ++repRear;
            repElem++;
        }//end if        
    }//end updateRep()
    
    
    /**
     * Inserts updates in Whig priority queue
     * @return void
     * @param popPrez The president object to be inserted
     */
    private void updateWhig(Presidents popPrez){
        int l;

        if (isEmptyWhig()){
            whigQueue.add(popPrez);
        }else{
            for (l= whigElem-1; l>=0; l--){
                if(popPrez.getNumber() <= whigQueue.get(l).getNumber()){
                    whigQueue.add(l+1,whigQueue.get(l));
                    whigQueue.remove(l); 
                }
                else{
                    break;
                }//end if
            }//end for
            whigQueue.add(l+1, popPrez);
            ++whigRear;
            whigElem++;
        }//end if
    }//end updateWhig()
    
    /**
     * Displays the update stack
     * @return void
     * @param none
     */
    public void displayStack(){
        prezStack.display();
    }//end displayStack
}//end Queue 