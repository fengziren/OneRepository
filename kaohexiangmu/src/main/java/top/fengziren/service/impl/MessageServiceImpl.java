package top.fengziren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fengziren.mapper.MessageMapper;
import top.fengziren.modol.Message;
import top.fengziren.modol.MessageSelect;
import top.fengziren.service.MessageService;
import top.fengziren.service.MsgService;

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
    public List<Message> getMessageByMessageSelect(MessageSelect messageSelect) {

        List<Message> messageList = messageMapper.getMessageByMessageSelect(messageSelect);
        Integer status = messageSelect.getStatus();

        Iterator<Message> iterator = messageList.iterator();
//        未读
        if(0 == status) {
            while (iterator.hasNext()) {
                Message message = iterator.next();
                if(message.getCount() > 1){
                    iterator.remove();
                }else if(message.getSum() > 0){
                    iterator.remove();
                }
            }
        }
//        已读
        if(1 == status) {
            while (iterator.hasNext()) {
                Message message = iterator.next();
                if(message.getCount() > 1){
                    iterator.remove();
                }else if(0 == message.getSum()){
                    iterator.remove();
                }
            }
        }
//        部分已读
        if(2 == status) {
            while (iterator.hasNext()) {
                if( 1 == iterator.next().getCount()){
                    iterator.remove();
                }
            }
        }
        return messageList;
    }

    @Override
    public Message getMessageByUidAndMid(Long uId, Long mId) {
        Message message = messageMapper.getMessageByUidAndMid(uId,mId);
        if(null != message){

        }

        return message;
    }

    @Override
    public String delMessages(Long uId, List<Long> mIdList) {








        if(1==1){
            return "删除失败";
        }
        return "删除成功";
    }
}
