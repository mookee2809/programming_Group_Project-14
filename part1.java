

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class part1{}

class Request
{
    public String locationRequest;
    public String begindate;
    public String endate;
    Request(){} //default constructor
    public void inputRequest(String locationRequest, String begindate, String endate)
    {
        this.locationRequest = locationRequest;
        this.begindate = begindate;
        this.endate = endate;
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

    AnalyzeData(){}
    AnalyzeData(String a, String b,String c,String d,String e,String f,String g, String h)
    {
        ios_code = a;
        continent = b;
        location = c;
        date = d;
        new_cases = e ;
        new_deaths = f;
        people_vaccinated = g;
        population = h;
    }
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
    public void display()
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

}



class Data {
    public static void main(String arg[])
    {
        //
        String Location;
        String BeginDate; 
        String EndDate;
        Scanner sc = new Scanner(System.in);
        Location = sc.nextLine();
        //BeginDate = sc.nextLine();
        //EndDate = sc.nextLine();;

        //Create Object
        AnalyzeData DataTest = new AnalyzeData();
        String[] temp;
        int i=0;

        //reading file
        try {
            File myObj = new File("data.txt");
            Scanner myReader = new Scanner(myObj);
            
            int count1=0; 
            int count2=0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splits = data.split(",");
                if(splits[1].compareTo(Location)==0 || splits[2].compareTo(Location)==0 )
                {
                    DataTest.inputData(splits);
                    DataTest.display();
                    //to test if it really print out 2 type of 'Africa'
                    if(splits[1].compareTo(Location)==0 )
                        count1++;
                    count2++;
                }
                
            }
            System.out.println("Count 1:"+count1+" Count 2: "+count2);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}

