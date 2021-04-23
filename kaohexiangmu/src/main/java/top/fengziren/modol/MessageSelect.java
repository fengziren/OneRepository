package top.fengziren.modol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MessageSelect {
    private Long fId;
    private String title;
    private Integer status;
    private Date startTime;
    private Date endTime;
}
