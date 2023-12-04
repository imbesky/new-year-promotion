package imbesky.promotion.controller;

import static imbesky.promotion.constant.Date.PROMOTION_END_DATE;
import static imbesky.promotion.constant.Date.PROMOTION_START_DATE;
import static imbesky.promotion.constant.Format.DATE_FORMAT;
import static imbesky.promotion.constant.InputMessage.DATE_LABEL;
import static imbesky.promotion.constant.InputMessage.DATE_NOTICE;
import static imbesky.promotion.constant.InputMessage.GREETING;
import static imbesky.promotion.constant.InputMessage.MENU_BOARD;
import static imbesky.promotion.constant.InputMessage.MENU_NAME;
import static imbesky.promotion.constant.InputMessage.MENU_PRICE;
import static imbesky.promotion.constant.InputMessage.NUMBER_LABEL;
import static imbesky.promotion.constant.InputMessage.NUMBER_NOTICE;
import static imbesky.promotion.constant.InputMessage.ORDER_FORMAT_EXAMPLE;
import static imbesky.promotion.constant.InputMessage.ORDER_LABEL;
import static imbesky.promotion.constant.InputMessage.ORDER_NOTICE;
import static imbesky.promotion.constant.InputMessage.SUBMIT;
import static imbesky.promotion.constant.Menu.MENUS;
import static imbesky.promotion.constant.Number.ORDER_MAX;
import static imbesky.promotion.constant.Number.ORDER_MIN;
import static imbesky.promotion.constant.Number.VISIT_NUMBER_MIN;
import static imbesky.promotion.constant.Number.VISIT_NUMBER_WEEKDAY_MAX;
import static imbesky.promotion.constant.Number.VISIT_NUMBER_WEEKEND_MAX;
import static imbesky.promotion.constant.Url.ERROR_PAGE;
import static imbesky.promotion.constant.Url.REDIRECT;

import imbesky.promotion.domain.dto.InputDto;
import imbesky.promotion.service.InputService;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class InputController {
    private final InputService inputService;

    public InputController(InputService inputService) {
        this.inputService = inputService;
    }

    @GetMapping("/")
    public String index() {
        return REDIRECT.concat("input");
    }

    @GetMapping("/input")
    public void visit(final Model model) {
        model.addAttribute("greeting", GREETING);

        model.addAttribute("dateLabel", DATE_LABEL);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        model.addAttribute("dateNotice",
                String.format(DATE_NOTICE,
                        formatter.format(PROMOTION_START_DATE),
                        formatter.format(PROMOTION_END_DATE)));

        model.addAttribute("numberLabel", NUMBER_LABEL);
        model.addAttribute("numberNotice",
                String.format(NUMBER_NOTICE, VISIT_NUMBER_MIN, VISIT_NUMBER_WEEKDAY_MAX, VISIT_NUMBER_WEEKEND_MAX));

        model.addAttribute("menuBoard", MENU_BOARD);
        model.addAttribute("menus", MENUS);
        model.addAttribute("menuName", MENU_NAME);
        model.addAttribute("menuPrice", MENU_PRICE);

        model.addAttribute("orderLabel", ORDER_LABEL);
        model.addAttribute("orderFormat", ORDER_FORMAT_EXAMPLE);
        model.addAttribute("orderNotice",
                String.format(ORDER_NOTICE, ORDER_MIN, ORDER_MAX));

        model.addAttribute("submit", SUBMIT);
    }

    @GetMapping("/enter")
    public String visitInput(final InputDto inputDto, final RedirectAttributes redirectAttributes) {
        try {
            inputService.save(inputDto);
            return REDIRECT.concat("result");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addAttribute("detail", e.getMessage());
            return REDIRECT.concat(ERROR_PAGE);
        }
    }

}
