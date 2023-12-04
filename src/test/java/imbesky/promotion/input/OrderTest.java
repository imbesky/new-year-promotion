package imbesky.promotion.input;

import static imbesky.promotion.constant.Menu.PEAR_JUICE;
import static imbesky.promotion.constant.Menu.WHITE_WINE;
import static imbesky.promotion.constant.MenuType.DESSERT;
import static imbesky.promotion.constant.MenuType.DRINK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import imbesky.promotion.domain.input.Order;
import imbesky.promotion.exception.OrderException;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {
    @Test
    @DisplayName("숫자가 아닌 주문 개수: 문자")
    void numberNotNumeric() {
        final String input = "장어구이-장";
        final int visitNumber = 1;

        assertThrows(OrderException.class, () -> new Order(input, visitNumber));
    }

    @Test
    @DisplayName("메뉴판에 없는 메뉴")
    void invalidMenu() {
        final String input = "초코케이크-1";
        final int visitNumber = 1;

        assertThrows(OrderException.class, () -> new Order(input, visitNumber));
    }

    @Test
    @DisplayName("중복된 메뉴")
    void duplicateMenu() {
        final String input = "장어구이-1,장어구이-2";
        final int visitNumber = 1;

        assertThrows(OrderException.class, () -> new Order(input, visitNumber));
    }

    @Test
    @DisplayName("최소치 미만의 주문 개수")
    void numberUnderMin() {
        final String input = "장어구이-0";
        final int visitNumber = 1;

        assertThrows(OrderException.class, () -> new Order(input, visitNumber));
    }

    @Test
    @DisplayName("총 인원 대비 최소치 미만의 주문 개수")
    void totalNumberUnderMin() {
        final String input = "장어구이-1";
        final int visitNumber = 2;

        assertThrows(OrderException.class, () -> new Order(input, visitNumber));
    }

    @Test
    @DisplayName("총 인원 대비 최대치 초과의 주문 개수")
    void totalNumberOverMax() {
        final String input = "장어구이-11";
        final int visitNumber = 1;

        assertThrows(OrderException.class, () -> new Order(input, visitNumber));
    }

    @Test
    @DisplayName("특정 메뉴 타입의 주문 개수")
    void numberOfMenuType() {
        final String input = "호박죽-1,갈비찜-1,떡-2,배즙-1";
        final int visitNumber = 1;

        final Order order = new Order(input, visitNumber);

        assertThat(order.numberOf(DESSERT)).isEqualTo(2);
    }

    @Test
    @DisplayName("특정 메뉴 타입의 주문")
    void orderOfMenuType() {
        final String input = "호박죽-1,화이트와인-1,갈비찜-1,떡-2,배즙-1";
        final int visitNumber = 1;

        final Order order = new Order(input, visitNumber);

        assertThat(order.of(DRINK)).isEqualTo(Map.of(WHITE_WINE, 1, PEAR_JUICE, 1));
    }

    @Test
    @DisplayName("총주문 금액")
    void totalPrice() {
        final String input = "새해특선-1,소주-1";
        final int visitNumber = 1;

        final Order order = new Order(input, visitNumber);

        assertThat(order.totalPrice()).isEqualTo(64_000);
    }

    @Test
    @DisplayName("본식 혹은 전식이 없는 주문")
    void orderNotIncludeMainOrAppetizer() {
        final String input = "소주-5";
        final int visitNumber = 1;

        assertThrows(OrderException.class, () -> new Order(input, visitNumber));
    }

}
