package imbesky.promotion.controller;

import static imbesky.promotion.constant.Url.REDIRECT;
import static imbesky.promotion.constant.Url.REDIRECT_NOTICE;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

@Controller
public class ErrorController {
    @GetMapping("/error")
    public void error(@RequestAttribute("message") final String message, final Model model) {
        model.addAttribute("message", message);
        model.addAttribute("redirect", REDIRECT);
        model.addAttribute("redirectNotice", REDIRECT_NOTICE);
    }
}
