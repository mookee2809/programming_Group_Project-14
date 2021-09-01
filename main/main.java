
package main;

import data.DataGrouping;
import data.Summary;

import util.Menu;

public class Main {

    public static void main(String[] args) {

        
        Menu menu = new Menu("Covid Data Analysis");
        menu.addNewOption("Please choose 1 of the following option!\n1. A pair of start date and end date");
        menu.addNewOption("2. A number of days or weeks from a specific date");
        menu.addNewOption("3. A number of days or weeks to a specific date");

        Summary sum = new Summary();

        int choice;
        do {

            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    sum.StartEndDate();
                    break;
                case 2:
                    
                    break;
                case 3:
                    System.out.println("Good bye");
                    break;
            }
        } while (choice != 3);
    }
}


