package imbesky.promotion.domain.promotion;

import static imbesky.promotion.constant.Menu.SOJU;
import static imbesky.promotion.constant.Menu.SPRITE;
import static imbesky.promotion.constant.MenuType.MAIN;

import imbesky.promotion.constant.Menu;
import imbesky.promotion.constant.MenuType;
import imbesky.promotion.domain.input.Order;
import java.util.Map;

public class NewYearFreeGift implements FreeGift {
    public final static MenuType TARGET = MAIN;
    private final Order order;

    public NewYearFreeGift(Order order) {
        this.order = order;
    }

    @Override
    public boolean applicable() {
        return order.totalPrice() >= 50_000;
    }

    @Override
    public Map<Menu, Integer> result() {
        return Map.of(checkGiftMenu(), checkGiftNumber());
    }

    private Menu checkGiftMenu() {
        if (order.totalPrice() >= 100_000) {
            return SOJU;
        }
        return SPRITE;
    }

    private int checkGiftNumber() {
        return order.numberOf(TARGET);
    }
}
