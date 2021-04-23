package top.fengziren.mapper;

import org.apache.ibatis.annotations.Param;
import top.fengziren.modol.Msg;

import java.util.List;

public interface MsgMapper {
    int saveListMsg(List<Msg> msgs);

    List<Msg> getMsgsByUidAndMid(@Param("uId") Long uId, @Param("mId") Long mId);

    void updateMsgDelstatus(Msg msg);
}
