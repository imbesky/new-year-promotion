package imbesky.promotion.controller;

import static imbesky.promotion.constant.Url.REDIRECT;
import static imbesky.promotion.constant.Url.REDIRECT_NOTICE;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ErrorController {
    @GetMapping("/exception")
    public void handleError(@RequestParam("detail") final String detail, final Model model) {
        model.addAttribute("detail", detail);
        model.addAttribute("redirect", REDIRECT);
        model.addAttribute("redirectNotice", REDIRECT_NOTICE);
    }
}
