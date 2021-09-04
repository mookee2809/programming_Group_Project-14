
import java.util.*;
import java.io.FileNotFoundException;
import java.util.stream.Stream;

public class New{
    New(){}
    AnalyzeData a = new AnalyzeData();
    public void displayChart() throws FileNotFoundException, Exception
    {
        int numOfGroup;
        numOfGroup = a.length;
        System.out.println(numOfGroup);
        int row = 24;
        int column = 80;
        String yLabel = "value";
        int labelLength = yLabel.length()+ 2;
        Long[] timeGroup = new Long[1000];
        Long[] value = new Long[1000];

        //initialize an empty chart
        String[][] chart = new String[row][labelLength+column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column + labelLength; j++) {
                chart[i][j] = " ";
            }
        }
        int numOfValue = 79/(numOfGroup +1);
    }


}