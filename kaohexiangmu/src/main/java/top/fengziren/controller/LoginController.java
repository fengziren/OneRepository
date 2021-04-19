package top.fengziren.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fengziren.bean.User;

@Controller
public class LoginController {
    @RequestMapping("/")
    public String fun(){
        return "login";
    }
    @RequestMapping("/login")
    public String loginFun(User user){
        System.out.println(user.getUsername()+"****"+user.getPassword());
        return "main";
    }
    @RequestMapping("/register")
    public String regisFun(){
        return "register";
    }

}
