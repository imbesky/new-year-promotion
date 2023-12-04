package imbesky.promotion.domain.promotion;

import imbesky.promotion.constant.FreeGiftDetail;
import imbesky.promotion.constant.Menu;
import imbesky.promotion.domain.input.Order;
import java.util.Map;

public class NewYearFreeGift implements FreeGift {
    private final static int MIN_INDEX_FROM_BACK = 1;
    private final Order order;
    private FreeGiftDetail gift;

    public NewYearFreeGift(Order order) {
        this.order = order;
    }

    @Override
    public boolean applicable() {
        return order.totalPrice()
                >= FreeGiftDetail.values()[FreeGiftDetail.values().length - MIN_INDEX_FROM_BACK]
                .getStandardPrice();
    }

    @Override
    public Map<Menu, Integer> result() {
        return Map.of(checkGiftMenu(), checkGiftNumber());
    }

    private Menu checkGiftMenu() {
        gift = FreeGiftDetail.of(order.totalPrice());
        return gift.getMenu();
    }

    private int checkGiftNumber() {
        return order.numberOf(gift.getTarget()) * gift.getNumber();
    }
}
