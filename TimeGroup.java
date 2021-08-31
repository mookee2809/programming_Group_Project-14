import java.util.*;
import java.text.SimpleDateFormat;

public class TimeGroup {
    
    private final Date[] dates;
    private final int[] metricValue;
    private final int metricType;
    private final int groupType;

    // constructor
    TimeGroup(Date date, int value, int type, int grouping) {
        dates = new Date[1];
        metricValue = new int[1];
        dates[0] = date;
        metricValue[0] = value;
        metricType = type;
        groupType = grouping;
    }

    // instant construct
    TimeGroup(int amount, int type, int grouping) {
        dates = new Date[amount];
        metricValue = new int[amount];
        metricType = type;
        groupType = grouping;
    }

    public int getGroupType() {
        return groupType;
    }

    // display dates in each group
    public void DisplayDates() {
        if (groupType == 1) {
            for (Date value : dates) {
                System.out.print("\n" + DateToString(value));
            }
        }
        if (groupType == 2 || groupType == 3) {

            System.out.print("\n" + DateToString(dates[0]) + " - " + DateToString(dates[dates.length - 1]));
        }
    }

    // convert days to string with time field removed
    private String DateToString(Date input) {
        SimpleDateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");
        return outputFormatter.format(input);
    }
}