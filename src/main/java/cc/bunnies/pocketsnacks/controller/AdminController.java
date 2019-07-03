package cc.bunnies.pocketsnacks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @RequestMapping(value = {"/admin", "/admin/index"})
    public String index() {
        return "admin/index";
    }
}
