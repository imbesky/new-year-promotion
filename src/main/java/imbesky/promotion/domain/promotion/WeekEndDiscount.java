package imbesky.promotion.domain.promotion;

import static imbesky.promotion.constant.DiscountDetail.WEEKEND;
import static imbesky.promotion.constant.MenuType.MAIN;

import imbesky.promotion.constant.DiscountDetail;
import imbesky.promotion.constant.MenuType;
import imbesky.promotion.domain.input.Order;
import imbesky.promotion.domain.input.VisitDate;

public class WeekEndDiscount implements Discount {
    public final static DiscountDetail TYPE = WEEKEND;
    private final static MenuType TARGET = MAIN;
    private final VisitDate visitDate;
    private final Order order;

    public WeekEndDiscount(final VisitDate visitDate, Order order) {
        this.visitDate = visitDate;
        this.order = order;
    }

    @Override
    public boolean applicable() {
        return visitDate.inRange(TYPE.getStartDate(), TYPE.getEndDate())
                && visitDate.isWeekend();
    }

    @Override
    public String type() {
        return TYPE.getName();
    }

    @Override
    public int value() {
        return (int) (TYPE.getRatio() * order.numberOf(TARGET) * order.totalPrice());
    }

}
