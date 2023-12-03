package imbesky.promotion.domain.input;

import static imbesky.promotion.constant.Date.PROMOTION_END_DATE;
import static imbesky.promotion.constant.Date.PROMOTION_START_DATE;
import static imbesky.promotion.constant.Date.WEEKEND;
import static imbesky.promotion.constant.Format.DATE_FORMAT;
import static imbesky.promotion.constant.Number.PROPER_REST;

import imbesky.promotion.exception.VisitDateException;
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
        if (!date.isBefore(PROMOTION_START_DATE) && !date.isAfter(PROMOTION_END_DATE)) {
            throw new VisitDateException();
        }
    }

    public boolean isWeekend() {
        return WEEKEND.contains(date.getDayOfWeek());
    }

    public boolean inRange(final LocalDate start, final LocalDate end) {
        return !date.isBefore(start) && !date.isAfter(end);
    }

    public boolean equals(final LocalDate date) {
        return date.equals(this.date);
    }

    public boolean isDividedBy(final int divider) {
        return date.getDayOfMonth() % divider == PROPER_REST;
    }

    public int daySince(final LocalDate date) {
        return date.compareTo(this.date);
    }
}
