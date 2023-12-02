package imbesky.promotion.exception;

import static imbesky.promotion.exception.PromotionException.ORDER_EXCEPTION;

public class OrderException extends IllegalArgumentException {
    private static final PromotionException TYPE = ORDER_EXCEPTION;

    public OrderException() {
        super(TYPE.getMessage());
    }
}
