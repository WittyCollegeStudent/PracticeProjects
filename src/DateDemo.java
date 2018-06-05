import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.DataFormatException;

public class DateDemo {

    public static void main(String []args) throws ParseException {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
//        String dateString = "20100412";
//        Calendar calendar = Calendar.getInstance();
//        long nowDate = calendar.getTime().getTime(); //Date.getTime() 获得毫秒型日期
//        try {
//            long specialDate = simpleDateFormat.parse(dateString).getTime();
//            long betweenDate = (nowDate - specialDate) / (1000 * 60 * 60 * 24); //计算间隔多少天，则除以毫秒到天的转换公式
//            System.out.println(betweenDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        long time1 = System.nanoTime();
//        for(int i = 0 ; i < 100000; i ++){
//
//        }
//        long time2 = System.nanoTime();
//        System.out.println(time2 - time1);
//        String str = DateUtils.getDateBeforeMonths(0);
//        System.out.println(DateUtils.getCurrentYear());
//        System.out.println(DateUtils.getDateBeforeMonths(1,"20170809", "yyyyMMdd"));
        System.out.println("".compareTo("20181208"));
    }

}
class DateUtils{

    public static String getCurrentYear(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy0000");
        Date date = new Date();
        return sdf.format(date);
    }

    public static String getDateBeforeMonths(int months){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, months);
        Date d = c.getTime();
        String day = format.format(d);
        return day;
    }

    public static String getDateBeforeMonths(int months, String currDate, String format) throws ParseException{
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = dateFormat.parse(currDate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, - months);
        return dateFormat.format(c.getTime());
    }

}
