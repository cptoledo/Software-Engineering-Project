package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeUtils {

    public static Calendar getCalendar() {
        return Calendar.getInstance();
    }

    public static String getTimeString(String format) {
        //eg. TimeUtils.getTimeString("MMMM d, yyyy")
        //    TimeUtils.getTimeString("h:mm:ss a")
        return convert(format, Calendar.getInstance());
    }

    public static String convert(String format, Calendar time) {
        return (new SimpleDateFormat(format)).format(time.getTime());
    }

    public static Calendar parse(String format, String time) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        calendar.setTime(dateFormat.parse(time));
        return calendar;
    }
}
