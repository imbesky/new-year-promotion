package imbesky.promotion.repository;

import imbesky.promotion.domain.Order;
import imbesky.promotion.domain.VisitDate;
import imbesky.promotion.domain.VisitNumber;
import org.springframework.stereotype.Repository;

@Repository
public class DataRepository {
    // 데이터베이스 연동 없이 구현
    private VisitDate visitDate;
    private VisitNumber visitNumber;
    private Order order;

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

    public VisitDate inquireVisitDate() {
        return visitDate;
    }

    public VisitNumber inquireVisitNumber() {
        return visitNumber;
    }

    public Order inquireOrder() {
        return order;
    }

}
