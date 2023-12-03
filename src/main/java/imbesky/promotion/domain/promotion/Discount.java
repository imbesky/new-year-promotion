package imbesky.promotion.domain.promotion;

public interface Discount {

    boolean applicable();

    String type();

    int value();
}
