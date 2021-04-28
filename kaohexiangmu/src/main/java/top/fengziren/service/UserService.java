package top.fengziren.service;

import com.github.pagehelper.PageInfo;
import top.fengziren.modol.User;

import java.util.List;

public interface UserService {
    User getUserByUsernameAndPassword(String username, String password);

    PageInfo getUsers(String name,int pageNum, int pageSize);

    String getUsernameByUsername(String username);

    Long saveUser(User user);

    List<User> getUserEXid(Long uId);
}
