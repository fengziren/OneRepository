package top.fengziren.service;

import com.github.pagehelper.PageInfo;
import top.fengziren.modol.Message;
import top.fengziren.modol.MessageSelect;

import java.util.List;

public interface MessageService {
    Long saveMessage(Message message);

    PageInfo<Message> getMessageByMessageSelect(int pageNum,int  pageSize,MessageSelect messageSelect);

    Message getMessageByUidAndMid(Long uId, Long mId);

    String delMessages(Long uId, List<Long> mIdList);

    List<Message> getMessageByMessageSelectShou(MessageSelect messageSelect);

    Message getMessageBySidAndMidShou(Long sId, Long mId);

    String delMessageShou(Long sId, List<Long> mIdList);
}
