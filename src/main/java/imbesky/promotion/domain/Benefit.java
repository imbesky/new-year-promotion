package imbesky.promotion.domain;

import static imbesky.promotion.constant.Format.NONE;
import static imbesky.promotion.constant.FreeGiftDetail.FREE_GIFT;
import static imbesky.promotion.constant.Number.INITIAL_VALUE;
import static imbesky.promotion.constant.Number.MINUS;

import imbesky.promotion.constant.Membership;
import imbesky.promotion.domain.dto.BenefitDto;
import imbesky.promotion.domain.input.Order;
import imbesky.promotion.domain.input.VisitDate;
import imbesky.promotion.domain.promotion.Discount;
import imbesky.promotion.domain.promotion.FreeGift;
import imbesky.promotion.domain.promotion.LunarNewYearDdayDiscount;
import imbesky.promotion.domain.promotion.NewYearFreeGift;
import imbesky.promotion.domain.promotion.SpecialDiscount;
import imbesky.promotion.domain.promotion.WeekDayDiscount;
import imbesky.promotion.domain.promotion.WeekEndDiscount;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Benefit {
    private final List<Discount> discounts;
    private final FreeGift newYearFreeGift;

    private Benefit(final VisitDate visitDate, final Order order) {
        discounts = List.of(
                new LunarNewYearDdayDiscount(visitDate),
                new WeekDayDiscount(visitDate, order),
                new WeekEndDiscount(visitDate, order),
                new SpecialDiscount(visitDate));
        newYearFreeGift = new NewYearFreeGift(order);
    }

    public static Benefit of(final VisitDate visitDate, final Order order) {
        return new Benefit(visitDate, order);
    }

    public BenefitDto toDto() {
        final Map<String, Integer> benefits = benefits();
        final int totalBenefitPrice = benefits.values().stream().mapToInt(i -> i).sum();
        return new BenefitDto(
                freeGifts(), benefits, totalBenefitPrice, Membership.of(totalBenefitPrice).getName());
    }

    private Map<String, Integer> benefits() {
        final Map<String, Integer> benefits = discounts.stream()
                .filter(Discount::applicable)
                .filter(Discount -> Discount.value() != INITIAL_VALUE)
                .collect(Collectors.toMap(
                        Discount::type,
                        Discount -> Discount.value() * MINUS
                ));
        if (newYearFreeGift.applicable()) {
            benefits.put(FREE_GIFT, newYearFreeGift.result().entrySet().stream()
                    .mapToInt(gift -> gift.getKey().getPrice() * gift.getValue()).sum() * MINUS);
        }
        return benefits;
    }

    private Map<String, Integer> freeGifts() {
        if (newYearFreeGift.applicable()) {
            return newYearFreeGift.result().entrySet().stream()
                    .collect(Collectors.toMap(
                            Entry -> Entry.getKey().getName(),
                            Entry::getValue
                    ));
        }
        return Map.of(NONE, INITIAL_VALUE);
    }
}
