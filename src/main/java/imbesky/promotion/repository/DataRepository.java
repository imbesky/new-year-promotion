package imbesky.promotion.repository;

import imbesky.promotion.domain.Visit;
import org.springframework.stereotype.Repository;

@Repository
public class DataRepository {
    // 데이터베이스 연동 없이 구현
    private Visit visit;

    public void save(final Visit visit) {
        this.visit = visit;
    }

    public Visit inquireVisit() {
        return visit;
    }

}
