/*
Author: Kevin Bell
Course: COP3538
Project#: 2
Title: Priority Queues
Due Date: 10/4/2106

Builds and updates a priority queue of president objects with a stack

 */
package ds_p2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Reads input data from text files
 */
public class File {
        private FileReader fr;
        private BufferedReader br;
        
        //input vars
        private int number;
        private String name;
        private String party;
        private String code;
        private int years;
        private String state;
        private String input;
        
        //input arraylist
        private ArrayList<Presidents> fileData;
        
    /**
     * Constructor for File class
     * @return constructor
     * @param file The file to be read
     * @throws FileNotFoundException 
     */    
    public File(String file) throws FileNotFoundException{
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        
        fileData = new ArrayList<>();  
    }//end constructor
        

    /**
     * Parses data from input file
     * @return void
     * @param none
     * @throws IOException 
     */
    public void parse() throws IOException{

        while((input = br.readLine()) != null){
            number = Integer.parseInt(input.substring(0,2).trim());
            name = input.substring(2,25).trim();
            code = input.substring(25,27).trim();
            years = Integer.parseInt(input.substring(27,29).trim());
            party = input.substring(29,49).trim();
            state = input.substring(49, input.length());
            
            fileData.add(new Presidents(number, name, code, years, party, state));
        }//end while
    }//end parse()
    
    
    /**
     * Parses data from update file
     * @return void
     * @param none
     * @throws FileNotFoundException
     */
    public void parseUpdate() throws IOException{

        while((input = br.readLine()) !=null){
            number = Integer.parseInt(input.substring(0,3).trim());
            name = input.substring(3,23).trim();
            code = null;
            years = -1;
            party = input.substring(23, input.length()).trim();
            state = null;
            
            fileData.add(new Presidents (number, name, code, years, party, state)); //add input into presisident object and update the priority queue
        }//end while
    }//end updateReader()

    
    /**
     * Returns fileData to main
     * @return The fileData array list
     * @param none
     */   
    public ArrayList<Presidents> getFileData(){
          return fileData;
      }//end getFileData
    
    
    /**
     * Displays input Array
     * @return void
     * @param none
     */
    public void displayFileData(){
        for(int i = 0; i<fileData.size(); i++){
            System.out.println(fileData.get(i));
        }//end for
    }//end display
}//end File class

