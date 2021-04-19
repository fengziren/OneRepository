package top.fengziren.bean;

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
    private long uid;
    private String username;
    private String password;
    private String tel;
    private Date createtime;
    private Date updatetime;
    private String describe;
}
