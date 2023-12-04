package imbesky.promotion.constant;

import static imbesky.promotion.constant.Number.MINUS;

public enum Membership {
    PLATINUM("백금", 50_000),
    GOLD("금", 20_000),
    SILVER("은", 10_000),
    BRONZE("동", 5_000),
    NONE(Format.NONE, 0);
    private final String name;
    private final int standardPrice;

    Membership(String name, int standardPrice) {
        this.name = name;
        this.standardPrice = standardPrice;
    }

    public String getName() {
        return name;
    }

    public int getStandardPrice() {
        return standardPrice;
    }

    public static Membership of(final int price) {
        for (Membership membership : values()) {
            if (price * MINUS >= membership.getStandardPrice()) {
                return membership;
            }
        }
        throw new IllegalStateException();
    }
}
