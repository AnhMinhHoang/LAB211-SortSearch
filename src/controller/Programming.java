package controller;

import view.Menu;
import model.Element;
import common.*;

public class Programming extends Menu<String> {

    static String[] mc = {"sort", "Search", "Exit"};

    protected Algorithm algorithm;
    protected Library library;
    protected int[] array;
    protected int size_array;

    public Programming(Element element) {
        super("Program", mc);
        library = new Library();
        algorithm = new Algorithm();
        size_array = element.getSize_array();
        array = element.getArray();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1: {
                sort();
                break;
            }
            case 2: {
                search();
                library.display(array);
                break;
            }
            case 3: {
                System.exit(0);
                break;
            }
        }
    }

    public void sort() {
        String[] s = {"Bubble sort", "Quick sort", "Exit"};
        Menu menu = new Menu("SortProgram", s) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1: {
                        algorithm.bubbleSort(array);
                        library.display(array);
                        break;
                    }
                    case 2: {
                        algorithm.quickSort(array, 0, size_array - 1);
                        library.display(array);
                        break;
                    }
                    case 3: {
                        System.exit(0);
                        break;
                    }
                }
            }
        };
        menu.run();
    }

    public void search() {
        String[] s = {"Linear Search", "Binary search", "Exit"};
        Menu menu = new Menu("SearchProgram", s) {
            @Override
            public void execute(int choice) {
                library.display(array);
                int value = library.getInt("Enter the number(1-100)", 1, 100);
                switch (choice) {
                    case 1: {
                        System.out.println("Linear search");
                        int i = algorithm.linearSearch(array, value);
                        if (i == -1) {
                            System.out.println("Not found");
                        } else {
                            System.out.println(array[i] + " at location " + (i+1));
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Binary search");
                        int i = algorithm.binarySearch(array, size_array, value);
                        if (i == -1) {
                            System.out.println("Not found");
                        } else {
                            System.out.println(array[i] + " at location " + (i+1));
                        }
                        break;
                    }
                    case 3: {
                        System.exit(0);
                        break;
                    }
                }
            }
        };
        menu.run();
    }

}
