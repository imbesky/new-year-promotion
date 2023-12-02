package imbesky.promotion.exception;

import static imbesky.promotion.exception.PromotionException.VISIT_NUMBER_EXCEPTION;

public class VisitNumberException extends IllegalArgumentException {
    private static final PromotionException TYPE = VISIT_NUMBER_EXCEPTION;

    public VisitNumberException() {
        super(TYPE.getMessage());
    }
}
