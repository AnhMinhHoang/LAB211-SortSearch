package controller;

import view.Menu;
import model.Element;
import common.*;

public class SortProgramming extends Menu<String>{
    
    static String[] mc = {"Bubble sort", "Quick sort", "Exit"};
    
    protected Algorithm algorithm;
    protected Library library; 
    protected int[] array;
    protected int size_array;
    
    public SortProgramming(Element element){
        super("Sort", mc);
        library = new Library();
        algorithm = new Algorithm();
        size_array = element.getSize_array();
        array = element.getArray();
    }
    
    @Override
    public void execute(int choice) {
       switch(choice){
           case 1: {
               algorithm.bubbleSort(array);
               library.display(array);
               break;
           }
           case 2:{
               algorithm.quickSort(array, 0, size_array - 1);
               library.display(array);
               break;
           }
           case 3:{
               System.exit(0);
               break;
           }
               
       }
    }

}
