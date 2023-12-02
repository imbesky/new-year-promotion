package imbesky.promotion.domain;

import static imbesky.promotion.constant.Date.PROMOTION_END_DATE;
import static imbesky.promotion.constant.Date.PROMOTION_START_DATE;
import static imbesky.promotion.constant.Format.DATE_FORMAT;

import imbesky.promotion.exception.VisitDateException;
import imbesky.promotion.util.DayUtil;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VisitDate {
    private final LocalDate date;

    public VisitDate(final String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        try {
            validate(LocalDate.parse(date, formatter));
        } catch (DateTimeException e) {
            throw new VisitDateException();
        }
        this.date = LocalDate.parse(date, formatter);
    }

    private void validate(final LocalDate date) {
        if (!DayUtil.isBetween(PROMOTION_START_DATE, PROMOTION_END_DATE, date)) {
            throw new VisitDateException();
        }
    }

    public boolean isWeekday() {
        return DayUtil.isWeekend(date);
    }

    public boolean inRange(final LocalDate start, final LocalDate end) {
        return DayUtil.isBetween(start, end, date);
    }

    public int dayOfMonth() {
        return date.getDayOfMonth();
    }
}
