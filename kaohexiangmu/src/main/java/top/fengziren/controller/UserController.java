package top.fengziren.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fengziren.modol.User;
import top.fengziren.service.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/users")
    public String selectUsers(String name){
        List<User> users = userService.getUsers(name);

        return null;
    }


}
