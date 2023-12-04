package imbesky.promotion.domain.dto;

import java.util.Map;

public record OrderDto(
        Map<String, Integer> orders,
        int totalPrice
) {
}
