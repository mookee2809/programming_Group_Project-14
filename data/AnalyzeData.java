/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author AN515-55
 */
public class AnalyzeData {

    //iso_code,continent,location,date,new_cases,new_deaths,people_vaccinated,population
    TimeGroup[] groups = new TimeGroup[100];

    public AnalyzeData(String ios_code, String continent, String location, String date, String new_cases, String new_deaths, String people_vaccinated, String population) {
        this.ios_code = ios_code;
        this.continent = continent;
        this.location = location;
        this.date = date;
        this.new_cases = new_cases;
        this.new_deaths = new_deaths;
        this.people_vaccinated = people_vaccinated;
        this.population = population;
    }
    public String ios_code;
    public String continent;
    public String location;
    public String date;
    public String new_cases;
    public String new_deaths;
    public String people_vaccinated;
    public String population;
    int length = 0;

    public int[] CountNewCase = new int[1000];
    public int[] CountNewDeath = new int[1000];
    public int[] CountVaccinated = new int[1000];
    public String[] BeginDateinGroup = new String[1000];
    public String[] EndDateinGroup = new String[1000];

    public AnalyzeData() {
    }

    public void inputData(String[] Data) {
        if (Data[0] == "") {
            this.ios_code = "None";
        } else {
            this.ios_code = Data[0];
        }

        if (Data[1] == "") {
            this.continent = "None";
        } else {
            this.continent = Data[1];
        }

        if (Data[2] == "") {
            this.location = "None";
        } else {
            this.location = Data[2];
        }
        if (Data[3] == "") {
            this.date = "None";
        } else {
            this.date = Data[3];
        }
        if (Data[4] == "") {
            this.new_cases = "None";
        } else {
            this.new_cases = Data[4];
        }
        if (Data[5] == "") {
            this.new_deaths = "None";
        } else {
            this.new_deaths = Data[5];
        }
        if (Data[6] == "") {
            this.people_vaccinated = "None";
        } else {
            this.people_vaccinated = Data[6];
        }
        if (Data[7] == "") {
            this.population = "None";
        } else {
            this.population = Data[7];
        }
    }

    public void displayInfor() {
        System.out.print(this.ios_code + " ");
        System.out.print(this.continent + " ");
        System.out.print(this.location + " ");
        System.out.print(this.date + " ");
        System.out.print(this.new_cases + " ");
        System.out.print(this.new_deaths + " ");
        System.out.print(this.people_vaccinated + " ");
        System.out.print(this.population + " " + "\n");
    }

    public void displayAfterChecking_NewCase() {

        for (int i = 0; i < length; i++) {
            System.out.print(BeginDateinGroup[i] + "-" + EndDateinGroup[i] + ": ");
            System.out.println("New Cases[" + (i + 1) + "]: " + CountNewCase[i]);
            System.out.println("__________________________________________");

        }
    }

    public void displayAfterChecking_NewDeath() {
        for (int i = 0; i < length; i++) {
            System.out.print(BeginDateinGroup[i] + "-" + EndDateinGroup[i] + ": ");
            System.out.println("New Deaths[" + (i + 1) + "]: " + CountNewDeath[i]);
            System.out.println("__________________________________________");
        }
    }

    public void displayAfterChecking_Vaccinated() {
        for (int i = 0; i < length; i++) {
            System.out.print(BeginDateinGroup[i] + "-" + EndDateinGroup[i] + ": ");
            System.out.println("People Vaccinated[" + (i + 1) + "]: " + CountVaccinated[i]);
            System.out.println("__________________________________________");
        }
    }

    public void displayChart() {
        System.out.println("Here is the chart that you request!");
    }

    public int[] string2intDate(String[] DateTime) {
        int[] IntDateTime = new int[10];

        IntDateTime[0] = Integer.parseInt(DateTime[0]);
        IntDateTime[1] = Integer.parseInt(DateTime[1]);
        IntDateTime[2] = Integer.parseInt(DateTime[2]);
        return IntDateTime;
    }

    public boolean checkDateTime(String[] BeDate, String[] EnDate, String[] Date) {
        boolean check = true;
        int[] BeginDate = string2intDate(BeDate);
        int[] EndDate = string2intDate(EnDate);
        int[] CheckDate = string2intDate(Date);
        if (CheckDate[2] >= BeginDate[2] && CheckDate[2] <= EndDate[2]) {
            if (CheckDate[2] == BeginDate[2]) {
                if (CheckDate[0] >= BeginDate[0]) {
                    if (CheckDate[0] == BeginDate[0]) {
                        if (CheckDate[1] < BeginDate[1]) {
                            check = false;
                        }
                    }
                } else {
                    check = false;
                }
            }

            if (CheckDate[2] == EndDate[2]) {
                if (CheckDate[0] <= EndDate[0]) {
                    if (CheckDate[0] == EndDate[0]) {
                        if (CheckDate[1] > EndDate[1]) {
                            check = false;
                        }
                    }
                } else {
                    check = false;
                }
            }

        } else {
            check = false;
        }
        return check;
    }

    void CountNewCase(String newcase, int group) {
        if (newcase != "") {
            CountNewCase[group] += Integer.parseInt(newcase);
        }
    }

    void CountNewDeath(String newdeath, int group) {
        if (newdeath != "") {
            CountNewDeath[group] += Integer.parseInt(newdeath);
        }
    }

    void CountNewVaccinated(String newvac, int group) {
        if (newvac != "") {
            CountVaccinated[group] += Integer.parseInt(newvac);
        }
    }

    void InputBeginDateOfGroup(String BeginDate, int index) {
        BeginDateinGroup[index] = BeginDate;
    }

    void InputEndDateOfGroup(String EndDate, int index) {
        EndDateinGroup[index] = EndDate;
    }
}
