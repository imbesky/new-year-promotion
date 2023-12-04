package imbesky.promotion.service;

import imbesky.promotion.domain.Benefit;
import imbesky.promotion.domain.dto.BenefitDto;
import imbesky.promotion.domain.dto.OrderDto;
import imbesky.promotion.domain.dto.VisitDateDto;
import imbesky.promotion.repository.DataRepository;
import org.springframework.stereotype.Service;

@Service
public class ResultService {

    private final DataRepository repository;

    public ResultService(DataRepository repository) {
        this.repository = repository;
    }

    public BenefitDto benefitResult() {
        return repository
                .saveBenefit(Benefit.of(repository.inquireVisitDate(), repository.inquireOrder()))
                .toDto();
    }

    public OrderDto orderResult() {
        return repository.inquireOrder()
                .toDto();
    }

    public VisitDateDto visitDateResult() {
        return repository.inquireVisitDate()
                .toDto();
    }
}
