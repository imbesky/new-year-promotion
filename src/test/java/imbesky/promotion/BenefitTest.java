package imbesky.promotion;

import static imbesky.promotion.constant.Membership.SILVER;
import static org.assertj.core.api.Assertions.assertThat;

import imbesky.promotion.constant.Membership;
import imbesky.promotion.domain.Benefit;
import imbesky.promotion.domain.dto.BenefitDto;
import imbesky.promotion.domain.input.Order;
import imbesky.promotion.domain.input.VisitDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BenefitTest {
    @Test
    @DisplayName("혜택 테스트: 적용 이벤트가 없는 경우")
    void none() {
        final VisitDate visitDate = new VisitDate("2024-02-13"); //수요일
        final Order order = new Order("갈비찜-1", 1);

        final Benefit benefit = Benefit.of(visitDate, order);
        final BenefitDto benefitDto = benefit.toDto();

        assertThat(benefitDto.discounts().size()).isEqualTo(0);
        assertThat(benefitDto.totalBenefitPrice()).isEqualTo(0);
        assertThat(benefitDto.membership()).isEqualTo(Membership.NONE.getName());
    }

    @Test
    @DisplayName("혜택 테스트: 주말 할인을 제외한 모든 이벤트가 적용되는 경우")
    void exceptWeekendDiscount() {
        final VisitDate visitDate = new VisitDate("2024-02-05"); //월요일
        final Order order = new Order("장어구이-1,배즙-1", 1);

        final Benefit benefit = Benefit.of(visitDate, order);
        final BenefitDto benefitDto = benefit.toDto();

        assertThat(benefitDto.discounts().get("음력 설 디데이 할인")).isEqualTo(-4_500);
        assertThat(benefitDto.discounts().get("주중 할인")).isEqualTo(-1_000);
        assertThat(benefitDto.discounts().get("특별 할인")).isEqualTo(-2_024);
        assertThat(benefitDto.freeGifts().get("스프라이트")).isEqualTo(1);
        assertThat(benefitDto.totalBenefitPrice()).isEqualTo(-10_524);
        assertThat(benefitDto.membership()).isEqualTo(SILVER.getName());
    }
}
