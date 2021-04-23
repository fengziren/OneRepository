package top.fengziren.service;

import top.fengziren.modol.Message;
import top.fengziren.modol.MessageSelect;
import top.fengziren.modol.MessageSend;

import java.util.List;

public interface MsgService {
    String saveMessage(MessageSend messageSend);

}
