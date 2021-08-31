
package main;

import data.DataGrouping;
import data.Summary;

import util.Menu;

public class Main {

    public static void main(String[] args) {

        int choice;
        Menu menu = new Menu("Covid Data analsys");
        menu.addNewOption("1. A pair of start date and end date");
        menu.addNewOption("2. A number of days or weeks from a specific date");
        menu.addNewOption("3. A number of days or weeks to a specific date");
        
        
        Summary summary = new Summary();
        
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    summary.StartEndDate();
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        } while (choice != 3);
    }
}

