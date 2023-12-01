package imbesky.promotion.constant;

import static imbesky.promotion.constant.MenuType.APPETIZER;
import static imbesky.promotion.constant.MenuType.DESSERT;
import static imbesky.promotion.constant.MenuType.DRINK;
import static imbesky.promotion.constant.MenuType.MAIN;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Menu {
    BIBIM_RICE("비빔밥", 12_000, APPETIZER),
    PUMPKIN_PORRIDGE("호박죽", 6_500, APPETIZER),
    CUCUMBER_SALAD("오이 무침", 4_000, APPETIZER),
    EEL_STEAK("장어 구이", 52_000, MAIN),
    BULGOGI("불고기", 36_000, MAIN),
    GALBI_STEW("갈비찜", 45_000, MAIN),
    NEW_YEAR_PLATTER("새해 특선", 60_000, MAIN),
    RICE_CAKE("떡", 12_000, DESSERT),
    YAKGWA("약과", 5_000, DESSERT),
    PEAR_JUICE("배즙", 5_000, DRINK),
    SPRITE("스프라이트", 3_000, DRINK),
    WHITE_WINE("화이트 와인", 55_000, DRINK),
    SOJU("소주", 4_000, DRINK);

    public static final int MIN_ORDER = 1;
    public static final int MAX_ORDER = 10;
    private final static Map<String, Menu> menus = Collections.unmodifiableMap(Stream
            .of(values())
            .collect(Collectors
                    .toMap(Menu::getName, Menu -> Menu)));
    private final String name;
    private final int price;
    private final MenuType type;

    Menu(String name, int price, MenuType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public MenuType getType() {
        return type;
    }

    public static Menu findByName(final String name) {
        return menus.get(name);
    }
}
