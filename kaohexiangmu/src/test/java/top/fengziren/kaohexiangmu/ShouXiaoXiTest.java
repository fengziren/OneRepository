package top.fengziren.kaohexiangmu;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.fengziren.modol.Message;
import top.fengziren.modol.MessageSelect;
import top.fengziren.service.MessageService;

import java.util.Arrays;
import java.util.List;


/*
* 收消息测试类
* */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ShouXiaoXiTest {
    @Autowired
    MessageService messageService;


    //查询消息
    @Ignore
    @Test
    /*
     * 参数：
     *   title，status，startTime----endTime
     * */
    public void selectMessageShou(){
        MessageSelect messageSelect = new MessageSelect();
        messageSelect.setSId(Long.valueOf(3));
//        messageSelect.setTitle("消息1");
        messageSelect.setStatus(1);
//        messageSelect.setStartTime(getCustomDate("2021-04-20 10:30"));
//        messageSelect.setEndTime(getCustomDate("2021-04-21 14:30"));

        List<Message> messageList = messageService.getMessageByMessageSelectShou(messageSelect);
        messageList.forEach(System.out::println);



    }
    /*
     * 查看消息
     * 参数：
     *   sId,mId
     * */
    @Ignore
    @Test
    public void  selectMessageParticulars(){
        Long sId = Long.valueOf(3);
        Long mId = Long.valueOf(18);
        Message message = messageService.getMessageBySidAndMidShou(sId,mId);
        System.out.println(message);

    }
    /*
     * 删除消息
     * 参数：
     * sId, List<mId>
     *
     * */
//    @Ignore
    @Test
    public void  delMessages(){
        Long sId = Long.valueOf(3);
        List<Long> mIdList = Arrays.asList(Long.valueOf(21),Long.valueOf(22),Long.valueOf(23),Long.valueOf(12));
        String del = messageService.delMessageShou(sId,mIdList);
        System.out.println(del);



    }



}
