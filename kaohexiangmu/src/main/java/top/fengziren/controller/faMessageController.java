package top.fengziren.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    //    查询消息
    @RequestMapping("/famsg")
    public String faMain(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "3") int pageSize,
            MessageSelect messageSelect, HttpSession session, Model model){

            User user = (User) session.getAttribute("user");
            messageSelect.setFId(user.getUId());
            System.out.println(messageSelect);
            session.setAttribute("arg",messageSelect);
            PageInfo<Message> messageList = messageService.getMessageByMessageSelect(pageNum,pageSize,messageSelect);
            model.addAttribute("pageInfo",messageList);

        return "main/faMessage";
    }

}
