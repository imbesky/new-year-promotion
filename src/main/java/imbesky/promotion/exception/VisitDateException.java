package imbesky.promotion.exception;

import static imbesky.promotion.exception.PromotionException.VISIT_DATE_EXCEPTION;

public class VisitDateException extends IllegalArgumentException {
    private static final PromotionException TYPE = VISIT_DATE_EXCEPTION;

    public VisitDateException() {
        super(TYPE.getMessage());
    }
}
