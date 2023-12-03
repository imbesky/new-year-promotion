package imbesky.promotion.constant;

import static imbesky.promotion.constant.Date.DDAY_EVENT_END_DATE;
import static imbesky.promotion.constant.Date.PROMOTION_END_DATE;
import static imbesky.promotion.constant.Date.PROMOTION_START_DATE;

import java.time.LocalDate;

public enum DiscountDetail {
    LUNAR_NEW_YEAR_DDAY(PROMOTION_START_DATE, DDAY_EVENT_END_DATE, 1_000, 100, 0),
    WEEKDAY(PROMOTION_START_DATE, PROMOTION_END_DATE, 0, 0, 0.2F),
    WEEKEND(PROMOTION_START_DATE, PROMOTION_END_DATE, 0, 0, 0.05F),
    SPECIAL(PROMOTION_START_DATE, PROMOTION_END_DATE, 2_024, 0, 0);

    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int priceDefault;
    private final int priceUnit;
    private final float ratio;

    DiscountDetail(LocalDate startDate, LocalDate endDate, int priceDefault, int priceUnit, float ratio) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceDefault = priceDefault;
        this.priceUnit = priceUnit;
        this.ratio = ratio;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getPriceDefault() {
        return priceDefault;
    }

    public int getPriceUnit() {
        return priceUnit;
    }

    public float getRatio() {
        return ratio;
    }
}
