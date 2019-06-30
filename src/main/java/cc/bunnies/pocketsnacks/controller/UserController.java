package cc.bunnies.pocketsnacks.controller;

import cc.bunnies.pocketsnacks.dao.UserDao;
import cc.bunnies.pocketsnacks.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping("/user/list")
    public String list(ModelMap modelMap) {
        List<User> users = userDao.getAllUser();  //获取所有用户
        modelMap.addAttribute("users", users);  //将数据传递给view
        return "user_list";  //view 的名字
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String add(ModelMap modelMap, @RequestParam String username, @RequestParam String password) {
        User user = User.builder().username(username).password(password).build();
        int uid = userDao.insert(user);
        if (uid <= 0) {
            modelMap.addAttribute("err_msg", "插入出错");
        }
        List<User> users = userDao.getAllUser();
        modelMap.addAttribute("users", users);
        return "user_list";
    }
}