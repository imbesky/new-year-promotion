package imbesky.promotion.util;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayUtil {
    public static boolean isWeekday(final LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    public static boolean isWeekend(final LocalDate date) {
        return date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY;
    }

    public static boolean isBetween(final LocalDate start, final LocalDate end, final LocalDate date) {
        return !date.isBefore(start) && !date.isAfter(end);
    }

    
}
