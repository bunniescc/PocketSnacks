package cc.bunnies.pocketsnacks.controller;

import cc.bunnies.pocketsnacks.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @RequestMapping("/")
    @ResponseBody
    String index() {
        return "Hello World";
    }
}
