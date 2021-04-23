package top.fengziren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fengziren.mapper.UserMapper;
import top.fengziren.modol.User;
import top.fengziren.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        return userMapper.getUserByUsernameAndPassword(username,password);
    }

    @Override
    public List<User> getUsers(String name) {
        if(null != name && !("".equals(name))){
            name = '%'+name+'%';
        }else {
            name = null;
        }
        return userMapper.getUsers(name);
    }

    @Override
    public Long saveUser(User user) {
        return userMapper.saveUser(user);
    }

    @Override
    public String getUsernameByUsername(String username) {
        return userMapper.getUsernameByUsername(username);
    }
}
