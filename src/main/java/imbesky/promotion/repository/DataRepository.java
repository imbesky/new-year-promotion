package imbesky.promotion.repository;

import imbesky.promotion.domain.Benefit;
import imbesky.promotion.domain.input.Order;
import imbesky.promotion.domain.input.VisitDate;
import imbesky.promotion.domain.input.VisitNumber;
import org.springframework.stereotype.Repository;

@Repository
public class DataRepository {
    // 데이터베이스 연동 없이 구현
    private VisitDate visitDate;
    private VisitNumber visitNumber;
    private Order order;
    private Benefit benefit;

    public VisitDate saveVisitDate(final VisitDate visitDate) {
        this.visitDate = visitDate;
        return visitDate;
    }

    public VisitNumber saveVisitNumber(final VisitNumber visitNumber) {
        this.visitNumber = visitNumber;
        return visitNumber;
    }

    public Order saveOrder(final Order order) {
        this.order = order;
        return order;
    }

    public Benefit saveBenefit(final Benefit benefit) {
        this.benefit = benefit;
        return benefit;
    }

    public VisitDate inquireVisitDate() {
        return visitDate;
    }

    public VisitNumber inquireVisitNumber() {
        return visitNumber;
    }

    public Order inquireOrder() {
        return order;
    }

    public Benefit inquireBenefit() {
        return benefit;
    }

}
