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
    private Integer status;
    private String fName;
    private String sUserName;

}
