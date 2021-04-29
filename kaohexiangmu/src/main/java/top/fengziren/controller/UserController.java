package top.fengziren.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.fengziren.modol.User;
import top.fengziren.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/main")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("")
    public  String mianFun(String name, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "5") int pageSize, Model model){


        PageInfo<User> pageInfo = userService.getUsers(name,pageNum,pageSize);

        model.addAttribute("pageInfo",pageInfo);
        if(name != null && ""!=name){
            model.addAttribute("arg",name);
        }
        System.out.println(pageInfo);
        return "main/main";
    }



}
