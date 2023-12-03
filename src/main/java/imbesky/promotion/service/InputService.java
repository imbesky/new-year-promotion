package imbesky.promotion.service;

import imbesky.promotion.domain.dto.InputDto;
import imbesky.promotion.domain.input.Order;
import imbesky.promotion.domain.input.VisitDate;
import imbesky.promotion.domain.input.VisitNumber;
import imbesky.promotion.repository.DataRepository;
import org.springframework.stereotype.Service;

@Service
public class InputService {
    private final DataRepository repository;

    public InputService(DataRepository repository) {
        this.repository = repository;
    }

    public void save(final InputDto inputDto) {
        final VisitDate visitDate = saveVisitDate(inputDto.date());
        final VisitNumber visitNumber = saveVisitNumber(inputDto.number(), visitDate.isWeekend());
        saveOrder(inputDto.order(), visitNumber.getNumber());
    }

    private VisitDate saveVisitDate(final String input) {
        return repository.saveVisitDate(new VisitDate(input));
    }

    private VisitNumber saveVisitNumber(final int input, final boolean isWeekday) {
        return repository.saveVisitNumber(new VisitNumber(input, isWeekday));
    }

    private void saveOrder(final String order, final int visitNumber) {
        repository.saveOrder(new Order(order, visitNumber));
    }
}
