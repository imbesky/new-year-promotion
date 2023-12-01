package imbesky.promotion.constant;

public enum MenuType {
    APPETIZER("전식"),
    MAIN("본식"),
    DESSERT("디저트"),
    DRINK("음료");
    private final String name;

    MenuType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
