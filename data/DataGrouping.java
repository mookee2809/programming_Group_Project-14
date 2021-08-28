package data;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import util.MyToys;

public class DataGrouping {

    private static ArrayList<Data> DataList = new ArrayList();
    private static Scanner x = new Scanner(System.in);

    public void dateSearch(String searchTerm, String filepath) {

        boolean found = false;
        String iso_code = "";
        String continent = "";
        String location = "";
        String date = "";
        String new_cases = "";
        String new_deaths = "";
        String people_vaccinated = "";
        String population = "";
        
        //String code = MyToys.getString("Input date: ", "The date is required!");
        //x = searchDataObjectByDate(code);
        try {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext() && !found) {
                iso_code = x.next();
                continent = x.next();
                location = x.next();
                date = x.next();
                new_cases = x.next();
                new_deaths = x.next();
                people_vaccinated = x.next();
                population = x.next();

                if (date.equals(searchTerm)) {
                    found = true;
                }
            }

            if (found) {
                
                JOptionPane.showMessageDialog(null, "Code: " + iso_code + " Continent: " + continent + " Location: " + location + " Date: " + date
                 + " New case: " + new_cases + " New death: " + new_deaths + " People vaccinated: " + people_vaccinated + " Population: " + population);
            } else {
                JOptionPane.showMessageDialog(null, "Record not found");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }
    
    public Data searchDataObjectByDate (String date){
        if (DataList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < DataList.size(); i++) {
            if (DataList.get(i).getDate().equalsIgnoreCase(date)) {
                return DataList.get(i);
            }
        }
        return null;
    }
}
