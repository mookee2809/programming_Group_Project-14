package data;
import data.*;
import java.util.*;

public class Display {

    // tabular display method
    public static void displayTable(TimeGroup[] groups, int[] groupsValue, int calculationType, String regionName, String metric, String period) {
        
        System.out.println("=".repeat(100));
        System.out.printf("%20s", "NUMBER OF " + metric + period + " IN " + regionName);
        System.out.println();
        System.out.println();
        System.out.println("_".repeat(55));
        System.out.printf("%10s %38s", "Range", "Value");
        System.out.println();
        System.out.println("_".repeat(55));

        // row
        for (int row = 0; row < groups.length; row++) {
            if (groups[row].getGroupType() == 1) {
                // first column
                groups[row].DisplayDates();
                // second column
                // to show total or metric
                if (calculationType == 1) {
                    System.out.printf("%40s", "New total: " + groupsValue[row]);
                    System.out.println();
                }
                if (calculationType == 2) {
                    System.out.printf("%40s", "Up to: " + groupsValue[row]);
                    System.out.println();
                }
            }
            if (groups[row].getGroupType() == 2 || groups[row].getGroupType() == 3) {
                // first column
                groups[row].DisplayDates();
                // to show total or metric
                // second column
                if (calculationType == 1) {
                    System.out.printf("%20s", "New total: " + groupsValue[row]);
                    System.out.println();
                }
                if (calculationType == 2) {
                    System.out.printf("%20s", "Up to: " + groupsValue[row]);
                    System.out.println();
                }
            }
        }
        System.out.println("_".repeat(55) + "\n");
    }
}
