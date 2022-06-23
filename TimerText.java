import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerText {
    public static void main(String[] args) throws ParseException {
        Timer timer = new Timer();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
        Date firstTime = format.parse("2022-06-23 19:53:00");
        timer.schedule(new TimerTask(){
            public void run(){
                System.out.println("计时器运行:"+format.format(new Date(new Date().getTime())));
            }
        },firstTime,1000*5);
    }
}
