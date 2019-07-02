package cc.bunnies.pocketsnacks.service.impl;

import cc.bunnies.pocketsnacks.dao.UserDao;
import cc.bunnies.pocketsnacks.model.User;
import cc.bunnies.pocketsnacks.service.UserService;
import cc.bunnies.pocketsnacks.util.MultiResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public MultiResult<User> login(String username, String password) {
        User user = userDao.getUserByUsername(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return new MultiResult<>(null, user);
            } else {
                return new MultiResult<>("密码错误", null);
            }
        } else {
            return new MultiResult<>("用户名不存在", null);
        }
    }

    @Override
    public int register(User user) {
        User u = userDao.getUserByUsername(user.getUsername());
        if (u != null) {
            return -1;//用户名已存在
        } else {
            int uid = userDao.create(user);
            return uid > 0 ? uid : -2;
        }
    }

    @Override
    public List<User> getUsersByPage(int page, int size) {
        return userDao.getUsersByPage((page - 1) * size, size);
    }
}