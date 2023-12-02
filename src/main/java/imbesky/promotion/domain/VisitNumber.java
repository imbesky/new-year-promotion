package imbesky.promotion.domain;

import imbesky.promotion.exception.VisitNumberException;

public class VisitNumber {
    public final static int MIN = 1;
    public final static int WEEKDAY_MAX = 6;
    public final static int WEEKEND_MAX = 12;
    private final int number;

    public VisitNumber(final int number, final boolean isWeekday) {
        validate(number, isWeekday);
        this.number = number;
    }

    private void validate(final int number, final boolean isWeekday) {
        if (number < MIN) {
            throw new VisitNumberException();
        }
        if (isWeekday && number > WEEKDAY_MAX) {
            throw new VisitNumberException();
        } else if (number > WEEKEND_MAX) {
            throw new VisitNumberException();
        }
    }

    public int getNumber() {
        return number;
    }
}
