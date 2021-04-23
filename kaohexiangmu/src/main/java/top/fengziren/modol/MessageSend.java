package top.fengziren.modol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class MessageSend {


    private Long fid;
    private List<Long> sidList;
    private String title;
    private String content;
}
