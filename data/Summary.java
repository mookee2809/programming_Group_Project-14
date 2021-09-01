package data;

import java.util.Scanner;
import util.MyToys;

public class Summary {

    public String LocationRequest;
    public String BeginDate;
    public String EndDate;
    public int NumofGroup;
    public int pick;

    public Summary() {
    }

    public void StartEndDate() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter some information following below");
        System.out.print("Please enter country/continent: ");
        this.LocationRequest = sc.nextLine();

        this.BeginDate = MyToys.getDate("Please Input Beginning Date(Month/Date/Year)): ", "Your input must be under "
                + "the format of (Month/Date/Year), Month/Date/Year stands for digits",
                "^(([0]?[1-9]|1[012])/([0]?[1-9]|[12][0-9]|3[01])/(2020|2021))");

        this.EndDate = MyToys.getDate("Please Input Ending Date(Month/Date/Year)): ", "Your input must be under "
                + "the format of (Month/Date/Year), Month/Date/Year stands for digits",
                "^(([0]?[1-9]|1[012])/([0]?[1-9]|[12][0-9]|3[01])/(2020|2021))");
        System.out.print("Please enter the number of days for datagrouping: ");
        this.NumofGroup = sc.nextInt();
        MyMenu();
    }

    public void inputPick() {
        Scanner sc = new Scanner(System.in);
        this.pick = sc.nextInt();
    }

    public int infor;
    public int chart;
    public int question;

    public void metric_menu() {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Please enter number (1,2,3) depending on which information you want to display! ");
        System.out.println("1) Show New Cases \n2) Show New Deaths \n3) Show Vaccinated People");
        System.out.println("---------------------------------------------------------------------------------");
        
    }

    public void display_menu() {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Please enter number (1,2) depending on how you want information to be displayed! ");
        System.out.println("1) Tabular display \n2) Chart display");
        System.out.println("---------------------------------------------------------------------------------");
    }

    public void question_menu() {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Would you like to proceed or quit? \nEnter 9 to proceed. \nEnter 0 to quit.");
        System.out.println("---------------------------------------------------------------------------------");
    }

    public void enterInfo() {
        Scanner sc = new Scanner(System.in);
        metric_menu();
        boolean test = false;
        while (test == false) {
            System.out.print("Your selection here: ");
            infor = sc.nextInt();
            if (infor == 1 || infor == 2 || infor == 3) {
                test = true;
            } else {
                System.out.println("Unrecognized option");
            }
        }
    }

    public void enterChart() {
        Scanner sc = new Scanner(System.in);
        display_menu();
        boolean test = false;
        while (test == false) {
            System.out.print("Your selection here: ");
            chart = sc.nextInt();
            if (chart == 1 || chart == 2) {
                test = true;
            } else {
                System.out.println("Unrecognized option");
            }
        }
    }

    public void enterQuestion() {
        Scanner sc = new Scanner(System.in);
        question_menu();
        boolean test = false;
        while (test == false) {
            System.out.print("Your selection here: ");
            question = sc.nextInt();
            if (question == 0 || question == 9) {
                test = true;
            } else {
                System.out.println("Unrecognized option");
            }
        }
    }

    public void MyMenu() {
        boolean test = true;
        while (test == true) {
            //input information
            Summary summary = new Summary();
            //request.StartEndDate();
            enterInfo();
            enterChart();

            //Creating Object AnalyzeDate
            AnalyzeData Data = new AnalyzeData();
            //reading file
            FileChecking file = new FileChecking();
            file.ReadingAndCheckFile(summary, Data);

            //display
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("Here is our response to your request!");

            if (chart == 1) {
                switch (infor) {
                    case 1:
                        System.out.println("__________________________________________");
                        Data.displayAfterChecking_NewCase();
                        break;
                    case 2:
                        System.out.println("__________________________________________");
                        Data.displayAfterChecking_NewDeath();
                        break;
                    case 3:
                        System.out.println("__________________________________________");
                        Data.displayAfterChecking_Vaccinated();
                        break;
                    default:
                        System.out.println("Problem of enter information variable!");
                        break;
                }
            } else {
                System.out.println("__________________________________________");
                Data.displayChart();
            }

            //continue
            enterQuestion();
            if (question == 0) {
                System.out.println("\nThank you and goodbye.");
                test = false;
            }
            System.out.println("---------------------------------------------------------------------------------");
        }
    }

}
