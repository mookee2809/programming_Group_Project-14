package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import util.MyToys;

class Summary
{
    public String LocationRequest;
    public String BeginDate;
    public String EndDate;
    public int NumofGroup;
    public int pick;


    Summary(){}
    public void StartEndDate()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println ( "Please enter some information following below" );
        System.out.print ( "Please enter country/continent: " );
        this.LocationRequest = sc.nextLine();
        System.out.print ( "Please enter beginning date: " );
        this.BeginDate = MyToys.getDate("Input First Date(Date/Month/Year)): ", "Your input must be under "
                + "the format of (Date/Month/Year), Date/Month/Year stands for digits",
                "^(([0]?[1-9]|1[012])/([0]?[1-9]|[12][0-9]|3[01])/(2020|2021))");
        System.out.print ( "Please enter ending date: " );
        this.EndDate = MyToys.getDate("Input Last Date(Date/Month/Year)): ", "Your input must be under "
                + "the format of (Date/Month/Year), Date/Month/Year stands for digits",
                "^(([0]?[1-9]|1[012])/([0]?[1-9]|[12][0-9]|3[01])/(2020|2021))");
        System.out.print ( "Please enter the number of days for datagrouping: " );
        this.NumofGroup = sc.nextInt();
    }
    public void inputPick()
    {
        Scanner sc = new Scanner(System.in);
        this.pick = sc.nextInt();
    }

}



class AnalyzeData
{
    //iso_code,continent,location,date,new_cases,new_deaths,people_vaccinated,population
    public String ios_code;
    public String continent;
    public String location;
    public String date;
    public String new_cases;
    public String new_deaths;
    public String people_vaccinated;
    public String population;
    int length=0;
    public int[] CountNewCase = new int[1000];
    public int[] CountNewDeath = new int[1000];
    public int[] CountVaccinated = new int[1000];
    public String[] BeginDateinGroup = new String[1000];
    public String[] EndDateinGroup = new String[1000];
    AnalyzeData(){}
    public void inputData(String[] Data)
    {
        if(Data[0]=="")
            this.ios_code = "None";
        else
            this.ios_code = Data[0];

        if(Data[1]=="")
            this.continent = "None";
        else
            this.continent = Data[1];

        if(Data[2]=="")
            this.location = "None";
        else
            this.location = Data[2];
        if(Data[3]=="")
            this.date = "None";
        else
            this.date = Data[3];
        if(Data[4]=="")
            this.new_cases = "None";
        else
            this.new_cases = Data[4];
        if(Data[5]=="")
            this.new_deaths = "None";
        else
            this.new_deaths = Data[5];
        if(Data[6]=="")
            this.people_vaccinated = "None";
        else
            this.people_vaccinated = Data[6];
        if(Data[7]=="")
            this.population = "None";
        else
            this.population = Data[7];
    }
    public void displayInfor()
    {
        System.out.print(this.ios_code + " ") ;
        System.out.print(this.continent+ " ");
        System.out.print(this.location + " ");
        System.out.print(this.date + " ");
        System.out.print(this.new_cases + " ");
        System.out.print(this.new_deaths + " ");
        System.out.print(this.people_vaccinated + " ");
        System.out.print(this.population + " " + "\n");
    }
    public void displayAfterChecking_NewCase()
    {
        for(int i=0; i<length; i++)
        {
            System.out.print(BeginDateinGroup[i]+"-"+EndDateinGroup[i]+": ");
            System.out.println("New Cases["+(i+1)+"]: "+CountNewCase[i]);
            System.out.println("__________________________________________");
        }
    }
    public void displayAfterChecking_NewDeath()
    {
        for(int i=0; i<length; i++)
        {
            System.out.print(BeginDateinGroup[i]+"-"+EndDateinGroup[i]+": ");
            System.out.println("New Deaths["+(i+1)+"]: "+CountNewDeath[i]);
            System.out.println("__________________________________________");
        }
    }
    public void displayAfterChecking_Vaccinated()
    {
        for(int i=0; i<length; i++)
        {
            System.out.print(BeginDateinGroup[i]+"-"+EndDateinGroup[i]+": ");
            System.out.println("People Vaccinated["+(i+1)+"]: "+CountVaccinated[i]);
            System.out.println("__________________________________________");
        }
    }
    public void displayChart()
    {
        System.out.println("Here is the chart that you request!");
    }
    public int[] string2intDate(String[] DateTime)
    {
        int[] IntDateTime = new int[10];

        IntDateTime[0] = Integer.parseInt(DateTime[0]);
        IntDateTime[1] = Integer.parseInt(DateTime[1]);
        IntDateTime[2] = Integer.parseInt(DateTime[2]);
        return IntDateTime;
    }
    public boolean checkDateTime(String[] BeDate, String[] EnDate, String[] Date)
    {
        boolean check = true;
        int[] BeginDate = string2intDate(BeDate);
        int[] EndDate = string2intDate(EnDate);
        int[] CheckDate = string2intDate(Date);
        if(CheckDate[2] >= BeginDate[2] && CheckDate[2] <= EndDate[2])
        {
            if(CheckDate[2] == BeginDate[2])
            {
                if(CheckDate[0] >= BeginDate[0])
                {
                    if(CheckDate[0] == BeginDate[0])
                    {
                        if(CheckDate[1] < BeginDate[1])
                            check = false;
                    }
                }
                else
                    check = false;
            }

            if(CheckDate[2] == EndDate[2])
            {
                if(CheckDate[0] <= EndDate[0])
                {
                    if(CheckDate[0] == EndDate[0])
                    {
                        if(CheckDate[1] > EndDate[1])
                            check = false;
                    }
                }
                else
                    check = false;
            }

        }
        else
            check = false;
        return check;
    }
    void CountNewCase(String newcase, int group)
    {
        if(newcase != "")
            CountNewCase[group] +=Integer.parseInt(newcase);
    }
    void CountNewDeath(String newdeath, int group)
    {
        if(newdeath != "")
            CountNewDeath[group] +=Integer.parseInt(newdeath);
    }
    void CountNewVaccinated(String newvac, int group)
    {
        if(newvac != "")
            CountVaccinated[group] +=Integer.parseInt(newvac);
    }
    void InputBeginDateOfGroup(String BeginDate, int index)
    {
        BeginDateinGroup[index] = BeginDate;
    }
    void InputEndDateOfGroup(String EndDate, int index)
    {
        EndDateinGroup[index] = EndDate;
    }
}



class FromFile
{
    //boolean whetherExist = false;

    FromFile(){}
    public void ReadingAndCheckFile(Summary request, AnalyzeData DataTest)
    {
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
                if(splits[1].compareTo(request.LocationRequest)==0 || splits[2].compareTo(request.LocationRequest)==0 )
                {
                    //whetherExist = true;

                    if(DataTest.checkDateTime(BeDate,EnDate,Date))
                    {
                        if(count==0)
                        {
                            DataTest.InputBeginDateOfGroup(splits[3], group);
                        }
                        DataTest.inputData(splits);
                        //DataTest.displayInfor();
                        DataTest.CountNewCase(splits[4],group);
                        DataTest.CountNewDeath(splits[5],group);
                        DataTest.CountNewVaccinated(splits[6],group);
                        count++;
                        temp3 = splits[3];
                        temp4 = splits[4];
                        temp5 = splits[5];
                        temp6 = splits[6];
                        if(count==request.NumofGroup)
                        {
                            DataTest.InputEndDateOfGroup(splits[3], group);
                            count =0;
                            group++;
                        }
                    }
                }

            }
            myReader.close();
            if(count>1)
            {
                DataTest.InputEndDateOfGroup(temp3, group);
                group++;
                DataTest.length = group;
            }
            else
            {
                DataTest.length = group;
                group = group - 1;
                DataTest.CountNewCase(temp4,group);
                DataTest.CountNewDeath(temp5,group);
                DataTest.CountNewVaccinated(temp6,group);
                DataTest.InputEndDateOfGroup(temp3,group);
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

class Menu
{
    int infor;
    int chart;
    int question;
    Menu(){}
    public void metric_menu()
    {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Please enter number (1,2,3) depending on which information you want to display! ");
        System.out.println("1) Show New Cases \n2) Show New Deaths \n3) Show Vaccinated People");
        System.out.println("---------------------------------------------------------------------------------");
    }
    public void display_menu()
    {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Please enter number (1,2) depending on how you want information to be displayed! ");
        System.out.println("1) Tabular display \n2) Chart display");
        System.out.println("---------------------------------------------------------------------------------");
    }
    public void question_menu()
    {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Would you like to proceed or quit? \nEnter 9 to proceed. \nEnter 0 to quit.");
        System.out.println("---------------------------------------------------------------------------------");
    }
    public void enterInfo()
    {
        Scanner sc = new Scanner(System.in);
        metric_menu();
        boolean test = false;
        while (test==false)
        {
            System.out.print("Your selection here: ");
            infor = sc.nextInt();
            if(infor == 1 || infor == 2 || infor == 3)
            {
                test = true;
            }
            else
            {
                System.out.println ( "Unrecognized option" );
            }
        }
    }
    public void enterChart()
    {
        Scanner sc = new Scanner(System.in);
        display_menu();
        boolean test = false;
        while (test==false)
        {
            System.out.print("Your selection here: ");
            chart = sc.nextInt();
            if(chart == 1 || chart == 2)
            {
                test = true;
            }
            else
            {
                System.out.println ( "Unrecognized option" );
            }
        }
    }
    public void enterQuestion()
    {
        Scanner sc = new Scanner(System.in);
        question_menu();
        boolean test = false;
        while (test==false)
        {
            System.out.print("Your selection here: ");
            question = sc.nextInt();
            if(question == 0 || question == 9)
            {
                test = true;
            }
            else
            {
                System.out.println ( "Unrecognized option" );
            }
        }
    }
    public void MyMenu()
    {
        boolean test = true;
        while(test ==true)
        {
            //input information
            Summary request = new Summary();
            //request.StartEndDate();
            enterInfo();
            enterChart();

            //Creating Object AnalyzeDate
            AnalyzeData DataTest = new AnalyzeData();
            //reading file
            FromFile file = new FromFile();
            file.ReadingAndCheckFile(request,DataTest);

            //display
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("Here is our response to your request!");

            if(chart==1)
            {
                switch (infor)
                {
                    case 1:
                        System.out.println("__________________________________________");
                        DataTest.displayAfterChecking_NewCase();
                        break;
                    case 2:
                        System.out.println("__________________________________________");
                        DataTest.displayAfterChecking_NewDeath();
                        break;
                    case 3:
                        System.out.println("__________________________________________");
                        DataTest.displayAfterChecking_Vaccinated();
                        break;
                    default:
                        System.out.println("Problem of enter information variable!");
                        break;
                }
            }
            else
            {
                System.out.println("__________________________________________");
                DataTest.displayChart();
            }

            //continue
            enterQuestion();
            if(question==0)
            {
                System.out.println ("\nThank you and goodbye.");
                test = false;
            }
            System.out.println("---------------------------------------------------------------------------------");
        }
    }
}

public class DataTesting {
    public static void main(String arg[])
    {
        Menu menu = new Menu();
        menu.MyMenu();
    }
}