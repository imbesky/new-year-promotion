package imbesky.promotion.domain.input;

import static imbesky.promotion.constant.Date.PROMOTION_END_DATE;
import static imbesky.promotion.constant.Date.PROMOTION_START_DATE;
import static imbesky.promotion.constant.Date.WEEKEND;
import static imbesky.promotion.constant.Format.DATE_FORMAT;
import static imbesky.promotion.constant.Number.PROPER_REST;

import imbesky.promotion.domain.dto.VisitDateDto;
import imbesky.promotion.exception.VisitDateException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VisitDate {
    private final LocalDate date;

    public VisitDate(final String input) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        final LocalDate date;
        try {
            date = LocalDate.from(formatter.parse(input));
        } catch (DateTimeException e) {
            throw new VisitDateException();
        }
        validate(date);
        this.date = date;
    }

    public VisitDateDto toDto() {
        return new VisitDateDto(date.getMonthValue(), date.getDayOfMonth());
    }

    private void validate(final LocalDate date) {
        if (date.isBefore(PROMOTION_START_DATE) || date.isAfter(PROMOTION_END_DATE)) {
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

    public int daysBetween(final LocalDate date) {
        return Math.abs(date.getDayOfYear() - this.date.getDayOfYear());
    }
}
