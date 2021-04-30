package top.fengziren.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.fengziren.mapper.MessageMapper;
import top.fengziren.modol.Message;
import top.fengziren.modol.MessageSelect;
import top.fengziren.modol.Msg;
import top.fengziren.service.MessageService;
import top.fengziren.service.MsgService;
import top.fengziren.tools.MyDateTools;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    MsgService msgService;
    @Override
    public Long saveMessage(Message message) {

        return messageMapper.saveMessage(message);
    }

    @Override
    public PageInfo<Message> getMessageByMessageSelect(int pageNum,int pageSize,MessageSelect messageSelect) {

        if(null == messageSelect.getStartTime() || "null".equals(messageSelect.getStartTime()) || "".equals(messageSelect.getStartTime())){
            messageSelect.setStartDateTime(null);
            messageSelect.setEndDateTime(null);
        }else if(null == messageSelect.getEndTime() || "null".equals(messageSelect.getEndTime()) || "".equals(messageSelect.getEndTime())){
            messageSelect.setStartDateTime(null);
            messageSelect.setEndDateTime(null);
        }else{
            messageSelect.setStartDateTime(MyDateTools.getCustomDate(messageSelect.getStartTime(),"start"));
            messageSelect.setEndDateTime(MyDateTools.getCustomDate(messageSelect.getEndTime(),"end"));
        }

        PageHelper.startPage(pageNum,pageSize);
        List<Message> messageList = messageMapper.getMessageByMessageSelect(messageSelect);
        return new PageInfo<>(messageList);
    }

    @Override
    public Message getMessageByUidAndMid(Long uId, Long mId) {
        Message message = messageMapper.getMessageByUidAndMid(uId,mId);

        return message;
    }
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public String delMessages(Long uId, List<Long> mIdList) {

        for (Long mId : mIdList) {
            List<Msg> msgList = msgService.getMsgsByUidAndMid(uId, mId);
            for (Msg msg : msgList) {
                if (0 == msg.getDelStatus() || 2 == msg.getDelStatus()) {
                    msgService.updateMsgDelstatus(msg);
                }
            }

        }
        return "删除成功";
    }

    @Override
    public PageInfo<Message> getMessageByMessageSelectShou(int pageNum,int pageSize,MessageSelect messageSelect) {
        if(null == messageSelect.getStartTime() || "null".equals(messageSelect.getStartTime()) || "".equals(messageSelect.getStartTime())){
            messageSelect.setStartDateTime(null);
            messageSelect.setEndDateTime(null);
        }else if(null == messageSelect.getEndTime() || "null".equals(messageSelect.getEndTime()) || "".equals(messageSelect.getEndTime())){
            messageSelect.setStartDateTime(null);
            messageSelect.setEndDateTime(null);
        }else{
            messageSelect.setStartDateTime(MyDateTools.getCustomDate(messageSelect.getStartTime(),"start"));
            messageSelect.setEndDateTime(MyDateTools.getCustomDate(messageSelect.getEndTime(),"end"));
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Message> messageList = messageMapper.getMessageByMessageSelectShou(messageSelect);
        return new PageInfo<>(messageList);

    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Message getMessageBySidAndMidShou(Long sId, Long mId) {
        Message message = messageMapper.getMessageBySidAndMidShou(sId,mId);
        if(message.getStatus().equals("0")) {
            msgService.updateMsgStatusById(message.getMsgId());
        }
        return message;
    }
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public String delMessageShou(Long sId, List<Long> mIdList) {
        for (Long mId : mIdList) {
           msgService.updateMsgDelstatusBySid(sId , mId);
        }
        return "删除成功";
    }
}
