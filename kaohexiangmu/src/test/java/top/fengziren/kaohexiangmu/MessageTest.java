package top.fengziren.kaohexiangmu;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.fengziren.modol.Message;
import top.fengziren.modol.MessageSelect;
import top.fengziren.modol.MessageSend;
import top.fengziren.service.MessageService;
import top.fengziren.service.MsgService;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MessageTest {
    @Autowired
    MsgService msgService;
    @Autowired
    MessageService messageService;
    @Ignore
    @Test
    //发送消息
    //发送id,接收List<id>,title,content
    public void sendMessage(){
        MessageSend messageSend = new MessageSend();
        messageSend.setFid(Long.valueOf(1));
        List<Long> list = Arrays.asList(Long.valueOf(5),Long.valueOf(4),Long.valueOf(3),Long.valueOf(2));
        messageSend.setSidList(list);
        messageSend.setTitle("消息1");
        messageSend.setContent("消息1_3发送测试内容**********************\n消息1_3发送测试内容******************");
        System.out.println(messageSend.toString());
        String msg = msgService.saveMessage(messageSend);
        System.out.println(msg);

    }
    //查询消息
    @Ignore
    @Test
    /*
    * 参数：
    *   title，status，startTime----endTime
    * */
    public void selectMessage(){
        MessageSelect messageSelect = new MessageSelect();
        messageSelect.setFId(Long.valueOf(1));
//        messageSelect.setTitle("消息1");
        messageSelect.setStatus(0);
//        messageSelect.setStartTime(getCustomDate("2021-04-20 10:30"));
//        messageSelect.setEndTime(getCustomDate("2021-04-21 14:30"));

        List<Message> messageList = messageService.getMessageByMessageSelect(messageSelect);
        messageList.forEach(System.out::println);



    }

    /*
    * 查看消息
    * 参数：
    *   uId,mId
    * */
    @Ignore
    @Test
    public void  selectMessageParticulars(){
        Long uId = Long.valueOf(1);
        Long mId = Long.valueOf(22);
        Message message = messageService.getMessageByUidAndMid(uId,mId);
        System.out.println(message);



    }

    /*
    * 删除消息
    * 参数：
    * uId, List<mId>
    *
    * */
    public void  delMessages(){
        Long uId = Long.valueOf(1);
        List<Long> mIdList = Arrays.asList(Long.valueOf(5),Long.valueOf(4),Long.valueOf(3),Long.valueOf(2));
        String del = messageService.delMessages(uId,mIdList);
        System.out.println(del);



    }
    static Date getCustomDate(String time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date  date= simpleDateFormat.parse(time,new ParsePosition(0));
        return date;
    }
}
