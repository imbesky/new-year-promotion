package imbesky.promotion.domain;

import static imbesky.promotion.constant.Number.VISIT_NUMBER_MIN;
import static imbesky.promotion.constant.Number.VISIT_NUMBER_WEEKDAY_MAX;
import static imbesky.promotion.constant.Number.VISIT_NUMBER_WEEKEND_MAX;

import imbesky.promotion.exception.VisitNumberException;

public class VisitNumber {
    private final int number;

    public VisitNumber(final int number, final boolean isWeekday) {
        validate(number, isWeekday);
        this.number = number;
    }

    private void validate(final int number, final boolean isWeekday) {
        if (number < VISIT_NUMBER_MIN) {
            throw new VisitNumberException();
        }
        if (isWeekday && number > VISIT_NUMBER_WEEKDAY_MAX) {
            throw new VisitNumberException();
        } else if (number > VISIT_NUMBER_WEEKEND_MAX) {
            throw new VisitNumberException();
        }
    }

    public int getNumber() {
        return number;
    }
}
