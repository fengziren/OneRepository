package top.fengziren.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.fengziren.modol.Message;
import top.fengziren.modol.MessageSelect;
import top.fengziren.modol.User;
import top.fengziren.service.MessageService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/main")
public class ShouMessageController {
    @Autowired
    MessageService messageService;
    @RequestMapping("/shoumsg")
    public String selectMessageShou(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
            MessageSelect messageSelect, HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        messageSelect.setSId(user.getUId());
        session.setAttribute("arg",messageSelect);
        PageInfo<Message> messageList = messageService.getMessageByMessageSelectShou(pageNum,pageSize,messageSelect);
        model.addAttribute("pageInfo",messageList);
//        System.out.println(messageList.toString());
        return "main/shouMessage";


    }
    @RequestMapping("/shoumsg/selParticulars")
    @ResponseBody
    public Message  selectMessageParticulars(Long mId,HttpSession session){
        User user = (User) session.getAttribute("user");
        Message message = messageService.getMessageBySidAndMidShou(user.getUId(),mId);
        return message;
    }
    @RequestMapping("/shoumsg/delmsg")
    public String  delMessages(@RequestParam("midList") List<Long> midList ,HttpSession session){
        User user = (User) session.getAttribute("user");
        String del = messageService.delMessageShou(user.getUId(),midList);
        System.out.println(del);
        return "redirect:/main/shoumsg";


    }
}
