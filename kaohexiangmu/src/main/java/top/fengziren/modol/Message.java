package top.fengziren.modol;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private Long mId;
    private String title;
    private String content;
    private Date mTime;

    //非表属性
    private Long msgId;
    private String fName;
    private String sUserName;
    private String status;
/*//    去重后的条数1表示未读或已读；大于1表示部分已读
    private Integer count;
//    status的和；count=1--->sum=0表示未读；sum>0表示已读；
//    status的和；count>1--->忽略sum；
    private Integer sum;*/

}
