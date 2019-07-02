package cc.bunnies.pocketsnacks.controller;

import cc.bunnies.pocketsnacks.model.User;
import cc.bunnies.pocketsnacks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/admin/user/list")
    public String userList(
            ModelMap modelMap,
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size
    ) {
        List<User> users = userService.getUsersByPage(page, size);
        modelMap.addAttribute("users", users);
        return "admin/user_list";
    }
}