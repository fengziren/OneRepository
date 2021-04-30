package top.fengziren.controller;

import com.github.pagehelper.PageInfo;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.fengziren.modol.*;
import top.fengziren.service.MessageService;
import top.fengziren.service.MsgService;
import top.fengziren.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

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
    @RequestMapping("/famsg/delmsgAjax")
    @ResponseBody
    public String delMessageAjax(@RequestParam("midList") List<Long> midList,HttpSession session){
        User user = (User) session.getAttribute("user");
//        System.out.println(midList.toString());
        String del = messageService.delMessages(user.getUId(),midList);
        System.out.println(del);
        return del;
    }

    /*     url: "图片地址",
         alt: "图片文字说明",
         href: "跳转链接"*/
    @ResponseBody
    @RequestMapping(value = "/famsg/upload-img" , produces="application/json;charset=utf-8")
    public EditorResult upload(MultipartFile upImg){
        //工具类对象
        EditorResult er = new EditorResult();
        er.setErrno(1);
        //获取文件地址
        String basepath = "E:\\JavaStudy\\OneRepository\\kaohexiangmu\\src\\main\\resources\\static\\img";
        String imgname = UUID.randomUUID().toString();
        //文件后缀名
        String suffix = upImg.getOriginalFilename().substring(upImg.getOriginalFilename().lastIndexOf("."));
        //文件保存
        try {
            upImg.transferTo(new File(basepath+"/"+imgname+suffix));
            //上传成功修改errno错误状态,返回路径
            er.setErrno(0);
            er.setData(new String[]{"/img/"+imgname+suffix});
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回类型是固定的，这里需要一个工具类
        return er;
    }

}
