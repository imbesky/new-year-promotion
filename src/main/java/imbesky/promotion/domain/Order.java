package imbesky.promotion.domain;

import static imbesky.promotion.constant.Format.COMMA;
import static imbesky.promotion.constant.Format.DASH;
import static imbesky.promotion.constant.Number.FIRST_INDEX;
import static imbesky.promotion.constant.Number.SECOND_INDEX;

import imbesky.promotion.constant.Menu;
import imbesky.promotion.exception.OrderException;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<Menu, Integer> orders = new HashMap<>();

    private Order(final String input) {
        String[] orders = input.split(COMMA);
        for (String order : orders) {
            String[] detail = order.split(DASH);
            validate(detail);
            save(detail);
        }
    }

    private void validate(final String[] detail) {
        if (Menu.findByName(detail[FIRST_INDEX]) == null) {
            throw new OrderException();
        }
        try {
            Integer.parseInt(detail[SECOND_INDEX]);
        } catch (NumberFormatException e) {
            throw new OrderException();
        }
        // 0 이상임?
        // 합계 인당 10 이상임?
    }

    private void save(final String[] detail) {
        orders.put(Menu.findByName(detail[FIRST_INDEX]), Integer.valueOf(detail[SECOND_INDEX]));
    }

    public int orderedNumber(final Menu menu) {
        return orders.get(menu);
    }
}
