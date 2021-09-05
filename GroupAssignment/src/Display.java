
class Display
{
    Display(){}
    public void displayInfor(AnalyzeData DataTest) //display to check whether the program work properly
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
    public void displayAfterChecking_NewCase(AnalyzeData DataTest)
    {
        for(int i=0; i<DataTest.length; i++)
        {
            System.out.print(DataTest.BeginDateinGroup[i]+"-"+DataTest.EndDateinGroup[i]+": ");
            System.out.println("New Cases["+(i+1)+"]: "+DataTest.CountNewCase[i]);
            System.out.println("__________________________________________");
        }
    }
    public void displayAfterChecking_NewDeath(AnalyzeData DataTest)
    {
        for(int i=0; i<DataTest.length; i++)
        {
            System.out.print(DataTest.BeginDateinGroup[i]+"-"+DataTest.EndDateinGroup[i]+": ");
            System.out.println("New Deaths["+(i+1)+"]: "+DataTest.CountNewDeath[i]);
            System.out.println("__________________________________________");
        }
    }
    public void displayAfterChecking_Vaccinated(AnalyzeData DataTest)
    {
        for(int i=0; i<DataTest.length; i++)
        {
            System.out.print(DataTest.BeginDateinGroup[i]+"-"+DataTest.EndDateinGroup[i]+": ");
            System.out.println("People Vaccinated["+(i+1)+"]: "+DataTest.CountVaccinated[i]);
            System.out.println("__________________________________________");
        }
    }


    //display chart
    public void displayChart(long[] arr, int length)
    {
        //Number Axis
        long max = seekMax(arr,length);
        long min = seekMin(arr, length);
        String[] arrValue = new String[24];
        System.out.println("Max: "+max);
        arrValue = valueNumberAxis(max,min);

        //printing chart
        String[][] chart = new String[30][90];
        for(int i=0; i<length+2; i++)
        {
            for(int j=0; j<24+2; j++)
            {
                String string = arrValue[j];
                if((arr[i] <= Integer.parseInt(string.replaceAll(" ",""))))
                {
                    chart[25 - (j+2)][i+2] = "*";
                    j=25; // break the for loop to stop printing else  "*" will be printed at every value position chart[i][j++]
                }
            }

        }
        for(int i=0; i<24; i++)
        {
            for(int j=0; j<80; j++)
            {
                if(j==0)
                    System.out.print(arrValue[24-i-1]);
                else
                {
                    if(j==1)
                        System.out.print("|");
                    else
                    {
                        if(i==23 && j>1)
                        {
                            if(chart[i][j]!=null && i<26 && j <length+2)
                                System.out.print(chart[i][j]);
                            else
                                System.out.print("_");
                            /*if(chart[i][j]=="*" && i<26 && j <length+2 )
                            {
                                System.out.print(chart[i][j]);
                            }
                            System.out.print("_");*/
                        }
                        else
                        {
                            if(chart[i][j]==null)
                                System.out.print(" ");
                            else
                                System.out.print(chart[i][j]);
                        }
                    }
                }
            }
            System.out.print("\n");
        }


        // Date Axis
        System.out.print("Min: "+min);
    }
    public String[] valueNumberAxis(long max, long min)
    {
        int[] arr = {1,2,11,22};
        //divisors of 22 (max value and min value are not included)
        //to divide Y axis into reasonable units
        long initTemp = max - min;
        long unit = 0;
        long temp;
        if(initTemp<=11)
        {
            for(int i=0; i<4;i++)
            {
                if(arr[i]>=initTemp)
                {
                    unit = 22/arr[i];
                    break;
                }
            }
            temp = 1;
        }
        else
        {
            if(initTemp>11 && initTemp<=24)
            {
                unit = 2;
                temp = 2;
            }
            else
            {
                unit = 1;
                temp = (max - min)/(22);
            }

        }
        //to compare the value of each group with the value on the Y axis
        long currentValue = 0;
        String[] arrValue = new String[24];
        for(int i=0; i<24;i++)
        {
            //* will be printed at the position that has approximate values
            if(i%unit==0)
            {
                if(i == 0)
                    currentValue=min;
                else
                {
                    currentValue+=temp;
                    if(currentValue>max)
                        currentValue = max;
                }
            }
            arrValue[i] = String.format("%15s",currentValue);
        }
        return arrValue;
    }

    //seek Min and Max value
    public long seekMin(long[] arr, int length )
    {
        long min = arr[0];
        for(int i=1; i<length; i++)
        {
            if(arr[i]<min)
                min = arr[i];
        }
        return min;
    }
    public long seekMax(long[] arr, int length)
    {
        long max = arr[0];
        for(int i=1; i<length; i++)
        {
            if(arr[i]>max)
                max = arr[i];
        }
        return max;
    }
}
