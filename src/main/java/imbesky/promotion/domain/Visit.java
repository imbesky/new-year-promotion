package imbesky.promotion.domain;

import imbesky.promotion.domain.dto.VisitDto;

public class Visit {
    private final VisitDate date;
    private final VisitNumber number;

    private Visit(final VisitDate date, final VisitNumber number) {
        this.date = date;
        this.number = number;
    }

    public static Visit from(final VisitDto visitDto) {
        final VisitDate date = new VisitDate(visitDto.date());
        return new Visit(date, new VisitNumber(visitDto.number(), date.isWeekday()));
    }
}
