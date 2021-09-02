import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

class Request
{
    public String LocationRequest;
    public String BeginDate;
    public String EndDate;
    public int NumofGroup;
    public int upto;
    public int after;
    public int weekOrDay;

    Request(){}
    public void inputNameRequest()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println ( "Please enter some information following below" );
        System.out.print ( "Please enter country/continent: " );
        this.LocationRequest = sc.nextLine();
        System.out.println("---------------------------------------------------------------------------------");

    }
    public void inputTimeRequest(int timerange)
    {
        Scanner sc = new Scanner(System.in);
        switch (timerange)
        {
            case 1:
                System.out.print ( "Please enter beginning date: " );
                this.BeginDate = sc.nextLine();
                System.out.print ( "Please enter ending date: " );
                this.EndDate = sc.nextLine();
                System.out.print ( "Please enter quantity of each group: " );
                this.NumofGroup = sc.nextInt();
                break;
            case 2:
                System.out.print ( "Please enter week or day (1 - week // 2 - day): " );
                this.weekOrDay = sc.nextInt();
                System.out.print ( "Please enter up to: " );
                this.upto = sc.nextInt();
                sc.nextLine();
                System.out.print ( "Please enter ending date: " );
                this.EndDate = sc.nextLine();
                System.out.print ( "Please enter quantity of each group: " );
                this.NumofGroup = sc.nextInt();
                upTo(EndDate,upto,weekOrDay);
                break;
            case 3:
                System.out.print ( "Please enter week or day (1 - week // 2 - day): " );
                this.weekOrDay = sc.nextInt();
                sc.nextLine();
                System.out.print ( "Please enter beginning date: " );
                this.BeginDate = sc.nextLine();
                System.out.print ( "Please enter after: " );
                this.after = sc.nextInt();
                System.out.print ( "Please enter quantity of each group: " );
                this.NumofGroup = sc.nextInt();
                afTer(BeginDate,after,weekOrDay);
                break;
            default:
                break;
        }

    }

    public void upTo(String endDate, int upto, int weekOrDay )
    {
        SimpleDateFormat obj = new SimpleDateFormat("MM/dd/yy");
        try
        {
            Date end =  obj.parse(endDate);
            long start = 0;
            if(weekOrDay==1)
            {
                start  = end.getTime() - upto*7L*24L*60L*60L*1000L;
            }
            else
            {
                start  = end.getTime() - upto*24L*60L*60L*1000L;
            }
            Date startDate = new Date(start);
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            BeginDate = dateFormat.format(startDate);
            System.out.println(BeginDate);
        }
        catch (ParseException except)
        {
            System.out.println("Error Date Time Input");
        }
    }

    public void afTer(String beginDate, int after, int weekOrDay )
    {
        SimpleDateFormat obj = new SimpleDateFormat("MM/dd/yy");
        try
        {
            Date start =  obj.parse(beginDate);
            long end = 0;
            if(weekOrDay==1)
            {
                end  = start.getTime() + after*7L*24L*60L*60L*1000L;
            }
            else
            {
                end  = start.getTime() + after*24L*60L*60L*1000L;
            }
            Date endDate = new Date(end);
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            EndDate = dateFormat.format(endDate);
            System.out.println(EndDate);
        }
        catch (ParseException except)
        {
            System.out.println("Error Date Time Input");
        }
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
    public long[] CountNewCase = new long[1000];
    public long[] CountNewDeath = new long[1000];
    public long[] CountVaccinated = new long[1000];
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
    public void displayChart(int infor)
    {
        long max = 0;
        long min = 0;
        if(infor == 1)
        {
            max = seekMax(CountNewCase);
            min = seekMin(CountNewCase);
        }
        if(infor == 2)
        {
            max = seekMax(CountNewDeath);
            min = seekMin(CountNewDeath);
        }
        if(infor == 2)
        {
            max = seekMax(CountVaccinated);
            min = seekMin(CountVaccinated);
        }
        long unit = (max-min)/10;
        long[][] myChart = new long[1000][1000];
        System.out.println("Here is the chart that you request!");
        System.out.println(max+" "+min);
        for(int i =0; i<30; ++i)
        {
            for(int j=0; j<80; ++j)
            {
                //myChart[i][j] = 0;
                //System.out.print(i+"_"+j);
                if(j==0)
                {
                    if(i==0)
                        System.out.print(max);
                    else
                    {
                        if(i==29)
                            System.out.print(min);
                        else
                        {
                            if(i%2==0)
                                System.out.print((min+unit*(10-i)));
                        }
                    }

                }
                if(j==1)
                    System.out.print("|");
                if(i==29)
                {
                    if(j!=0)
                        System.out.print("__");
                }
            }
            System.out.print("\n");
        }
    }
    public long seekMin(long[] arr)
    {
        long min = arr[0];
        for(int i=1; i<length; i++)
        {
            if(arr[i]<min)
                min = arr[i];
        }
        return min;
    }
    public long seekMax(long[] arr)
    {
        long max = arr[0];
        for(int i=1; i<length; i++)
        {
            if(arr[i]>max)
                max = arr[i];
        }
        return max;
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
    public void ReadingAndCheckFile(Request request, AnalyzeData DataTest)
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
    int timerange;
    Menu(){}
    public void time_menu()
    {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println( "Please enter you selection: " );
        System.out.println( "1) Pair: "  );
        System.out.println( "2) Up to: " );
        System.out.println( "3: After" );
        System.out.println("---------------------------------------------------------------------------------");
    }
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

    public void MyMenu()
    {
        boolean test = true;
        while(test ==true)
        {
            //input information
            Request request = new Request();
            request.inputNameRequest();
            enterTimerange();
            request.inputTimeRequest(timerange);
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
                DataTest.displayChart(infor);
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

public class Data {
    public static void main(String arg[])
    {
        Menu menu = new Menu();
        menu.MyMenu();
    }
}
