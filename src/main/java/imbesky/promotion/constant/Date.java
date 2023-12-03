package imbesky.promotion.constant;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Date {
    public final static int YEAR = 2024;
    private final static int JANUARY = 1;
    private final static int FEBRUARY = 2;
    public final static List<DayOfWeek> WEEKEND = List.of(SATURDAY, SUNDAY);
    public final static LocalDate PROMOTION_START_DATE = LocalDate.of(YEAR, JANUARY, 1);
    public final static LocalDate PROMOTION_END_DATE = LocalDate.of(YEAR, FEBRUARY, 29);
    public final static LocalDate DDAY_EVENT_END_DATE = LocalDate.of(YEAR, FEBRUARY, 10);
}
