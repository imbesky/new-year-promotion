package imbesky.promotion.domain.promotion;

import static imbesky.promotion.constant.DiscountDetail.WEEKDAY;
import static imbesky.promotion.constant.MenuType.DRINK;
import static imbesky.promotion.constant.Number.INITIAL_VALUE;

import imbesky.promotion.constant.DiscountDetail;
import imbesky.promotion.constant.Menu;
import imbesky.promotion.constant.MenuType;
import imbesky.promotion.domain.input.Order;
import imbesky.promotion.domain.input.VisitDate;
import java.util.Map.Entry;

public class WeekDayDiscount implements Discount {
    public final static DiscountDetail TYPE = WEEKDAY;
    private final static MenuType TARGET = DRINK;
    private final VisitDate visitDate;
    private final Order order;

    public WeekDayDiscount(final VisitDate visitDate, Order order) {
        this.visitDate = visitDate;
        this.order = order;
    }

    @Override
    public boolean applicable() {
        return visitDate.inRange(TYPE.getStartDate(), TYPE.getEndDate())
                && !visitDate.isWeekend();
    }

    @Override
    public String type() {
        return TYPE.getName();
    }

    @Override
    public int value() {
        int value = INITIAL_VALUE;
        for (Entry<Menu, Integer> drink : order.of(TARGET).entrySet()) {
            value += drink.getKey().getPrice() * drink.getValue();
        }
        return (int) (value * TYPE.getRatio());
    }
}
