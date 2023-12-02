package imbesky.promotion.exception;

public enum PromotionException {
    VISIT_DATE_EXCEPTION("유효하지 않은 방문 날짜입니다."),
    VISIT_NUMBER_EXCEPTION("유효하지 않은 방문 인원입니다."),
    ORDER_EXCEPTION("유효하지 않은 주문입니다.");
    private static final String PREFIX = "[ERROR] ";
    private final String message;


    PromotionException(java.lang.String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX.concat(message);
    }
}
