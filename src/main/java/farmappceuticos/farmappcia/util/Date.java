package farmappceuticos.farmappcia.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Date {

    // DAYOFWEEK[1] gives MON, DAYOFWEEK[7] gives SUN...
    public static final String[] DAYOFWEEK = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };

    // MONTH[12] gives DEC, MONTH[1] gives JAN...
    public static final String[] MONTH = { "EMPTY", "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP",
            "OCT", "NOV", "DEC" };

    private final static int REFYEAR = 1990;

    private int day;
    private int month;
    private int year;
    private int dow;
    private boolean isHoliday;


}
