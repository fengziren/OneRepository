package top.fengziren.tools;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateTools {


   public static Date getCustomDate(String time,String status){
       if("start".equals(status)){
           time += " 00:00";
       }else{
           time += " 24:00";
       }
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
       Date date = simpleDateFormat.parse(time,new ParsePosition(0));
       return date;
    }
}
