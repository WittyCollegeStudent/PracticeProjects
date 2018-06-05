package timedemo;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: weianyang
 * @Date: 2018/5/8 18:12
 * @Description: weianyang
 */
public class TimerDemo {

    private static int cnt;

    public static void main(String arg[]){
        Timer timer;
        cnt = 0;
        timer = new Timer();
        timer.cancel();
        timer = new Timer();
        timer.schedule(

                new TimerTask() {
                    @Override
                    public void run() {
                        if(cnt >= 0){
                            cnt ++;
                            System.out.println("222");
                        }
                        if(cnt == 5){
                            cnt = -1;
//                            timer.cancel();
                        }
                    }
                }, 0, 1000
        );
    }

}

