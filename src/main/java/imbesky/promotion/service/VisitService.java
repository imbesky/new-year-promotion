package imbesky.promotion.service;

import imbesky.promotion.domain.Visit;
import imbesky.promotion.domain.dto.VisitDto;
import imbesky.promotion.repository.DataRepository;
import org.springframework.stereotype.Service;

@Service
public class VisitService {
    private final DataRepository repository;

    public VisitService(DataRepository repository) {
        this.repository = repository;
    }

    public void saveVisit(final VisitDto visitDto) {
        repository.save(Visit.from(visitDto));
    }
}
