/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

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

    public void ReadingAndCheckFile(Summary request, AnalyzeData DataTest) {
        int count = 0;
        int group = 0;
        String temp3 = new String();
        String temp4 = new String();
        String temp5 = new String();
        String temp6 = new String();

        //reading file
        try {
            File myObj = new File("C:\\Users\\PC\\Downloads\\data.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splits = data.split(",");
                String[] BeDate = request.BeginDate.split("/");
                String[] EnDate = request.EndDate.split("/");
                String[] Date = splits[3].split("/");
                if (splits[1].compareTo(request.LocationRequest) == 0 || splits[2].compareTo(request.LocationRequest) == 0) {
                    //whetherExist = true;

                    if (DataTest.checkDateTime(BeDate, EnDate, Date)) {
                        if (count == 0) {
                            DataTest.InputBeginDateOfGroup(splits[3], group);
                        }
                        DataTest.inputData(splits);
                        //DataTest.displayInfor();
                        DataTest.CountNewCase(splits[4], group);
                        DataTest.CountNewDeath(splits[5], group);
                        DataTest.CountNewVaccinated(splits[6], group);
                        count++;
                        temp3 = splits[3];
                        temp4 = splits[4];
                        temp5 = splits[5];
                        temp6 = splits[6];
                        if (count == request.NumofGroup) {
                            DataTest.InputEndDateOfGroup(splits[3], group);
                            count = 0;
                            group++;
                        }
                    }
                }

            }
            myReader.close();
            if (count > 1) {
                DataTest.InputEndDateOfGroup(temp3, group);
                group++;
                DataTest.length = group;
            } else {
                DataTest.length = group;
                group = group - 1;
                DataTest.CountNewCase(temp4, group);
                DataTest.CountNewDeath(temp5, group);
                DataTest.CountNewVaccinated(temp6, group);
                DataTest.InputEndDateOfGroup(temp3, group);
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
