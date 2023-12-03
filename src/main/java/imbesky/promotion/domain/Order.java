package imbesky.promotion.domain;

import static imbesky.promotion.constant.Format.BLANK;
import static imbesky.promotion.constant.Format.COMMA;
import static imbesky.promotion.constant.Format.DASH;
import static imbesky.promotion.constant.Format.EMPTY;
import static imbesky.promotion.constant.Number.FIRST_INDEX;
import static imbesky.promotion.constant.Number.ORDER_MAX;
import static imbesky.promotion.constant.Number.ORDER_MIN;
import static imbesky.promotion.constant.Number.SECOND_INDEX;

import imbesky.promotion.constant.Menu;
import imbesky.promotion.exception.OrderException;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private final Map<Menu, Integer> orders = new HashMap<>();
    private int totalOrderedNumber = 0;

    public Order(final String input, final int visitNumber) {
        String[] orders = input.replace(BLANK, EMPTY).split(COMMA);
        for (String order : orders) {
            final String[] detail = order.split(DASH);
            orderValidate(detail);
            save(detail);
        }
        finalValidate(visitNumber);
    }

    private void orderValidate(final String[] detail) {
        final int orderNumber;
        try {
            orderNumber = Integer.parseInt(detail[SECOND_INDEX]);
        } catch (NumberFormatException e) {
            throw new OrderException();
        }
        final Menu menu = Menu.findByName(detail[FIRST_INDEX]);
        if (menu == null
                || orders.containsKey(menu)
                || orderNumber < ORDER_MIN) {
            throw new OrderException();
        }
    }

    private void finalValidate(final int visitNumber) {
        if (totalOrderedNumber / visitNumber < ORDER_MIN
                || totalOrderedNumber / visitNumber < ORDER_MAX) {
            throw new OrderException();
        }
    }

    private void save(final String[] detail) {
        orders.put(Menu.findByName(detail[FIRST_INDEX]), Integer.parseInt(detail[SECOND_INDEX]));
        totalOrderedNumber += Integer.parseInt(detail[SECOND_INDEX]);
    }

    public int orderedNumber(final Menu menu) {
        return orders.get(menu);
    }
}
