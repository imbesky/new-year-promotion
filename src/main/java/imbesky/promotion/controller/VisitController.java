package imbesky.promotion.controller;

import static imbesky.promotion.constant.Date.PROMOTION_END_DATE;
import static imbesky.promotion.constant.Date.PROMOTION_START_DATE;
import static imbesky.promotion.constant.Format.DATE_FORMAT;
import static imbesky.promotion.constant.Format.DATE_LABEL;
import static imbesky.promotion.constant.Format.DATE_NOTICE;
import static imbesky.promotion.constant.Format.NUMBER_LABEL;
import static imbesky.promotion.constant.Format.NUMBER_NOTICE;
import static imbesky.promotion.constant.Url.ERROR_PAGE;
import static imbesky.promotion.constant.Url.REDIRECT;
import static imbesky.promotion.domain.VisitNumber.MIN;
import static imbesky.promotion.domain.VisitNumber.WEEKDAY_MAX;
import static imbesky.promotion.domain.VisitNumber.WEEKEND_MAX;

import imbesky.promotion.domain.dto.VisitDto;
import imbesky.promotion.service.VisitService;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class VisitController {
    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping("/visit")
    public void visit(final Model model) {
        model.addAttribute("dateLabel", DATE_LABEL);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        model.addAttribute("dateNotice",
                String.format(DATE_NOTICE,
                        formatter.format(PROMOTION_START_DATE),
                        formatter.format(PROMOTION_END_DATE)));
        model.addAttribute("numberLabel", NUMBER_LABEL);
        model.addAttribute("numberNotice",
                String.format(NUMBER_NOTICE, MIN, WEEKDAY_MAX, WEEKEND_MAX));
    }

    @GetMapping("/visit-input")
    public String visitInput(final VisitDto visitDto, final RedirectAttributes redirectAttributes) {
        try {
            visitService.saveVisit(visitDto);
            return REDIRECT.concat("order");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addAttribute("message", e.getMessage());
            return ERROR_PAGE;
        }
    }
}
