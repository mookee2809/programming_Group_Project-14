/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.AnalyzeData;
import data.Summary;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author AN515-55
 */
public class FileChecking {

    public void ReadingAndCheckFile(Summary summary, AnalyzeData AnalyzeData) {
        int count = 0;
        int group = 0;
        String temp3 = new String();
        String temp4 = new String();
        String temp5 = new String();
        String temp6 = new String();

        //reading file
        try {
            File myObj = new File("C:\\Users\\AN515-55.LAPTOP-VMBQ4GNS\\Documents\\NetBeansProjects\\Group Project\\src\\main\\covid-data.csv");
            try (Scanner myReader = new Scanner(myObj)) {
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String[] splits = data.split(",");
                    String[] BeDate = summary.BeginDate.split("/");
                    String[] EnDate = summary.EndDate.split("/");
                    String[] Date = splits[3].split("/");
                    if (splits[1].compareTo(summary.LocationRequest) == 0 || splits[2].compareTo(summary.LocationRequest) == 0) {
                        //whetherExist = true;
                        
                        if (AnalyzeData.checkDateTime(BeDate, EnDate, Date)) {
                            if (count == 0) {
                                AnalyzeData.InputBeginDateOfGroup(splits[3], group);
                            }
                            AnalyzeData.inputData(splits);
                            //DataTest.displayInfor();
                            AnalyzeData.CountNewCase(splits[4], group);
                            AnalyzeData.CountNewDeath(splits[5], group);
                            AnalyzeData.CountNewVaccinated(splits[6], group);
                            count++;
                            temp3 = splits[3];
                            temp4 = splits[4];
                            temp5 = splits[5];
                            temp6 = splits[6];
                            if (count == summary.NumofGroup) {
                                AnalyzeData.InputEndDateOfGroup(splits[3], group);
                                count = 0;
                                group++;
                            }
                        }
                    }
                    
                }
            }
            if (count > 1) {
                AnalyzeData.InputEndDateOfGroup(temp3, group);
                group++;
                AnalyzeData.length = group;
            } else {
                AnalyzeData.length = group;
                group = group - 1;
                AnalyzeData.CountNewCase(temp4, group);
                AnalyzeData.CountNewDeath(temp5, group);
                AnalyzeData.CountNewVaccinated(temp6, group);
                AnalyzeData.InputEndDateOfGroup(temp3, group);
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
