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
    private Long sId;
    private String title;
    private Integer status;
    private String startTime;
    private String endTime;
}
