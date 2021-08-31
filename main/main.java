
package main;

import data.DataGrouping;


public class main {

    public static void main(String[] args) {
        String filepath = "covid-data.csv";
        String searchTearm = "3/9/2020";
        DataGrouping data = new DataGrouping();
        data.dateSearch(searchTearm, filepath);
        
    }
}
