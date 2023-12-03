package imbesky.promotion.service;

import imbesky.promotion.domain.Benefit;
import imbesky.promotion.domain.dto.BenefitDto;
import imbesky.promotion.repository.DataRepository;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {

    private final DataRepository repository;

    public PromotionService(DataRepository repository) {
        this.repository = repository;
    }

    public BenefitDto result() {
        return repository
                .saveBenefit(Benefit.of(repository.inquireVisitDate(), repository.inquireOrder()))
                .toDto();
    }
}
