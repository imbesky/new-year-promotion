package imbesky.promotion.domain.promotion;

public interface Discount {

    boolean applicable();

    int value();
}
