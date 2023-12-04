package imbesky.promotion.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import imbesky.promotion.domain.input.VisitDate;
import imbesky.promotion.exception.VisitDateException;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VisitDateTest {
    @Test
    @DisplayName("범위 이전: 2023년 12월 31일")
    void dateBefore() {
        final String input = "2023-12-31";

        assertThatThrownBy(() -> {
            new VisitDate(input);
        }).isInstanceOf(VisitDateException.class);
    }

    @Test
    @DisplayName("범위 이후: 2023년 3월 1일")
    void dateAfter() {
        final String input = "2023-03-01";

        assertThatThrownBy(() -> {
            new VisitDate(input);
        }).isInstanceOf(VisitDateException.class);
    }

    @Test
    @DisplayName("isWeekend(): 주말 확인")
    void isWeekend() {
        final String input = "2024-01-07"; //일요일
        final VisitDate visitDate = new VisitDate(input);

        assertThat(visitDate.isWeekend()).isTrue();
    }

    @Test
    @DisplayName("inRange(): 범위 확인")
    void inRange() {
        final String input = "2024-02-01";
        final VisitDate visitDate = new VisitDate(input);

        final LocalDate startDate = LocalDate.of(2024, 1, 31);
        final LocalDate endDate = LocalDate.of(2024, 2, 2);

        assertThat(visitDate.inRange(startDate, endDate)).isTrue();
    }

    @Test
    @DisplayName("equals(): 일치 확인")
    void equals() {
        final String input = "2024-02-01";
        final VisitDate visitDate = new VisitDate(input);

        final LocalDate date = LocalDate.of(2024, 2, 2);

        assertThat(visitDate.equals(date)).isFalse();
    }

    @Test
    @DisplayName("isDividedBy(): 나머지 확인")
    void isDividedBy() {
        final String input = "2024-01-12";
        final VisitDate visitDate = new VisitDate(input);

        final int divider = 4;

        assertThat(visitDate.isDividedBy(divider)).isTrue();
    }

    @Test
    @DisplayName("daySince(): 날짜 차이확인")
    void daySince() {
        final String input = "2024-02-05";
        final VisitDate visitDate = new VisitDate(input);

        final LocalDate date = LocalDate.of(2024, 2, 10);

        assertThat(visitDate.daySince(date)).isEqualTo(5);
    }
}
