package imbesky.promotion.input;

import static imbesky.promotion.constant.Number.VISIT_NUMBER_MIN;
import static imbesky.promotion.constant.Number.VISIT_NUMBER_WEEKDAY_MAX;
import static imbesky.promotion.constant.Number.VISIT_NUMBER_WEEKEND_MAX;
import static org.junit.jupiter.api.Assertions.assertThrows;

import imbesky.promotion.domain.input.VisitNumber;
import imbesky.promotion.exception.VisitNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VisitNumberTest {
    @Test
    @DisplayName("최소치보다 작은 방문자 수")
    void numberUnderMin() {
        final int input = VISIT_NUMBER_MIN - 1;

        assertThrows(VisitNumberException.class, () -> new VisitNumber(input, true));
    }

    @Test
    @DisplayName("최대치보다 큰 방문자 수: 주말")
    void numberOverMaxWeekend() {
        final int input = VISIT_NUMBER_WEEKEND_MAX + 1;
        final boolean isWeekend = true;

        assertThrows(VisitNumberException.class, () -> new VisitNumber(input, isWeekend));
    }

    @Test
    @DisplayName("최대치보다 큰 방문자 수: 주중")
    void numberOverMaxWeekday() {
        final int input = VISIT_NUMBER_WEEKDAY_MAX + 1;
        final boolean isWeekend = false;

        assertThrows(VisitNumberException.class, () -> new VisitNumber(input, isWeekend));
    }
}
