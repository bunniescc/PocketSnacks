package cc.bunnies.pocketsnacks.service;

import cc.bunnies.pocketsnacks.model.User;
import cc.bunnies.pocketsnacks.util.MultiResult;

import java.util.List;

public interface UserService {
    MultiResult<User> login(String username, String password);

    int register(User user);

    List<User> getUsersByPage(int page, int size);
}
