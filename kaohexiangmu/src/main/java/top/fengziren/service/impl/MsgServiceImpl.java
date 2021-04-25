package top.fengziren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.fengziren.mapper.MsgMapper;
import top.fengziren.modol.Message;
import top.fengziren.modol.MessageSelect;
import top.fengziren.modol.MessageSend;
import top.fengziren.modol.Msg;
import top.fengziren.service.MessageService;
import top.fengziren.service.MsgService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MsgServiceImpl implements MsgService{
    @Autowired
    MessageService messageService;

    @Autowired
    MsgMapper msgMapper;
    @Override
    public String saveMessage(MessageSend messageSend) {
        /*
        * 1.创建message对象写入内容，添加时间
        *       保存，返回id
        * 2.创建List<Msg>对象写入信息，添加状态，删除状态
        *       写入中间表
        * */
        Message message = new Message();
        message.setTitle(messageSend.getTitle());
        message.setContent(messageSend.getContent());
        message.setMTime(new Date());
        messageService.saveMessage(message);
        if(message.getMId()<0){
            return "发送失败";
        }

        List<Msg> msgs = new ArrayList<>();
        for(Long sid : messageSend.getSidList()){
            Msg tempMsg = new Msg();
            tempMsg.setFId(messageSend.getFid());
            tempMsg.setSId(sid);
            tempMsg.setMId(message.getMId());
            tempMsg.setStatus(0);//默认0--》未读
            tempMsg.setDelStatus(0);//默认0--》都未删除
            msgs.add(tempMsg);
        }

        int flagMsg = msgMapper.saveListMsg(msgs);
        if(flagMsg<0){
            return "发送失败";
        }

        return "发送成功";
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public List<Msg> getMsgsByUidAndMid(Long uId, Long mId) {
        return msgMapper.getMsgsByUidAndMid(uId,mId);
    }

    @Override
    public void updateMsgDelstatus(Msg msg) {
        msgMapper.updateMsgDelstatus(msg);
    }

    @Override
    public void updateMsgStatusById(Long msgId) {
        msgMapper.updateMsgStatusById(msgId);
    }

    @Override
    public void updateMsgDelstatusBySid(Long sId, Long mId) {
        msgMapper.updateMsgDelstatusBySid(sId,mId);

    }
}
