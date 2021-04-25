package top.fengziren.controller;


import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fengziren.modol.User;
import top.fengziren.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public String helloFun(){
        return "/login";
    }

    @PostMapping("/login")
    public String loginFun(String userName,
                           String passWord,
                           HttpSession session){
        User user = userService.getUserByUsernameAndPassword(userName,passWord);
        if(null != user) {
            session.setAttribute("user",user);
            System.out.println(user.getUserName() + "****" + user.getPassWord());
            return "redirect:/main";
        }
        return "redirect:/";
    }
    @RequestMapping("/login/register")
    public String regisFun(){
        return "/register";
    }
    @PostMapping("/login/register/submit")
    public String regisSubmit(User user){
        String username = userService.getUsernameByUsername(user.getUserName());
        if(null != username && !("".equals(username))){
            System.out.println("已存在！！！");
            return "/register";
        }
        user.setCreateTime(new Date());
        System.out.println(user.toString());
        Long targt =  userService.saveUser(user);
        if(targt>0){
            return "/login";
        }else {
            return "/register";
        }
    }

    @RequestMapping("/main")
    public String jumpMian(){
        return "/main/main";
    }

}
