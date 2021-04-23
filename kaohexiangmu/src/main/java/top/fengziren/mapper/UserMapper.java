package top.fengziren.mapper;

import org.apache.ibatis.annotations.Param;
import top.fengziren.modol.User;

import java.util.List;

public interface UserMapper {
    User getUserByUsernameAndPassword(@Param("username") String username,@Param("password") String password);

    List<User> getUsers(@Param("name") String name);

    String getUsernameByUsername(String username);

    Long saveUser(User user);
}
