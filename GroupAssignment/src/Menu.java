import java.util.Scanner;


public class Menu {
    int infor;
    int chart;
    int question;
    int timerange;
    Menu(){}
    public void time_menu()
    {
        System.out.println( "\n___________________________________________________" );
        System.out.println( "                   Data Summary                    " );
        System.out.println( "___________________________________________________" );
        System.out.println( "1. A pair of start date and end date               " );
        System.out.println( "2. A number of days or weeks from a particular date" );
        System.out.println( "3: A number of days or weeks to a particular date  " );

    }
    public void metric_menu()
    {
        System.out.println( "\n________________________________" );
        System.out.println( "           Metric                    " );
        System.out.println( "________________________________" );
        System.out.println( "1. Calculate new cases               " );
        System.out.println( "2. Calculate new deaths              " );
        System.out.println( "3: Calculate vaccinated people       " );

    }
    public void display_menu()
    {
        System.out.println( "\n____________________" );
        System.out.println( "      Display       " );
        System.out.println( "____________________" );
        System.out.println( "1. Tabular display  " );
        System.out.println( "2. Chart display    " );

    }
    public void question_menu()
    {
        System.out.println("\n__________________________________");
        System.out.println("Would you like to proceed or quit? \nEnter 9 to proceed. \nEnter 0 to quit.");
        System.out.println("__________________________________");
    }
    public void enterInfo()
    {
        Scanner sc = new Scanner(System.in);
        metric_menu();
        boolean test = false;
        while (test==false)
        {
            System.out.print("\nYour selection here: ");
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
            System.out.print("\nYour selection here: ");
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
            System.out.print("\nYour selection here: ");
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
    public void enterTimerange()
    {
        Scanner sc = new Scanner(System.in);
        time_menu();
        boolean test = false;
        while (test==false)
        {
            System.out.print("Your selection here: ");
            timerange = sc.nextInt();
            if(timerange == 1 || timerange == 2 || timerange == 3)
            {
                test = true;
            }
            else
            {
                System.out.println ( "Unrecognized option" );
            }
        }
    }
    public void display(AnalyzeData DataTest)
    {
        System.out.println("_____________________________________");
        System.out.println("Here is our response to your request!");
        Display display = new Display();
        if(chart==1)
        {
            switch (infor)
            {
                case 1:
                    System.out.println("__________________________________________");
                    display.displayAfterChecking_NewCase(DataTest);
                    break;
                case 2:
                    System.out.println("__________________________________________");
                    display.displayAfterChecking_NewDeath(DataTest);
                    break;
                case 3:
                    System.out.println("__________________________________________");
                    display.displayAfterChecking_Vaccinated(DataTest);
                    break;
                default:
                    System.out.println("Problem of enter information variable!");
                    break;
            }
        }
        else
        {
            System.out.println("__________________________________________");
            switch (infor)
            {
                case 1:
                    System.out.println("__________________________________________");
                    display.displayChart(DataTest.CountNewCase, DataTest.length);
                    break;
                case 2:
                    System.out.println("__________________________________________");
                    display.displayChart(DataTest.CountNewDeath, DataTest.length);
                    break;
                case 3:
                    System.out.println("__________________________________________");
                    display.displayChart(DataTest.CountVaccinated, DataTest.length);
                    break;
                default:
                    System.out.println("Problem of enter information variable!");
                    break;
            }
        }
    }
    public boolean whethercontinue()
    {
        boolean temp = true;
        if(question==0)
        {
            System.out.println ("\nThank you and goodbye.");
            temp = false;
        }
        return temp;
    }
    public void MyMenu()
    {
        boolean test = true;
        while(test ==true)
        {
            //input information
            FromFile file = new FromFile();
            Request request = new Request();
            request.inputNameRequest(file);
            enterTimerange();
            request.inputTimeRequest(timerange);
            enterInfo();
            enterChart();
            //Creating Object AnalyzeData
            AnalyzeData DataTest = new AnalyzeData();
            //reading file
            file.ReadingAndCheckFile(request,DataTest);
            //display
            display(DataTest);
            //continue
            enterQuestion();
            test = whethercontinue();
        }
    }
}
