package imbesky.promotion.constant;

import java.time.LocalDate;

public class Date {
    public final static int YEAR = 2024;
    public final static int JANUARY = 1;
    public final static int FEBRUARY = 2;
    public final static int SPECIAL_EVENT_STANDARD = 5;
    public final static LocalDate PROMOTION_START_DATE = LocalDate.of(YEAR, JANUARY, 1);
    public final static LocalDate DDAY_EVENT_END_DATE = LocalDate.of(YEAR, FEBRUARY, 10);
    public final static LocalDate PROMOTION_END_DATE = LocalDate.of(YEAR, FEBRUARY, 29);

}
