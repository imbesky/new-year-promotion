package imbesky.promotion.domain.promotion;

import static imbesky.promotion.constant.DiscountDetail.LUNAR_NEW_YEAR_DDAY;

import imbesky.promotion.constant.DiscountDetail;
import imbesky.promotion.domain.input.VisitDate;

public class LunarNewYearDdayDiscount implements Discount {
    public final static DiscountDetail TYPE = LUNAR_NEW_YEAR_DDAY;
    private final VisitDate visitDate;

    public LunarNewYearDdayDiscount(final VisitDate visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public boolean applicable() {
        return visitDate.inRange(TYPE.getStartDate(), TYPE.getEndDate());
    }

    @Override
    public String type() {
        return TYPE.getName();
    }

    @Override
    public int value() {
        return TYPE.getPriceDefault() + TYPE.getPriceUnit() * visitDate.daySince(TYPE.getStartDate());
    }
}
