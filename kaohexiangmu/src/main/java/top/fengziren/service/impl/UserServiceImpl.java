package top.fengziren.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo<User> getUsers(String name,int pageNum, int pageSize) {

            PageHelper.startPage(pageNum,pageSize);
            List<User> users = userMapper.getUsers(name);



        return new PageInfo<User>(users);
    }

    @Override
    public Long saveUser(User user) {
        return userMapper.saveUser(user);
    }

    @Override
    public List<User> getUserEXid(Long uId) {
        return userMapper.getUserEXid(uId);
    }

    @Override
    public String getUsernameByUsername(String username) {
        return userMapper.getUsernameByUsername(username);
    }
}
