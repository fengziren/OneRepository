package top.fengziren.mapper;

import org.apache.ibatis.annotations.Param;
import top.fengziren.modol.Message;
import top.fengziren.modol.MessageSelect;

import java.util.List;

public interface MessageMapper {
    long saveMessage(Message message);

    List<Message> getMessageByMessageSelect(MessageSelect messageSelect);

    Message getMessageByUidAndMid(@Param("uId") Long uId, @Param("mId") Long mId);


}
