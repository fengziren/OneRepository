package top.fengziren.service;

import top.fengziren.modol.User;

import java.util.List;

public interface UserService {
    User getUserByUsernameAndPassword(String username, String password);

    List<User> getUsers(String name);

    String getUsernameByUsername(String username);

    Long saveUser(User user);
}
