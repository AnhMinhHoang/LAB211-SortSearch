package view;

import java.util.Scanner;
import java.util.ArrayList;

public abstract class Menu<T> {
    protected String title;
    protected ArrayList<T> list = new ArrayList();
    
    public Menu(String title, String[] s){
        this.title = title;
        for(String item: s){
            list.add((T)item);
        }
    }
    
    public Menu(){};
    
    
    public void display(){
        System.out.println(title);
        System.out.println("-------------------------------");
        for(int i = 0; i < list.size(); i++){
            System.out.println((i+1) + "." + list.get(i));
        }
    }
    
    public int getChoice(){
        Scanner sc = new Scanner(System.in);
        display();
        System.out.println("--------------------------------");
        System.out.println("Enter your selection: ");
        return sc.nextInt();
    }
    
    public abstract void execute(int choice);
    
    public void run(){
        int choice;
        do{
            choice = getChoice();
            execute(choice);
        }
        while(choice > 0 && choice < list.size());
    }
}
