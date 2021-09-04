import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Summary {
}
class Request //this class is used for asking user inputs
{
    public String LocationRequest;
    public String BeginDate = null;
    public String EndDate = null;
    public int NumofGroup;
    public int upto;
    public int after;
    public int weekOrDay;

    Request(){}
    //ask for location
    public void inputNameRequest(FromFile file)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println ("Hello");

        while(file.whetherExist == false)
        {
            System.out.print ("Please enter country/continent: " );
            this.LocationRequest = sc.nextLine();
            file.checkName(LocationRequest);
            if(file.whetherExist == false)
            {
                System.out.println("We don't have data for this location.");
            }
        }
    }
    //ask for calculating metric
    public void inputTimeRequest(int timerange)
    {
        Scanner sc = new Scanner(System.in);
        switch (timerange)
        {
            //a pair of date
            case 1:
                while ( BeginDate == null || checkDateTimeFormat(BeginDate)==false)
                {
                    System.out.print ("Please enter start date: " );
                    this.BeginDate = sc.nextLine();
                }
                while ( EndDate == null ||checkDateTimeFormat(EndDate)==false || checkEndDate(BeginDate,EndDate)==false)
                {
                    System.out.print ("Please enter end date:   " );
                    this.EndDate = sc.nextLine();
                }
                System.out.print ("Please enter the number of day for grouping: " );
                this.NumofGroup = sc.nextInt();
                break;
            //days up to specific date
            case 2:
                System.out.print ( "Please enter week or day:" +
                        "\n- Enter '1' for week" +
                        "\n- Enter '2' for day\n " );
                this.weekOrDay = sc.nextInt();
                System.out.print ( "Please number of day or week to a particular day " );
                this.upto = sc.nextInt();
                sc.nextLine();
                while (EndDate == null ||checkDateTimeFormat(EndDate)==false)
                {
                    System.out.print ("Please enter end date:   " );
                    this.EndDate = sc.nextLine();
                }
                upTo(EndDate,upto,weekOrDay);
                System.out.print ("Please enter the number of day for grouping: " );
                this.NumofGroup = sc.nextInt();
                break;
            //date after specific date
            case 3:
                System.out.print ( "Please enter week or day:\n - Enter '1' for week\n - Enter '2' for day\n " );
                this.weekOrDay = sc.nextInt();
                sc.nextLine();
                while (BeginDate == null || checkDateTimeFormat(BeginDate)==false)
                {
                    System.out.print ("Please enter start date: " );
                    this.BeginDate = sc.nextLine();
                }
                System.out.print ( "Please number of day or week after a particular day " );
                this.after = sc.nextInt();
                afTer(BeginDate,after,weekOrDay);
                System.out.print ( "Please enter the number of day for grouping: " );
                this.NumofGroup = sc.nextInt();
                break;
            default:
                break;
        }

    }

    //metric for days up to specific date
    public void upTo(String endDate, int upto, int weekOrDay )
    {
        SimpleDateFormat obj = new SimpleDateFormat("MM/dd/yy");
        try
        {
            Date end =  obj.parse(endDate);
            long start = 0;
            //finding startdate decrease by the amount of day/week given
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
            BeginDate = dateFormat.format(startDate);//reformat after calculating
            System.out.println(BeginDate);
        }
        catch (ParseException except)
        {
            System.out.println("Error Date Time Input");
        }
    }
    //metric for days after specific date
    public void afTer(String beginDate, int after, int weekOrDay )
    {
        SimpleDateFormat obj = new SimpleDateFormat("MM/dd/yy");
        try
        {
            Date start =  obj.parse(beginDate);
            long end = 0;
            //finding enddate increase by the amount of day/week given
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
            EndDate = dateFormat.format(endDate);//reformat after calculating
            System.out.println(EndDate);
        }
        catch (ParseException except)
        {
            System.out.println("Error Date Time Input");
        }
    }

    //check date format of the input
    public boolean checkDateTimeFormat(String Date)
    {
        boolean test = false;
        SimpleDateFormat obj = new SimpleDateFormat("MM/dd/yy");
        try
        {
            Date end =  obj.parse(Date);//input matches the date format initialized above
            test = true;
        }
        catch (ParseException except)
        {
            System.out.println("Error Date Time Input");
        }
        return test;
    }

    //check if endate happen after begindate
    public boolean checkEndDate(String BeginDate, String EndDate)
    {
        boolean test = false;
        SimpleDateFormat obj = new SimpleDateFormat("MM/dd/yy");
        try
        {
            Date begin = obj.parse(BeginDate);
            Calendar beginCalendar = new GregorianCalendar();
            beginCalendar.setTime(begin);

            Date end =  obj.parse(EndDate);
            Calendar endCalendar = new GregorianCalendar();
            endCalendar.setTime(end);

            if(beginCalendar.before(endCalendar))
                test = true;
            else
                System.out.println("Error Date Time Input. Ending date must be after beginning date");
        }
        catch (ParseException except)
        {
            System.out.println("Error Date Time Input in checkEndDate");
        }
        return test;
    }
}

class AnalyzeData
{

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
    public void displayInfor() //display to test whether reading file is successful
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

    public int[] string2intDate(String[] DateTime)
    {
        //reformat data inside data file for easier calculation
        int[] IntDateTime = new int[10];

        IntDateTime[0] = Integer.parseInt(DateTime[0]);
        IntDateTime[1] = Integer.parseInt(DateTime[1]);
        IntDateTime[2] = Integer.parseInt(DateTime[2]);
        return IntDateTime;
    }

    //checkd date before grouping data
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
    //counting newcase using increment
    void CountNewCase(String newcase, int group)
    {
        if(newcase != "")
            CountNewCase[group] +=Integer.parseInt(newcase);
    }
    //counting newdeadth using increment
    void CountNewDeath(String newdeath, int group)
    {
        if(newdeath != "")
            CountNewDeath[group] +=Integer.parseInt(newdeath);
    }
    //counting vaccinated by getting the lastest of a group
    void CountNewVaccinated(String newvac, int group)
    {
        if(newvac != "")
            CountVaccinated[group] =Integer.parseInt(newvac);
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
