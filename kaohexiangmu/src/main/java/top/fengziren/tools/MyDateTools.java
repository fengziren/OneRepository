package top.fengziren.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateTools {

    public static Date getNowDate(){
        Date nowdate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:MM");
        String str = simpleDateFormat.format(nowdate);
        System.out.println(str);



        return null;
    }
}
