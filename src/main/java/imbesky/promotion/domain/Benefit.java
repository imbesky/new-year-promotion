package imbesky.promotion.domain;

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
        final Map<String, Integer> discounts = discounts();
        final int totalBenefitPrice = discounts.values().stream().mapToInt(i -> i).sum();
        return new BenefitDto(discounts, freeGifts(), Membership.of(totalBenefitPrice).getName());
    }

    private Map<String, Integer> discounts() {
        return discounts.stream()
                .filter(Discount::applicable)
                .collect(Collectors.toMap(
                        Discount::type,
                        Discount::value
                ));
    }

    private Map<String, Integer> freeGifts() {
        return newYearFreeGift.result().entrySet().stream()
                .collect(Collectors.toMap(
                        Entry -> Entry.getKey().getName(),
                        Entry::getValue
                ));
    }
}
