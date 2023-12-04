package imbesky.promotion.constant;

import static imbesky.promotion.constant.Menu.SOJU;
import static imbesky.promotion.constant.Menu.SPRITE;
import static imbesky.promotion.constant.MenuType.MAIN;

public enum FreeGiftDetail {
    FIRST(SOJU, 100_000, MAIN, 1),
    SECOND(SPRITE, 50_000, MAIN, 1);
    public final static String FREE_GIFT = "증정 이벤트";
    private final Menu menu;
    private final int standardPrice;
    private final MenuType target;
    private final int number;

    FreeGiftDetail(Menu menu, int standardPrice, MenuType target, int number) {
        this.menu = menu;
        this.standardPrice = standardPrice;
        this.target = target;
        this.number = number;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getStandardPrice() {
        return standardPrice;
    }

    public MenuType getTarget() {
        return target;
    }

    public int getNumber() {
        return number;
    }

    public static FreeGiftDetail of(final int totalPrice) {
        for (FreeGiftDetail freeGift : values()) {
            if (totalPrice >= freeGift.standardPrice) {
                return freeGift;
            }
        }
        throw new IllegalStateException();
    }
}
