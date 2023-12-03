package imbesky.promotion.domain.promotion;

import static imbesky.promotion.constant.DiscountDetail.SPECIAL;

import imbesky.promotion.constant.DiscountDetail;
import imbesky.promotion.domain.input.VisitDate;

public class SpecialDiscount implements Discount {
    public final static DiscountDetail TYPE = SPECIAL;
    private final static int SPECIAL_EVENT_STANDARD = 5;
    private final VisitDate visitDate;

    public SpecialDiscount(final VisitDate visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public boolean applicable() {
        return visitDate.inRange(TYPE.getStartDate(), TYPE.getEndDate()) &&
                (visitDate.isDividedBy(SPECIAL_EVENT_STANDARD) || visitDate.equals(TYPE.getEndDate()));
    }

    @Override
    public String type() {
        return TYPE.getName();
    }

    @Override
    public int value() {
        return TYPE.getPriceDefault();
    }
}
