package moa.store.lessons.util;

import java.time.LocalDate;
import java.util.Date;
import java.sql.Time;
import java.text.ParseException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TimeUtil {

    public static long getDuration(Time initTime, Time finishTime){
        return TimeUnit.MILLISECONDS.toMinutes(finishTime.getTime() - initTime.getTime());
    }

    public static List<Date> getAllDayOfTheMonth(int year, int month, int weekDay) throws ParseException {

        List<Date> dates = new ArrayList<>();
        for(int day=1; day<= getLengthOfMonth(year, month); day++){
            Calendar calendar = getCalendar(year, month, day);
            if(isWeekDaySelected(calendar, weekDay)){
                dates.add(calendar.getTime());
            }
        }
        return dates;
    }

    private static boolean isWeekDaySelected(Calendar calendar, int weekDay){
        return weekDay == calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static int getLengthOfMonth(int year, int month){
        return YearMonth.of(year, month).lengthOfMonth();
    }

    public static Calendar getCalendar(int year, int month, int day) {
        return new GregorianCalendar(year, getMonthNumber(month), day);
    }

    private static int getMonthNumber(int month){
        return month - 1;
    }

    public static java.sql.Date toSqlDate(Date date){
        return new java.sql.Date(date.getTime());
    }

    public static int getCurrentYear(){
        return LocalDate.now().getYear();
    }


}
