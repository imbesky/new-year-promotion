package imbesky.promotion.constant;

public enum Membership {
    PLATINUM("백금", 50_000),
    GOLD("금", 20_000),
    SILVER("은", 10_000),
    BRONZE("동", 5_000);
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

    public static Membership target(final int price) {
        for (Membership membership : values()) {
            if (price >= membership.getStandardPrice()) {
                return membership;
            }
        }
        return null;
    }
}
