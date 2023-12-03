package imbesky.promotion.domain.dto;

import java.util.Map;

public record BenefitDto(
        Map<String, Integer> discounts,
        Map<String, Integer> freeGifts,
        String membership
) {
}
