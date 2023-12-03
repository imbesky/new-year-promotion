package imbesky.promotion.domain.promotion;

import imbesky.promotion.constant.Menu;
import java.util.Map;

public interface FreeGift {
    boolean applicable();

    Map<Menu, Integer> result();
}
