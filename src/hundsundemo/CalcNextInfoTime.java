package hundsundemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 根据起始时间和结束时间计算出下一次提醒时间
 * @author zhangbo22479
 * @date 2018/11/30
 */
public class CalcNextInfoTime {

    public static void main(String[] args) throws ParseException {
        String startTime = "090900", endTime = "200000";
        String currTime = "154700";
        int remindNum = 5;
        boolean nextDay = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("HHmm");
        Date startDate = dateFormat.parse(startTime);
        Date endDate = dateFormat.parse(endTime);
        Date currDate = dateFormat.parse(currTime);
        System.out.println(startDate);
    }

}
