package imbesky.promotion.domain.input;

import static imbesky.promotion.constant.Character.BLANK;
import static imbesky.promotion.constant.Character.COMMA;
import static imbesky.promotion.constant.Character.DASH;
import static imbesky.promotion.constant.Character.EMPTY;
import static imbesky.promotion.constant.Number.FIRST_INDEX;
import static imbesky.promotion.constant.Number.INITIAL_VALUE;
import static imbesky.promotion.constant.Number.ORDER_MAX;
import static imbesky.promotion.constant.Number.ORDER_MIN;
import static imbesky.promotion.constant.Number.SECOND_INDEX;

import imbesky.promotion.constant.Menu;
import imbesky.promotion.constant.MenuType;
import imbesky.promotion.domain.dto.OrderDto;
import imbesky.promotion.exception.OrderException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Order {
    private final Map<Menu, Integer> orders = new HashMap<>();
    private int totalOrderedNumber = INITIAL_VALUE;
    private int totalPrice = INITIAL_VALUE;

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
        if (menu == null || orders.containsKey(menu) || orderNumber < ORDER_MIN) {
            throw new OrderException();
        }
    }

    private void finalValidate(final int visitNumber) {
        if (totalOrderedNumber / visitNumber < ORDER_MIN
                || totalOrderedNumber / visitNumber > ORDER_MAX) {
            throw new OrderException();
        }
    }

    private void save(final String[] detail) {
        orders.put(Menu.findByName(detail[FIRST_INDEX]), Integer.parseInt(detail[SECOND_INDEX]));
        totalOrderedNumber += Integer.parseInt(detail[SECOND_INDEX]);
        totalPrice += Menu.findByName(detail[FIRST_INDEX]).getPrice() * Integer.parseInt(detail[SECOND_INDEX]);
    }

    public OrderDto toDto() {
        return new OrderDto(
                orders.entrySet().stream()
                        .collect(Collectors
                                .toMap(order -> order.getKey().getName(), Entry::getValue)),
                totalPrice);
    }

    public int numberOf(final MenuType menuType) {
        return orders.entrySet().stream()
                .filter(order -> order.getKey().getType().equals(menuType))
                .mapToInt(Entry::getValue).sum();
    }

    public Map<Menu, Integer> of(final MenuType menuType) {
        return orders.entrySet().stream()
                .filter(order -> order.getKey().getType().equals(menuType))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    public int totalPrice() {
        return totalPrice;
    }
}
