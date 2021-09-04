
class Display
{
    Display(){}
    public void displayInfor(AnalyzeData DataTest) //display to check wheter the program work properly
    {
        System.out.print(DataTest.ios_code + " ") ;
        System.out.print(DataTest.continent+ " ");
        System.out.print(DataTest.location + " ");
        System.out.print(DataTest.date + " ");
        System.out.print(DataTest.new_cases + " ");
        System.out.print(DataTest.new_deaths + " ");
        System.out.print(DataTest.people_vaccinated + " ");
        System.out.print(DataTest.population + " " + "\n");
    }
    public void displayAfterCheckingNewCase(AnalyzeData DataTest)
    {
        for(int i=0; i<DataTest.length; i++)
        {
            System.out.print(DataTest.BeginDateinGroup[i]+"-"+DataTest.EndDateinGroup[i]+": ");
            System.out.println("New Cases["+(i+1)+"]: "+DataTest.CountNewCase[i]);
            System.out.println("__________________________________________");
        }
    }
    public void displayAfterCheckingNewDeath(AnalyzeData DataTest)
    {
        for(int i=0; i<DataTest.length; i++)
        {
            System.out.print(DataTest.BeginDateinGroup[i]+"-"+DataTest.EndDateinGroup[i]+": ");
            System.out.println("New Deaths["+(i+1)+"]: "+DataTest.CountNewDeath[i]);
            System.out.println("__________________________________________");
        }
    }
    public void displayAfterCheckingVaccinated(AnalyzeData DataTest)
    {
        for(int i=0; i<DataTest.length; i++)
        {
            System.out.print(DataTest.BeginDateinGroup[i]+"-"+DataTest.EndDateinGroup[i]+": ");
            System.out.println("People Vaccinated["+(i+1)+"]: "+DataTest.CountVaccinated[i]);
            System.out.println("__________________________________________");
        }
    }
    public void displayChart(AnalyzeData DataTest)
    {

    }
    public long seekMin(long[] arr, AnalyzeData DataTest )
    {
        long min = arr[0];
        for(int i=1; i<DataTest.length; i++)
        {
            if(arr[i]<min)
                min = arr[i];
        }
        return min;
    }
    public long seekMax(long[] arr, AnalyzeData DataTest)
    {
        long max = arr[0];
        for(int i=1; i<DataTest.length; i++)
        {
            if(arr[i]>max)
                max = arr[i];
        }
        return max;
    }
}