package top.fengziren.modol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long uId;
    private String userName;
    private String name;
    private String passWord;
    private String tel;
    private Date createTime;
    private String describe;
}
