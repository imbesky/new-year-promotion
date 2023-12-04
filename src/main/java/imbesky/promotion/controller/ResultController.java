package imbesky.promotion.controller;

import static imbesky.promotion.constant.Format.BENEFIT_FORMAT;
import static imbesky.promotion.constant.Format.FREE_GIFT_FORMAT;
import static imbesky.promotion.constant.Format.ORDER_FORMAT;
import static imbesky.promotion.constant.Format.WON;
import static imbesky.promotion.constant.ResultMessage.BENEFIT_DETAIL;
import static imbesky.promotion.constant.ResultMessage.FREE_GIFT;
import static imbesky.promotion.constant.ResultMessage.HEADER;
import static imbesky.promotion.constant.ResultMessage.MEMBERSHIP;
import static imbesky.promotion.constant.ResultMessage.ORDER;
import static imbesky.promotion.constant.ResultMessage.PURCHASE_PRICE;
import static imbesky.promotion.constant.ResultMessage.RESULT_NOTICE;
import static imbesky.promotion.constant.ResultMessage.TOTAL_BENEFIT;
import static imbesky.promotion.constant.ResultMessage.TOTAL_PRICE;

import imbesky.promotion.constant.Format;
import imbesky.promotion.domain.dto.BenefitDto;
import imbesky.promotion.domain.dto.OrderDto;
import imbesky.promotion.domain.dto.VisitDateDto;
import imbesky.promotion.service.ResultService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResultController {
    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/result")
    public void result(final Model model) {
        final VisitDateDto visitDate = resultService.visitDateResult();
        final OrderDto order = resultService.orderResult();
        final BenefitDto benefit = resultService.benefitResult();

        model.addAttribute("order", order);
        model.addAttribute("benefit", benefit);

        model.addAttribute("none", Format.NONE);
        model.addAttribute("orderFormat", ORDER_FORMAT);
        model.addAttribute("freeGiftFormat", FREE_GIFT_FORMAT);
        model.addAttribute("benefitFormat", BENEFIT_FORMAT);
        model.addAttribute("won", WON);

        model.addAttribute("resultNotice",
                String.format(RESULT_NOTICE, visitDate.month(), visitDate.date()));
        model.addAttribute("orderHeader",
                String.format(HEADER, ORDER));
        model.addAttribute("totalPriceHeader",
                String.format(HEADER, TOTAL_PRICE));
        model.addAttribute("freeGiftHeader",
                String.format(HEADER, FREE_GIFT));
        model.addAttribute("benefitHeader",
                String.format(HEADER, BENEFIT_DETAIL));
        model.addAttribute("totalBenefitPriceHeader",
                String.format(HEADER, TOTAL_BENEFIT));
        model.addAttribute("purchasePriceHeader",
                String.format(HEADER, PURCHASE_PRICE));
        model.addAttribute("membershipHeader",
                String.format(HEADER, MEMBERSHIP));
    }
}
