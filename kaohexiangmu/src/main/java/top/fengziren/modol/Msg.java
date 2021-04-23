package top.fengziren.modol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Msg {
    private Long msgId;
//  发件人id
    private Long fId;
//  收件人id
    private Long sId;
//  消息id
    private Long mId;
//  消息状态
    private Integer status;
//  删除状态
    private Integer delStatus;

}
