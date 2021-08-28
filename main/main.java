
package main;

import data.DataGrouping;


public class main {

    public static void main(String[] args) {
        String filepath = "C:\\Users\\AN515-55.LAPTOP-VMBQ4GNS\\Desktop\\FPT_SE\\PRO192\\Suk\\Csv\\src\\csv\\covid-data.csv";
        String searchTearm = "3/9/2020";
        DataGrouping data = new DataGrouping();
        data.dateSearch(searchTearm, filepath);
        
    }
}
