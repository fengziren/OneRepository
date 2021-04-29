package top.fengziren.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.fengziren.modol.Message;
import top.fengziren.modol.MessageSelect;
import top.fengziren.modol.MessageSend;
import top.fengziren.modol.User;
import top.fengziren.service.MessageService;
import top.fengziren.service.MsgService;
import top.fengziren.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/main")
public class FaMessageController {
    @Autowired
    MessageService messageService;
    @Autowired
    UserService userService;
    @Autowired
    MsgService msgService;
    //    查询消息
    @GetMapping("/famsg")
    public String faMain(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
            MessageSelect messageSelect, HttpSession session, Model model){

            User user = (User) session.getAttribute("user");
            messageSelect.setFId(user.getUId());
            System.out.println(messageSelect);
            session.setAttribute("arg",messageSelect);
            PageInfo<Message> messageList = messageService.getMessageByMessageSelect(pageNum,pageSize,messageSelect);
            model.addAttribute("pageInfo",messageList);

        return "main/faMessage";
    }
    @PostMapping("/famsg")
    public String faMessage(MessageSend messageSend,HttpSession session) {
        //发送消息
        //发送id,接收List<id>,title,content
        User user = (User) session.getAttribute("user");

        messageSend.setFid(user.getUId());
        String msg = msgService.saveMessage(messageSend);
        System.out.println(msg);
        return "redirect:/main/famsg";
    }

    @ResponseBody
    @RequestMapping("/famsg/users")
    public List<User> getUserEXid(HttpSession session){
        User user = (User) session.getAttribute("user");
        List<User> users = userService.getUserEXid(user.getUId());
        return users;
    }

    @ResponseBody
    @RequestMapping("/famsg/selParticulars")
    public Message  selectMessageParticulars(Long mId,HttpSession session){
        User user = (User) session.getAttribute("user");
        Message message = messageService.getMessageByUidAndMid(user.getUId(),mId);
        System.out.println(message);
        return message;


    }
    @RequestMapping("/famsg/delmsg")
    public String delMessage(@RequestParam("midList") List<Long> midList,HttpSession session){
        User user = (User) session.getAttribute("user");
//        System.out.println(midList.toString());
        String del = messageService.delMessages(user.getUId(),midList);
        System.out.println(del);
        return "redirect:/main/famsg";
    }
}
