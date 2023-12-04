package imbesky.promotion.domain.dto;

import java.util.Map;

public record BenefitDto(
        Map<String, Integer> freeGifts,
        Map<String, Integer> discounts,
        int totalBenefitPrice,
        String membership
) {
}
