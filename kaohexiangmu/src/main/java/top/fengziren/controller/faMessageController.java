package top.fengziren.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fengziren.modol.Message;
import top.fengziren.modol.MessageSelect;
import top.fengziren.modol.User;
import top.fengziren.service.MessageService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/main")
public class faMessageController {
    @Autowired
    MessageService messageService;
    //    发消息
    @RequestMapping("/famsg")
    public String faMain(MessageSelect messageSelect, HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        messageSelect.setFId(user.getUId());
        System.out.println(messageSelect.getStartTime());
        PageInfo<Message> messageList = messageService.getMessageByMessageSelect(messageSelect);
        model.addAttribute("pageInfo",messageList);
        model.addAttribute("status",messageSelect.getStatus());
        return "main/faMessage";
    }

}
